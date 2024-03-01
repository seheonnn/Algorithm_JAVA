package baekjoon.CH07정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1747_소수와팰린드롬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// N은 1,000,000까지

		// 에라토스테네스의 체
		int[] A = new int[10000001];
		for (int i = 2; i < A.length; i++) {
			A[i] = i;
		}

		for (int i = 2; i < Math.sqrt(A.length); i++) {
			if (A[i] == 0)
				continue;
			// i의 배수에 해당하는 요소는 0으로 표기 -> 소수가 아님
			for (int j = i + i; j < A.length; j = j + i) {
				A[j] = 0;
			}
		}
		for (int i = N; i < A.length; i++) {
			if (A[i] != 0 && isPalindrome(String.valueOf(A[i]))) {
				System.out.println(A[i]);
				break;
			}
		}

	}

	public static boolean isPalindrome(String str) {
		int start = 0; // 앞에서 시작하는 인덱스
		int end = str.length() - 1; // 뒤에서 시작하는 인덱스

		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) // 각 인덱스의 요소값이 서로 일치하지 않으면
				return false; // 팰린드롬이 아님
			start++;
			end--;
		}
		return true; // 모두 통과하였다면 팰린드롬임
	}
}
