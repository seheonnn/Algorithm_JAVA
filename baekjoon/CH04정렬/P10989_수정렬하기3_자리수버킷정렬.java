package baekjoon.CH04정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10989_수정렬하기3_자리수버킷정렬 {
	public static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		br.close();
		Radix_Sort(A, 5); // 10000 보다 작거나 같은 자연수
		for (int i = 0; i < N; i++) {
			bw.write(A[i] + "\n");
		}

		bw.flush();
		bw.close();
	}

	public static void Radix_Sort(int[] A, int max_size) {
		int[] output = new int[A.length];
		int jarisu = 1;
		int count = 0;

		while (count != max_size) {
			int[] bucket = new int[10];
			for (int i = 0; i < A.length; i++) {
				bucket[(A[i] / jarisu) % 10]++;
			}
			for (int i = 1; i < 10; i++) {
				bucket[i] += bucket[i - 1];
			}
			for (int i = A.length - 1; i >= 0; i--) {
				output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
				bucket[(A[i] / jarisu) % 10]--;
			}
			System.arraycopy(output, 0, A, 0, A.length);
			jarisu = jarisu * 10;
			count++;
		}
	}
}
