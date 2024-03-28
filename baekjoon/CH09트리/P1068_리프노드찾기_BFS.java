package baekjoon.CH09트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1068_리프노드찾기_BFS {
	public static ArrayList<Integer>[] A;
	public static boolean[] visitied;
	public static int N, root, delete, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		A = new ArrayList[N];
		visitied = new boolean[N];
		answer = 0;

		for (int i = 0; i < N; i++)
			A[i] = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			// a 가 -1이면 i는 root 노드
			// 다른 숫자라면 i의 부모 노드
			if (tmp != -1) {
				A[tmp].add(i);
				A[i].add(tmp);
			} else {
				root = i;
			}
		}
		st = new StringTokenizer(br.readLine());
		delete = Integer.parseInt(st.nextToken());

		// 제거하는 노드의 자식 노드들은 모두 제거. 이후 "트리에 남은" 리프 노드의 개수 구하기
		if (delete == root) {
			// root 노드를 제거하는 경우 트리의 모든 노드가 제거되므로 트리에 남은 리프 노드는 없음
			System.out.println(0);
		} else {
			BFS(root);
			System.out.println(answer);
		}

	}

	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visitied[v] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int cnt = 0;
			for (int i : A[cur]) {
				// 방문하지 않은 노드이면서 삭제 노드가 아닌 경우에 탐색
				if (!visitied[i] && i != delete) {
					visitied[i] = true;
					queue.add(i);
					cnt++;
				}
			}
			if (cnt == 0)
				answer++;
		}
	}
}
