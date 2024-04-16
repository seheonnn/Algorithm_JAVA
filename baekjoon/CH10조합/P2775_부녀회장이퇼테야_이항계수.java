package baekjoon.CH10조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2775_부녀회장이퇼테야_이항계수 {

	public static int[][] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		D = new int[14 + 1][14 + 1];
		for (int i = 0; i <= 14; i++) {
			D[i][1] = 1;
			D[0][i] = i;
		}

		for (int i = 1; i <= 14; i++) {
			for (int j = 2; j <= 14; j++) {
				D[i][j] = D[i - 1][j] + D[i][j - 1];
			}
		}

		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			System.out.println(D[N][K]);
		}
	}
}
