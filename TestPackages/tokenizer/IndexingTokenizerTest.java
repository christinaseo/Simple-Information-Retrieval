/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizer;

import java.util.ArrayList;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author seochri1
 */
public class IndexingTokenizerTest {
    /**
     * Test of tokenize method, of class IndexingTokenizer.
     */
    @Test
    public void testTokenize() {
        System.out.println("tokenize");
        IndexingTokenizer instance = new IndexingTokenizer();
        ArrayList<String> expResult = instance.soln.tokenize(new soln.io.FileDocSource("Extracted NSF/Part1/awards_1990/awd_1990_00").getDoc(1));
        ArrayList<String> result = instance.tokenize(new io.FileDocSource("Extracted NSF/Part1/awards_1990/awd_1990_00").getDoc(1));
        assertEquals(expResult, result);
    }
    
        @Test
    public void testTokenizeNotEquals() {
        System.out.println("tokenize");
        IndexingTokenizer instance = new IndexingTokenizer();
        ArrayList<String> expResult = instance.soln.tokenize(new soln.io.FileDocSource("Extracted NSF/Part1/awards_1990/awd_1990_00").getDoc(1));
        ArrayList<String> result = instance.tokenize(new io.FileDocSource("Extracted NSF/Part1/awards_1990/awd_1990_00").getDoc(3));
        assertNotEquals(expResult, result);
    }
    
}
