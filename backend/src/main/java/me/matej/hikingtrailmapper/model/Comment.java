package me.matej.hikingtrailmapper.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.matej.hikingtrailmapper.dtos.CommentDto;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "comment")
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String comment;

    @ManyToOne()
    private User user;

    @ManyToOne
    private Trail trail;

    public Comment(String comment, User user, Trail trail) {
        this.comment = comment;
        this.user = user;
        this.trail = trail;
    }

    public CommentDto toDto() {
        return new CommentDto(id,
                comment,
                user.toDto());
    }
}
