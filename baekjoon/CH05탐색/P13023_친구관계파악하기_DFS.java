package baekjoon.CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023_친구관계파악하기_DFS {
	public static boolean[] visited;
	public static ArrayList<Integer>[] A;
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		A = new ArrayList[N];
		visited = new boolean[N];
		result = 0;

		for (int i = 0; i < N; i++)
			A[i] = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				DFS(i, 1);
				if (result == 1)
					break;
			}
		}
		System.out.println(result);
	}

	public static void DFS(int v, int depth) {
		if (visited[v])
			return;

		if (depth == 5) {
			result = 1;
			return;
		}

		visited[v] = true;
		for (int i : A[v]) {
			if (!visited[i]) {
				DFS(i, depth + 1);
			}
		}
		// DFS 호출 후에 visited 되돌리기 -> 다른 경로를 통해 해당 부분을 또 방문할 수 있도록 함
		visited[v] = false;
	}
}
