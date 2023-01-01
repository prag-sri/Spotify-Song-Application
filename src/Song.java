public class Song {
    private String title;
    private double duration;
    private String genre;
    private String singer;

    public Song(String title, double duration, String genre, String singer) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getSinger() {
        return singer;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}
