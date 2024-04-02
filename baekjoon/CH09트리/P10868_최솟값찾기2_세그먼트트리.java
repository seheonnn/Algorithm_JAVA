package baekjoon.CH09트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10868_최솟값찾기2_세그먼트트리 {
	public static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int treeHeight = 0;
		int length = N;

		while (length != 0) {
			length /= 2;
			treeHeight++;
		}

		int treeSize = (int)Math.pow(2, treeHeight + 1);
		int leftNodeStartIndex = treeSize / 2 - 1;

		// 트리 초기화
		tree = new long[treeSize + 1];
		for (int i = 0; i <= treeSize; i++) {
			tree[i] = Integer.MAX_VALUE;
		}

		for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
			st = new StringTokenizer(br.readLine());
			tree[i] = Long.parseLong(st.nextToken());
		}

		// 트리의 마지막 인덱스
		setTree(treeSize - 1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			s += leftNodeStartIndex;
			e += leftNodeStartIndex;
			System.out.println(getMin(s, e));
		}
	}

	public static void setTree(int i) {
		while (i != 1) {
			// 현재 노드가 부모 노드보다 값이 작을 때 해당 값을 부모 노드에 저장
			if (tree[i / 2] > tree[i])
				tree[i / 2] = tree[i];
			i--;
		}
	}

	public static long getMin(int s, int e) {
		long min = Integer.MAX_VALUE;
		while (s <= e) {
			if (s % 2 == 1) {
				min = Math.min(min, tree[s]);
				s++;
			}
			if (e % 2 == 0) {
				min = Math.min(min, tree[e]);
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return min;
	}
}
