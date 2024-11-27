import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

//Read the file line by line and if the line has a length > 0 - done
//Then we can store that word in a linked list of type words - done

//Then we can sort the words A-Z based on cononical form - done

//now we have create a linked list for all anagrams
//and a linked list for current anagrams to be added to
//all anagrams. Then we sort all anagrams based on family size
//highest to lowest. Then we can loop through all anagrams and sort
//the words from biggest to smallest.
//Then we can start printing our output.

public class Assignment6 {

    Scanner input = null;

    public static void main(String[] theArgs) throws FileNotFoundException {
        try {
            Scanner input = new Scanner(new File("words.txt"));
            PrintStream output = new PrintStream(new File("out6.txt"));
            LinkedList<Words> words = new LinkedList<>();
            words = getWords(input, words);

            Collections.sort(words);

            LinkedList<AnagramFamily> families = createAnagramFamilies(words);

            families.sort(new FamilySizeDescending());

            writeOutput(output, families);


        }
        catch (FileNotFoundException e) {
            System.out.println("Error Opening File(s): " + e);
            System.exit(1);
        }
    }

    public static LinkedList<Words> getWords (Scanner input,
                                              LinkedList<Words> word) {
        while (input.hasNextLine()) {
            String currentWord = input.nextLine();
            if (!currentWord.isEmpty()) {
                word.add(new Words(currentWord));
            }
        }

        return word;

    }

    public static LinkedList<AnagramFamily> createAnagramFamilies(LinkedList<Words> words) {
        LinkedList<AnagramFamily> families = new LinkedList<>();
        LinkedList<Words> currentFamily = new LinkedList<>();

        Iterator<Words> iterator = words.iterator();
        Words currentWord = null;

        while (iterator.hasNext()) {
            Words nextWord = iterator.next();
            if (currentWord == null || nextWord.getCanonicalForm().equals(currentWord.getCanonicalForm())) {
                currentFamily.add(nextWord);
            } else {
                families.add(new AnagramFamily(new LinkedList<>(currentFamily)));
                currentFamily.clear();
                currentFamily.add(nextWord);
            }
            currentWord = nextWord;
        }

        if (!currentFamily.isEmpty()) {
            families.add(new AnagramFamily(new LinkedList<>(currentFamily)));
        }

        return families;
    }


    public static void writeOutput(PrintStream output, LinkedList<AnagramFamily> families) {
        output.println("Top 5 Largest Families:");
        for (int i = 0; i < Math.min(5, families.size()); i++) {
            output.println(families.get(i));
            output.println();
        }

        output.println("\nFamilies of Size 8:");
        for (AnagramFamily family : families) {
            if (family.getSize() == 8) {
                output.println(family);
                output.println();
            }
        }

        output.println("\nLast Family:");
        if (!families.isEmpty()) {
            output.println(families.get(families.size() - 1));
        }
    }

}
