package app;

import linkedList.linkedList;
import node.node;

public class App {
	
	public static <T> void main(String[] args) {
		// TODO Auto-generated method stub
		linkedList<String> names    = new linkedList<String>();
		linkedList<String>lastnames = new linkedList<String>();
		linkedList<Integer>ages     = new linkedList<Integer>(19);
		names.addStart("Javier");
		names.addStart("Andres");
		names.addStart("Karely");
		names.addStart("Abraham");	
		names.addEnd("Maria");	
		names.addEnd("Alejandro");
		names.addEnd("Viviana");
		names.addEnd("Yesica");
	   	names.pronter();
		System.out.println("--------Getfirst-------");
		names.getfirst();
		System.out.println("--------Getlast-------");
		names.getlast();
		System.out.println("--------Removeafter-------");
		names.removeafter("Maria");
		names.pronter();
		System.out.println("--------Removebefore-------");
		names.removebefore("Andres");
		names.pronter();
		System.out.println("--------Replace-------");
		names.replace("Alejandro","Alex");
		names.pronter();
		System.out.println("--------IsEmpty-------");
		System.out.println(names.isEmpty());
	
		//System.out.println("-----");
		System.out.println("---------Removefirst------");
		names.removefirs();
		names.pronter();
		System.out.println("---------Removelast------");
		names.removelast();
		names.pronter();
		System.out.println("---------Reindex------");
		names.reIndex();
		System.out.println("---------Size----------");
		names.size();
		System.out.println("---------Indexof--------");
		System.out.println("La posicion es: "+names.indexof("Viviana"));
		System.out.println("---------Clear----------");
		names.clear();
		names.pronter();
		
	}
}
/*
 * Replace ****************************
 * Clear			  *****************
 * isempty            *****************
 * getfist            *****************
 * getlast           ******************
 * removefirst   **********************
 * removelast    **********************
 * size         ***********************
 * removeafter   **********************
 * removebefore  **********************
 * indexof            *****************
 * reindex            *****************
 */










