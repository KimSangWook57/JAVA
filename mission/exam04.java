package edu.mission;

import java.util.Scanner;

public class exam04 {

//십진수 이진수 바꾸기
	public static void main(String[] args) {
		
	int n_10 =0;
	
	while(true) {
		Scanner kb = new Scanner(System.in);		
		System.out.print("정수를 입력하세요.(0=종료): ");
		n_10 = kb.nextInt();
		
		String n_2 ="";
		
		if (n_10 ==0) {
			System.out.println("루프를 종료합니다");
			break;
		}
		
		for(int i =n_10; i>0; i /= 2) {
			n_2=String.valueOf(i % 2) + n_2;
		}
		
		System.out.println(n_2);
	
	   }
	}
}
		
		
		
		
		
		
		
		
		
		
		