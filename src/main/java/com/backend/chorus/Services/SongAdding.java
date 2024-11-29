package com.backend.chorus.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.chorus.Entity.Song;
import com.backend.chorus.Repository.SongAddRepo;

@Component
public class SongAdding {

    @Autowired
    private SongAddRepo objSongAddRepo;

    public Song saveSong(Song objSong){

        return objSongAddRepo.save(objSong);
    }

    public List<Song> saveAllSongs(List<Song> objSongList){

        return (List<Song>)objSongAddRepo.saveAll(objSongList);
    }
}
