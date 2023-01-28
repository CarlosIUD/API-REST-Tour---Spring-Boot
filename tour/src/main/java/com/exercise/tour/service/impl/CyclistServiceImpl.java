package com.exercise.tour.service.impl;

import com.exercise.tour.model.Cyclist;
import com.exercise.tour.model.Team;
import com.exercise.tour.repository.CyclistRepository;
import com.exercise.tour.repository.TeamRepository;
import com.exercise.tour.service.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CyclistServiceImpl implements CyclistService {

    @Autowired
    private CyclistRepository cyclistRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Cyclist getCyclistById(Integer id) {
        return cyclistRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cyclist> getAllCyclist() {
        List<Cyclist> cyclists = cyclistRepository.findAll();
        return cyclists;
    }

    @Override
    public void saveCyclist(Integer teamId, Cyclist cyclist) {
        Team team = getTeamById(teamId);
        cyclist.setTeam(team);
        cyclistRepository.save(cyclist);

    }

    @Override
    public void updateCyclist(Integer teamId, Integer cyclistId, Cyclist cyclist) {
        Team team = getTeamById(teamId);
        Cyclist newCyclist = getCyclistWithTeam(cyclistId, team);
        newCyclist.setName(cyclist.getName());
        newCyclist.setNationality(cyclist.getNationality());


      /*  newCyclist.toBuilder()
                .name(cyclist.getName())
                .nationality(cyclist.getNationality())
                .team(team)
                .build();*/
        cyclistRepository.save(newCyclist);


    }

    private Cyclist getCyclistWithTeam(Integer cyclistId, Team team) {
        return team.getCyclists().stream().filter(foundCyclist -> foundCyclist.getId() == cyclistId).findFirst().orElseThrow(() -> new RuntimeException("Cyclist by ID not found"));
    }

    private Team getTeamById(Integer teamId) {
        return teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
    }


    @Override
    public void deleteCyclistById(Integer teamId, Integer cyclistId) {
        Team team = getTeamById(teamId);
        Cyclist newCyclist = getCyclistWithTeam(cyclistId, team);
        cyclistRepository.delete(newCyclist);
        var name = "hola";
    }
}
