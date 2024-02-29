package baekjoon.CH03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class P1874_스택수열_스택 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		boolean noPrint = false;

		int[] A = new int[N];

		ArrayList<Character> result = new ArrayList<>();
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		int num = 1; // 오름차순 수
		for (int i = 0; i < N; i++) {
			int curr = A[i];
			if (curr >= num) {
				while (curr >= num) {
					stack.push(num++);
					result.add('+');
				}
				stack.pop();
				result.add('-');
			} else { // 현재 수열의 값 < 오름차순 자연수
				int n = stack.pop();
				if (n > curr) {
					noPrint = true;
				} else {
					result.add('-');
				}
			}
		}

		if (noPrint)
			System.out.println("NO");
		else {
			for (Character c : result) {
				System.out.println(c);
			}

		}
	}
}
