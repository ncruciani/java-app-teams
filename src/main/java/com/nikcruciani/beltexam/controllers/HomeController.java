package com.nikcruciani.beltexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nikcruciani.beltexam.models.LoginUser;
import com.nikcruciani.beltexam.models.Team;
import com.nikcruciani.beltexam.models.User;
import com.nikcruciani.beltexam.services.TeamService;
import com.nikcruciani.beltexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class HomeController {
	
	@Autowired
	private UserService userservice ; 
	@Autowired
	private TeamService teamservice ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";

	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		userservice.register(newUser, result);
		
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("userId" , newUser.getId());
		return "redirect:/home";
		
		
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userservice.login(newLogin, result);
		
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		session.setAttribute("userId" , user.getId());
		return "redirect:/home";
		
	}
	
	@GetMapping("/home")
	public String welcome(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId==null) {
			return "redirect:/";
		}
		
		User user = userservice.findById(userId);
		model.addAttribute("user", user ); 
		model.addAttribute("teams", teamservice.findAllTeams());
		return "home.jsp";
	}
		@PostMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		
		@GetMapping("/addPage")
		public String addPage(Model model, HttpSession session) {
			Long userId = (Long) session.getAttribute("userId");
			if (userId == null) {
				return "redirect:/" ; 
			}
			
			User user = userservice.findById(userId);
			model.addAttribute("user", user);
			model.addAttribute("team", new Team());
			return "addPage.jsp";
		}
		
		@PostMapping("/teams")
		public String createTeams(@Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session) {
			Long userId = (Long) session.getAttribute("userId");
			
			if (userId == null) {
				return "reddirect:/";
			}
			if (result.hasErrors()) {
				return "addPage.jsp";
			}
			team.setUser(userservice.findById(userId));
			teamservice.create(team);
			return "redirect:/home";
		}
		
		@GetMapping("/teams/{id}")
		public String showPage (Model model, @PathVariable("id")Long id , HttpSession session) {
			Long userId = (Long) session.getAttribute("userId");
			if (userId == null) {
				return "redirect:/";
			}
			Team team = teamservice.findById(id);
			if (team == null) {
				return "redirect:/home";
			}
				model.addAttribute("team" , team);
				model.addAttribute("user" , userservice.findById(userId));
				return "team.jsp";
		
		}
		@GetMapping("/teams/{id}/edit")
		public String editTeam(@PathVariable("id") Long id, Model model, HttpSession session) {
			Long userId = (Long) session.getAttribute("userId");
			if(userId == null) {
				return "redirect:/";
			}
			
			Team team = teamservice.findById(id);
			
			if (team == null) {
				return "redirect:/home";
			}
			if (userId.equals(team.getUser().getId())) {
				model.addAttribute("team", team);
				return "edit.jsp";
			}else {
				return "redirect:/home";
			}
		}
		@PostMapping("/teams/{id}/edit")
		public String updateTeam (@PathVariable("id") Long id , @Valid @ModelAttribute("team") Team updatedTeam, BindingResult result, HttpSession session) {
			if (result.hasErrors()) {
				return "edit.jsp";
			}
			Long userId = (Long) session.getAttribute("userId");
			if (userId == null) {
				return "redirect:/";
			}
			Team existingTeam = teamservice.findById(id);
			if (existingTeam == null) {
				return "redirect:/home";
			}
			if (userId.equals(existingTeam.getUser().getId())) {
				existingTeam.setTeamName(updatedTeam.getTeamName());
				existingTeam.setSkillLevel(updatedTeam.getSkillLevel());
				existingTeam.setGameDay(updatedTeam.getGameDay());
				
				teamservice.update(existingTeam);
				return "redirect:/home";
				
			} else {
				return "redirect:/home"; 
			}
		}
		
		@PostMapping("/teams/{id}/delete")
		public String deleteteam(@PathVariable("id") Long id, HttpSession session){
			Long userId = (Long) session.getAttribute("userId");
			if(userId == null) {
				return"redirect:/";
			}
			Team team = teamservice.findById(id);
			if (team == null) {
				return "redirect:/home";
			}
			if (userId.equals(team.getUser().getId())) {
				teamservice.deleteById(id);
			}
			return "redirect:/home";
		}
		
		


}
