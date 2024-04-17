package baekjoon.CH10조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010_다리놓기_조합 {
	public static int T;
	public static int[][] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		D = new int[31][31];
		for (int i = 0; i <= 30; i++) {
			D[i][1] = i;
			D[i][0] = 1;
			D[i][i] = 1;
		}

		for (int i = 2; i <= 30; i++) {
			for (int j = 1; j < i; j++) {
				D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
			}
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// M, N 순서 주의 !!
			// 동쪽에서 서쪽을 선택하는 경우의 수
			System.out.println(D[M][N]);
		}
	}

}
