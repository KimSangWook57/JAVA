package edu.mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// 교수님 예제.

public class exam09_2 {
	// numArr를 선언, ArratList<> 안에 <ArrayList<Integer>를 넣었다.
	private static ArrayList<ArrayList<Integer>> numArr = new ArrayList<>();
	// 숫자를 읽어들이는 코드.
	public static boolean readNumber() {

		String str;
		// 파일에서 숫자를 읽어온다.
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));) {
			// 첫번째 줄과 두번째 줄을 읽어들여서 리스트에 넣는다.
			for (int i = 0; i < 2; i++) {

				numArr.add(new ArrayList<Integer>());
				str = br.readLine();
				
				if (str == null)	return false;

				System.out.println("str=" + str);
				// str에 넣었던 문자열 숫자를 두 배열에 쪼개서 넣어준다.
				String[] arr = str.split("");
				// 일의 자리 수부터 배열에 거꾸로 넣는다.
				for (int j = arr.length - 1; 0 <= j; j--) {
					numArr.get(i).add(Integer.parseInt(arr[j]));
				}
				// ['1', '2', '3', '4', '5'], ['9', '8', '7', '6']
				// 
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

// 두 숫자 읽어서 배열로 입력
		// 오류 처리 코드.
		if (readNumber() == false) {
			System.out.println("Error");
			return;
		}
		
// 자리수가 큰 배열을 0번째로 설정
		// 자리수 비교 코드
		int dif = numArr.get(0).size() - numArr.get(1).size();
		// 왼쪽이 더 작다면 배열의 위치를 바꾸어 준다.
		if (dif < 0) {
			ArrayList<Integer> tArr = numArr.get(0);
			numArr.set(0, numArr.get(1));
			numArr.set(1, tArr);
			// 음수값을 양수로 바꾼다.
			dif = Math.abs(dif);
		}

// 두 배열 더하기
		// 자릿수 체크용 코드.
		int olrim = 0;
		// 먼저 작은 배열의 크기까지 루프를 돌며 각 배열의 수를 더한다.
		for (int i = 0; i < numArr.get(1).size(); i++) {
			int sum = numArr.get(0).get(i) + numArr.get(1).get(i) + olrim;
			// 더한 값이 10을 넘는다면, 자리수를 올려주고 나머지 값을 대입한다.
			numArr.get(0).set(i, sum % 10);
			if (10 <= sum)	olrim = 1;
			else			olrim = 0;
		}
		// 자릿수 값이 체크되었다면...
		if (olrim == 1) {
			// 두 배열의 사이즈가 같다면 평범하게 더하면 된다.
			if (numArr.get(0).size() == numArr.get(1).size()) {
				numArr.get(0).add(1);
			}
			// 두 배열의 사이즈가 다르다면...
			// ['1', '2', '3', '4', '5']
			// ['9', '8', '7', '6']
			else {
				// 2번째 배열의 제일 높은 자릿수 값을 체크. 
				for (int i = numArr.get(1).size(); i < numArr.get(0).size(); i++) {
					
					int sum = numArr.get(0).get(i) + olrim;
					numArr.get(0).set(i, sum % 10);
					
					if (10 <= sum) {
						olrim = 1;
					} else {
						olrim = 0;
						break;
					}
				}

				if (olrim == 1)
					numArr.get(0).add(1);
			}
		}

// 결과 출력하기
		// 일의 자리부터 찍기 위해 배열의 끝(오른쪽)에 있는 값을 넣은 뒤, 왼쪽으로 더해지도록 만든다.
		for (int i = numArr.get(0).size() - 1; 0 <= i; i--) {
			System.out.print(numArr.get(0).get(i));
		}

		System.out.println("\nDone");

	}

}