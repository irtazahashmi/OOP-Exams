import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Playlist {
    private List<Song> songs;
    private List<Advertisement> ads;

    public Playlist() {
        this.songs = new ArrayList<Song>();
        this.ads = new ArrayList<Advertisement>();
    }

    public List<Advertisement> getAds() {
        return ads;
    }

    public void setAds(List<Advertisement> ads) {
        this.ads = ads;
    }

    public static Playlist read(Scanner sc) {
        Playlist playlist = new Playlist();

        while (sc.hasNextLine()) {
            boolean read = false;

            CompactDisc cd = CompactDisc.read(sc);
            if (cd != null) {
                read = true;
                playlist.addCd(cd);
            }

            Advertisement ad = Advertisement.read(sc);
            if (ad != null) {
                read = true;
                playlist.ads.add(ad);
            }

            if (!read) {
                sc.nextLine();
            }
        }

        return playlist;
    }

    public synchronized void addCd(CompactDisc cd) {
        for (Song song : cd.getSongs()) {
            this.songs.add(song);
        }
    }

    public synchronized void shuffle() {
        Collections.shuffle(this.songs);
    }

    public synchronized String play() {
        if (this.songs.size() == 0) {
            return null;
        }

        Song song = songs.remove(0);
        Advertisement ad = this.nextAd();
        return String.format("%s\nNext ad: %s", song, ad);
    }

    private Advertisement nextAd() {
        // Rotate ads because ads just wrap around
        Advertisement ad = this.ads.remove(0);
        this.ads.add(ad);
        return ad;
    }

    public String toString() {
        String str = "";

        // Song
        for (int i = 0; i < this.songs.size(); i++) {
            Song song = this.songs.get(i);
            str += String.format("%s\n", song.toString());

            Advertisement ad = this.ads.get(i % this.ads.size());
            str += String.format("Next ad: %s\n", ad.toString());
        }

        return str;
    }
}
