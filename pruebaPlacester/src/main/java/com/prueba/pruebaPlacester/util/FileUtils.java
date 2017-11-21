package com.prueba.pruebaPlacester.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.commons.lang3.StringUtils;
import com.prueba.pruebaPlacester.ItemList;


/**
 * FileUtils: Many useful functions for text parsing
 * 
 * @author : Maria Laura Díaz - 11/21/2017
 * @version : 1.0
 *
 */

public class FileUtils {
	  public enum ResevedWords{
	 	 A, THE, AND, OF, IN, BE, ALSO, AS
	  }
	
	  /**
	   * Verify if it is a reserved words
	   * @return true if it is a reserved words and false otherwise
       *  
	   */
	  private static boolean isReservedWord (String word) {
		  for (ResevedWords r : ResevedWords.values()) {
			   if(StringUtils.equalsIgnoreCase(r.toString(), word))
				   return true;
		  }
		  return false;
	  }

	  /**
	   * Parse the text with the statement of the exercise
	   * @param nameFile: name file text
	   * @param wordsList: list with all the unique words
	   * @return 
       *  
	   */
	  public static void parseText(String nameFile, ItemList itemList) {
	        File f = null;
	        FileReader fr = null;
	        BufferedReader br = null;	        
	  	    int totalLines = 0 ;
	  	   
	        try {
				f = new File (nameFile);
				fr = new FileReader (f);
				br = new BufferedReader(fr);
				String line;
				
				// Reading the file
				while((line=br.readLine())!=null) {
					totalLines = parserLine(line,totalLines,itemList);
				}
	        }
	        catch(Exception e){
	           e.printStackTrace();
	        }finally{
	           // Closing the file
	           try{
	              if( null != fr ){
	                 fr.close();
	              }
	           }catch (Exception e2){
	              e2.printStackTrace();
	           }
	        }
	    }
	  
	  /**
	   * Parse the text line
	   * @param line : line text
	   * @param totalLines : number of lines
	   * @param wordsList: list of unique words
	   * @return total number of statements
       *  
	   */
	   public static int parserLine(String line, int totalSentences,ItemList itemList) {
		   String[] lines;
		   String[] words;
		   int j;
		   int k;
		   String regExp = "\\ |\\,|\"|\\:|\\[|\\]|\\{|\\}";
		   		   		   
		   lines = line.split("\\.");  //divide the lines in sentences
		   j = 0;
		   while (j < lines.length) {
			  words = lines[j].split(regExp);	
			  k = 0;
			  while (k < words.length) {
				  if (StringUtils.isNotEmpty(words[k]) && !isReservedWord(words[k])) {
					  itemList.addWord(words[k], totalSentences);
				  }
				  k++;		
			  }
			  j++;
			  totalSentences++;
		   }
		   
		   return totalSentences;
	   }
	  
}
