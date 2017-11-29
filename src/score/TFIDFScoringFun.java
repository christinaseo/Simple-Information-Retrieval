/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package score;

import index.Index;

/**
 *
 * @author seochri1
 */
public class TFIDFScoringFun implements TermScoringFun{
    Index index;

    @Override
    public void init(Index s) {
        index = s;
    }

    @Override
    public double scoreToken(String term, int freq) {
         double n = index.getDocSource().getNumDocs();
         double docfreq = index.getDocumentFreq(term);
        double score = Math.log10((double)freq+1.0) * Math.log10((double)n/(double)docfreq);
         return score;
    }
    
}
