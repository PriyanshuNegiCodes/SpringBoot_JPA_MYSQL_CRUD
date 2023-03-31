package com.example.C13Sprint1MC1.Repository;

import com.example.C13Sprint1MC1.Domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrackRepository extends JpaRepository<Track, Integer> {
    List<Track> findByTrackName(String trackName);
}