package CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색_BFS {
	public static int[][] A;
	public static boolean[][] visited;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static int N;
	public static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		A = new int[N][M];

		// 2차원 배열 입력
		for (int i = 0; i < N; i++) {
			String line = br.readLine(); // TODO 유의할 것
			for (int j = 0; j < M; j++) {
				A[i][j] = line.charAt(j) - '0';
			}
		}
		BFS(0, 0);
		System.out.println(A[N - 1][M - 1]);
	}

	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if (-1 < nx && nx < N && -1 < ny && ny < M) {
					if (A[nx][ny] != 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						A[nx][ny] = A[cur[0]][cur[1]] + 1;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
}
