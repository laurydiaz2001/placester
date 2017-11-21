package com.prueba.pruebaPlacester;

import java.util.Iterator;

import com.google.gson.Gson;
import com.prueba.pruebaPlacester.pojo.Item;
import com.prueba.pruebaPlacester.util.FileUtils;

/**
 * Test Placester - Main
 * 
 * @author : Maria Laura Díaz - 11/21/2017
 * @version : 1.0
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String fileName = "src\\main\\resources\\text.txt"; 
  	    ItemList itemsList = new ItemList();
  	    
        
        //Parse of text
        FileUtils.parseText(fileName,itemsList);
            
        //sort results
        itemsList.sortItemList();
        
        //show results
        System.out.println("Results:");
        
        Gson gson = new Gson();
        Iterator<Item> it = itemsList.getWordsList().iterator();
        while(it.hasNext()){
        	Item i = it.next();
        	String json = gson.toJson(i);
        	System.out.println(json);
        }
    }
}
