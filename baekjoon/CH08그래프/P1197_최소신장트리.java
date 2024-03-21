package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1197_최소신장트리 {

	public static int N, M;
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 0; i <= N; i++)
			parent[i] = i;

		// 우선순위큐를 통하여 자동 정렬
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			queue.add(new Edge(A, B, C));
		}

		int useEdge = 0;
		int result = 0;
		while (useEdge < N - 1) {
			Edge cur = queue.poll();
			// 엣지의 시작과 끝이 같은 집합이 아님 == 연결해도 싸이클이 생기지 않음
			if (find(cur.start) != find(cur.end)) {
				union(cur.start, cur.end);
				result += cur.weight;
				useEdge++;
			}
		}
		System.out.println(result);
	}

	public static int find(int a) {
		if (a == parent[a])
			return a;
		else
			return parent[a] = find(parent[a]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b)
			parent[b] = a;
	}

	public static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
