/*
 * Course: TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                   and Application
 *  Name:		   Alex Douk
 *  Instructor:	Mr. Schuessler
 *  Assignment:   Programming Assignment 6
 *
 *  File Name:	FamilySizeDescending.java
 */

import java.util.Comparator;

/**
 * Comparator for sorting AnagramFamily objects
 * in descending order of size.
 *
 * @author Alex Douk
 * @version Fall 2024
 */
public class FamilySizeDescending implements Comparator<AnagramFamily> {

    /**
     * Compares two AnagramFamily objects
     * by their size in descending order.
     *
     * @param o1 the first AnagramFamily to compare
     * @param o2 the second AnagramFamily to compare
     * @return a negative integer, zero,
     * or a positive integer if the size of the
     * first family is greater than, equal to, or less than the second
     */
    @Override
    public int compare(AnagramFamily o1, AnagramFamily o2) {
        return Integer.compare(o2.getSize(), o1.getSize());
    }
}
