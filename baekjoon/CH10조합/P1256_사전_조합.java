package baekjoon.CH10조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1256_사전_조합 {
	public static int[][] D;
	public static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		D = new int[202][202];

		// 조합 테이블 초기화
		for (int i = 0; i <= 200; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == 1) {
					D[i][j] = 1;
				} else {
					D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
					if (D[i][j] > 1000000000) // 범위 넘어가는 경우
						D[i][j] = 1000000001;
				}
			}
		}

		if (D[N + M][M] < K) { // 주어진 자릿수로 만들 수 없는 K 번째 수인 경우
			System.out.print("-1");
		} else {
			while (!(N == 0 && M == 0)) {
				// a를 선택했을 때 남은 문자로 만들 수 있는 모든 경우의 수가 K보다 큰 경우
				if (D[N - 1 + M][M] >= K) {
					System.out.print("a");
					N--; // a 문자 개수 감소
				} else { // 모든 경우의 수가 K보다 작은 경우
					System.out.print("z");
					K = K - D[N - 1 + M][M]; // K 값 업데이트
					M--; // z 문자 개수 감소
				}
			}
		}
	}
}
