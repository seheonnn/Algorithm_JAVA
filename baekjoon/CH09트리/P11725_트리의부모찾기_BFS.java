package baekjoon.CH09트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725_트리의부모찾기_BFS {
	public static ArrayList<Integer>[] A;
	public static boolean[] visited;
	public static int[] answer;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		answer = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}

		BFS(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}
	}

	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i : A[cur]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
					answer[i] = cur;
				}
			}
		}
	}
}
