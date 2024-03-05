package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18352_특정거리의도시찾기_BFS {
	public static ArrayList<Integer>[] A;
	public static int[] visited;
	public static List<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];
		visited = new int[N + 1];
		result = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
			visited[i] = -1;
		}

		for (int i = 0; i < M; i++) {
			String[] temp = br.readLine().split(" ");
			A[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
		}

		BFS(X);
		for (int i = 1; i <= N; i++) {
			if (visited[i] == K)
				result.add(i);
		}
		if (result.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(result);
			for (int temp : result) {
				System.out.println(temp);
			}
		}
	}

	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v]++;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i : A[cur]) {
				if (visited[i] == -1) {
					visited[i] = visited[cur] + 1;
					queue.add(i);
				}
			}
		}
	}
}
