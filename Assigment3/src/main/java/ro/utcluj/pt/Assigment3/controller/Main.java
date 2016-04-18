package ro.utcluj.pt.Assigment3.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import  ro.utcluj.pt.Assigment3.model.Simulator;

public class Main {

	public static void main(String[] args) {
		
		/*
		Date date = new Date(System.currentTimeMillis() +300000);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate); 
		*/
//		LinkedList<Object> a = new LinkedList<Object>();
//		Object b =new Object();
//		a.add(b);
//		a.add(b);
//		a.add(b);
//		a.add(b);
//		a.add(b);
//		a.add(b);
//		int size =a.size();
//		for(int i=0;i<size;i++)
//		{
//			a.remove(i);
//			System.out.println(i+".");
//			System.out.print(size+"-");
//			size = a.size();
//			System.out.print(size);
//			System.out.println();
//		}
//	
		new AppController();
		
	}

}
