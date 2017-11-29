/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import io.DocSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import score.TermScoringFun;
import tokenizer.Tokenizer;

/**
 *
 * @author seochri1
 */
//This class indexes all of the documents
//in the DocSource and provides an interface for efficiently searching them and returning ranked results
//scored by TF-IDF once the index is built.



public class InvertedIndex extends Index{
   
    //string is a token and it maps to a hashmap that contains all the
    //documents that the token shows up in, and the term frequency
    private HashMap<String,HashMap<Integer,Integer>> _index;
    //count of documents that contain the word and is capped by the total number of documents
    private HashMap<String,Integer> _docFreq;

    public InvertedIndex(DocSource doc_source, Tokenizer tokenizer, TermScoringFun scoring) {
        super(doc_source, tokenizer, scoring);
        _index = new HashMap<>();
        _docFreq = new HashMap<>();
    }
    

    @Override
    public void buildIndex() {
        //loop through every document
        for (int i=0; i < _docSource.getNumDocs(); i++){
                //Tokenize all words in the string, we are left with an arraylist of strings which represents the tokens
                ArrayList<String> tokens = _tokenizer.tokenize(_docSource.getDoc(i));
                //for all tokens, add it to the given hashmaps
                for (String temp:tokens){
                    Integer count = 0;
                    //Get the term frequency 
                    for (String temp2:tokens){
                        if(temp2.equals(temp))
                            count++;
                    }        
                    //if it is not already in the hashmap
                    if (_index.containsKey(temp) == false){ 
                        HashMap<Integer,Integer> tempHash = new HashMap<>();
                     tempHash.put(i, count);
                        _index.put(temp,tempHash);
                    }
                    //if it is already in the hashmap
                    else if (_index.containsKey(temp))
                        _index.get(temp).put(i,count);
                }
                //for all tokens in the index, get the document frequency
                for (String s : _index.keySet())
                    _docFreq.put(s, _index.get(s).size());
        }
    }

    @Override
    public int getDocumentFreq(String term) {
        if (_docFreq.get(term) == null)
            return 1;
        else
            return _docFreq.get(term);
    }
    

    @Override
    public ArrayList<DocScore> getSortedSearchResults(String query) {
        //maintain a hashmap (term scores are provided by _scoring data member)
        HashMap<Integer, Double> docVals = new HashMap<>();
        TreeSet<SortedDocScore> sortedDocs = new TreeSet<>();
        //tokenize the query
        ArrayList<String> tokens = _tokenizer.tokenize(query);        
        //for all the tokens, add the the sorted docs array list
        for (String token:tokens) {
            if ((_index.containsKey(token))){
            //Get the hashmap that corresponds to the token
            HashMap<Integer,Integer> innerHash = _index.get(token);
            //Loop through all the documents in this token
            for (int i : innerHash.keySet()){
                //if this is the first time the document has shown up, make a new sortedDocScore and add to sortedDocs
                if (!(docVals.containsKey(i))){
                    docVals.put(i, _scoring.scoreToken(token, _index.get(token).get(i)));
                 }
                //else it is not new, overwrite existing score
                else {
                    double tempscore = docVals.get(i);
                    docVals.put(i,tempscore + _scoring.scoreToken(token, _index.get(token).get(i)));
                    //find the value in sortedDocs and add the new score on top of the existing score                    
                }  
            }
            }       
        }
        //add to sorted doc score
        for (Integer key:docVals.keySet()){
            SortedDocScore tempDoc = new SortedDocScore(docVals.get(key), key, _docSource.getDoc(key));
            sortedDocs.add(tempDoc);
                
        }
        ArrayList<DocScore> list = new ArrayList<>(sortedDocs.size());
        list.addAll(sortedDocs);
        //returns list of sortedDcosCores sorted by compareto used in sorteddocscore
        return list;
    }
 
}
