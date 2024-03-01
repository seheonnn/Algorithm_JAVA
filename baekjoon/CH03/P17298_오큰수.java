package baekjoon.CH03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P17298_오큰수 {
	public static void main(String[] args) throws IOException {
		// 기준 수보다 오른쪽에 있으면서 큰 수 중 가장 왼쪽에 있는 수
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int[] A = new int[N];
		int[] result = new int[N];

		String[] s = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(s[i]);
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			// 스택이 비어있지 않고 현재 수열이 스택의 top보다 클 경우
			while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
				result[stack.pop()] = A[i];
			}
			stack.push(i);
		}

		// 반복문이 종료되었는데 스택에 남아있는 값이 있다면 빌 때까지 pop 하고 -1 넣음
		while (!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(result[i] + " ");
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
