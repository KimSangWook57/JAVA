package edu.mission;

public class exam03 {

	public static void main(String[] args) {
		
		int oman =50000;
		int man =10000;
		int ochun =5000;
		int chun =1000;
		
		//값 입력
		int tot = 152000;
		
		//오만원권 매수 계산
		int cnt50 = tot/oman;
		System.out.println("5만원권 : " +cnt50);
		
		//나머지 금액 계산
		tot=tot-oman*cnt50;
		
		
		//만원권 매수 계산
		int cnt10 = tot/man;
		System.out.println("1만원권 : " +cnt10);
		
		//남은금액 계산
		tot=tot-oman*cnt10;
		
		int cnt5 = tot/ochun;
		System.out.println("5천원권 : " +cnt5);
		tot=tot-oman*cnt5;
		
	    
		
		
		
		
		
	
				
		
		
	

	}

}
