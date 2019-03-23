import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompactDisc {
    private List<Song> songs;
    private String artist;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private String title;
    private int year;

    public CompactDisc(String artist, String title, int year) {
        this.songs = new ArrayList<Song>();
        this.artist = artist;
        this.title = title;
        this.year = year;
    }

    public void addSong(Song s) {
        songs.add(s);
    }

    public static CompactDisc read(Scanner sc) {
        if (!sc.hasNext(Pattern.compile("CD"))) {
            return null;
        }

        String line = sc.nextLine();
        Pattern cdRe = Pattern.compile("CD (.*?), (.*?), (\\d+)");
        Matcher cdMatcher = cdRe.matcher(line);
        cdMatcher.find();

        String artist = cdMatcher.group(1);
        String title = cdMatcher.group(2);
        int year = Integer.parseInt(cdMatcher.group(3));

        CompactDisc cd = new CompactDisc(artist, title, year);

        Song song;
        for (;;) {
            song = Song.read(sc);
            if (song == null) {
                break;
            }

            song.setCd(cd);
            cd.addSong(song);
        }

        return cd;
    }

    public String toString() {
        return String.format("Album: %s's %s", this.artist, this.title);
    }
}
