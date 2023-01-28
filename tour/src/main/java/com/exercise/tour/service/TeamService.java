package com.exercise.tour.service;

import com.exercise.tour.model.Team;

import java.util.List;

public interface TeamService {

    Team getTeamById(Integer id);

    List<Team> getAllTeams();

    void saveTeam(Team team);

    void updateTeam(Integer id, Team team);

    void deleteTeam(Integer id);
}
