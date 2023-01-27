package edu.mission;

import java.util.Scanner;

public class exam06 {

	public static void main(String[] args) {
		int max;
		int min;
		int rem;
		
		Scanner kb = new Scanner(System.in);		
		System.out.print("첫번째 정수 ");
		int a =kb.nextInt();
		System.out.print("두번째 정수 ");
		int b =kb.nextInt();
		
	/*	if (a>b) {
			max =a; min =b;
			
			
		}*/
		if(a>b) {
			max=a;
			min=b;
			
		}
		else {
			max=b;
			min=a;
			
		} 
		rem=max%min;
		
		while(rem!=0) {
			max=min;
			min=rem;
			rem=max%min;
			
		}
		do {
			
		
		System.out.println(min);
		System.out.println(a*b/min);
		}
	}

		
	
	
	


