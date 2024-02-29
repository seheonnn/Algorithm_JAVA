package baekjoon.CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10815_숫자카드_이진탐색 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] sang = new int[N]; // 상근이가 가진 카드들
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			sang[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] card = new int[M]; // 찾아햐 하는 카드들
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			card[i] = Integer.parseInt(st.nextToken());

		// 이진 탐색은 대상 배열이 정렬되어 있어야
		Arrays.sort(sang);

		for (int i = 0; i < M; i++) {
			int target = card[i];
			int start = 0;
			int end = N - 1;
			boolean find = false;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (target < sang[mid])
					end = mid - 1;
				else if (sang[mid] < target)
					start = mid + 1;
				else {
					find = true;
					break;
				}
			}
			System.out.print(find ? "1 " : "0 ");
		}
	}
}
