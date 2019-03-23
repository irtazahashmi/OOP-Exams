public class Shuffler extends Thread {
    private Playlist playlist;

    public Shuffler(Playlist playlist) {
        this.playlist = playlist;
    }

    public void run() {
        this.playlist.shuffle();
    }
}
