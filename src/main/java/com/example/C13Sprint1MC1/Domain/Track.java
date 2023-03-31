package com.example.C13Sprint1MC1.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Track {

    @Id
    private int trackId;
    private String trackName;
    private String trackComments;
    private String trackRating;
    private String trackArtist;
}
