package CH04정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// TODO 다시
public class P1377_버블소트1 {
	// swap이 한 번도 일어나지 않은 루프가 언제인지 알아내는 문제
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Node[] A = new Node[N];

		for (int i = 0; i < N; i++) {
			A[i] = new Node(Integer.parseInt(br.readLine()), i);
		}

		Arrays.sort(A); // -> O(n logn)

		int MAX = 0;
		for (int i = 0; i < N; i++) {
			if (MAX < (A[i].index - i)) {// 정렬 전 index - 정렬 후 index의 최댓값
				MAX = A[i].index - i;
			}
		}

		System.out.println(MAX + 1);
	}

	static class Node implements Comparable<Node> {
		public int value;
		public int index;

		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Node o) { // Array.sort()에서 value를 기준으로 정렬
			return this.value - o.value;
		}
	}
}
