package 자료구조123장;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

//Comparable 인터페이스를 사용하려면 compareTo() method를 구현
class Fruit implements Comparable<Fruit> {
	private String name;
	private int price;

	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "<" + name + ", " + price + ">";
	}

	@Override
	public int compareTo(Fruit o) {
		// 구현할 부분
		// 두 과일의 가격과 이름을 비교한 뒤에, 값을 반환한다.
		if 		(this.price > o.price)											return 1;
		else if (this.price < o.price)											return -1;
		// 조건이 맞지 않는 값들 중에서는 가격을 우선시한다.
		// else if (this.price == o.price && this.name.compareTo(o.name) == 1)		return 1;
		// else if (this.price == o.price && this.name.compareTo(o.name) == -1) 	return -1;
		else 																	return 0;
	}

	public int getPrice() {
		return price;
	}
}

//===========================

public class Chap3_객체정렬 {

	public static void main(String[] args) {
//	String[] s = { "sort", "string", "array" };
//	Arrays.sort(s);
//	Arrays.sort(s, Comparator.naturalOrder());  // 오름차순?
//	Arrays.sort(s, Comparator.reverseOrder());  // 내림차순?

		/*
		 * Arrays.sort(s, new Comparator<String>() {
		 * 
		 * @Override public int compare(String o1, String o2) { return o2.compareTo(o1);
		 * // 내림차순으로 정렬 } });
		 */
//	s = Arrays.stream(s).sorted().toArray(String[]::new);	// 리스트 -> 배열
//	s = Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);
//	Collections.sort(Arrays.asList(s));		// 배열 -> 리스트
		Fruit[] arr = { new Fruit("사과", 200), 
						new Fruit("키위", 500), 
						new Fruit("오렌지", 200), 
						new Fruit("바나나", 50),
						new Fruit("수박", 880), 
						new Fruit("체리", 10) };

		System.out.println(arr);
		System.out.println("정렬 전::");
		for (Fruit item : arr)
			System.out.print(" " + item);
		// Fruit에 compareTo()가 있어도 람다식 우선 적용
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice());
		// Arrays.sort(arr);
		
		
		
//		int count = arr.length;
//			for (int i = 0; i < count; i++)
//				for (int j = i +1; j < count; j++) {
//					if (arr[i].compareTo(arr[j]) > 0) {
//						Fruit temp; temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
//					}
//				}
			
		System.out.println();
		System.out.println("정렬 후::");
		for (Fruit item : arr)
			System.out.print(" " + item);

		ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr));
		ArrayList<Fruit> lst2 = new ArrayList<Fruit>();
		lst2.add(new Fruit("복숭아", 200));
		lst2.add(new Fruit("포도", 300));
		lst2.add(new Fruit("참외", 100));
		lst2.add(new Fruit("딸기", 50));
		lst2.add(new Fruit("블루베리", 500));
		lst2.add(new Fruit("구지뽕", 300));
		
		System.out.println();
		System.out.println("새로운 리스트2::");
		for (Fruit item : lst2)
			System.out.print(" " + item);
		// 아래 코드는 배열이 아니어서 오류가 뜬다.
		// Arrays.sort(lst2); 
		Collections.sort(lst2);
		System.out.println();
		System.out.println("정렬된 새로운 리스트2::");
		for (Fruit item : lst2)
			System.out.print(" " + item);

		ArrayList<Fruit> lst3 = new ArrayList<Fruit>();

		Iterator<Fruit> iter1 = lst1.iterator();
		Iterator<Fruit> iter2 = lst2.iterator();
		Fruit data1 = iter1.next();
		Fruit data2 = iter2.next();
		// 구현할 부분(if문)
		// 루프를 돌며 내용들을 더한다.
		while(iter1.hasNext() && iter2.hasNext()) {
			if (data1.compareTo(data2) < 0) {
				lst3.add(data1);
				data1 = iter1.next();
			} else if (data1.compareTo(data2) > 0){
				lst3.add(data2);
				data2 = iter2.next();
			} else {
				lst3.add(data1);
				lst3.add(data2);
				data1 = iter1.next();
				data2 = iter2.next();
			}
		}
		// 남은 부분들을 가져다 붙인다.
		while(iter1.hasNext()) {
			lst3.add(data1);
			data1 = iter1.next();
		}
		while(iter2.hasNext()) {
			lst3.add(data2);
			data2 = iter2.next();
		}
		
		System.out.println();
		System.out.println("merge:: ");
		for (Fruit item : lst3)
			System.out.print(item + " ");
		// 새로운 과일인 "참외"를 넣는다.
		Fruit newFruit = new Fruit("참외", 100);
		// binary search
		Comparator<Fruit> cc = new Comparator<Fruit>() {
			// 익명클래스 사용
			public int compare(Fruit u1, Fruit u2) {
				return u1.compareTo(u2);
			}
		};
		int res = cc.compare(data1, newFruit);
		if (res > 0)
			System.out.println("\ndata1 > newFruit\n");
		/*
		 * System.out.println(); int result = Collections.binarySearch(lst3, newFruit, cc); 
		 * System.out.println("\nCollections.binarySearch() 조회결과::" +
		 * lst3.get(result));
		 *  // 이름이 같은 것만? 아니면 이름과 가격이 같은 것만?
		 */
		
		// 배열 생성.
		Fruit[] fa = new Fruit[lst3.size()];
		// ArrayList -> Array
		fa = lst3.toArray(fa);
		int result3 = Arrays.binarySearch(fa, newFruit, cc);
		System.out.println("\nArrays.binarySearch() 조회결과::" + lst3.get(result3));
		/*
		 * int result2 = binSearch(fa, lst3.size(), newFruit);
		 * System.out.println("\nbinSearch() 조회결과:" + lst3.get(result2));
		 */
	}

	// 교재 109 페이지 참조하여 구현.
	// 비교연산자 부분에 주의. (CompareTo 사용.)
	static int binSearch(Fruit[] a, int n, Fruit f) {
		// 구현할 부분
		
	}
}
