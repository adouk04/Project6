/*
 * Course: TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                   and Application
 *  Name:		   Alex Douk
 *  Instructor:	Mr. Schuessler
 *  Assignment:   Programming Assignment 6
 *
 *  File Name:	AnagramFamily.java
 */

import java.util.Collections;
import java.util.LinkedList;

/**
 * Represents a family of anagrams, consisting of a collection of words
 * that share the same canonical form (sorted version of the word).
 * This class provides methods to
 * retrieve and manipulate the anagram family.
 *
 * Each family is sorted in descending
 * order based on the normal form of the words.
 *
 * @author Alex Douk
 * @version Fall 2024
 */
public class AnagramFamily {

    private LinkedList<Words> wordsList;
    private int size;

    /**
     * Constructs an AnagramFamily object from a list of Words.
     * The words are sorted in descending order based on their normal form.
     *
     * @param wordsLinkedList the list of Words forming the family
     */
    public AnagramFamily(LinkedList<Words> wordsLinkedList) {
        wordsList = new LinkedList<>(wordsLinkedList);
        size = wordsList.size();
        Collections.sort(this.wordsList, new WordObjectDescending());
    }

    /**
     * Returns a copy of the list of Words in this family.
     *
     * @return a new LinkedList containing the Words in this family
     */
    public LinkedList<Words> getWordsList() {
        return new LinkedList<>(wordsList);
    }

    /**
     * Returns the size of this anagram family.
     *
     * @return the size of the family
     */
    public int getSize() {
        return size;
    }

    /**
     * Retrieves the canonical form (sorted version) of the first word
     * in the family, which represents the anagram family.
     *
     * @return the canonical form,
     * or an empty string if the family is empty
     */
    public String getCanonicalForm() {
        if (wordsList.isEmpty()) {
            return "";
        } else {
            return wordsList.getFirst().getCanonicalForm();
        }
    }

    /**
     * Returns a string representation of the anagram family,
     * including its size, canonical form, and words in the family.
     *
     * @return a string describing the anagram family
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family Size: ").append(size).append(", ");
        sb.append("Canonical Form: ").
                append(getCanonicalForm()).append(" List:\n");
        sb.append("Words: ");
        for (Words word : wordsList) {
            sb.append(word.getNormalForm()).append(" ");
        }
        return sb.toString().trim(); // Trim to remove the trailing space
    }
}
