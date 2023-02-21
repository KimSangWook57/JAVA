package chap05_recursive;

public class EightQueenSolution {
	// 전역 변수 선언.
	static int row = 8;
	static int col = 8;
	static int[][] data = new int[8][8];

	// 메인 페이지는 문제를 해결하는 코드만 남긴다.
	public static void main(String[] args) {
		// 시작 포인트에 퀸을 놓는다.
		data[0][0] = 1;

		// 배열 출력: 8개의 queen 배치.
		// 92개의 해를 구해 0과 1로 보여주기.
		SolveQueen();
	}

	// 해결 알고리즘 파트.
	public static void SolveQueen() {
		Point p = new Point(0, 0);
		MyStack s = new MyStack();
		int x = p.getX();
		int y = p.getY();
		int flag = 0;
		while (true) {
			while (x < row) {
				while (y < col) {
					if (CheckMove(x, y)) {
						data[x][y] = 1;
						s.Push(new Point(x, y));
						y = 0;
						break;
					}
					y++;
				}
				x++;
				if (y >= col) {
					if (!s.isEmpty()) {
						p = s.Pop();
						x = p.getX();
						y = p.getY();
						data[x][y] = 0;
						y++;
					} else {
						flag = 1;
						break;
					}
				}
			}
			if (flag == 1)
				break;

			PrintQueen();

			p = s.Pop();
			x = p.getX();
			y = p.getY();
			data[x][y] = 0;
			y++;
		}
	}

	// 가로, 세로, 슬래쉬, 역슬래쉬 방향 체크
	public static boolean CheckMove(int x, int y) {
		// 가로 체크
		if (!checkRow(x))
			return false;
		// 세로 체크
		if (!checkCol(y))
			return false;
		// 오른쪽 위에서 왼쪽 아래로
		// x++, y-- or x--, y++ where 0<= x,y <= 7
		if (!checkDiagSW(x, y))
			return false;
		// 왼쪽 위에서 오른쪽 아래로
		// x++, y++ or x--, y--
		if (!checkDiagSE(x, y))
			return false;
		// 모든 조건이 맞다면...
		return true;
	}

	// 이미 1의 값이 있다는 것은, 놓을 수 없다는 뜻이다.
	// 가로 코드 구현.
	public static boolean checkRow(int x) {
		for (int i = 0; i < row; i++) {
			if (data[x][i] == 1)
				return false;
		}
		return true;
	}

	// 세로 코드 구현.
	public static boolean checkCol(int y) {
		for (int i = 0; i < col; i++) {
			if (data[i][y] == 1)
				return false;
		}
		return true;
	}

	// 슬래쉬 방향 체크.
	public static boolean checkDiagSW(int x, int y) {
		int dx = x;
		int dy = y;
		// 오른쪽 위 체크.
		while (dx >= 0 && dx < row && dy >= 0 && dy < col) {
			if (data[dx][dy] == 1)
				return false;
			dx++;
			dy--;
		}
		dx = x;
		dy = y;
		// 왼쪽 아래 체크.
		while (dx >= 0 && dx < row && dy >= 0 && dy < col) {
			if (data[dx][dy] == 1)
				return false;
			dx--;
			dy++;
		}
		return true;
	}

	// 역슬래쉬 방향 체크.
	public static boolean checkDiagSE(int x, int y) {
		int dx = x;
		int dy = y;
		// 오른쪽 아래 체크.
		while (dx >= 0 && dx < row && dy >= 0 && dy < col) {
			if (data[dx][dy] == 1)
				return false;
			dx++;
			dy++;
		}
		dx = x;
		dy = y;
		// 왼쪽 위 체크.
		while (dx >= 0 && dx < row && dy >= 0 && dy < col) {
			if (data[dx][dy] == 1)
				return false;
			dx--;
			dy--;
		}
		return true;
	}

	// current row에 대한 다음 배치 가능한 모든 column을 조사하고 move[]에 1로 설정.
	void NextMove(int[] move, int row) {

		// 배치가 가능할 때만 move[]에 1을 넣는다.
	}

	// currentRow에 대하여 queen을 (x,y)에 배치 가능하면 true.
	public static boolean CheckMove(int currentRow, int row, int col) {

	}

	// 모든 결과를 계산 후 프린트할 코드.
	static void PrintQueen() {
		// 루프를 돌며 결과를 찍는다.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

// 스택 구현.
class MyStack {
	// 인덱스 top과 배열의 크기 array를 설정.
	private int top;
	Point[] array;

	public MyStack() {
		top = 0;
		array = new Point[100];
	}

	// 배열이 비었는지 확인하는 코드.
	public boolean isEmpty() {
		if (top == 0)
			return true;
		else
			return false;
	}

	// Point의 값을 집어넣는 코드.
	public void Push(Point p) {
		array[++top] = p;
	}

	// Point의 값을 꺼내는 코드.
	public Point Pop() {
		return array[--top];
	}
}

// Point 클래스 구현.
class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}