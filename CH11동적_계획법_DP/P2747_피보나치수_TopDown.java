package CH11동적_계획법_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2747_피보나치수_TopDown {
	public static int[] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		D = new int[N + 1];

		// 계산 전
		for (int i = 0; i <= N; i++) {
			D[i] = -1;
		}
		D[0] = 0;
		D[1] = 1;

		fibo(N);
		System.out.println(D[N]);

	}

	public static int fibo(int n) {
		// 계산한 적이 있으면 바로 반환
		if (D[n] != -1)
			return D[n];
		return D[n] = fibo(n - 2) + fibo(n - 1);
	}
}
