package edu.mission;


public class exam08_1 {
	

	public static boolean prime(int num) {
		for (int i = 2; i < num ; i++) {
			if(num % i == 0)  	return false;
		}
		return true;
	}		

	public static void main(String[] args) {
		  		
		  int num = Integer.parseInt(args[0]);
		  if (prime(num) == true)System.out.println ("Prime");
		  else						System.out.println ("Not Prime");
	
		  
		  System.out.println("Done");
	  } DiceGame
	}