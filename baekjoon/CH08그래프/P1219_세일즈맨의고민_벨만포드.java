package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 기존 벨만포드와 반대, 양수 사이클을 찾아야
public class P1219_세일즈맨의고민_벨만포드 {
	public static Edge[] edges;
	public static long[] distance, money;
	public static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edges = new Edge[M];
		distance = new long[N];
		money = new long[N];

		for (int i = 0; i < N; i++) {
			distance[i] = Integer.MIN_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); // 교통수단의 가격

			edges[i] = new Edge(A, B, C);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}

		bellmanFord(start);

		if (distance[end] == Integer.MIN_VALUE) // 해당 도시에 도착 불가능
			System.out.println("gg");
			// 양수 사이클이 있어 돈을 무한히 벌 수 있음
		else if (distance[end] == Integer.MAX_VALUE)
			System.out.println("Gee");
		else
			System.out.println(distance[end]);

	}

	// 변형된 벨만포드
	public static void bellmanFord(int start) {
		distance[start] = money[start];
		// N 보다 큰 수로 반복하여 양수 사이클을 찾음
		for (int i = 1; i <= N + 100; i++) {
			for (int j = 0; j < M; j++) {
				Edge edge = edges[j];

				// 출발 노드가 양수 사이클에 연결된 노드라면 도착 노드도 양수 사이클로 표시
				if (distance[edge.start] == Integer.MAX_VALUE)
					distance[edge.end] = Integer.MAX_VALUE;

					// 방문한 노드이면서 더많은 돈을 벌 수 있는 새로운 경로가 있으면 업데이트
				else if (distance[edge.start] != Integer.MIN_VALUE
					&& distance[edge.end] < distance[edge.start] - edge.weight + money[edge.end]) {
					distance[edge.end] = distance[edge.start] - edge.weight + money[edge.end];

					// N 번 반복 이후 업데이트 되는 경로들은 양수 사이클임
					if (i > N)
						distance[edge.end] = Integer.MAX_VALUE;
				}
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
