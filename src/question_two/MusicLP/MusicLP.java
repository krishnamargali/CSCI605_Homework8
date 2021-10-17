package question_two.MusicLP;

public class MusicLP implements Comparable<MusicLP> {
    int year;
    String artist;
    String title;
    float length;
    int tracks;

    public MusicLP(int year, String artist, String title, float length, int tracks) {
        this.year = year;
        this.artist = artist;
        this.title = title;
        this.length = length;
        this.tracks = tracks;
    }

    @Override
    public int compareTo(MusicLP anotherMusicLP) {
        return compare(this.length, anotherMusicLP.length);
    }

    private static int compare(float length1, float length2)  {
        return (length1 < length1) ? -1 : ((length1 == length2) ? 0 : 1);
    }

    @Override
    public String toString() {
        return "MusicLP{" +
                "year=" + year +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", tracks=" + tracks +
                '}';
    }
}
