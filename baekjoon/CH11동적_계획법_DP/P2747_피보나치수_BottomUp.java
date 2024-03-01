package baekjoon.CH11동적_계획법_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2747_피보나치수_BottomUp {
	public static int[] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		D = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			D[i] = -1;
		}
		D[0] = 0;
		D[1] = 1;

		//DP
		for (int i = 2; i <= N; i++)
			D[i] = D[i - 1] + D[i - 2];

		System.out.println(D[N]);
	}
}
