package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11657_타임머신_벨만포드_엣지 {
	public static Edge[] edges;

	public static long[] distance; // int로 하는 경우 출력 초과
	public static boolean hasCycle;

	public static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edges = new Edge[M + 1];
		distance = new long[N + 1];
		for (int i = 0; i <= N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(A, B, C);
		}
		bellmanFord(1);

		if (!hasCycle) {
			// 1번 도시에서 출발
			for (int i = 2; i <= N; i++) {
				// 해당 도시(i 도시)로 갈 수 있는 경로가 없는 경우 -1 출력
				if (distance[i] == Integer.MAX_VALUE)
					System.out.println(-1);
				else
					System.out.println(distance[i]);
			}
		}
		// 음의 사이클이 있는 경우 -1 출력
		else
			System.out.println(-1);

	}

	public static void bellmanFord(int start) {
		distance[start] = 0;
		// N 보다 1 적은 수만큼 반복
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				Edge edge = edges[j];
				if (distance[edge.start] != Integer.MAX_VALUE
					&& distance[edge.end] > distance[edge.start] + edge.weight)
					distance[edge.end] = distance[edge.start] + edge.weight;
			}
		}

		// 모든 노드를 방문한 뒤에도 최단 경로가 존재하면 음수 사이클이 있다는 것.
		for (int i = 0; i < M; i++) {
			Edge edge = edges[i];
			if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.weight) {
				hasCycle = true;
				break;
			}
		}
	}

	public static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

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
