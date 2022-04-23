package me.matej.hikingtrailmapper.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Setter @Getter
    private String comment;

    @Setter @Getter
    private int id;


}
