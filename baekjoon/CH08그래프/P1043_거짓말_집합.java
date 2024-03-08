package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1043_거짓말_집합 {
	public static ArrayList<Integer>[] party;
	public static int[] set;
	public static int[] trueP; // 진실을 아는 사람들 배열
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		result = 0;
		set = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			set[i] = i;
		}

		int T = Integer.parseInt(st.nextToken());
		trueP = new int[T];
		for (int i = 0; i < T; i++)
			trueP[i] = Integer.parseInt(st.nextToken());

		party = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			party[i] = new ArrayList<Integer>();
			int size = Integer.parseInt(st.nextToken());

			for (int j = 0; j < size; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		// 각 파티에 참여한 사람들 그룹화
		for (int i = 0; i < M; i++) {
			int group = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++) {
				union(group, party[i].get(j));
			}
		}

		// 진실을 아는 사람과 현재 파티가 같은 집합이면 거짓말을 할 수 없음
		for (int i = 0; i < M; i++) {
			boolean canLie = true;
			int curParty = party[i].get(0);
			for (int j = 0; j < trueP.length; j++) {
				if (check(find(curParty), find(trueP[j]))) {
					canLie = false;
					break;
				}
			}
			if (canLie)
				result++;
		}
		System.out.println(result);
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

	// 같은 집합인지
	public static boolean check(int a, int b) {
		a = find(a);
		b = find(b);

		return a == b;
	}
}
