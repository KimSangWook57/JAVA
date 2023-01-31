package 자료구조123장;

//2장 스트링 배열 정렬 merge
//1차 수업 - 2번째 코딩 실습
//중복이 없는 리스트를 merge하는 버젼

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
//10장 Collection, Test01, Test02를 사용
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ArraryListMerge수정본 {
//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\
//file1: 서울,북경,상해,서울,도쿄, 뉴욕,부산
//file2: 런던, 로마,방콕, 도쿄,서울,부산
//file > string split() > 배열 > ArrayList > sort > iterator 사용하여 merge > 중복 제거 > string 배열 > file에 저장


	/*
	static int binSearch(String[] s, int n, String key) {
		//자료구조 책 페이지 115 코드 사용한다.
	}
	*/
	
	//구현할 부분 : 리스트에서 중복을 제거한다, 정렬후 호출하는 것을 전제로 구현.
	static ArrayList<String> removeDuplicate(ArrayList<String> al) {
		// 첫번째 요소와 두번째 요소를 비교하여, 같으면 하나를 지우고, 다르면 다음으로 넘어간다.
		int i = 0;
		while(i < al.size() - 1) {
			if (al.get(i).compareTo(al.get(i+1)) == 0) {
				al.remove(i);
				i--;
			}
			i++;
		}
		return al;
	}
	public static void main(String[] args) {
		try {
			Path input1 = Paths.get("a1.txt");
			byte[] bytes1 = Files.readAllBytes(input1);
			
			Path input2 = Paths.get("a2.txt");
			byte[] bytes2 = Files.readAllBytes(input2);
			String s1 = new String(bytes1);
			String s2 = new String(bytes2);		
			System.out.println("s1 = " + s1);
			System.out.println("s2 = " + s2);
			String[] sarray1 = s1.split(",|\r\n"); // 자바 regex \n으로 검색
			String[] sarray2 = s2.split(",|\r\n"); // file에서 enter키는 \r\n으로 해야 분리됨
			for (int i = 0; i <sarray1.length; i++) {
				sarray1[i] = sarray1[i].trim();  // 텍스트 공백 제거
			}
			System.out.println();
			System.out.print("sarray1 : ");
			for (String city : sarray1)
				System.out.print(city + " ");
			System.out.println();
			System.out.print("sarray1 : ");
			for (int i = 0; i <sarray2.length; i++) {
				sarray2[i] = sarray2[i].trim();
			}
			for (String city : sarray2) 
				System.out.print(city + " ");
			System.out.println();
			System.out.println("+++++++");
			// 배열을 정리하는 방법들.
			// 교수님 예제.
			/*
			// 방법1
			Arrays.sort(sarray1, (a,b) -> a.compareTo(b)); 
		 	// 방법2
			Arrays.sort(sarray1, new Comparator<String>() {
			      @Override
			      public int compare(String a1, String a2) {
			    	  return a1.compareTo(s2);
			      }
			   });
			//방법3
		    Comparator<String> cc1 = new Comparator<String>() {//익명클래스 사용 
		        public int compare(String u1, String u2) {
		          return u1.compareTo(u2);
		        }
		      };  
		      Arrays.sort(sarray1, cc1);
			*/
		      
			// file1에서 read하여 list1.add()한다.
			// 배열을 list로 만드는 방법.
			
			// 방법1:
			ArrayList<String> list1 = new ArrayList<>();
			for (String temp : sarray1) {
				list1.add(temp);
			}
			
			// 방법2 (추천)
			ArrayList<String> list2 = new ArrayList<>(Arrays.asList(sarray2));
			
			System.out.println("collection.sort()::");

			Collections.sort(list1);
			System.out.print("list1::");
			for (String city : list1)
				System.out.print(city + " ");

			//Arrays.sort(list2, null);
			System.out.println();
			System.out.print("list2::");		
			Collections.sort(list2);
			for (String city : list2)
				System.out.print(city + " ");
			
			//정렬된 list에서 중복 제거 코드
			list1 = removeDuplicate(list1);
			list2 = removeDuplicate(list2);
			
			// 중복 제거 후 
			System.out.print("\n" + "중복 제거 후 list1: ");
			for (String city : list1)
				System.out.print(city + " ");
			System.out.print("\n" + "중복 제거 후 list2: ");
			for (String city : list2)
				System.out.print(city + " ");
			ArrayList<String> list3 = new ArrayList<String>();
			// list를 사용하여 merge.
			// 교수님 예제.
			/*
			int ix = 0, iy = 0;
			while (ix < list1.size() && iy < list2.size()) {
				if (list1.get(ix).compareTo(list2.get(iy)) < 0) {
					list3.add(list1.get(ix++));
				}
				else if (list1.get(ix).compareTo(list2.get(iy)) > 0) {
					list3.add(list2.get(iy++));
				}
				else {
					list3.add(list1.get(ix++));
					list3.add(list2.get(iy++));
				}
			}
			while (ix < list1.size()) {
				list3.add(list1.get(ix++));
			}
			while (iy < list2.size()) {
				list3.add(list2.get(iy++));
			}
			*/
			
			//--------------------- array version: merge에 중복 제거하면 정상 동작함 
			String [] sl1 = new String[list1.size()];
			String [] sl2 = new String[list2.size()];
			String [] sl3 = new String[list1.size() + list2.size()];
			sl1 = list1.toArray(sl1);
			sl2 = list2.toArray(sl2);
			System.out.println("배열 출력");
			System.out.print("sl1 : ");
			for (String city : sl1)
				System.out.print(city + " ");
			System.out.println();
			System.out.print("sl2 : ");
			for (String city : sl2)
				System.out.print(city + " ");
			int px = 0, qx = 0, rx = 0;
			int cnt1 = sl1.length, cnt2 = sl2.length;
			//merge하는 부분을 구현: 스트링 배열이 정렬되고 중복이 제거된 경우.
			
		    // 내 예시.
			// 작은 값부터 넣기 위한 코드.
			while(px < cnt1 && qx < cnt2) {
				// sl1의 값이 더 작다면...
				if(sl1[px].compareTo(sl2[qx]) < 0) {
					sl3[rx++] = sl1[px++];
				} 
				// sl2의 값이 더 작다면...
				else if(sl1[px].compareTo(sl2[qx]) > 0) {
					sl3[rx++] = sl2[qx++];
				}
				// 둘의 값이 같다면 둘 다 넣어준다.
				else {
					sl3[rx++] = sl1[px++];
					sl3[rx++] = sl2[qx++];
				}
			}
			// 남은 값들을 뒤에 넣어 준다.
			while(px < cnt1) {
				sl3[rx++] = sl1[px++];
			}
			while(qx < cnt2) {
				sl3[rx++] = sl2[qx++];
			}
			
			System.out.println();
			System.out.print("sl3 : ");
			for (String city : sl3)
				System.out.print(city + " ");
			// -------------------- list version
			/*
			Iterator<String> iter1 = list1.iterator();
			Iterator<String> iter2 = list2.iterator();
			// iterator를 사용하여 merge하는 코드: 복잡하다. 비추 
			// iterator를 사용하여 merge한다
			String d1=null, d2=null, temp = null;
			int m = 0;
			while(iter1.hasNext() && iter2.hasNext()) {
				if (m == 0) {
				d1 = iter1.next();
				d2 = iter2.next();
				if (temp != null) {
					if (d1.compareTo(temp) == 0) {
						d1 = iter1.next();
						continue;
					}
					else if (d2.compareTo(temp) == 0) {
						d2 = iter2.next();
						continue;
					}else {
						list3.add(temp);
					}
				}
				m = 1;
				}
				if (d1.compareTo(d2)< 0) {
					list3.add(d1);
					d1 = iter1.next();
				}
				if (d1.compareTo(d2) > 0) {
					list3.add(d2);
					d2 = iter2.next();
				}	
				else {
					temp = d1;
					m = 0;
				}
				
			}
			while (iter1.hasNext()) {
				if (d1.compareTo(d2)> 0) {
					list3.add(d2);
					list3.add(d1);
					do {
						d1 = iter1.next();
						list3.add(d1);
					} while(iter1.hasNext());
				} else if (d1.compareTo(d2)< 0) {
					list3.add(d1);
					d1 = iter1.next();
					if (iter1.hasNext())
						continue;
					else
						if (d1.compareTo(d2)<= 0) {
							list3.add(d1);
							break;
						}
						else list3.add(d2);
				} {
					list3.add(d1);
					while (iter1.hasNext()) {
						d1 = iter1.next();
						list3.add(d1);
					}
					break;
				}
			}
			while (iter1.hasNext()) {
				//coding 필요 
			}
			*/
			
			/* 중복을 포함하여 merge하는 코드: 복잡하다. 비추
			String data1=null, data2 = null;
			int mode = 0;
			while (mode >= 0) {
				if (mode == 0) {
				data1 = iter1.next();
				data2 = iter2.next();
				System.out.println("data1 = " + data1);
				System.out.println("data2 = " + data2);
				}
				else if (mode == 1) {
					data1 = iter1.next();
					System.out.println("data1 = " + data1);
				}
				else
					data2 = iter2.next();
				System.out.println("data2 = " + data2);

				if ((data1.compareTo(data2)) <= 0) {

					list3.add(data1);
					if (iter1.hasNext())
					mode = 1;
					else {mode = -1;
					list3.add(data2);
					}
				

				} else if ((data1.compareTo(data2)) > 0) {
					list3.add(data2);
					if (iter2.hasNext())
					mode = 2;
					else {mode = -2;
					list3.add(data1);
					}
				} 
			}
			*/
			
			// binary search 구현
			// 방법1:
			//Arrays.binarySearch(null, null, null);// ArrayList에는 binarySearch()가 없다.
			// 방법2:
			// int result = Collections.binarySearch(list3, newFruit, cc);

			// 방법3:
			ArrayList<String> merge = new ArrayList<>();
			for(String item : sl3) {
				if(!merge.contains(item))
					merge.add(item);
			}
			
			System.out.println();
			System.out.print("merge:: ");
			for (String city : merge)
				System.out.print(city + " ");
			// ArrayList를 배열로 전환
			String[] st = list3.toArray(new String[list3.size()]);
			// binary search 구현
			// binSearch(st, st.length, "key");
			// 정렬된 list3을 file에 출력하는 코드 완성
			System.out.print("\n" + "file에 출력:");
			int bufferSize = 10240;
			String b = " ";
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			for (String sx : merge) {
				System.out.print(" " + sx);
				buffer.put(sx.getBytes());
				buffer.put(b.getBytes());
			}
			buffer.flip();
			FileOutputStream file = new FileOutputStream("a3.txt");
			FileChannel channel = file.getChannel();
			channel.write(buffer);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}