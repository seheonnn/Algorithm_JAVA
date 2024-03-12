package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753_최단경로_다익스트라 {
	public static ArrayList<Node>[] list;
	public static int[] distance;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());

		list = new ArrayList[V + 1];
		distance = new int[V + 1];
		visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Node>();
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[u].add(new Node(v, w));
		}

		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();

		// 시작점에서 index 까지의 거리 저장 배열
		distance[start] = 0;
		queue.add(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int nowVertex = now.vertex;

			// visited 사용시 성능 향상
			if (!visited[nowVertex]) {
				visited[nowVertex] = true;
				// 현재 노드에서 갈 수 있는 모든 다음 노드들을 순회
				for (Node next : list[nowVertex]) {
					// 만약 현재까지의 거리와 현재 노드에서 다음 노드로 가는 가중치를 더한 값이
					// 다음 노드까지의 최단거리(현재 노드를 거치치 않는 경우)보다 작다면 업데이트 하고 큐에 넣음
					if (distance[next.vertex] > now.weight + next.weight) {
						distance[next.vertex] = now.weight + next.weight;
						queue.add(new Node(next.vertex, distance[next.vertex]));
					}
				}
			}
		}
	}

	public static class Node implements Comparable<Node> {
		private final int vertex;
		private final int weight;

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
