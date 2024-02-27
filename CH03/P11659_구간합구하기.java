package CH03;

import java.util.Scanner;

// 3-2 백준 : 11659
public class P11659_구간합구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// int[] A = new int[M];
		int[] S = new int[N+1];
		S[0] = 0;
		for (int i = 1; i<=N; i++) {
			// A[i] = sc.nextInt();
			// S[i+1] = S[i] + A[i];
			S[i] = S[i-1] + sc.nextInt();
		}
		for (int i = 1; i<=M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			// 구간합 공식 : S[j] - S[i-1]
			System.out.println(S[b] - S[a-1]);
		}
	}
}
