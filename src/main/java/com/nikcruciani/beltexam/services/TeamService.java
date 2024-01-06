package com.nikcruciani.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikcruciani.beltexam.models.Team;
import com.nikcruciani.beltexam.repositories.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepo;
	
	public Team findById(Long id) {
		Optional<Team>potentialTeam = teamRepo.findById(id);
		
		if (potentialTeam.isPresent()) {
			return potentialTeam.get();
		}else {
			return null;
		}
	}
	
	public Team create(Team team) {
		return teamRepo.save(team);
	}
	public List<Team> findTeamByUserId(Long userId) {
		return teamRepo.findByUserId(userId);
	}
	public void deleteById(Long teamId) {
		teamRepo.deleteById(teamId);
	}
	public List<Team> findAllTeams() {
		return teamRepo.findAll();
	}
	
	public void update (Team team) {
		Optional<Team> existingTeamOptional = teamRepo.findById(team.getId());
		if (existingTeamOptional.isPresent()) {
			Team existingTeam = existingTeamOptional.get();
			
			existingTeam.setTeamName(team.getTeamName());
			existingTeam.setSkillLevel(team.getSkillLevel());
			existingTeam.setGameDay(team.getGameDay());
			
			teamRepo.save(existingTeam);

		}
	}

}
