import java.util.Comparator;

public class FamilySizeDescending implements Comparator<AnagramFamily> {

    @Override
    public int compare(AnagramFamily o1, AnagramFamily o2) {
        return Integer.compare(o2.getSize(), o1.getSize());
    }

}
