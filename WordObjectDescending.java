import java.util.Comparator;

public class WordObjectDescending implements Comparator<Words> {

    @Override
    public int compare(Words o1, Words o2) {
        return o2.getNormalForm().compareTo(o1.getNormalForm());
    }
}