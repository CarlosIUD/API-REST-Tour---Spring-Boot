package com.exercise.tour.service;

import com.exercise.tour.model.Cyclist;
import com.exercise.tour.model.Team;


import java.util.List;


public interface CyclistService {

    Cyclist getCyclistById(Integer id);

    List<Cyclist> getAllCyclist();

    void saveCyclist(Integer teamId, Cyclist cyclist);

    void updateCyclist(Integer teamId, Integer cyclistId, Cyclist cyclist);

    void deleteCyclistById(Integer teamId, Integer cyclistId);



    


}
