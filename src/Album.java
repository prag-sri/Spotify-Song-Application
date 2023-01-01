import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>(); //important- initializing here saves space
    }

    public boolean findSong(String title){
        for(Song s: songs)
        {
            if(s.getTitle().equals(title))
                return true;
        }
        return false;
    }

    public void addSongToAlbum(String title, double duration){

        //Make sure song exists or not
        if(findSong(title))
        {
            System.out.println("The song is already present!");
        }
        else
        {
            Song newSong= new Song(title,duration,null,null);
            songs.add(newSong);
            System.out.println("New song has been added");
        }
    }

    public void addToPlaylist(int trackNo, LinkedList<Song> playList){
        int index= trackNo-1;
        if(index>=0 && index<songs.size())
        {
            Song s= songs.get(index);
            playList.add(s);
        }
    }

    public void addToPlaylist(String title, LinkedList<Song> playList){
        for(Song s: songs)
        {
            if(s.getTitle().equals(title))
            {
                playList.add(s);
                break;
            }
        }

    }
}
