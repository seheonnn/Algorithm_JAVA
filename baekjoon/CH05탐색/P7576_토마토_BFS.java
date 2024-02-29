package baekjoon.CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// TODO 다시하기
public class P7576_토마토_BFS {
	public static int M;
	public static int N;
	public static int[][] A;
	public static boolean[][] visited;

	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(line[j]);
			}
		}

		BFS();

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				result = Math.max(result, A[i][j]);
			}
		}
		System.out.println(result - 1);
	}

	public static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] == 1) {
					visited[i][j] = true;  // 초기 익은 토마토의 좌표를 방문했음을 표시
					queue.add(new int[] {i, j});  // 초기 익은 토마토의 좌표를 큐에 추가
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (-1 < nx && nx < N && -1 < ny && ny < M) {
					if (!visited[nx][ny] && A[nx][ny] == 0) {
						visited[nx][ny] = true;
						A[nx][ny] = A[x][y] + 1;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
}
