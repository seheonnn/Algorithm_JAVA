package baekjoon.CH08그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1325_효율적인해킹_BFS {
	public static ArrayList<Integer>[] computer;
	public static boolean[] visited;

	// 각 index = 시작 컴퓨터의 번호 / value: 해당 컴퓨터에서 해킹을 시작했을 때 해킹할 수 있는 컴퓨터의 수
	public static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		computer = new ArrayList[N + 1];
		result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			computer[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			computer[A].add(B);
		}

		for (int i = 1; i <= N; i++) {
			// 모든 컴퓨터에 대하여 BFS 실행
			visited = new boolean[N + 1];
			BFS(i);
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (max < result[i]) // 최댓값 찾기
				max = result[i];
		}

		for (int i = 1; i <= N; i++) {
			if (result[i] == max)
				bw.write(i + " ");
		}
		bw.close();
	}

	public static void BFS(int v) {
		Queue<Integer> queue = new ArrayDeque<>(); // LinkedList<>() 보다 성능↑
		queue.add(v);
		visited[v] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i : computer[cur]) {
				// if (!visited[i]) {
				// 	visited[i] = true;
				// 	result[i]++;
				// 	queue.add(i);
				// }

				// 성능상 우위
				if (visited[i])
					continue;
				visited[i] = true;
				result[i]++;
				queue.add(i);
			}
		}
	}
}
