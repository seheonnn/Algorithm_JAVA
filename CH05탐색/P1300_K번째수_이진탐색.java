package CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1300_K번째수_이진탐색 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());

		int start = 1;
		int end = K;
		int result = 0;

		while (start <= end) {
			int mid = (start + end) / 2;
			// 몇 개의 원소가 K 보다 작은지
			int count = 0;

			for (int i = 1; i <= N; i++) {
				// mid 값을 i로 나누어서 각 행에서 mid보다 작거나 같은 값의 개수를 계산
				count += Math.min(mid / i, N);
			}

			if (count < K)
				start = mid + 1;
			else {
				result = mid;
				end = mid - 1;
			}
		}
		System.out.println(result);
	}
}
