package baekjoon.CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260_DFS와BFS {
	public static boolean[] visited;
	public static ArrayList<Integer>[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			A[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}

		// 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
		for (int i = 1; i <= N; i++) {
			Collections.sort(A[i]);
		}
		DFS(start);
		System.out.println();
		visited = new boolean[N + 1];
		BFS(start);
	}

	// 재귀
	public static void DFS(int v) {
		if (visited[v])
			return;
		System.out.printf(v + " ");
		visited[v] = true;
		for (int i : A[v]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}

	// Queue 이용
	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			for (int i : A[cur]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
