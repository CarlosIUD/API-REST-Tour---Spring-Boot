package com.exercise.tour.controller;


import com.exercise.tour.model.Team;
import com.exercise.tour.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    private Map<String, Object> response = new HashMap<>();

    @GetMapping("/all")
    private ResponseEntity<?> findAllTeams() {
        response.clear();
        response.put("cyclist", teamService.getAllTeams());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findTeamById(@PathVariable Integer id) {
        response.clear();
        response.put("team", teamService.getTeamById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save")
    private ResponseEntity<?> saveTeam(@RequestBody Team team) {
        response.clear();
        teamService.saveTeam(team);
        response.put("message: ", "team saved succesfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<?> updateTeam(@PathVariable Integer id, @RequestBody Team team) {
        response.clear();
        teamService.updateTeam(id, team);
        response.put("message", "team updated succesfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteTeam(@PathVariable Integer id) {
        response.clear();
        response.put("message", "team deleted succesfully");
        teamService.deleteTeam(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
