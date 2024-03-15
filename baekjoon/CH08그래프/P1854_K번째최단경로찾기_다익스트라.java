package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1854_K번째최단경로찾기_다익스트라 {

	public static int n, m, k;
	public static ArrayList<Node>[] list;

	public static PriorityQueue<Integer>[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		distance = new PriorityQueue[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
			// distance 의 요소인 큐 내림차순으로
			distance[i] = new PriorityQueue<>(Collections.reverseOrder());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, c));
		}

		dijkstra(1);

		for (int i = 1; i <= n; i++) {
			// 해당 도시에 갈 경로가 k 개 미만임 -> k 번째 최단경로가 존재하지 않음
			if (distance[i].size() == k)
				System.out.println(distance[i].peek());
			else
				System.out.println(-1);
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		distance[start].add(0);

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int nowVertex = now.vertex;
			int nowWeight = now.weight;

			for (Node next : list[nowVertex]) {
				// distance 의 요소로 있는 큐의 크기가 k 보다 작으면 같아질 때까지 add
				// distance 에 값을 채우는 연산이 반복 되므로 기존 방식대로 visited 를 사용하면 오류 날 수 있음
				if (distance[next.vertex].size() < k) {
					distance[next.vertex].add(nowWeight + next.weight);
					queue.add(new Node(next.vertex, nowWeight + next.weight));
				}
				// distance[next.vertex].size() == k 이고,
				// k 번째 최단경로(distance[next.vertex].peek()) 보다 현재 노드를 지나는 경로의 비용(nowWeight + next.weight)이 더 작으면 최단경로 갱신
				// queue.peek() 은 요소 확인(큐 내에 해당 요소는 삭제되지 않고 그대로), queue.poll()은 요소 추출(큐에서 해당 요소 삭제됨)
				else if (distance[next.vertex].peek() > nowWeight + next.weight) {
					distance[next.vertex].poll();
					distance[next.vertex].add(nowWeight + next.weight);
					queue.add(new Node(next.vertex, nowWeight + next.weight));
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
