package me.matej.hikingtrailmapper.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
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

    public Trail(User user,
                 String trailName,
                 String trailDescription,
                 String suggestedGear,
                 float trailLength,
                 int hikeDuration,
                 boolean waterAvailability) {
        this.user = user;
        this.trailName = trailName;
        this.trailDescription = trailDescription;
        this.suggestedGear = suggestedGear;
        this.trailLength = trailLength;
        this.hikeDuration = hikeDuration;
        this.waterAvailability = waterAvailability;
    }
}
