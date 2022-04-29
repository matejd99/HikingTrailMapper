package me.matej.hikingtrailmapper.contracts;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateTrailRequest {
    private String trailName;
    private String trailDescription;
    private String suggestedGear;
    private float trailLength;
    private int hikeDuration;
    private boolean waterAvailability;
}
