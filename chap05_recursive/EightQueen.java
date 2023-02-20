package chap05_recursive;

import java.awt.Point;

public class EightQueen {
	//  문제 해결형 자바 코딩 실습이 필요.
	//  - main()의 작성 방법 훈련 -
	
	//  배열 초기화
	int[][] data = new int[8][8];

	public static void main(String[] args) {

		// 문제 해결 코드.
		Mystack s1 = new Mystack();

		// 배열의 열 출력: 8개의 queen 배치.(92개의 해를 구해 보여주기)
		SolveQueen();
	}

//  함수 호출로 구현 훈련. 0과 1을 빈 공간과 채워진 공간으로 바꾸어 준 뒤,
//  결과값을 출력해 준다.
	static void SolveQueen() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				System.out.print(data[row][col] + " ");
			}
			System.out.println();
		}

	}

}
//  => 8 Queen 문제 풀기: 스택 사용하여 backtracking 코딩 실습.
//  -> 2차원 배열에 0으로 초기화, Queen을 배치하면 1로 설정,
//  8 X 8 배열에 8개 퀸이 가로 세로 대각선에 충돌이 없으면 성공.
//  -> stack에 Point 객체를 생성하여 push, pop::(x, y, move) =>
//  move는 다음 이동 가능 candidate의 column임.

	// current row에 대한 다음 배치 가능한 모든 column을 조사하고 move[]에 1로 설정.
	// 조건이 맞는 곳에 퀸을 집어넣는다.
	void NextMove(Point move, int value) {
		// 배치가 가능할 때만 move에 1을 넣는다.
		data[move.x][move.y] = value;
	}

	class MyStack {
		// int top;
		Point[] data;

		// 문제를 푸는 코드.
		void solve(int row) {
			// 모든 row를 돌았다면, 해결방법을 반환한다.
			if (row == 8) {
				return;
			}

			for (int col = 0; col < 8; col++) {
				// Push값이 비었다면, 퀸을 새로운 포지션에 놓는다.
				if (CheckMove(new Point(row, col))) {
					Point queenPos = new Point(row, col);
					NextMove(queenPos, 1);
					
					// 다음 칸으로 이동
					solve(row + 1);
					
					// 해결법을 찾지 못했다면, 퀸을 제거한다.
					if (!)
					
				}
			}

		}

//		void Push(Point p) {
//
//		}

		Point Pop() {
			// 조건이 맞지 않으면 다시 처음으로 돌아간다.
		}

		// currentRow에 대하여 queen을 (x,y)에 배치 가능하면 true.
		boolean CheckMove(int currentRow, int row, int col) {

			return true;
		}

//  => backtracking을 stack을 이용하여 push/pop으로 해결하는 것을 보이는 것임

//  -> 가로, 세로, 대각선에 대한 충돌 체크 함수 코딩
	boolean CheckMove(x, y) {
		checkRow(x);		// 가로 체크		
		checkCol(y);		// 세로 체크
		checkDiagSW(x,y);   // 오른쪽 위에서 왼쪽 아래로	x++, y-- or x--, y++ where 0<= x,y <= 7 
		checkDiagSE(x,y);   // 왼쪽 위에서 오른쪽 아래로	x++, y++ or x--, y--
    }

	boolean checkRow(int row) {
		for (int j = 0; j < data.length(); j++) {
			if (row == ) {
				return false;
			}
		return true;
		}
	}

}
