/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL 3
 * Program: Playlist
 */
import java.util.*;
public class Playlist{
    private String name;
    private ArrayList <Song> songs = new ArrayList<>();
    
    /**
     * Creates a new instance of a Playlist
     * @param name determines the name of the playlist
     */
    public Playlist(String name){
        this.name = name;
    }
    
    /**
     * Retrieves the name of a playlist
     * @return this.name the name of the playlist
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Adds a song to the playlist
     * @param song the song which will be added to the playlist
     */
    public void addSong(Song song){
        this.songs.add(song);
    }
    
    /**
     * Removes a specific song from the playlist
     * @param song the song which will be removed from the playlist
     */
    public void removeSong(Song song){
        this.songs.remove(song);
    }
    
    /**
     * Provides the ArrayList of songs in a playlist
     * @return this.songs the ArrayList of songs in the playlist
     */
    public ArrayList <Song> getSongs(){
        return this.songs;
    }
}