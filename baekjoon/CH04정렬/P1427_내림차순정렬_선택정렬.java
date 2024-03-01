package baekjoon.CH04정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1427_내림차순정렬_선택정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int[] A = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			A[i] = str.charAt(i) - '0'; // charAt의 반환값은 char 임 -> int 로 매핑될 수도 있으므로 형변환 필수
		}

		for (int i = 0; i < str.length(); i++) {
			int Max = i;
			for (int j = i + 1; j < str.length(); j++) {
				if (A[j] > A[Max]) // 최댓값인 index를 찾아야
					Max = j;
			}
			if (A[i] < A[Max]) {
				int tmp = A[Max];
				A[Max] = A[i];
				A[i] = tmp;
			}
		}

		for (int i = 0; i < str.length(); i++) {
			System.out.printf(String.valueOf(A[i]));
		}
	}
}
