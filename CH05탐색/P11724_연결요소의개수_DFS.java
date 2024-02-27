package CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// TODO DFS
public class P11724_연결요소의개수_DFS {

	public static boolean[] visited;
	public static ArrayList<Integer>[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1]; // 이중 리스트
		visited = new boolean[N + 1];

		int count = 0;

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}

	public static void DFS(int v) {
		if (visited[v])
			return;

		visited[v] = true;

		for (int i : A[v]) {
			if (!visited[i])
				DFS(i);
		}
	}
}
