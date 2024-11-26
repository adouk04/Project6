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

            Iterator<Words> iterator = words.iterator();
            LinkedList<AnagramFamily> families = new LinkedList<>();
            while (iterator.hasNext()) {

            }

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

}
