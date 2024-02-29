package baekjoon.CH06그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1541_최솟값을만드는괄호배치찾기 {
	public static String[] str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 덧셈 연산을 먼저 진행 후 모두 뺄셈 연산
		str = br.readLine().split("-");

		int result = 0;

		for (int i = 0; i < str.length; i++) {
			// 덧셈만 있는 경우가 있으므로 addExpression 부터 실행
			int temp = addExpression(str[i]);
			if (i == 0) // 첫 번째 요소는 항상 덧셈
				result += temp;
			else // 덧셈 연산 후 나머지는 모두 뺄셈 연산
				result -= temp;
		}

		System.out.println(result);
	}

	public static int addExpression(String s) {
		// 덧셈 연산 먼저
		int sum = 0;
		String[] temp = s.split("[+]");
		for (int i = 0; i < temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}
}
