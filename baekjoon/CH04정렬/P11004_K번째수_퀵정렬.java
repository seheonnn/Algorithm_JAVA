package baekjoon.CH04정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번째수_퀵정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		QuickSort(A, 0, N - 1, K - 1);
		System.out.println(A[K - 1]);
	}

	public static void QuickSort(int[] A, int S, int E, int K) {
		if (S < E) {
			int pivot = Partition(A, S, E);
			if (pivot == K) {
			} else if (K < pivot) {
				QuickSort(A, S, pivot - 1, K);
			} else {
				QuickSort(A, pivot + 1, E, K);
			}
		}
	}

	public static int Partition(int[] A, int S, int E) {
		if (A.length == 2) {
			if (A[S] > A[E])
				Swap(A, S, E);
			return E;
		}

		int M = (S + E) / 2;
		Swap(A, S, M);
		int pivot = A[S];
		int i = S + 1, j = E;
		while (i <= j) {
			while (j >= S + 1 && pivot < A[j]) {
				j--;
			}
			while (i <= E && pivot > A[i]) {
				i++;
			}
			if (i <= j) {
				Swap(A, i++, j--);
			}
		}
		A[S] = A[j];
		A[j] = pivot;
		return j;
	}

	public static void Swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
