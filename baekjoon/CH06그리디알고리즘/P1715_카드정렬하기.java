package baekjoon.CH06그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1715_카드정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			queue.add(Integer.parseInt(st.nextToken()));
		}

		int data1 = 0;
		int data2 = 0;
		int result = 0;
		while (queue.size() != 1) {
			// .poll() 은 가장 높은 우선순위 제거 / .remove() 는 가장 앞 요소 제거
			data1 = queue.poll();
			data2 = queue.poll();

			// 작은 묶음부터 비교 후 다시 큐에 넣음
			result += data1 + data2;
			queue.add(data1 + data2);
		}
		System.out.println(result);
	}
}
