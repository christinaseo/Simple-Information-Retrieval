/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author seochri1
 */
public class SortedDocScoreTest {
    /**
     * Test of compareTo method, of class SortedDocScore.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        SortedDocScore o = new SortedDocScore(4.0,1,"hello");
        SortedDocScore instance = new SortedDocScore(1.0,4,"world");
        int expResult = 1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);

    }
    
        @Test
        public void testCompareTo1() {
        System.out.println("compareTo");
        SortedDocScore o = new SortedDocScore(1.0,1,"hello");
        SortedDocScore instance = new SortedDocScore(1.0,4,"hello");
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);

    }
    
}
