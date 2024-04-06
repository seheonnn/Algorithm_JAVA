package baekjoon.CH09트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// TODO 다시하기
public class P11437_LCA_BFS {
	public static ArrayList<Integer>[] tree;
	public static int[] depth;
	public static int[] parent;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		depth = new int[N + 1];
		parent = new int[N + 1];
		visited = new boolean[N + 1];

		BFS(1);

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

	public static int executeLCA(int a, int b) {
		if (depth[a] < depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}

		// 두 노드 사이의 depth 통일
		while (depth[a] != depth[b]) {
			a = parent[a];
		}

		// 같은 조상 노드가 나올 때까지 반복
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}

	public static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
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
					parent[i] = cur; // 부모 노드 저장
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
}
