package com.example.C13Sprint1MC1.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Track {

    @Id
    private int TrackId;
    private String TrackName;
    private String TrackComments;
    private String TrackRating;
    private String TrackArtist;
}
