import java.util.LinkedList;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
public class Main {

    public static ArrayList<Album> albums= new ArrayList<>();
    public static void main(String[] args) {
        Album album= new Album("Album1","AC/DC");
        album.addSongToAlbum("TNT",4.5);
        album.addSongToAlbum("Highway to Hell",3.5);
        album.addSongToAlbum("Thunderstruck",5.0);
        albums.add(album);

        album= new Album("Album2","Eminem");
        album.addSongToAlbum("Rap God",4.5);
        album.addSongToAlbum("Not Afraid",3.5);
        album.addSongToAlbum("Lose Yourself",4.5);
        albums.add(album);

        LinkedList<Song> playlist1= new LinkedList<>();

        albums.get(0).addToPlaylist("TNT",playlist1);
        albums.get(0).addToPlaylist("Highway to Hell",playlist1);
        albums.get(1).addToPlaylist("Rap God",playlist1);
        albums.get(1).addToPlaylist("Lose Yourself",playlist1);

        play(playlist1);
    }

    private static void play(LinkedList<Song> playlist)
    {
        printMenu();

        ListIterator<Song> listIterator= playlist.listIterator();
        boolean forward= true;
        if(playlist.size()>0)
        {
            System.out.println("Playing the first song");
            System.out.println(listIterator.next().toString());
        }
        else
        {
            System.out.println("Playlist is Empty");
            return;
        }

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your option:");

        boolean quit= false;

        while(!quit)
        {
            int option= sc.nextInt();

            switch(option)
            {
                case 0:
                {
                    quit= true;
                    break;
                }
                case 1:
                {
                    if(!forward)
                        listIterator.next();

                    if(listIterator.hasNext())
                    {
                        System.out.println("Playing next song "+listIterator.next().toString());
                        forward= true;
                    }
                    else
                        System.out.println("You are at the last song");
                    break;
                }
                case 2:
                {
                    if(forward)
                        listIterator.previous();
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Playing previous song "+listIterator.previous().toString());
                        forward= false;
                    }
                    else
                        System.out.println("You are at the first song");
                    break;
                }
                case 3:
                {
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Replaying current song "+listIterator.previous().toString());
                            forward= false;
                        }
                    }
                    else
                    {
                        if(listIterator.hasNext())
                        {
                            System.out.println("Replaying current song "+listIterator.next().toString());
                            forward= true;
                        }
                    }
                    break;
                }
                case 4:
                {
                    System.out.println("Printing all songs");
                    printsongs(playlist);
                    break;
                }
                case 5:
                {
                    printMenu();
                    break;
                }
                case 6:
                {
                    //listIterator.remove()- delete a song
                    if(forward)
                        playlist.remove();
                    else
                    {
                        listIterator.next();
                        playlist.remove();
                    }
                    break;
                }
                default:
                    System.out.println("Invalid option!");
            }
        }

    }

    public static void printsongs(LinkedList<Song> playlist) {
        for(Song s: playlist)
        {
            System.out.println(s.toString());
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n Press");
        System.out.println("0 - to quit\n" +
                "1- to play next song\n" +
                "2- to play previous song\n" +
                "3- to replay the current song\n" +
                "4- list of all songs\n" +
                "5- print all available options\n" +
                "6- delete current song");
    }
}