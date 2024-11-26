import java.util.Comparator;

public class WordObjectDescending implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        int compareLength = 0;
        if (s2.length() - s1.length() != compareLength) {
            compareLength = s2.length() - s1.length();
        }
        else {
            compareLength = s2.compareToIgnoreCase(s1);
        }
        return compareLength;
    }
}