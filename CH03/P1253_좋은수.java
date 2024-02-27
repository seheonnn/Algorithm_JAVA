package CH03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1253_좋은수 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int[] A = new int[N];

		String[] s = bf.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(s[i]);
		}
		int count = 0;
		Arrays.sort(A);

		for (int k = 0; k < N; k++) {
			int i = 0, j = N - 1;
			int std = A[k];
			while (i < j) {
				if (A[i] + A[j] == std) {
					if (i != k && j != k) { // i, j가 k와 다르다 == 자기 자신이 아님
						count++;
						break;
					} else if (i == k) { // k가 i나 j 중 하나와 같다는 것은 std 가 합을 이루는 두 수 중 하나라는 의미
						i++;
					} else if (j == k) {
						j--;
					}

				} else if (A[i] + A[j] < std) { // 합이 작으면 작은 수 증가
					i++;
				} else if (A[i] + A[j] > std) { // 합이 크면 큰 수 감소
					j--;
				}
			}
		}
		System.out.println(count);
		bf.close();
	}
}
