package baekjoon.CH07정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1033_칵테일 {
	public static ArrayList<Node>[] A; // Node 객체를 요소로 하는 이중 리스트
	public static long lcm; // 최소공배수
	public static boolean[] visited;
	public static long[] D; // 최소공배수 배열

	public static void DFS(int v) {
		if (visited[v])
			return;

		visited[v] = true;
		for (Node i : A[v]) {
			int next = i.getB();
			if (!visited[next])
				D[next] = D[v] * i.getQ() / i.getP(); // q, p 유의
			DFS(next);
		}
	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		A = new ArrayList[N];
		visited = new boolean[N];
		D = new long[N];
		lcm = 1;

		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < N - 1; i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int p = Integer.parseInt(temp[2]);
			int q = Integer.parseInt(temp[3]);
			A[a].add(new Node(b, p, q));
			A[b].add(new Node(a, q, p)); // q와 p 유의
			lcm *= (((long)p * q) / gcd(p, q));
		}

		D[0] = lcm;
		DFS(0);
		long mgcd = D[0];
		// 배열의 모든 요소들의 최대공약수
		for (int i = 1; i < N; i++) {
			mgcd = gcd(mgcd, D[i]);
		}

		for (int i = 0; i < N; i++) {
			System.out.print(D[i] / mgcd + " "); // 배열의 각 값들을 배열의 최대공약수로 나누어 출력
		}
	}

	static class Node {
		int b; // 해당 노드와 연결된 노드
		int p;
		int q;

		public Node(int b, int p, int q) {
			this.b = b;
			this.p = p;
			this.q = q;
		}

		public int getB() {
			return b;
		}

		public int getP() {
			return p;
		}

		public int getQ() {
			return q;
		}
	}
}
