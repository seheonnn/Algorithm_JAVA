package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11657_타임머신_벨만포드_노드 {
	// 벨만포드의 경우 노드보단 엣지로 구현할 것!
	public static ArrayList<Node>[] list;

	public static long[] distance; // int로 하는 경우 출력 초과
	public static boolean hasCycle;

	public static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		distance = new long[N + 1];
		for (int i = 0; i <= N; i++) {
			distance[i] = Long.MAX_VALUE;
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			list[A].add(new Node(B, C));
		}
		bellmanFord(1);

		if (!hasCycle) {
			// 1번 도시에서 출발
			for (int i = 2; i <= N; i++) {
				// 해당 도시(i 도시)로 갈 수 있는 경로가 없는 경우 -1 출력
				if (distance[i] == Long.MAX_VALUE)
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
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (Node cur : list[j]) {
					if (distance[j] != Long.MAX_VALUE && distance[cur.vertex] > distance[j] + cur.weight)
						distance[cur.vertex] = distance[j] + cur.weight;
				}
			}
		}

		// 모든 노드를 방문한 뒤에도 최단 경로가 존재하면 음수 사이클이 있다는 것.
		for (int i = 1; i <= N; i++) {
			for (Node cur : list[i]) {
				if (distance[i] != Long.MAX_VALUE && distance[cur.vertex] > distance[i] + cur.weight) {
					hasCycle = true;
					break;
				}
			}
		}
	}

	public static class Node implements Comparable<Node> {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}
