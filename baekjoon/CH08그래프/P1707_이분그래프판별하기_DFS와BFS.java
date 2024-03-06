package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1707_이분그래프판별하기_DFS와BFS {
	public static ArrayList<Integer>[] A;
	public static boolean[] visited;
	public static int[] check;
	public static boolean isEven;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 테스트 케이스 개수
		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			// V: 정점의 개수, E: 엣지의 개수
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			A = new ArrayList[V + 1];
			visited = new boolean[V + 1];

			check = new int[V + 1];
			isEven = true;

			for (int i = 1; i <= V; i++) {
				A[i] = new ArrayList<>();
			}

			for (int i = 1; i <= E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				A[a].add(b);
				A[b].add(a);
			}

			// 주어진 그래프가 1개로 연결되어 있다는 보장이 없으므로 모든 노드에서 실행
			for (int i = 1; i <= V; i++) {
				if (isEven) {
					// DFS(i);
					BFS(i);
				} else {
					// 이미 이분 그래프가 아니라면 종료
					break;
				}
			}
			// 이분 그래프인지 판단
			if (isEven) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static void BFS(int v) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(v);
		visited[v] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i : A[cur]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
					// 인접한 노드는 같은 집합이 아니므로 다른 집합으로 처리
					check[i] = (check[cur] + 1) % 2;
				} else if (check[cur] == check[i]) {
					// 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아니므로 isEven 변수 수정
					isEven = false;
				}
			}
		}
	}

	public static void DFS(int v) {
		if (visited[v])
			return;

		visited[v] = true;
		for (int i : A[v]) {
			if (!visited[i]) {
				check[i] = (check[v] + 1) % 2;
				DFS(i);
			} else if (check[v] == check[i]) {
				isEven = false;
			}
		}
	}
}
