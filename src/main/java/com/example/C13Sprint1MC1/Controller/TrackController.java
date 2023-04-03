package com.example.C13Sprint1MC1.Controller;

import com.example.C13Sprint1MC1.Domain.Track;
import com.example.C13Sprint1MC1.Services.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class TrackController {
    ITrackService iTrackService;

    @Autowired
    public TrackController(ITrackService iTrackService) {
        this.iTrackService = iTrackService;
    }

    //http://localhost:65500/api/v1/saveTrack
    @PostMapping("/saveTrack")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        return new ResponseEntity<>(iTrackService.saveTrack(track), HttpStatus.CREATED);
    }
    //http://localhost:65500/api/v1/getTrack
    @GetMapping("/getTrack")
    public ResponseEntity<?> getTrack(){
        return new ResponseEntity<>(iTrackService.getAllTracks(), HttpStatus.OK);
    }

    //http://localhost:65500/api/v1/delete/105
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return new ResponseEntity<>(iTrackService.deleteTrack(id), HttpStatus.OK);
    }
    //http://localhost:65500/api/v1/update/104
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Track track,@PathVariable int id){
        return new ResponseEntity<>(iTrackService.updateTrack(track, id),HttpStatus.OK);
    }

   // http://localhost:65500/api/v1/gettrack/103
    @GetMapping("/gettrack/{id}")
    public ResponseEntity<?> getTrackById( @PathVariable int id){
        return new ResponseEntity<>(iTrackService.getTrackById(id), HttpStatus.OK);
    }

    //http://localhost:65500/api/v1/getTrack/song
    @GetMapping ("/getTrack/{name}")
    public ResponseEntity<?> getTrackByName(@PathVariable  String name){
        return new ResponseEntity<>(iTrackService.getTrackByName(name), HttpStatus.OK);
    }
    }
