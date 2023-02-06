package edu.mission;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class exam09 {

// 큰 정수 더하기 연산.
// 루프와 arraylist 활용.
// 배열을 뒤집는 메소드.


// 내용 읽어들이기.

	public static ArrayList<String> readNumbers() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			String str = br.readLine();

			// 배열로 만들어서 리스트에 담기.

			while (str != null) {
				byte_list.add(str); // list에 저장.
				str = br.readLine();
			}

			// ArrayReverse(byte_list);

			System.out.println(byte_list);
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

		// 리스트 선언.
		ArrayList<String> byte_list = new ArrayList<String>();

		for (int i = 0; i < byte_list.size(); i++) {
			System.out.println(byte_list.get(i));
		}

		// 배열로 나눈 숫자들을 한 글자씩 담을 배열 만들기.

		// 한 글자씩 나눈 배열들을 더하기.

		// 내용물을 출력해서 파일로 만들기.

		System.out.println("작업 종료.");

	}

}