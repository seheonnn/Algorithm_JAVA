package baekjoon.CH07정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1456_거의소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());

		// 에라토스테네스 방식 소수 구하기
		long[] Arr = new long[10000001]; // B는 10의 14승까지
		for (int i = 2; i < Arr.length; i++)
			Arr[i] = i;

		for (int i = 2; i <= Math.sqrt(Arr.length); i++) {
			if (Arr[i] == 0)
				continue;
			for (int j = i + i; j < Arr.length; j = j + i) {
				Arr[j] = 0;
			}
		}

		int cnt = 0;
		for (int i = 2; i < Arr.length; i++) {
			if (Arr[i] != 0) {
				long temp = Arr[i];
				// 거듭제곱의 범위 구하기
				while ((double)Arr[i] <= (double)B / (double)temp) { // (doubler) 유의
					if ((double)Arr[i] >= (double)A / (double)temp) {
						cnt++;
					}
					temp *= Arr[i];
				}
			}
		}
		System.out.println(cnt);
	}
}
