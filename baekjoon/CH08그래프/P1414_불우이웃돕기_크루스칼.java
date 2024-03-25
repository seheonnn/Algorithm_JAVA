package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1414_불우이웃돕기_크루스칼 {

	public static int[] parent;
	public static int N, sum;
	public static PriorityQueue<Edge> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		queue = new PriorityQueue<>();
		N = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 0; i <= N; i++)
			parent[i] = i;

		sum = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			char[] temp = st.nextToken().toCharArray();
			for (int j = 1; j <= N; j++) {
				int tmp = 0;
				int idx = j - 1;

				// 입력받은 문자 숫자로 변환
				if ('a' <= temp[idx] && temp[idx] <= 'z')
					tmp = temp[idx] - 'a' + 1;
				else if ('A' <= temp[idx] && temp[idx] <= 'Z')
					tmp = temp[idx] - 'A' + 27;

				sum += tmp;
				if (i != j && tmp != 0)
					queue.add(new Edge(i, j, tmp));
			}
		}

		// 최소신장트리
		int useEdge = 0;
		int result = 0;
		while (!queue.isEmpty()) {
			Edge cur = queue.poll();
			if (find(cur.start) != find(cur.end)) {
				union(cur.start, cur.end);
				result += cur.weight;
				useEdge++;
			}
		}

		if (useEdge == N - 1)
			System.out.println(sum - result);
		else
			System.out.println(-1);
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

		if (a != b)
			parent[b] = a;
	}

	public static class Edge implements Comparable<Edge> {
		int start, end, weight;

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
