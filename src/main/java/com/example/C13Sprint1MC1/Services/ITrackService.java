package com.example.C13Sprint1MC1.Services;

import com.example.C13Sprint1MC1.Domain.Track;

import java.util.List;

public interface ITrackService {
    Track saveTrack(Track track);
    List<Track> getAllTracks();
    boolean deleteTrack(int id);
    Track updateTrack(Track track, int id);
    List<Track> getTrackByName(String name);
    Track getTrackById(int id);
}
