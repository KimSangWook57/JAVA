package edu.mission;

import java.util.Scanner;

public class exam08 {
	
	
//	public static void prime(int num) {
//			
//			boolean isPrime = true;
//
//			
//			for(int i = 2; i <= num/2; i++) {
//	        	
//				if(num % i == 0) {
//	            	
//					isPrime = false;
//	              
//					break;
//				}
//			}
//	System.out.println(isPrime ? "소수입니다." : "소수가 아닙니다.");
//}
	
	public static void prime(int num) {
		//나누는 수를 1씩 증가시키는 루프
		for(int i = 2; i < num; i++) {
		  //만약 다른 수로 나누어진다면	
			if (num % i == 0) {
				System.out.println("소수가 아닙니다");
				return;
			}
		}
		//다른 어떤 수로 나누어지지 않는다면
		System.out.println("소수입니다");
		return;
	}		

	  public static void main(String[] args) {
		  
		
		  
		  try(Scanner kb = new Scanner (System.in)) {
			System.out.println("Number :");
			int num;
			while((num = kb.nextInt()) !=0) {
				
				prime(num);
				
				System.out.print("Number:");
			}
		  }
		  System.out.println("프로그램을 종료하시오");
	  }
	}