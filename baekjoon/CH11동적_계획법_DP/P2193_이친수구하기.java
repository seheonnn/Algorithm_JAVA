package baekjoon.CH11동적_계획법_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2193_이친수구하기 {
	public static long[][] D;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = new long[N + 1][2];

		// 1 자리수 0으로 끝남 -> 0은 이친수가 아님
		D[1][0] = 0;
		// 1 자리수 1로 끝남 -> 1은 이친수
		D[1][1] = 1;

		for (int i = 2; i <= N; i++) {
			// i 번째 0으로 끝나는 경우, i-1에서 0으로 끝나는 개수 + i-1에서 1로 끝나는 개수
			D[i][0] = D[i - 1][0] + D[i - 1][1];
			// // i 번째 1로 끝나는 경우, i-1에서 0으로 끝나는 개수 (11이 연속 두 번이면 이친수가 아님)
			D[i][1] = D[i - 1][0];
		}
		System.out.println(D[N][0] + D[N][1]);
	}
}
