package edu.mission;

import java.util.Scanner;
public class exam07_1 {
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하시오 : ");
      
		int num = sc.nextInt();

		
		boolean isPrime = true;

		
		for(int i = 2; i <= num/2; i++) {
        	
			if(num%i == 0) {
            	
				isPrime = false;
              
				break;
			}
		}
        
		
		System.out.printf(isPrime ? "소수입니다." : "소수가 아닙니다.");
	}
}