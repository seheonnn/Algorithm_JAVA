package baekjoon.CH11동적_계획법_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14501_퇴사 {
	public static int N;
	public static int[] T, P, D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		T = new int[N]; // 상담 기간
		P = new int[N]; // 상담 수입
		D = new int[N + 1]; // 오늘부터 퇴사일까지 벌 수 있는 최대 수입

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			// i 번째 상담을 퇴사일까지 끝낼 수 있을 때
			if (i + T[i] <= N) {
				D[i + T[i]] = Math.max(D[i + T[i]], P[i] + D[i]);
			}
			// i 번째 상담을 퇴사일까지 끝낼 수 없다면
			// 이전까지 일한 최대 수입을 넣음
			D[i + 1] = Math.max(D[i + 1], D[i]);
		}
		System.out.println(D[N]);
	}
}
