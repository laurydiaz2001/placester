package com.prueba.pruebaPlacester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import com.prueba.pruebaPlacester.pojo.Item;

/**
 * ItemList - class with a list with all the unique words
 * 
 * @author : Maria Laura Díaz - 11/21/2017
 * @version : 1.0
 *
 */

public class ItemList {

	  private ArrayList<Item> wordsList;
	  
	  public ItemList() {
		super();
		this.wordsList = new ArrayList<Item>();
	  }
	
	  public ItemList(ArrayList<Item> wordsList) {
		super();
		this.wordsList = wordsList;
	  }
	
	  public ArrayList<Item> getWordsList() {
		return wordsList;
	  }

	  public void setWordsList(ArrayList<Item> wordsList) {
		this.wordsList = wordsList;
      }

	  /**
       * addWord : add a new unique word o update it
       * @param word : word to add or update
       * @param senteceNumber: number of sentece
	   *
	   */
	  public void addWord(String word, int sentenceNumber) {
		  
		if (this.wordsList.isEmpty()) {
    		Item item = new Item();
    		ArrayList<Integer> sentence_indexes = new ArrayList<Integer>();
    		
    		item.setWord(word);
    		item.setTotal_occurances(1);
    		sentence_indexes.add(sentenceNumber);
    		item.setSentence_indexes(sentence_indexes);
    		this.wordsList.add(item);
    		return;
		}
			
		boolean exist = false;
	    Iterator<Item> it = this.wordsList.iterator();
	    while( (it.hasNext()) && (!exist) ){
	       	Item i = it.next();	 	    	
	    	if(isUniqueWord(i.getWord(),word)) { 
	    		i.setTotal_occurances(i.getTotal_occurances() + 1);
	    		addIndex(sentenceNumber, i.getSentence_indexes()); 
	    	//	i.getSentence_indexes().add(lineNumber);
	    		//this.wordsList.add(this.wordsList.indexOf(i),i);
	    		exist = true;
	    	}
	     }
	    
	    if(!exist) {
    		Item item = new Item();
    		ArrayList<Integer> sentence_indexes = new ArrayList<Integer>();
	    		
    		item.setWord(word);
    		item.setTotal_occurances(1);
    		sentence_indexes.add(sentenceNumber);
    		item.setSentence_indexes(sentence_indexes);
    		this.wordsList.add(item);
	    }		  
	  }
	  
	  /**
       * addIndex : add a new sentence index
       * @param sentenceNumber : number of the sentence to add it
       * @param sentence_indexes: array of sentence index
	   *
	   */
	  public void addIndex(int sentenceNumber,ArrayList<Integer> sentence_indexes) {
		   boolean exist = false;
		   int i = 0 ; 
		   
		   while ((i < sentence_indexes.size()) && (!exist)){
	        	if (sentence_indexes.get(i) == sentenceNumber)
	        		exist = true;
	        	i++;
	       }
		   
		   if(!exist)
			   sentence_indexes.add(sentenceNumber);
	  }

	  /**
	   * Verify if it is a unique word
	   * @param itemWord: word of the wordList
	   * @param word: word of the sentences 
	   * @return true if it is a reserved words and false otherwise
       *  
	   */
	  private boolean isUniqueWord (String itemWord, String word) {
          if( (StringUtils.equalsIgnoreCase(itemWord, word)) ||
        	  (StringUtils.equalsIgnoreCase(itemWord + "s", word)) ||
        	  (StringUtils.equalsIgnoreCase(itemWord + "es", word)) ||
        	  (StringUtils.equalsIgnoreCase(itemWord, word + "s")) ||
        	  (StringUtils.equalsIgnoreCase(itemWord, word + "es")) )
        	  return true;
		  
		  return false;
	  }
	  
	  /** 
	   * Sort the itemList 
	   * @return the itemList sorted
       *  
	   */
	  public void sortItemList() {

	    Collections.sort(this.wordsList, new Comparator<Item>() {
		@Override
		public int compare(Item i1, Item i2) {
  		    return i1.getWord().toUpperCase().compareTo(i2.getWord().toUpperCase());
		} });
	  }
}
