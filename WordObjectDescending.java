/*
 * Course: TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                   and Application
 *  Name:		   Alex Douk
 *  Instructor:	Mr. Schuessler
 *  Assignment:   Programming Assignment 6
 *
 *  File Name:	WordObjectDescending.java
 */

import java.util.Comparator;

/**
 * Comparator for sorting Words objects in
 * descending order based on their normal form.
 *
 * @author Alex Douk
 * @version Fall 2024
 */
public class WordObjectDescending implements Comparator<Words> {

    /**
     * Compares two Words objects by their normal form in descending order.
     *
     * @param o1 the first Words object to compare
     * @param o2 the second Words object to compare
     * @return a positive integer, zero, or a negative
     * integer if the normal form
     * of the first word is less than, equal to, or greater than the second
     */
    @Override
    public int compare(Words o1, Words o2) {
        return o2.getNormalForm().compareTo(o1.getNormalForm());
    }
}
