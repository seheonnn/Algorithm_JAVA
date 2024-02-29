package baekjoon.CH06그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// TODO 우선순위 큐
public class P1744_수묶기 {
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusPq = new PriorityQueue<>();

		int one = 0;
		int zero = 0;
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			// 수를 4개의 그룹으로 분리
			if (a > 1) {
				plusPq.add(a);
			} else if (a == 1) {
				one++;
			} else if (a == 0) {
				zero++;
			} else {
				minusPq.add(a);
			}
		}

		int sum = 0;

		// 양수 처리
		while (plusPq.size() > 1) {
			int first = plusPq.poll();
			int second = plusPq.poll();
			sum += first * second;
		}

		if (!plusPq.isEmpty())
			sum += plusPq.poll();

		// 음수 처리
		while (minusPq.size() > 1) {
			int first = minusPq.poll();
			int second = minusPq.poll();
			sum += first * second;
		}

		if (!minusPq.isEmpty())
			if (zero == 0)
				sum += minusPq.poll();

		// 1처리
		sum += one;
		System.out.println(sum);

	}
}
