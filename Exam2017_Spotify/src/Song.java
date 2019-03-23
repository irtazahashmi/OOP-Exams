import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Song extends Track {
    private CompactDisc cd; // Cyclic dependency :(
    private int trackNum;
    private String title;

    public CompactDisc getCd() {
        return cd;
    }

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public int getTrackNum() {
        return trackNum;
    }

    public void setTrackNum(int trackNum) {
        this.trackNum = trackNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Song(int trackNum, String title, String length) {
        super(length);
        this.title = title;
        this.trackNum = trackNum;
    }

    public static Song read(Scanner sc) {
        if (!sc.hasNext(Pattern.compile("SONG"))) {
            return null;
        }

        String line = sc.nextLine();
        Pattern songRe = Pattern.compile("SONG (\\d)+, (.+?), (\\d+:\\d+)");
        Matcher songMatch = songRe.matcher(line);

        songMatch.find();
        int trackNum = Integer.parseInt(songMatch.group(1));
        String title = songMatch.group(2);
        String length = songMatch.group(3);

        return new Song(trackNum, title, length);
    }

    public String toString() {
        return String.format("Album: %s's %s (%d)\n\t%s (%s)", this.cd.getArtist(), this.cd.getTitle(),
                this.cd.getYear(), this.title, this.getLength());
    }
}
