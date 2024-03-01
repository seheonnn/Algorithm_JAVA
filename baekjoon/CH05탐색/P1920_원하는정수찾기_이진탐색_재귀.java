package baekjoon.CH05탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_원하는정수찾기_이진탐색_재귀 {
	public static int N;
	public static int[] A;
	public static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A);
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			bw.write(binary_search(0, N - 1, Integer.parseInt(st.nextToken())) ? "1\n" : "0\n");
		}

		bw.flush();
		bw.close();
	}

	public static boolean binary_search(int start, int end, int target) {
		if (start > end)
			return false;
		int mid = (start + end) / 2;
		if (target < A[mid])
			return binary_search(start, mid - 1, target);
		else if (A[mid] < target)
			return binary_search(mid + 1, end, target);
		else
			return true;
	}
}
