package edu.mission;

import java.util.Scanner;

public class exam02 {

	public static void main(String[] args) {
		

		Scanner sc=new Scanner(System.in);
		System.out.print("정수 : ");
		int num=sc.nextInt();
		System.out.print(num+" : ");
		
		
		
		
		int BI7=num%2;
		num/=2;
		int BI6=num%2;
		num/=2;
		int BI5=num%2;
		num/=2;
		int BI4=num%2;
		num/=2;
		int BI3=num%2;
		num/=2;
		int BI2=num%2;
		num/=2;
		int BI1=num%2;
		System.out.print(BI1+""+BI2+""+BI3+""+BI4+""+BI5+""+BI6+""+BI7);
	}
}
