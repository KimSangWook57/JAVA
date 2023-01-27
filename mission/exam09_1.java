package edu.mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class exam09_1 {

	
	public static ArrayList<String>readNumber() {
	try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		String str;		 
		while((str =br.readLine()) != null) {
			System.out.println(str);
			list.add(str);
		}

		return list;
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}	

	
	public static void main(String[] args) {
	

		
		
		
		
		// 먼저 데이터를 읽으들여서 배열로 만든다.		
		if (randNumber)
		// 각 배열 데이터를 모두 잘라서 역순으로 숫자 배열로 만든다.
		// 두 배열을 더한다.	==> arr1이 arr2보다 개수가 많다고 가정
		// 출력한다.
		
		
		
		
		
		
		
	}

}
