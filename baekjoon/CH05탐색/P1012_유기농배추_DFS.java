package baekjoon.CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1012_유기농배추_DFS {
	public static int M;
	public static int N;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static int[][] A;
	public static boolean[][] visited;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스의 수

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken()); // 배추밭의 가로 길이
			N = Integer.parseInt(st.nextToken()); // 배추밭의 세로 길이
			int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수;

			A = new int[M][N];
			visited = new boolean[M][N];
			count = 0;

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				A[x][y] = 1;
			}
			for (int x = 0; x < M; x++) {
				for (int y = 0; y < N; y++) {
					if (A[x][y] == 1 && !visited[x][y]) {
						DFS(x, y);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void DFS(int i, int j) {
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if (-1 < nx && nx < M && -1 < ny && ny < N) {
				if (!visited[nx][ny] && A[nx][ny] == 1) {
					visited[nx][ny] = true;
					DFS(nx, ny);
				}
			}
		}
	}
}
