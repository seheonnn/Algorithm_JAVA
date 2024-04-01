package baekjoon.CH09트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO 다시하기
public class P2042_구간합구하기3_세그먼트트리 {
	public static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 변경이 일어나는 횟수
		int K = Integer.parseInt(st.nextToken()); // 구간 합을 구하는 횟수

		int treeHeight = 0;
		int length = N;

		while (length != 0) {
			length /= 2;
			treeHeight++;
		}
		int treeSize = (int)Math.pow(2, treeHeight + 1);
		int leftNodeStartIndex = treeSize / 2 - 1;
		tree = new long[treeSize + 1];
		// 데이터를 리프 노드에 입력 받기
		for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		setTree(treeSize - 1); // tree 생성
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			if (a == 1) {
				changeVal(leftNodeStartIndex + s, e);
			} else if (a == 2) {
				s += leftNodeStartIndex;
				e += leftNodeStartIndex;
				System.out.println(getSum(s, (int)e));
			} else {
				return;
			}
		}
	}

	// 구간 합을 구하는 함수
	public static long getSum(int s, int e) {
		long partSum = 0;
		while (s <= e) {
			if (s % 2 == 1) {
				partSum += tree[s];
				s++;
			}
			if (e % 2 == 0) {
				partSum += tree[e];
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return partSum;
	}

	// 값을 변경하는 함수
	public static void changeVal(int index, long val) {
		long diff = val - tree[index];
		while (index > 0) {
			tree[index] = tree[index] + diff;
			index /= 2;
		}
	}

	// 초기 트리를 구성하는 함수
	public static void setTree(int i) {
		while (i != 1) {
			tree[i / 2] += tree[i];
			i--;
		}
	}

}
