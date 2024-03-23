package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17472_다리만들기_크루스칼 {

	public static int N, M, isLandCnt;
	public static int[][] distance;
	public static int[] parent;
	public static Queue<int[]> q; // BFS 를 위한 큐
	public static PriorityQueue<Edge> pq = new PriorityQueue<>(); // 최소신장트리를 위한 우선순위큐
	public static boolean[][] visited;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		distance = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		isLandCnt = 2;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (distance[i][j] == 1 && !visited[i][j]) {
					BFS(i, j, isLandCnt);
					isLandCnt++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (distance[i][j] != 0) {
					makeBridge(i, j, distance[i][j]);
				}
			}
		}

		isLandCnt--;
		parent = new int[isLandCnt];
		for (int i = 1; i < isLandCnt; i++) {
			parent[i] = i;
		}
		int answer = kruskal();
		System.out.println(answer == 0 ? -1 : answer);

	}

	// 1. bruteforce 를 통해 map[i][j] == 1 인 곳을 찾고,
	// BFS 로 인접한 땅들을 모두 색칠(탐색)
	static void BFS(int x, int y, int idx) {
		q = new LinkedList<>();

		q.add(new int[] {x, y});
		distance[x][y] = idx;
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int px = p[0];
			int py = p[1];

			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];

				if (-1 < nx && nx < N && -1 < ny && ny < M && !visited[nx][ny]) {
					if (distance[nx][ny] == 1) {
						distance[nx][ny] = idx;
						visited[nx][ny] = true;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
	}

	// 2. 하나의 정점에서 네 가지의 다리가 설계되는지 확인 (크루스칼 알고리즘에 사용될 우선순위 큐에 추가)
	static void makeBridge(int x, int y, int idx) {
		q = new LinkedList<>();
		visited = new boolean[N][M];
		for (int d = 0; d < 4; d++) {
			q.add(new int[] {x, y, 0});
			visited[x][y] = true;

			while (!q.isEmpty()) {
				int[] p = q.poll();
				int px = p[0];
				int py = p[1];
				int weight = p[2];

				int nx = px + dx[d];
				int ny = py + dy[d];

				if (-1 < nx && nx < N && -1 < ny && ny < M && !visited[nx][ny]) {
					if (distance[nx][ny] != idx) {
						if (distance[nx][ny] != 0) {
							int end = idx - 1;
							int start = distance[nx][ny] - 1;
							int bridgeLen = weight;
							if (bridgeLen > 1) {
								pq.add(new Edge(start, end, bridgeLen));
								break;
							}
						} else {
							visited[nx][ny] = true;
							q.add(new int[] {nx, ny, weight + 1});
						}
					}
				}
			}
			q.clear();
		}
	}

	// 3. 크루스칼(최소신장트리)
	static int kruskal() {
		int sum = 0;
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			Edge node = pq.poll();
			int x = node.end;
			int y = node.start;

			if (find(x) != find(y)) {
				sum += node.weight;
				union(x, y);
			}
		}

		int rx = parent[1];
		for (int i = 2; i < isLandCnt; i++) {
			if (rx != find(parent[i])) {
				// System.out.println("연결 x ");
				return 0;
			}
		}

		return sum;
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

		// 주의
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	static class Edge implements Comparable<Edge> {
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
