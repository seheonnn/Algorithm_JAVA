package baekjoon.CH07정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO 다시하기
public class P1016_제곱이아닌수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		long min = Long.parseLong(s[0]); // int 는 10자리까지밖에 안 되므로 long 사용해야
		long max = Long.parseLong(s[1]);

		boolean[] A = new boolean[(int)(max - min + 1)];

		for (long i = 2; i <= Math.sqrt(max); i++) {
			long pow = i * i;
			// min % (i * i) 가 나누어 떨어진다면 몫부터 시작, 나누어 떨어지지 않는다면 몫 + 1부터 시작
			long start = min % pow == 0 ? min / pow : (min / pow) + 1;
			// (몫 or 몫 + 1) * (i * i) 값이 max 와 같아지거나 커질 때까지 반복
			for (long j = start; j * pow <= max; j++) {
				// 해당 요소값은 제곱수임
				A[(int)((j * pow) - min)] = true;
			}
		}

		int count = 0;
		for (int i = 0; i < A.length; i++)
			if (!A[i])
				count++;
		System.out.println(count);
	}
}
