import java.util.Collections;
import java.util.LinkedList;

public class AnagramFamily {
    private LinkedList<Words> wordsList;
    private int size;
    public AnagramFamily(LinkedList<Words> wordsLinkedList) {
        wordsList = new LinkedList<>(wordsLinkedList);
        size = wordsList.size();

        Collections.sort(this.wordsList, new WordObjectDescending());
    }

    public LinkedList<Words> getWordsList() {
        return new LinkedList<>(wordsList);
    }

    public int getSize() {
        return size;
    }

    public String getCanonicalForm() {
        if (wordsList.isEmpty()) {
            return "";
        } else {
            return wordsList.getFirst().getCanonicalForm();
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family Size: ").append(size).append(", ");
        sb.append("Canonical Form: ").append(getCanonicalForm()).append(" List:\n");
        sb.append("Words: ");
        for (Words word : wordsList) {
            sb.append(word.getNormalForm()).append(" ");
        }
        return sb.toString().trim(); // Trim to remove the trailing space
    }

}
