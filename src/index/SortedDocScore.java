/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

/**
 *
 * @author seochri1
 */
public class SortedDocScore extends DocScore implements Comparable<SortedDocScore> {

    public SortedDocScore(double score, int doc_id, String content) {
        super(score, doc_id, content);
    }

    @Override
    public int compareTo(SortedDocScore o) {
    //    if (!(o instanceof SortedDocScore))
    //       return 1;
        
        SortedDocScore E = (SortedDocScore)o;
        //first compare the score
        if(this.getScore() > E.getScore())
            return -1;
        else if (this.getScore() < E.getScore())
            return 1;
        
        //now look at alphabetically by content, double check the negative and positive
        else {
            if ((this.getContent().compareTo(E.getContent())) > 0)
                return 1;
            else if ((this.getContent().compareTo(E.getContent())) < 0)
                return -1;
            else
                return 0;
        }
    }
}
