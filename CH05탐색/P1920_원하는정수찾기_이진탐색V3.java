package CH05탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_원하는정수찾기_이진탐색V3 {
	public static int N;
	public static int[] A;
	public static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(st.nextToken());
		A = new int[N]; // 정렬할 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			boolean find = binary_search(
				Integer.parseInt(st.nextToken()));
			bw.write(find ? "1\n" : "0\n");
		}
		bw.close();
		br.close();
	}

	public static boolean binary_search(int target) {
		int start = 0;
		int end = N - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (target < A[mid])
				end = mid - 1;
			else if (A[mid] < target)
				start = mid + 1;
			else
				return true;
		}
		return false;
	}
}
