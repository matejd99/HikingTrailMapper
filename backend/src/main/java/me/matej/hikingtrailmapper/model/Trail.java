package me.matej.hikingtrailmapper.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.matej.hikingtrailmapper.dtos.TrailDto;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "trail")
@NoArgsConstructor
public class Trail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private User user;

    @Column
    private String trailName;

    @Column
    private String trailDescription;

    @Column
    private String suggestedGear;

    @Column
    private float trailLength;

    @Column
    private int hikeDuration;

    @Column
    private boolean waterAvailability;

    @Column
    private String path;

    public Trail(User user,
                 String trailName,
                 String trailDescription,
                 String suggestedGear,
                 float trailLength,
                 int hikeDuration,
                 boolean waterAvailability,
                 String path) {
        this.user = user;
        this.trailName = trailName;
        this.trailDescription = trailDescription;
        this.suggestedGear = suggestedGear;
        this.trailLength = trailLength;
        this.hikeDuration = hikeDuration;
        this.waterAvailability = waterAvailability;
        this.path = path;
    }

    public TrailDto toDto() {
        return new TrailDto(this.getId(),
                this.getTrailName(),
                this.getTrailDescription(),
                this.getSuggestedGear(),
                this.getTrailLength(),
                this.getHikeDuration(),
                this.isWaterAvailability(),
                this.user.toDto(),
                this.path);
    }
}
