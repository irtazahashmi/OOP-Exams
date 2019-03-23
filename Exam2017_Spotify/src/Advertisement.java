import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advertisement extends Track {
    private String advertiser;

    public String getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(String advertiser) {
        this.advertiser = advertiser;
    }

    public Advertisement(String advertiser, String length) {
        super(length);
        this.advertiser = advertiser;
    }

    public static Advertisement read(Scanner sc) {
        if (!sc.hasNext(Pattern.compile("ADD"))) {
            return null;
        }

        String line = sc.nextLine();
        Pattern trackRe = Pattern.compile("ADD (.+?), (\\d+:\\d+)");
        Matcher trackMatch = trackRe.matcher(line);

        trackMatch.find();
        String advertiser = trackMatch.group(1);
        String length = trackMatch.group(2);

        return new Advertisement(advertiser, length);
    }

    public String toString() {
        return String.format("%s (%s)", this.advertiser, this.getLength());
    }
}
