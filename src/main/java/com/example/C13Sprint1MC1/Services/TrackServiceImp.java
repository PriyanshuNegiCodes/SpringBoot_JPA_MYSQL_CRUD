package com.example.C13Sprint1MC1.Services;

import com.example.C13Sprint1MC1.Domain.Track;
import com.example.C13Sprint1MC1.Repository.ITrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImp implements ITrackService {
    ITrackRepository repository;
    @Autowired
    public TrackServiceImp(ITrackRepository repository){
        this.repository=repository;
    }
    @Override
    public Track saveTrack(Track track) {
        return repository.save(track);
    }

    @Override
    public List<Track> getAllById() {
        return repository.findAll();
    }

    @Override
    public boolean deleteTrack(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Track updateTrack(Track track, int id) {
        Optional<Track> checkTrack=repository.findById(id);
        if(checkTrack.isEmpty()){
            return null;
        }
        Track existingTrack = checkTrack.get();

        if(track.getTrackName()!=null){
            existingTrack.setTrackName(track.getTrackName());
        }
        if(track.getTrackComments()!=null){
            existingTrack.setTrackComments(track.getTrackComments());
        }
        if(track.getTrackArtist()!=null){
            existingTrack.setTrackArtist(track.getTrackArtist());
        }
        return repository.save(existingTrack);

    }

    @Override
    public List<Track> getTrackByName( String name) {
        return  repository.findByName(name);
    }

    @Override
    public Track getTrackById(int id) {
        return repository.findById(id).get();
    }
}
