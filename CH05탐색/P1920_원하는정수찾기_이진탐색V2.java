package CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_원하는정수찾기_이진탐색V2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A, 1, N + 1); // 1 ~ N 인 경우 해당 범위만 정렬되어야 함, Sort 사용할 때 주의할 것!!

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int start = 1;
			int end = N;
			boolean find = false;

			while (start <= end) {
				int mid = (start + end) / 2;

				if (target < A[mid]) {
					end = mid - 1;
				} else if (A[mid] < target) {
					start = mid + 1;
				} else {
					find = true;
					break;
				}
			}

			if (find) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
