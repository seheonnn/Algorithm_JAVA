package baekjoon.CH07정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		// 에라토스테네스 방식
		int[] A = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			// 2 부터 N까지 각 요소에 index 값 삽입
			A[i] = i;
		}

		// 2부터 N 의 제곱근까지 반복
		for (int i = 2; i <= Math.sqrt(N); i++) {
			// 요소값이 0이면 소수가 아닌 것으로 판단
			if (A[i] == 0) {
				continue;
			}

			// i 의 배수를 0으로 (삭제)
			for (int j = i + i; j <= N; j = j + i) {
				A[j] = 0;
			}
		}

		// 요소가 0이 아니면 소수로 판단
		for (int i = M; i <= N; i++) {
			if (A[i] != 0) {
				System.out.println(A[i]);
			}
		}
	}
}
