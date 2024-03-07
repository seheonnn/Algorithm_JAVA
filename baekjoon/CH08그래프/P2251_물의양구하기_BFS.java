package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2251_물의양구하기_BFS {
	public static int A, B, C;
	public static boolean[][] visited; // 1번 물통과 2번 물통만 방문여부 체크 -> 3번 물통의 물 양은 1번, 2번 물통에 따라 알아서 정해짐
	public static ArrayList<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visited = new boolean[201][201];
		result = new ArrayList<>();

		BFS(0, 0, C);

		Collections.sort(result);

		for (int i : result) {
			System.out.printf(i + " ");
		}
	}

	static void BFS(int a, int b, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {a, b, c});
		// visited[a][b] = true; // 첫 반복문에서 걸러지므로 주의할 것

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_a = cur[0];
			int cur_b = cur[1];
			int cur_c = cur[2];

			if (visited[cur_a][cur_b])
				continue;
			visited[cur_a][cur_b] = true;

			if (cur_a == 0) {
				result.add(cur_c);
			}

			// A물통에서 B물통으로 옮길 때
			if (cur_a + cur_b > B)
				queue.add(new int[] {cur_a + cur_b - B, B, cur_c});
			else
				queue.add(new int[] {0, cur_a + cur_b, cur_c});

			// A물통에서 C물통으로 옮길 때
			if (cur_a + cur_c > C)
				queue.add(new int[] {cur_a + cur_c - C, cur_b, C});
			else
				queue.add(new int[] {0, cur_b, cur_a + cur_c});

			// B물통에서 A물통으로 옮길 때
			if (cur_b + cur_a > A)
				queue.add(new int[] {A, cur_b + cur_a - A, cur_c});
			else
				queue.add(new int[] {cur_b + cur_a, 0, cur_c});

			// B물통에서 C물통으로 옮길 때
			if (cur_b + cur_c > C)
				queue.add(new int[] {cur_a, cur_b + cur_c - C, C});
			else
				queue.add(new int[] {cur_a, 0, cur_b + cur_c});

			// C물통에서 A물통으로 옮길 때
			if (cur_c + cur_a > A)
				queue.add(new int[] {A, cur_b, cur_c + cur_a - A});
			else
				queue.add(new int[] {cur_c + cur_a, cur_b, 0});

			// C물통에서 B물통으로 옮길 때
			if (cur_c + cur_b > B)
				queue.add(new int[] {cur_a, B, cur_c + cur_b - B});
			else
				queue.add(new int[] {cur_a, cur_c + cur_b, 0});
		}
	}
}
