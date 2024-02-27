package CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO 다시하기
public class P2343_블루레이_이진탐색 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		int start = 0;
		int end = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (start < A[i])
				start = A[i];
			end += A[i];
		}

		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;

			for (int i = 0; i < N; i++) {
				// 현재 mid 인덱스인 블루레이에 저장할 수 없어 새로운 블루레이로 교체
				if (sum + A[i] > mid) {
					count++;
					sum = 0;
				}
				sum += A[i];
			}
			// sum 이 0이 아니라면 블루레이가 더 필요함
			if (sum != 0)
				count++;

			// 중간 인덱스로 모든 레슨 저장 불가능한 경우
			if (count > M)
				start = mid + 1;
			else
				end = mid - 1;
		}
		System.out.println(start);
	}
}
