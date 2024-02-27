package CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_원하는정수찾기_이진탐색 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N]; // 정렬할 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken()); // 찾을 수
			int start = 0;
			int end = N - 1;
			boolean find = false;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (target < A[mid])
					end = mid - 1;
				else if (A[mid] < target)
					start = mid + 1;
				else {
					find = true;
					break;
				}
			}
			if (find)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
