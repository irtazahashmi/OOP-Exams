import java.io.File;
import java.util.Scanner;

public class Spotify {
    public static void main(String... args) throws Exception {
        File fp = new File("spotify.txt");
        Scanner fileScanner = new Scanner(fp);
        Scanner stdinScanner = new Scanner(System.in);

        // Read the file
        Playlist playlist = Playlist.read(fileScanner);

        mainLoop: for (;;) {
            System.out.println(
                    "Please make your choice:\n1 - Show the current playlist\n2 – Add a new CD including songs\n3 – Play\n4 – Shuffle\n5 – Stop the program");
            int option = stdinScanner.nextInt();
            stdinScanner.nextLine();
            switch (option) {
            case 1:
                System.out.println(playlist.toString());
                break;
            case 2:
                addCd(stdinScanner, playlist);
                break;
            case 3:
                System.out.println(playlist.play());
                break;
            case 4:
                (new Shuffler(playlist)).start();
                // Display 2 off the top
                System.out.println(playlist.play());
                System.out.println(playlist.play());
                break;
            case 5:
            default:
                break mainLoop;
            }
        }

        fileScanner.close();
    }

    private static void addCd(Scanner stdin, Playlist playlist) {
        System.out.println("New CD!\nEnter artist:");
        String artist = stdin.nextLine();
        System.out.println("Enter album title:");
        String title = stdin.nextLine();
        System.out.println("Enter year of release:");
        int year = Integer.parseInt(stdin.nextLine());
        CompactDisc cd = new CompactDisc(artist, title, year);

        System.out.println("How many songs?");
        int songsLen = Integer.parseInt(stdin.nextLine());
        for (int i = 0; i < songsLen; i++) {
            System.out.println(String.format("Enter song title %d:", i));
            String songTitle = stdin.nextLine();
            System.out.println("Enter length (mm:ss):");
            String length = stdin.nextLine();
            Song song = new Song(i + 1, songTitle, length);
            song.setCd(cd);
            cd.addSong(song);
        }

        playlist.addCd(cd);
    }
}
