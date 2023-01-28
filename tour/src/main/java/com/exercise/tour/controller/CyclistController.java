package com.exercise.tour.controller;

import com.exercise.tour.model.Cyclist;
import com.exercise.tour.model.Team;
import com.exercise.tour.service.CyclistService;
import com.exercise.tour.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cyclist")
public class CyclistController {

    @Autowired
    private CyclistService cyclistService;

    @Autowired
    private TeamService teamService;

    private Map<String, Object> response = new HashMap<>();

    @GetMapping("/all")
    private ResponseEntity<?> findAllCyclist() {
        response.clear();
        response.put("cyclists", cyclistService.getAllCyclist());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findCyclistById(@PathVariable Integer id) {
        response.clear();
        response.put("cyclist", cyclistService.getCyclistById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save/{teamId}")
    private ResponseEntity<?> saveCyclist(@RequestBody Cyclist cyclist, @PathVariable(value = "teamId") Integer teamId) {
        response.clear();
        cyclistService.saveCyclist(teamId, cyclist);
        response.put("message", "cyclist saved succesfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{teamId}/{cyclistId}")
    private ResponseEntity<?> updateCyclist(@PathVariable Integer teamId,
                                            @PathVariable Integer cyclistId, @RequestBody Cyclist cyclist) {
        response.clear();
        response.put("message", "Cyclist updated succesfully");
        cyclistService.updateCyclist(teamId, cyclistId, cyclist);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{teamId}/{cyclistId}")
    private ResponseEntity<?> deleteCyclist(@PathVariable(value = "teamId") Integer teamId,
                                            @PathVariable(value = "cyclistId") Integer cyclistId) {
        response.clear();
        response.put("message", "Cyclist deleted succesfully");
        cyclistService.deleteCyclistById(teamId, cyclistId);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
