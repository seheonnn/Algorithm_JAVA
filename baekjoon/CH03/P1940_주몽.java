package baekjoon.CH03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1940_주몽 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());

		int[] A = new int[N];

		String[] s = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(s[i]);
		}

		Arrays.sort(A);

		int count = 0;
		int i = 0;
		int j = N - 1;
		while (i < j) {
			if (A[i] + A[j] < M) { // 합이 M보다 작은 경우 작은 번호 재료 한 칸 증가
				i++;
			} else if (A[i] + A[j] > M) { // 합이 M보다 큰 경우 큰 번호 재료 한 칸 감소
				j--;
			} else { // 합이 M과 같은 경우 경우의 수 증가, 작은 번호 재료 한 칸 증가, 큰 번호 재료 한 칸 감소
				count++;
				i++;
				j--;
			}
		}
		System.out.println(count);
		bf.close();
	}
}
