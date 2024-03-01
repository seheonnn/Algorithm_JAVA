package baekjoon.CH04정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11399_ATM_Sort사용 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");

		int[] A = new int[N];
		int[] S = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(str[i]);
		}

		Arrays.sort(A);

		S[0] = A[0];
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + A[i];
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += S[i];
		}

		System.out.println(sum);
	}
}
