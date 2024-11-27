/*
 * Course: TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                   and Application
 *  Name:		   Alex Douk
 *  Instructor:	Mr. Schuessler
 *  Assignment:   Programming Assignment 6
 *
 *  File Name:	Words.java
 */

import java.util.Arrays;

/**
 * Represents a word with both its normal form (original string) and
 * canonical form (sorted version of the string). This class is used
 * to group words into anagram families.
 *
 * Implements Comparable to enable sorting by canonical form.
 *
 * @author Alex Douk
 * @version Fall 2024
 */
public class Words implements Comparable<Words> {

    private String normalForm;
    private String canonicalForm;

    /**
     * Constructs a Words object with its normal and canonical forms.
     *
     * @param word the original word string
     */
    public Words(String word) {
        normalForm = word;
        canonicalForm = toCanonicalWord(word);
    }

    /**
     * Converts a word into its canonical form by sorting its characters.
     *
     * @param word the original word string
     * @return the sorted version of the word
     */
    public static String toCanonicalWord(String word) {
        char[] sortedWord = word.toCharArray();
        Arrays.sort(sortedWord);
        return new String(sortedWord);
    }

    /**
     * Returns the original (normal) form of the word.
     *
     * @return the original word
     */
    public String getNormalForm() {
        return normalForm;
    }

    /**
     * Returns the canonical (sorted) form of the word.
     *
     * @return the sorted version of the word
     */
    public String getCanonicalForm() {
        return canonicalForm;
    }

    /**
     * Compares two Words objects by their canonical forms.
     *
     * @param other the Words object to compare to
     * @return a negative integer, zero,
     * or a positive integer if this object's
     * canonical form is less than, equal to, or greater than the other's
     */
    @Override
    public int compareTo(Words other) {
        return this.canonicalForm.compareTo(other.canonicalForm);
    }

    /**
     * Returns a string representation of this Words object.
     *
     * @return the normal form of the word
     */
    @Override
    public String toString() {
        return normalForm;
    }
}
