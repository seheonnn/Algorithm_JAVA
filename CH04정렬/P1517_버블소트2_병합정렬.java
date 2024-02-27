package CH04정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// TODO 틀린답. 다시하기
// 버블정렬의 경우 시간 초과
public class P1517_버블소트2_병합정렬 {
	public static int[] A, tmp;
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(st.nextToken());
		A = new int[N + 1];
		tmp = new int[N + 1];
		result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		MergeSort(1, N);
		bw.write(Integer.toString(result));
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
				result += m - index1 + 1;
				/**
				 * index1 > index2 인 경우 swap 이 일어남.
				 * 즉, index1 인 요소보다 큰 요소들은 index2 인 요소보다 큰 것을 의미하므로 이로 인해 발생하는 swap 횟수를 누적해야 함.
				 **/
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
