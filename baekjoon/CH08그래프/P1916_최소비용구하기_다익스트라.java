package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916_최소비용구하기_다익스트라 {
	public static ArrayList<Node>[] list;
	public static int[] distance;

	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		distance = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[u].add(new Node(v, w));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);

		bw.write(distance[end] + "\n");
		bw.close();
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();

		distance[start] = 0;
		queue.add(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int nowVertex = now.vertex;

			// visited 사용시 성능 향상
			if (!visited[nowVertex]) {
				visited[nowVertex] = true;
				for (Node next : list[nowVertex]) {
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
