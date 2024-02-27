package CH04정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// TODO 다시하기
public class P2751_수정렬하기2_병합정렬 {
	public static int[] A, tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		tmp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		MergeSort(1, N);
		for (int i = 1; i <= N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void MergeSort(int S, int E) {
		if (E - S < 1)
			return;
		int m = S + (E - S) / 2;
		MergeSort(S, m);
		MergeSort(m + 1, E);

		for (int i = S; i <= E; i++) {
			tmp[i] = A[i];
		}
		int k = S; // 전체 배열의 index
		int index1 = S;
		int index2 = m + 1;
		while (index1 <= m && index2 <= E) {
			if (tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				k++;
				index2++;
			} else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while (index1 <= m) {
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		while (index2 <= E) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}
