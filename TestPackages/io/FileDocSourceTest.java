/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author seochri1
 */
public class FileDocSourceTest {
    

    /**
     * Test of getNumDocs method, of class FileDocSource.
     */
    @Test
    public void testGetNumDocs() {
        System.out.println("getNumDocs");
        FileDocSource instance = new FileDocSource("Extracted NSF/Part1/awards_1990/awd_1990_00");
        instance.addToDoc();
        FileDocSource solnInstance = new FileDocSource("Extracted NSF/Part1/awards_1990/awd_1990_00");
        solnInstance.addToDoc();
        int expResult = solnInstance.getNumDocs();
        int result = instance.getNumDocs();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDoc method, of class FileDocSource.
     */
//    @Test
//    public void testGetDoc() {
//        System.out.println("getDoc");
//        int id = 0;
//        FileDocSource instance = null;
//        String expResult = "";
//        String result = instance.getDoc(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addToDoc method, of class FileDocSource.
//     */
//    @Test
//    public void testAddToDoc() {
//        System.out.println("addToDoc");
//        FileDocSource instance = null;
//        instance.addToDoc();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDocArray method, of class FileDocSource.
//     */
//    @Test
//    public void testGetDocArray() {
//        System.out.println("getDocArray");
//        FileDocSource instance = null;
//        ArrayList<String> expResult = null;
//        ArrayList<String> result = instance.getDocArray();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
