package com.backend.chorus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.chorus.Entity.Song;

public interface SongAddRepo extends CrudRepository<Song, Long> {

    // native Query
    @Query(value = "SELECT * FROM song_collection ORDER BY like_count DESC LIMIT 10", nativeQuery = true)
    public List<Song> mostLikedSongs();

    @Query(value = "SELECT * FROM song_collection ORDER BY click_count DESC LIMIT 15;", nativeQuery = true)
    public List<Song> mostClickedSongs();
}
