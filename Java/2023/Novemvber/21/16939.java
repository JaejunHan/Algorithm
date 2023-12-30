import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class B16939 {
	static int[][] cube;
	static int[][] copyMap;

	public static void main(String[] args) throws Exception {

		cube = new int[8][8];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int index = 0;
		while (st.hasMoreTokens()) {
			if (index < 12) {
				for (int i = 2; i <= 3; i++) {
					cube[index / 2][i] = Integer.parseInt(st.nextToken());
					index++;
				}

			} else if (index < 16) {
				for (int i = 0; i <= 1; i++) {
					cube[(index + 1) / 5][i] = Integer.parseInt(st.nextToken());
					index++;
				}
			} else {
				for (int i = 2; i <= 3; i++) {
					for (int j = 4; j <= 5; j++) {
						cube[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				for (int i = 2; i <= 3; i++) {
					for (int j = 6; j <= 7; j++) {
						cube[i][j] = Integer.parseInt(st.nextToken());
					}
				}
			}
		}

		// 뒷면 //
		// 시계방향
		copy();
		rotateSquare(0, 2, 0);
		rotateX(2, 0);
		if(check()) {
			System.out.println(1);
			return;
		}
		
		// 반시계방향
		copy();
		rotateSquare(0, 2, 1);
		rotateX(2, 1);
		if(check()) {
			System.out.println(1);
			return;
		}

		// 앞면 //
		copy();
		rotateSquare(4, 2, 0);
		rotateX(3, 0);
		if(check()) {
			System.out.println(1);
			return;
		}

		copy();
		rotateSquare(4, 2, 1);
		rotateX(3, 1);
		if(check()) {
			System.out.println(1);
			return;
		}
        
		//왼쪽 옆면//
		//앞쪽방향
		copy();
		rotateSquare(2,0,0);
		rotateY(2,0);
		if(check()) {
			System.out.println(1);
			return;
		}
		//뒷쪽방향
		copy();
		rotateSquare(2,0,1);
		rotateY(2,1);
		if(check()) {
			System.out.println(1);
			return;
		}
        
		//오른쪽 옆면//
		//앞쪽방향
		copy();
		rotateSquare(3,0,0);
		rotateY(3,0);
		if(check()) {
			System.out.println(1);
			return;
		}
		//뒷쪽방향
		copy();
		rotateSquare(3,0,1);
		rotateY(3,1);	
		if(check()) {
			System.out.println(1);
			return;
		}
        
		//아랫면//
		copy();
		rotateSquare(2,2,0);
		rotateBottom(0);
		if(check()) {
			System.out.println(1);
			return;
		}
		copy();
		rotateSquare(2,2,1);
		rotateBottom(1);
		if(check()) {
			System.out.println(1);
			return;
		}
		
		
		//윗면//
		copy();
		rotateSquare(2,6,0);
		rotateTop(0);
		if(check()) {
			System.out.println(1);
			return;
		}
		
		copy();
		rotateSquare(2,6,1);
		rotateTop(1);
		if(check()) {
			System.out.println(1);
			return;
		}
		

		System.out.println(0);

	}

	static void rotateSquare(int row, int col, int dir) {

		// 시계방향
		if (dir == 0) {
			copyMap[row][col] = cube[row + 1][col];
			copyMap[row][col + 1] = cube[row][col];
			copyMap[row + 1][col] = cube[row + 1][col + 1];
			copyMap[row + 1][col + 1] = cube[row][col + 1];
		}
		// 반시계방향
		else {
			copyMap[row][col] = cube[row][col + 1];
			copyMap[row][col + 1] = cube[row + 1][col + 1];
			copyMap[row + 1][col] = cube[row][col];
			copyMap[row + 1][col + 1] = cube[row + 1][col];
		}


	}
	static void rotateBottom(int dir) {
		if(dir==0) {
		copyMap[1][2] = cube[3][1];
		copyMap[1][3] = cube[2][1];
		copyMap[2][4] = cube[1][2];
		copyMap[3][4] = cube[1][3];
		copyMap[4][2] = cube[3][4];
		copyMap[4][3] = cube[2][4];
		copyMap[2][1] = cube[4][2];
		copyMap[3][1] = cube[4][3];
		}else {
			copyMap[1][2] = cube[2][4];
			copyMap[1][3] = cube[3][4];
			copyMap[2][4] = cube[4][3];
			copyMap[3][4] = cube[4][2];
			copyMap[4][2] = cube[2][1];
			copyMap[4][3] = cube[3][1];
			copyMap[2][1] = cube[1][3];
			copyMap[3][1] = cube[1][2];
		}
	}
	static void rotateTop(int dir) {
		if(dir==0) {
		copyMap[0][2] = cube[3][0];
		copyMap[0][3] = cube[2][0];
		copyMap[2][5] = cube[0][2];
		copyMap[3][5] = cube[0][3];
		copyMap[5][3] = cube[2][4];
		copyMap[5][2] = cube[3][4];
		copyMap[3][0] = cube[5][3];
		copyMap[2][0] = cube[5][2];
		}else {
			copyMap[0][2] = cube[2][4];
			copyMap[0][3] = cube[3][4];
			copyMap[2][5] = cube[5][3];
			copyMap[3][5] = cube[5][2];
			copyMap[5][3] = cube[3][0];
			copyMap[5][2] = cube[2][0];
			copyMap[3][0] = cube[0][2];
			copyMap[2][0] = cube[0][3];
		}
	}
//가로긴부분을 회전시키는 함수
	static void rotateX(int row, int dir) {
		if (dir == 0) {
			for (int i = 0; i < copyMap.length; i++) {
				int col = i < 6 ? i+2 : i%6;
				copyMap[row][i]=cube[row][col];
			}
		}
		else {
			for (int i = 0; i <copyMap.length; i++) {
				int col = i >1 ? i-2 : i+6;
				copyMap[row][i]=cube[row][col];
			}
		}
	}
    //세로긴부분을 회전시키는 함수
	static void rotateY(int col,int dir) {
		//앞으로
		if(dir==0) {
			for(int i=0;i<4;i++) {
				copyMap[i][col]=cube[i+2][col];
			}
			if(col==2) {
				copyMap[4][col] = cube[2][7];
				copyMap[5][col] = cube[3][7];
				copyMap[2][7] = cube[0][col];
				copyMap[3][7] = cube[1][col];
			}else {
				copyMap[4][col] = cube[2][6];
				copyMap[5][col] = cube[3][6];
				copyMap[2][6] = cube[0][col];
				copyMap[3][6] = cube[1][col];
			}
		}
		//뒤로
		else {
			for(int i=5;i>1;i--) {
				copyMap[i][col]=cube[i-2][col];
			}
			if(col==2) {
				copyMap[0][col] = cube[2][7];
				copyMap[1][col] = cube[3][7];
				copyMap[2][7] = cube[4][col];
				copyMap[3][7] = cube[5][col];
			}else {
				copyMap[0][col] = cube[2][6];
				copyMap[1][col] = cube[3][6];
				copyMap[2][6] = cube[4][col];
				copyMap[3][6] = cube[5][col];
			}
		}
	}
    //큐브가 맞춰졌는지->면마다 색이 다 같은지 확인
	static boolean check() {
		for(int i=0;i<6;i+=2) {
			int color = copyMap[i][2];
			for(int j=2;j<=3;j++) {
				if(copyMap[i][j]!=color || copyMap[i+1][j]!=color)
					return false;
			}
		}
		for(int i=0;i<copyMap.length;i+=2) {			
			int color = copyMap[2][i];
			for(int j=2;j<=3;j++) {
				if(copyMap[j][i]!=color || copyMap[j][i+1]!=color)
					return false;
			}
		}
		return true;
	}
    //배열을 복사하여 사용함
	static void copy() {
		int size = cube.length;
		copyMap = new int[size][size];
		for (int i = 0; i < size; i++) {
			System.arraycopy(cube[i], 0, copyMap[i], 0, size);
		}
	}

	

}