/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL 3
 * Program: Song
 */
import java.util.*;
public class Song{
    private String name;
    private String artist;
    private String album;
    private int time;
    
    /**
     * Creates a new instance of a song
     * @param name sets the name of the song
     * @param artist determines the artist of the song
     * @param album determines the album of the song
     * @param time sets the time length of the song
     */
    public Song(String name, String artist, String album, int time){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.time = time;
    }
    
    /**
     * Retrieves the name of a song
     * @return name the name of the song
     */
    public String getName(){
        return name;
    }
    
    /**
     * Retrieves the artist of a song
     * @return artist the artist of the song
     */
    public String getArtist(){
        return artist;
    }
    
    /**
     * Retrieves the album of a song
     * @return album the album of the song
     */
    public String getAlbum(){
        return album;
    }
    
    /**
     * Retrieves the time length of a song
     * @return time the time length of the song
     */
    public int getTime(){
        return time;
    }
}