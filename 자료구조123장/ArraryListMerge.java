package 자료구조123장;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

//10장 Collection의 Test01, Test02를 사용

//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list.
//list1: 서울,북경,상해,서울,도쿄,뉴욕,부산
//list2: 런던,로마,방콕,도쿄,서울,부산
// String [] 변수명 = s.split(",")를 이용해 spilt한다.


//file > string split() > 배열 > ArrayList > sort > iterator 사용하여 merge > 중복 제거 > string 배열 > file에 저장
// 두 행렬의 값을 비교하여 작은 값(빠른 순서)을 먼저 집어넣도록 한다.

public class ArraryListMerge {
	/*
	static int binSearch(String[] s, int n, String key) {
		//자료구조 책 페이지 115 코드 사용한다.
	}
	*/
	public static void main(String[] args) {
		try {
			// 2개의 파일로부터 각각 정보를 받는다.
			Path input1 = Paths.get("list1.txt");
			byte[] bytes1 = Files.readAllBytes(input1);
			Path input2 = Paths.get("list2.txt");
			byte[] bytes2 = Files.readAllBytes(input2);

			String[] sarray1 = new String[20];
			String[] sarray2 = new String[20];
			
			String s1 = new String(bytes1);
			String s2 = new String(bytes2);
		    System.out.println("s1 = " + s1);
		    System.out.println("s2 = " + s2);
		    sarray1 = s1.split(",");
		    sarray2 = s2.split(",");
			
			// list1에서 read하여 list1.add()한다.
		    // list2에서 read하여 list2.add()한다.
			// 배열을 list로 만드는 방법
			// 방법1:
//			ArrayList<String> arrayList = new ArrayList<>();
//			for (String temp : sarray) {
//				arrayList.add(temp);
//			}
			// 방법2
			ArrayList<String> list1 = new ArrayList<>(Arrays.asList(sarray1));
			ArrayList<String> list2 = new ArrayList<>(Arrays.asList(sarray2));
			
			System.out.println("collection.sort():");
			// 정렬.
			// Arrays.sort()
			Collections.sort(list1);
			System.out.print("list1 : ");
			for (String city : list1)
				System.out.print(city + " ");
			System.out.println();
			
			System.out.print("list2 : ");
			Collections.sort(list2);
			for (String city : list2)
				System.out.print(city + " ");
			
			ArrayList<String> list3 = new ArrayList<String>();

//			for (Iterator<String> iter1 = list1.iterator(); iter1.hasNext();) {
//				String data1 = iter1.next();
//				list3.add(data1);
//			}
//			for (Iterator<String> iter2 = list2.iterator(); iter2.hasNext();) {
//				String data2 = iter2.next();
//				list3.add(data2);
//			}
			
			// iterator를 사용하여 merge한다.
		    Iterator<String> iter1 = list1.iterator();
			Iterator<String> iter2 = list2.iterator();
			String data1 = iter1.next();
			String data2 = iter2.next();
			
			//ArrayList를 merge하는 코드 구현 list3 = list1 + list2(merge)
			
			// 루프를 돌며 내용들을 더한다.
			while(iter1.hasNext() && iter2.hasNext()) {
				if (data1.compareTo(data2) < 0) {
					list3.add(data1);
					data1 = iter1.next();
				} else if (data1.compareTo(data2) > 0){
					list3.add(data2);
					data2 = iter2.next();
				} else {
					list3.add(data1);
					list3.add(data2);
					data1 = iter1.next();
					data2 = iter2.next();
				}
			}
			// 남은 부분들을 가져다 붙인다.
			while(iter1.hasNext()) {
				list3.add(data1);
				data1 = iter1.next();
			}
			while(iter2.hasNext()) {
				list3.add(data2);
				data2 = iter2.next();
			}
			
			// list3를 정리한 리스트인 sortlist3를 만들었다.
			ArrayList<String> sortlist3 = new ArrayList<String>();
			for (String temp : list3) {
				if (!sortlist3.contains(temp)) {
					sortlist3.add(temp);
				}
			}
			
			
			// binary search 구현(sort되어 있어야 함)
			// 방법1:
			// Arrays.binarySearch(null, null, null);
			// ArrayList에는 binarySearch()가 없다.
			// 방법2:
			// int result = Collections.binarySearch(list3, newFruit, cc);
			// 방법3:

			System.out.println();
			System.out.print("merge : ");
			for (String city : sortlist3)
				System.out.print(city + " ");
			// ArrayList를 배열로 전환
			// String[] st = sortlist3.toArray(new String[sortlist3.size()]);
			// binary search 구현
			// binSearch(st, st.length, "key");
			// 정렬된 list3을 file에 출력하는 코드 완성
			int bufferSize = 10240;
			String b = " ";
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			for (String sx : sortlist3) {
				//System.out.println(" " + sx);
				buffer.put(sx.getBytes());
				buffer.put(b.getBytes());
			}
			buffer.flip();
			FileOutputStream file = new FileOutputStream("list3.txt");
			FileChannel channel = file.getChannel();
			channel.write(buffer);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
