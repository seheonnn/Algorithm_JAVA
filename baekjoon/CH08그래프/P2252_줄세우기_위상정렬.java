package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2252_줄세우기_위상정렬 {
	public static ArrayList<Integer>[] A;
	public static int[] indegree; // 진입 차수 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		indegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			A[x].add(y);
			indegree[y]++; // 주의 ! 진입 당하는 노드를 증가
		}

		// 위상 정렬
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.printf(cur + " ");
			for (int next : A[cur]) {
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
	}
}
