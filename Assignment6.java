/*
 * Course: TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                   and Application
 *  Name:		   Alex Douk
 *  Instructor:	Mr. Schuessler
 *  Assignment:   Programming Assignment 6
 *
 *  File Name:	Assignment6.java
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

/**
 * This program processes a list of words,
 * groups them into anagram families,
 * sorts the families by size, and writes the results to an output file.
 *
 * It reads words from an input file, sorts them,
 * groups them into families based on their canonical forms,
 * and outputs details such as the top 5 largest families,
 * families of size 8, and the last family.
 *
 * @author Alex Douk
 * @version Fall 2024
 */
public class Assignment6 {

    /**
     * The main method orchestrates the
     * program's functionality, including reading
     * input, processing words, creating anagram families,
     * and writing output to a file.
     *
     * @param theArgs
     * Command-line arguments (not used in this program).
     */
    public static void main(String[] theArgs) {
        try {
            Scanner input = new Scanner(new File("words.txt"));
            PrintStream output = new PrintStream(new File("out6.txt"));
            LinkedList<Words> words = new LinkedList<>();
            words = getWords(input, words);

            // Sort words by their canonical forms
            Collections.sort(words);

            // Create families of anagrams
            LinkedList<AnagramFamily> families =
                    createAnagramFamilies(words);

            // Sort families by size in descending order
            families.sort(new FamilySizeDescending());

            // Write results to the output file
            writeOutput(output, families);

        } catch (FileNotFoundException e) {
            System.out.println("Error Opening File(s): " + e);
            System.exit(1);
        }
    }

    /**
     * Reads words from the provided input
     * Scanner and adds them to a list.
     *
     * @param input the Scanner reading words from the input file.
     * @param word the LinkedList to store the words.
     * @return a LinkedList containing
     * the Words objects read from the input.
     */
    public static LinkedList<Words>
    getWords(Scanner input, LinkedList<Words> word) {
        while (input.hasNextLine()) {
            String currentWord = input.nextLine();
            if (!currentWord.isEmpty()) {
                word.add(new Words(currentWord));
            }
        }
        return word;
    }

    /**
     * Groups a list of Words into anagram families.
     * Each family consists of words
     * that share the same canonical form (sorted characters).
     *
     * @param words the sorted list of Words to group into families.
     * @return a LinkedList of AnagramFamily objects.
     */
    public static LinkedList<AnagramFamily>
    createAnagramFamilies(LinkedList<Words> words) {
        LinkedList<AnagramFamily> families = new LinkedList<>();
        LinkedList<Words> currentFamily = new LinkedList<>();

        Iterator<Words> iterator = words.iterator();
        Words currentWord = null;

        // Group words with the same canonical form into families
        while (iterator.hasNext()) {
            Words nextWord = iterator.next();
            if (currentWord == null ||
                    nextWord.getCanonicalForm().
                            equals(currentWord.getCanonicalForm())) {
                currentFamily.add(nextWord);
            } else {
                families.add(new AnagramFamily
                        (new LinkedList<>(currentFamily)));
                currentFamily.clear();
                currentFamily.add(nextWord);
            }
            currentWord = nextWord;
        }

        // Add the last family if not empty
        if (!currentFamily.isEmpty()) {
            families.add(new AnagramFamily
                    (new LinkedList<>(currentFamily)));
        }

        return families;
    }

    /**
     * Writes the results of the anagram family
     * analysis to the provided output stream.
     * The output includes:
     * - The top 5 largest families.
     * - All families of size 8.
     * - The last family in the sorted list.
     *
     * @param output the PrintStream to write the results to.
     * @param families the list of AnagramFamily objects, sorted by size.
     */
    public static void
    writeOutput(PrintStream output, LinkedList<AnagramFamily> families) {
        // Output the top 5 largest families
        output.println("Top 5 Largest Families:");
        for (int i = 0; i < Math.min(5, families.size()); i++) {
            output.println(families.get(i));
            output.println();
        }

        // Output families of size 8
        output.println("\nFamilies of Size 8:");
        for (AnagramFamily family : families) {
            if (family.getSize() == 8) {
                output.println(family);
                output.println();
            }
        }

        // Output the last family
        output.println("\nLast Family:");
        if (!families.isEmpty()) {
            output.println(families.get(families.size() - 1));
        }
    }
}
