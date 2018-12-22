package com.example.administrator.traning.callapi;

import java.util.ArrayList;

public class MusicList  {
    ArrayList<Music> listMusic;

    public MusicList(){

    }

    public MusicList(ArrayList<Music> listMusic) {
        this.listMusic = listMusic;
    }

    public ArrayList<Music> getListMusic() {
        return listMusic;
    }

    public void setListMusic(ArrayList<Music> listMusic) {
        this.listMusic = listMusic;
    }

    @Override
    public String toString() {
        return "MusicList{" +
                "listMusic=" + listMusic +
                '}';
    }
}
