package baekjoon.CH10조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1947_선물전달_조합 {
	public static long[] D;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		long mod = 1000000000;
		D = new long[1000001];
		D[1] = 0; // 혼자인 경우 -> 선물 전달 불가
		D[2] = 1; // 둘인 경우 -> 서로 교환하고 끝
		for (int i = 3; i <= N; i++) {
			// (i - 1) * (D[i - 1] + D[i - 2]) 계산에서 오버플로우가 발생할 수 있기 때문에 자료형 long 으로
			// 완전 순열 점화식
			D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % mod;
		}
		System.out.println(D[N]);
	}
}
