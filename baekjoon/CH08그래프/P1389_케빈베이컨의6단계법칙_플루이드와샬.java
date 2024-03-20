package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1389_케빈베이컨의6단계법칙_플루이드와샬 {
	static final int INF = 10000001; // INF 값 유의 !!
	public static int N, M;
	public static int[][] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

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
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			distance[A][B] = 1;
			distance[B][A] = 1;
		}

		floydWarshall();

		// 케빈 베이컨 수가 가장 작은 index 구하기
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int temp = 0;
			for (int j = 1; j <= N; j++) {
				temp += distance[i][j];
			}
			if (min > temp) {
				min = temp;
				result = i;
			}
		}
		System.out.println(result);
	}

	public static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (distance[i][j] > distance[i][k] + distance[k][j])
						distance[i][j] = distance[i][k] + distance[k][j];
				}
			}
		}
	}
}
