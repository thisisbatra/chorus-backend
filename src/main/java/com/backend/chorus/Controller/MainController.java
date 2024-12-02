package com.backend.chorus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.chorus.Entity.Song;
import com.backend.chorus.Repository.SongAddRepo;
import com.backend.chorus.Services.ITunesSearch;
import com.backend.chorus.Services.SongAdding;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = {"http://localhost:3000","https://chorusplay.vercel.app"})
@RestController
public class MainController {
    
    @Autowired
    private ITunesSearch objTunesSearch;
    @Autowired
    private SongAdding objSongAdding;
    @Autowired
    private SongAddRepo objSongAddRepo;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String Handler(){
        return "from main handler";
    }

    @GetMapping("/searchSong")
    public ResponseEntity<List<Song>> iTunesSearch(@RequestParam("term") String searchTerm){
        return new ResponseEntity<>(objTunesSearch.searchSong(searchTerm), HttpStatus.OK);
    }

    @PostMapping("/addSong")
    public ResponseEntity<Song> songAdded(@RequestBody Song objSong){
        return new ResponseEntity<Song>(objSongAdding.saveSong(objSong), HttpStatus.OK);
    }

    @PostMapping("/addAllSongs")
    public ResponseEntity<List<Song>> allSongadded(@RequestBody List<Song> objSongList){
        return new ResponseEntity<>(objSongAdding.saveAllSongs(objSongList),HttpStatus.OK);
    }

    @GetMapping("/getMostLikedSongs")
    public ResponseEntity<List<Song>> mostLikedSongs(){
        return new ResponseEntity<>(objSongAddRepo.mostLikedSongs(),HttpStatus.OK);
    }

    @GetMapping("/getMostClickedSongs")
    public ResponseEntity<List<Song>> mostclickedSongs(){
        return new ResponseEntity<>(objSongAddRepo.mostClickedSongs(),HttpStatus.OK);
    }
}