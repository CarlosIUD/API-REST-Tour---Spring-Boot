package com.exercise.tour.service.impl;

import com.exercise.tour.model.Team;
import com.exercise.tour.repository.TeamRepository;
import com.exercise.tour.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team getTeamById(Integer id) {
        return teamRepository.findById(id).orElse(null);
    }

    @Override
    public List<Team> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams;
    }

    @Override
    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void updateTeam(Integer id, Team team) {
        Team team1 = teamRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Team not found"));
        team1.setName(team.getName());
        team1.setCyclists(team.getCyclists());
        teamRepository.save(team1);
    }

    @Override
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }
}
