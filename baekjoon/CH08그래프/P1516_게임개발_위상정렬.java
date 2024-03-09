package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

// TODO 다시하기
public class P1516_게임개발_위상정렬 {
	public static ArrayList<Integer>[] A;
	public static int[] indegree;
	public static int[] buildTime; // 자기 자신이 지어지는데 걸리는 시간
	public static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		indegree = new int[N + 1];
		buildTime = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			buildTime[i] = Integer.parseInt(st.nextToken());
			while (true) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == -1)
					break;
				A[temp].add(i); // 주의 ! 진입 당하는 노드를 증가
				indegree[i]++;
			}
		}
		result = new int[N + 1];

		// 위상 정렬
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : A[cur]) {
				indegree[next]--;
				// 해당 건물을 짓기 위해 우선적으로 지어야 하는 건물들 중에서 가장 오래 걸리는 시간 (동시에 지어야 최소 시간이 됨)
				result[next] = Math.max(result[next], result[cur] + buildTime[cur]);
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			// 특정 건물을 짓기 위해 걸리는 시간 = 우선적으로 지어야 하는 건물들을 짓기 위해 걸리는 시간 + 특정 건물을 짓기 위해 걸리는 시간
			System.out.println(result[i] + buildTime[i]);
		}
	}
}
