/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author seochri1
 */
public class IndexingTokenizer implements Tokenizer {

    @Override
    public ArrayList<String> tokenize(String s) {
        //need to change so it lowercases all takoens an dpreserves hyphenated words as single words
        	ArrayList<String> ret = new ArrayList<>();
		Pattern p = Pattern.compile("\\w[\\w-]*");
		Matcher m = p.matcher(s);
		while (m.find()) {
	            ret.add(m.group().toLowerCase());
        }
		return ret;
    }
    
}
