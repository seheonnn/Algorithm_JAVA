package baekjoon.CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO 다시하기
public class P2023_신기한소수_DFS {
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
	}

	public static void DFS(int number, int jari) {
		if (jari == N) {
			if (isPrime(number)) {
				System.out.println(number);
			}
			return;
		}
		for (int i = 1; i < 10; i++) {
			if (i % 2 == 1) {
				if (isPrime(number * 10 + i)) {
					DFS(number * 10 + i, jari + 1);
				}
			}
			// if (i % 2 == 0)
			// 	continue;
			// if (isPrime(number * 10 + i)) {
			// 	DFS(number * 10 + i, jari + 1);
			// }
		}
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
