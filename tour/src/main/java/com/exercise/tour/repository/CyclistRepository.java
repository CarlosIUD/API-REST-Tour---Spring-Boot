package com.exercise.tour.repository;

import com.exercise.tour.model.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CyclistRepository extends JpaRepository<Cyclist, Integer> {
}
