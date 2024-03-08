package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976_여행계획짜기_집합 {
	public static int[][] city; // 0이면 i, j는 연결되어 있고 1이면 연결되지 않은 상태
	public static int[] set; // 집합을 나타내는 배열
	public static int[] plan; // 몇 개의 도시를 여행할지 정해져 있지 않으므로 배열로 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		// 자신이 속한 집합을 자기 자신으로 초기화
		set = new int[N + 1];
		for (int i = 0; i <= N; i++)
			set[i] = i;

		city = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		plan = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}

		// 서로 연결되어 있는 도시들에 대하여 합집합 수행
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (city[i][j] == 1)
					union(i, j);
			}
		}

		// 여행할 도시들이 모두 같은 집합에 속해있어야 함.
		int city_set = find(plan[1]);
		for (int i = 2; i <= M; i++) {
			if (city_set != find(plan[i])) {
				System.out.println("NO");
				return; // main 종료
			}
		}
		System.out.println("YES");
	}

	public static int find(int a) {
		if (a == set[a])
			return a;
		else
			return set[a] = find(set[a]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b)
			set[b] = a;
	}
}
