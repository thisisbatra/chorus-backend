package com.backend.chorus.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "songCollection")
public class Song {
    @Id
    Long id;
    String songName;
    String movieName;
    String artistName;
    String thumbUrl;
    String prevUrl;
    int likeCount;
    int clickCount;

    public Song() {
    }


    public Song(Long id, String prevUrl, String thumbUrl, String artistName, String songName,String movieName, int likeCount,int clickCount) {
        this.id = id;
        this.prevUrl = prevUrl;
        this.thumbUrl = thumbUrl;
        this.artistName = artistName;
        this.songName = songName;
        this.movieName= movieName;
        this.likeCount=likeCount;
        this.clickCount=clickCount;
    }
    public Song(Long id, String prevUrl, String thumbUrl, String artistName, String songName,String movieName) {
        this.id = id;
        this.prevUrl = prevUrl;
        this.thumbUrl = thumbUrl;
        this.artistName = artistName;
        this.songName = songName;
        this.movieName= movieName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrevUrl() {
        return this.prevUrl;
    }

    public void setPrevUrl(String prevUrl) {
        this.prevUrl = prevUrl;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getSongName() {
        return this.songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
    
    public String getMovieName(){
        return this.movieName;
    }

    public void setMovieName(String movieName){
        this.movieName= movieName;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getClickCount() {
        return this.clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

}
