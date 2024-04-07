package baekjoon.CH09트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 기존 LCA 문제보다 M이 매우 커지고 제한 시간이 작음
// 제곱근 형태를 이용하여 빠르게 최소 공통 조상을 구해야
public class P11438_LCA2_BFS {
	public static ArrayList<Integer>[] tree;
	public static int[] depth;
	public static int kmax;
	public static int[][] parent;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}

		depth = new int[N + 1];
		visited = new boolean[N + 1];
		int temp = 1;
		kmax = 0; // 최대 가능 depth
		while (temp <= N) {
			temp *= 2;
			kmax++;
		}

		parent = new int[kmax + 1][N + 1];
		BFS(1);
		for (int i = 1; i <= kmax; i++) {
			for (int j = 1; j <= N; j++) {
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
			}
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int LCA = executeLCA(a, b);
			System.out.println(LCA);
		}
	}

	public static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		int level = 1;
		int now_size = 1;
		int count = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i : tree[cur]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
					parent[0][i] = cur; // 부모 노드 저장
					depth[i] = level; // 현재 노드 depth 저장
				}
			}
			count++;
			if (count == now_size) {
				count = 0;
				now_size = queue.size();
				level++;
			}
		}
	}

	public static int executeLCA(int a, int b) {
		if (depth[a] > depth[b]) { // 더 깊은 depth 가 b가 되도록 변경
			int temp = a;
			a = b;
			b = temp;
		}
		for (int i = kmax; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[b] - depth[a]) {
				if (depth[a] <= depth[parent[i][b]]) {
					b = parent[i][b];
				}
			}
		}
		for (int i = kmax; i >= 0; i--) {
			if (parent[i][a] != parent[i][b]) {
				a = parent[i][a];
				b = parent[i][b];
			}
		}
		int LCA = a;
		if (a != b) {
			LCA = parent[0][LCA];
		}
		return LCA;
	}

}
