package me.matej.hikingtrailmapper.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrailDto {
    private Long id;
    private String trailName;
    private String trailDescription;
    private String suggestedGear;
    private float trailLength;
    private int hikeDuration;
    private boolean waterAvailability;
    private UserDto user;
    private String path;
    private List<CommentDto> comments;
}
