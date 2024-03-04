package baekjoon.CH07정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21568_확장유클리드호제법 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		long gcd = gcd(A, B); // 최대공약수

		if (C % gcd != 0) { // C가 A와 B의 최대공약수의 배수가 아니라면 -1 출력
			System.out.println(-1);
		} else {
			long mok = C / gcd;
			long[] ret = Execute(A, B);
			System.out.println(ret[0] * mok + " " + ret[1] * mok); // x, y 각각의 결과값에 C / A와 B의 최대공약수 값을 곱함
		}
	}

	public static long[] Execute(long a, long b) {
		long[] ret = new long[2];
		if (b == 0) {
			ret[0] = 1; // x = 1, y = 0으로 설정하고 리턴
			ret[1] = 0;
			return ret;
		}
		long q = a / b;
		long[] v = Execute(b, a % b);

		ret[0] = v[1]; // 역순으로 x, y깂 계산
		ret[1] = v[0] - v[1] * q;
		return ret;
	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
}
