package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2251_물의양구하기_DFS {
	public static int A, B, C;
	public static boolean[][] visited; // 1번 물통과 2번 물통만 방문여부 체크 -> 3번 물통의 물 양은 1번, 2번 물통에 따라 알아서 정해짐
	public static ArrayList<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		visited = new boolean[201][201];

		// 각 물통의 크기
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		result = new ArrayList<>();
		DFS(0, 0, C);

		Collections.sort(result);

		for (int i : result) {
			System.out.printf(i + " ");
		}
	}

	public static void DFS(int a, int b, int c) {
		if (visited[a][b])
			return;

		if (a == 0) {
			result.add(c);
		}
		visited[a][b] = true;

		// from -> to 로 물이 이동하는 케이스는 두 가지
		// 1. from + to 에 담긴 물의 양이 to의 전체 용량보다 클 경우 from 의 부분만이동
		// - to 물통은 물이 꽉 참
		// 2. from + to 에 담긴 물의 양이 to의 전체 용량보다 작은 경우 from 모두 이동
		// - from 물통은 빔

		// 1번 2번 과정을 반복하면서 1번 물통이 비게 될 경우, 3번 물통의 양을 저장

		// 0에서 1로 옮기는 경우
		if (a + b > B) {
			DFS((a + b) - B, B, c);
		} else {
			DFS(0, a + b, c);
		}

		// 1에서 0으로 옮기는 경우
		if (a + b > A) {
			DFS(A, a + b - A, c);
		} else {
			DFS(a + b, 0, c);
		}

		// 2에서 0으로 옮기는 경우
		if (a + c > A) {
			DFS(A, b, a + c - A);
		} else {
			DFS(a + c, b, 0);
		}

		// 2에서 1로 옮기는 경우
		if (b + c > B) {
			DFS(a, B, b + c - B);
		} else {
			DFS(a, b + c, 0);
		}

		// 0에서 2로 옮기는 경우
		DFS(a, 0, b + c);

		// 1에서 2로 옮기는 경우
		DFS(0, b, a + c);
	}
}
