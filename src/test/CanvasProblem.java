package test;

public class CanvasProblem {

	public static String solution(int N, String S, String T) {

		// init all grids as 0
		int grid[][] = new int[N][N];

		int totalHit = 0;
		int totalSunk = 0;

		String[] targets = T.split(" ");
		for (String target : targets) {
			int row = Integer.valueOf(target.charAt(0)) - 49;
			int col = Integer.valueOf(target.charAt(1)) - 65;
			// target the grid as 1
			grid[row][col] = 1;
		}

		String[] ships = S.split(",");
		for (String ship : ships) {
			String[] shipPos = ship.split(" ");
			String coord1 = shipPos[0];
			String coord2 = shipPos[1];

			char startRowChar = coord1.charAt(0);
			char endRowChar = coord2.charAt(0);
			int startRow = Integer.valueOf(startRowChar) - 49;
			int endRow = Integer.valueOf(endRowChar) - 49;

			char startColChar = coord1.charAt(1);
			char endColChar = coord2.charAt(1);
			int startCol = Integer.valueOf(startColChar) - 65;
			int endCol = Integer.valueOf(endColChar) - 65;

			int gridsHit = 0;
			int numGrids = 0;
			for (int i = startRow; i <= endRow; i++) {
				for (int j = startCol; j <= endCol; j++) {
					numGrids++;
					if (grid[i][j] == 1) {
						gridsHit++;
					}
				}
			}

			if (numGrids == gridsHit) {
				totalSunk++;
			} else if (gridsHit > 0) {
				totalHit++;
			}
		}

		return totalSunk + "," + totalHit;
	}

	public static void main(String[] args) {
		int N = 4;
		String S = "1B 2C,2D 4D";
		String T = "2B 2D 3D 4D 4A";

//		int N = 3;
//		String S = "1A 1B,2C 2C";
//		String T = "1B";

		String str = solution(N, S, T);
		System.out.println(str);
	}

	// N =4, S = "1B 2C,2D 4D"

	// T = "2B 2D 3D 4D 4A"
}
