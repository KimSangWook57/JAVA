package edu.mission;

public class exam05 {

// 행렬을 합치는 계산 메소드 merge.

	public int[] merge(int[] a, int[] b) {
		
		int[] c = new int [a.length + b.length];
		
		
		for(int i = 0; i < c.length; i++) {
		
			if (i == 0) {
		
				c[0] = a[0];
		
			}
		
			else if (i % 2 == 0) {
		
			c[i] = a[i/2];
		
			} else {
		
			c[i] = b[i/2];
		
			}
		
		}
		
		
		return c;
		
	}
		
		// 행렬 출력.
		
	public void printArray(int[] c) {

	
		for(int i = 0; i < c.length; i++) {
		
			System.out.print(c[i] + " ");
		
		}
		
		System.out.println();
		
	}
		
	
	public static void main(String[] args) {
	
		int[] a = {1, 3, 5, 7, 9, 11};
		
		int[] b = {2, 4, 6, 8, 10, 12};
		
		// 메소드 객체 생성.
		
		exam05 ex = new exam05();
		
		// 인스턴스 호출.
		
		int[] c = ex.merge(a, b);
		
		ex.printArray(a);
		
		ex.printArray(b);
		
		ex.printArray(c);


}

}

	
	

