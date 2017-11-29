/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import static io.FileFinder.GetAllFiles;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seochri1
 */
public class FileDocSource extends DocSource{
    //should load all files from a directory name provided in the constructor as a string.
    //should not load all files into memory at the same time
    //stores an array of all filenames to be loaded on demand
    //document ID is the array index of the file name
    
    protected ArrayList<String> _document;
    protected String Direc;

    public FileDocSource(String Directory){
        _document = new ArrayList<>();
        Direc = Directory;
        addToDoc();
    }

    @Override
    public int getNumDocs() {
        return _document.size();
    }

    @Override
    public String getDoc(int id) {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        try {
            //read the file with the corresponding title
            // System.out.println(_document.get(id)); 
            cin = new BufferedReader(new FileReader((_document.get(id))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDocSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        //turn the file into a string which we can use to tokenize
                StringBuilder sb = new StringBuilder();
                //for all lines in the file, we need to append it to sb
                String line="";
        try {
            while ((line = cin.readLine()) != null)
                sb.append(line);
        } catch (IOException ex) {
            Logger.getLogger(FileDocSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        //convert the string builder into a string so we can tokenize
        String docString = sb.toString();
        return docString;
    }
    
    public void addToDoc(){
        ArrayList<File> temp = GetAllFiles(Direc);
        for (File i:temp)
            _document.add(i.getAbsolutePath());

    }
    
    public ArrayList<String> getDocArray(){
        return _document;
    }
    
}
