package CH04정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11004_K번째수_퀵정렬_시간초과 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);

		int[] A = new int[N];
		String[] str = br.readLine().split(" ");

		for (int i = 0; i < str.length; i++) {
			A[i] = Integer.parseInt(str[i]);
		}

		QuickSort(A, 0, N - 1);
		System.out.println(A[K - 1]);
	}

	public static int Partition(int[] A, int p, int r) {
		int x = A[r]; // 마지막 요소가 pivot, pivot 을 구하는 방식에 따라 성능에 영향
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (A[j] <= x) {
				i++;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		int temp = A[i + 1];
		A[i + 1] = A[r];
		A[r] = temp;
		return i + 1;
	}

	public static void QuickSort(int[] A, int p, int r) {
		if (p < r) {
			int q = Partition(A, p, r);
			QuickSort(A, p, q - 1);
			QuickSort(A, q + 1, r);
		}
	}
}
