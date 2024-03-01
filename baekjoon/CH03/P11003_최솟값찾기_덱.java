package baekjoon.CH03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO 다시
public class P11003_최솟값찾기_덱 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Deque<Node> myDeque = new LinkedList<>(); // 주의
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			// 새로운 값이 들엉올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임

			while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
				myDeque.removeLast();
			}

			myDeque.addLast(new Node(now, i));

			// 범위에서 벗어난 값은 덱에서 제거
			if (myDeque.getFirst().index <= i - L) {
				myDeque.removeFirst();
			}
			bw.write(myDeque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	static class Node {
		public int value;
		public int index;

		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
