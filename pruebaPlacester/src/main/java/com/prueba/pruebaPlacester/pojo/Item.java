package com.prueba.pruebaPlacester.pojo;

import java.util.ArrayList;

/**
 * Item - unique word
 * 
 * @author : Maria Laura Díaz - 11/21/2017
 * @version : 1.0
 *
 */

public class Item {
	
	String word;
	int total_occurances;
	ArrayList<Integer> sentence_indexes;
	
	public Item() {
		super();
	}
	
	public Item(String word, int total_occurances, ArrayList<Integer> sentence_indexes) {
		super();
		this.word = word;
		this.total_occurances = total_occurances;
		this.sentence_indexes = sentence_indexes;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public Integer getTotal_occurances() {
		return total_occurances;
	}
	
	public void setTotal_occurances(Integer total_occurances) {
		this.total_occurances = total_occurances;
	}
	
	public ArrayList<Integer> getSentence_indexes() {
		return sentence_indexes;
	}
	
	public void setSentence_indexes(ArrayList<Integer> sentence_indexes) {
		this.sentence_indexes = sentence_indexes;
	}
}
