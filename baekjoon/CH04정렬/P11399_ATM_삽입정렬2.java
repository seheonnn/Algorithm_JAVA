package baekjoon.CH04정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11399_ATM_삽입정렬2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");

		int[] A = new int[N];
		int[] S = new int[N];

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(str[i]);

		for (int j = 1; j < N; j++) {
			int key = A[j];
			int i = j - 1;
			while (i >= 0 && A[i] > key) {
				A[i + 1] = A[i];
				i -= 1; // 여기에서 i 에 -1 을 했기 때문에
			}
			A[i + 1] = key; // A[i+1] 에 key 를 넣는 것임
		}

		S[0] = A[0];
		for (int i = 1; i < N; i++) {
			S[i] += S[i - 1] + A[i];
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += S[i];
		}
		System.out.println(sum);
	}
}
