package com.exercise.tour.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
//@Builder(toBuilder = true) //patrón de diseño
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cyclists")
public class Cyclist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nationality;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId")
    private Team team;


}
