import java.util.Arrays;

public class Words implements Comparable<Words> {

    private String normalForm;
    private String canonicalForm;

    public Words(String word) {
        normalForm = word;
        canonicalForm = toCanonicalWord(word);
    }

    public static String toCanonicalWord(String word) {
        char[] sortedWord = word.toCharArray();
        Arrays.sort(sortedWord);
        String canonicalWord = new String(sortedWord);
        return canonicalWord;
    }

    public String getNormalForm() {
        return normalForm;
    }

    public String getCanonicalForm() {
        return canonicalForm;
    }

    @Override
    public int compareTo(Words other) {
        return this.canonicalForm.compareTo(other.canonicalForm);
    }

    @Override
    public String toString() {
        return normalForm;
    }
}