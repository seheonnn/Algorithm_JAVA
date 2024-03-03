package baekjoon.CH07정수론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1850_최대공약수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 각 자리수의 최대 공약수 = 1의 개수
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		long result = gcd(a, b);

		while (result > 0) {
			bw.write("1");
			result--;
		}
		bw.flush();
		bw.close();
	}

	// 최대공약수 - 유클리드 호제법
	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
}
