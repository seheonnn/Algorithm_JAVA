package baekjoon.CH03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3-2 백준 : 11660
public class P11660_구간합구하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// StringTokenizer 는 입력 받고 초기화 해주어야 다음에도 입력 받을 수 있음.

		// Scanner sc = new Scanner(System.in);
		// int N = sc.nextInt();
		// int M = sc.nextInt();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] A = new int[N + 1][N + 1];
		A[0][0] = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				// A[i][j] = sc.nextInt();
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] D = new int[N + 1][N + 1];
		D[0][0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 2차원 배열 구간합 입력
				D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
			}
		}

		for (int i = 1; i <= M; i++) {
			// int x1 = sc.nextInt();
			// int y1 = sc.nextInt();
			// int x2 = sc.nextInt();
			// int y2 = sc.nextInt();

			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 2차원 배열 구간합 공식
			System.out.println(D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1]);
		}
	}
}
