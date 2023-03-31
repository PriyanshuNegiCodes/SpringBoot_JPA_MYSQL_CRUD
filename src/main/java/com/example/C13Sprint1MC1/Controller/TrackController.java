package com.example.C13Sprint1MC1.Controller;

import com.example.C13Sprint1MC1.Domain.Track;
import com.example.C13Sprint1MC1.Services.TrackServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class TrackController {
    TrackServiceImp trackservice;

    @Autowired
    public TrackController(TrackServiceImp trackservice) {
        this.trackservice = trackservice;
    }
    @PostMapping("/saveTrack")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackservice.saveTrack(track), HttpStatus.CREATED);
    }
    @GetMapping("/getTrack")
    public ResponseEntity<?> getTrack(){
        return new ResponseEntity<>(trackservice.getAllById(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return new ResponseEntity<>(trackservice.deleteTrack(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Track track, int id){
        return new ResponseEntity<>(trackservice.updateTrack(track, id),HttpStatus.OK);
    }
    @GetMapping("/gettrack/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id){
        return new ResponseEntity<>(trackservice.getTrackById(id), HttpStatus.OK);
    }
    @GetMapping ("/getTrack/{name}")
    public ResponseEntity<?> getTrackByName(@PathVariable String name){
        return new ResponseEntity<>(trackservice.getTrackByName(name), HttpStatus.OK);
    }


}
