package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717_집합표현하기 {
	public static int[] set; // 집합 표시 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 원소의 개수
		int M = Integer.parseInt(st.nextToken()); // 연산의 개수

		set = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			set[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			if (x == 0) { // 0이면 합집합
				union(y, z);
			} else { // 1이면 같은 집합의 원소인지 확인
				if (check(y, z))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

	// a의 집합 찾는 연산
	public static int find(int a) {
		if (a == set[a])
			return a;
		else
			return set[a] = find(set[a]); // 재귀함수로 구현함으로써 경로 압축
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		// 서로 집합이 다르면 b의 집합 a로
		if (a != b) {
			set[b] = a;
		}
	}

	public static boolean check(int a, int b) {
		a = find(a);
		b = find(b);

		return a == b;
	}
}
