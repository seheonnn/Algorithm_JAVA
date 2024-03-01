package baekjoon.CH06그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1931_회의실배정하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i][0] = Integer.parseInt(st.nextToken()); // 회의 시작 시간
			A[i][1] = Integer.parseInt(st.nextToken()); // 회의 종료 시간
		}

		Arrays.sort(A, (a, b) -> {
			// 종료 시간이 같으면
			if (a[1] == b[1])
				// 시작 시간 비교하여 정렬
				return Integer.compare(a[0], b[0]);
			// 기본은 종료 시간 기준으로
			return Integer.compare(a[1], b[1]);
		});

		int cnt = 0;
		int last = 0;

		for (int i = 0; i < N; i++) {
			int start = A[i][0];
			int end = A[i][1];

			if (start >= last) {
				cnt++;
				last = end;
			}
		}
		System.out.println(cnt);
	}
}
