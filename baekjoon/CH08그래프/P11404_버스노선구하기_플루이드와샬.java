package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P11404_버스노선구하기_플루이드와샬 {
	static final int INF = 10000001; // INF 값 유의 !!
	public static int[][] distance;
	public static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		// 초기화, 자기 자신한테 갈 수 없으니 0으로
		distance = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					distance[i][j] = 0;
				else
					distance[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 동일한 두 도시에 대하여 경로가 여러 개일 수 있음
			// 예시를 보면 "1 4 1"과 "1 4 2" 입력
			// 최단 경로이기 때문에 비용이 작은 것을 선택해야 함. "1 4 1" 선택해야
			distance[a][b] = Math.min(distance[a][b], c);
		}

		floydWarshall();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (distance[i][j] == INF)
					System.out.print(0 + " ");
				else
					System.out.printf(distance[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void floydWarshall() {
		// 플로이드 와샬 알고리즘
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 최단경로 초기화
					if (distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
	}
}
