package edu.mission;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 2개의 큰 정수 더하기 연산.
// 루프와 ArrayList 활용.
// 배열을 뒤집는 메소드?
// 내 예시.

public class exam09_1 {

	static ArrayList<String> arrStr = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		try {
			// 1줄씩 읽기 위해 Scanner 코드를 사용했다. 
			Scanner sc = new Scanner(new File("input.txt"));
			// 내용이 있다면 1줄씩 읽어와서 ArrayList에 넣어준다.
			while(sc.hasNext()) {
				String str = sc.next();
				arrStr.add(str);
				System.out.println("1줄 복사 완료!");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("내용 복사 실패!");
			
		}
		
		// ArrayList를 array로 변환.
		String[] newNum = arrStr.toArray(new String[0]);
		
		// 배열에 있는 두 값 더하기.
		// 문자열을 숫자로 바꾸어서 더해 준다.
		int n1 = Integer.valueOf(newNum[0]);
		int n2 = Integer.valueOf(newNum[1]);
		int result = n1 + n2;

		// 출력 내용 확인 코드.
		System.out.println("num(Str) : " + arrStr);
		System.out.println("newNum(int) : " + Arrays.toString(newNum));
		System.out.println("result : " + result);
		
		// 결과값을 파일로 만들기.
		BufferedOutputStream bs = null;

		try {
			bs = new BufferedOutputStream(new FileOutputStream("output.txt"));
			// 결과값을 문자열로 다시 변환해서 넣어주었다.
			String str = Integer.toString(result);
			// FileOutputStream의 write() 메소드는 파라미터로 byte만 받는다(고 한다).
			bs.write(str.getBytes());
			
		} catch (Exception e) {
			  e.getStackTrace();
			  System.out.println("파일 생성 실패!");
			  
		} finally {
			  bs.close();
			  System.out.println("파일 생성 작업 완료!");
			  
		} 

	}

}