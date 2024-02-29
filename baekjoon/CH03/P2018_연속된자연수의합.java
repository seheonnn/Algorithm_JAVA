package baekjoon.CH03;

import java.util.Scanner;

// 3-3 투 포인터 백준 : 2018
public class P2018_연속된자연수의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1; // 15(결과값) 하나인 경우
		int start_index = 1;
		int end_index = 1;
		int sum = 1;

		while (end_index != N) {
			if (sum == N) { // 현재의 연속 합이 N과 같은 경우
				count++;
				end_index++;
				sum += end_index;
			} else if (sum > N) { // 현재의 연속 합이 N보다 더 큰 경우
				sum -= start_index;
				start_index++;
			} else { // 현재의 연속 합이 N보다 더 작은 경우
				end_index++;
				sum += end_index;
			}
		}
		System.out.println(count);
	}
}

