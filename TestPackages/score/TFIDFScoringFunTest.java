/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package score;

import index.Index;
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
public class TFIDFScoringFunTest {
    Index index = new index.InvertedIndex(new io.FileDocSource("Extracted NSF/Part1/awards_1990/awd_1990_00"), 
				                          new tokenizer.IndexingTokenizer(), 
										  new score.TFIDFScoringFun());
    
    //@BeforeClass
    //public static void setUpClass() {
    //}
    
    //@AfterClass
    //public static void tearDownClass() {
    //}
    
    //@Before
    //public void setUp() {
    //}
    
    //@After
    //public void tearDown() {
    //}

   // @Test
    //public void testInit(){
      //  index = new index.InvertedIndex(new io.FileDocSource("Extracted NSF/Part1/awards_1990/awd_1990_00"), 
	//			                          new tokenizer.IndexingTokenizer(), 
	//									  new score.TFIDFScoringFun());
    //}
    /**
     * Test of scoreToken method, of class TFIDFScoringFun.
     */
    @Test
    public void testScoreToken() {
        System.out.println("scoreToken");
        String term = "candy";
        int freq = 0;
        TFIDFScoringFun instance = new TFIDFScoringFun();
        instance.init(index);
        double expResult = 0.0;
        double result = instance.scoreToken(term, freq);
        assertEquals(expResult, result, 0.0);
    }
    
//        @Test
//    public void testScoreToken2() {
//        System.out.println("scoreToken");
//        String term = "commercial";
//        int freq = 1;
//        TFIDFScoringFun instance = new TFIDFScoringFun();
//        instance.init(index);
//        double expResult = 0.7765922449035682;
//       double result = instance.scoreToken(term, freq);
//        assertEquals(expResult, result, 0.7765922449035682);
//    }
    
}
