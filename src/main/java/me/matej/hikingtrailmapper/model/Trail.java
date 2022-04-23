package me.matej.hikingtrailmapper.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Trail {

    @Setter @Getter
    private String trailName, trailDescription, suggestedGear;

    @Setter @Getter
    private float trailLength;

    @Setter @Getter
    private int hikeDuration;

    @Setter @Getter
    private boolean waterAvailability;

    @Setter @Getter
    private int id;


}
