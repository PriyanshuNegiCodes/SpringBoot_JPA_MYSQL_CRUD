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
    @PostMapping("/saveTrack")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        return new ResponseEntity<>(iTrackService.saveTrack(track), HttpStatus.CREATED);
    }
    @GetMapping("/getTrack")
    public ResponseEntity<?> getTrack(){
        return new ResponseEntity<>(iTrackService.getAllById(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return new ResponseEntity<>(iTrackService.deleteTrack(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Track track, int id){
        return new ResponseEntity<>(iTrackService.updateTrack(track, id),HttpStatus.OK);
    }
    @GetMapping("/gettrack/{id}")
    public ResponseEntity<?> getTrackById(int id){
        return new ResponseEntity<>(iTrackService.getTrackById(id), HttpStatus.OK);
    }
    @GetMapping ("/getTrack/{name}")
    public ResponseEntity<?> getTrackByName(String name){
        return new ResponseEntity<>(iTrackService.getTrackByName(name), HttpStatus.OK);
    }


}
