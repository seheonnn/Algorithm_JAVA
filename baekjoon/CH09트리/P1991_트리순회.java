package baekjoon.CH09트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991_트리순회 {
	public static int N;
	public static int[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 알파벳 26개
		// [0] -> 왼쪽 자식 노드
		// [1] -> 오른쪽 자식 노드
		tree = new int[26][2];
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			int root = temp[0].charAt(0) - 'A'; // index 변환
			char left = temp[1].charAt(0);
			char right = temp[2].charAt(0);

			// 자식 노드가 없는 경우 -1 저장
			if (left == '.') {
				tree[root][0] = -1;
			} else {
				tree[root][0] = left - 'A';
			}

			if (right == '.') {
				tree[root][1] = -1;
			} else {
				tree[root][1] = right - 'A';
			}
		}

		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
	}

	public static void preOrder(int now) {
		if (now == -1)
			return;
		System.out.print((char)(now + 'A')); // 1. 현재 노드
		preOrder(tree[now][0]); // 2. 왼쪽 자식 노드 탐색
		preOrder(tree[now][1]); // 3. 오른쪽 자식 노드 탐색
	}

	public static void inOrder(int now) {
		if (now == -1)
			return;
		inOrder(tree[now][0]); // 1. 왼쪽 자식 노드 탐색
		System.out.print((char)(now + 'A')); // 2. 현재 노드
		inOrder(tree[now][1]); // 3. 오른쪽 자식 노드 탐색
	}

	public static void postOrder(int now) {
		if (now == -1)
			return;
		postOrder(tree[now][0]); // 1. 왼쪽 자식 노드 탐색
		postOrder(tree[now][1]); // 2. 오른쪽 자식 노드 탐색
		System.out.print((char)(now + 'A')); // 3. 현재 노드
	}
}
