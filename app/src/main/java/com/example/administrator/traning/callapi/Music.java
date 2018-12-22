package com.example.administrator.traning.callapi;

public class Music {
    private String id;
    private String song;
    private String singer;
    private String urlSong;
    private String genres;
    private String createdAt;

    public Music() {

    }

    public Music(String id, String song, String singer, String urlSong, String genres, String createdAt) {
        this.id = id;
        this.song = song;
        this.singer = singer;
        this.urlSong = urlSong;
        this.genres = genres;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getUrlSong() {
        return urlSong;
    }

    public void setUrlSong(String urlSong) {
        this.urlSong = urlSong;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
