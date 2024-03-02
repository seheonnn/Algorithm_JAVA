package baekjoon.CH07정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11689_오일러피함수구현하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		long result = n; // n과 모든 수가 서로소라고 가정하고 시작
		// 제곱근(포함)까지만 진행
		for (long i = 2; i <= Math.sqrt(n); i++) {
			// i가 소인수일 때
			if (n % i == 0) {
				// 결과값 업데이트 / result: 현재까지의 서로소 개수, result/i: 현재까지 찾은 i의 배수의 개수
				result = result - result / i; // i와 n이 공약수인 경우 중복된 수를 빼줌
				while (n % i == 0) { // n을 i로 나눌 수 있을 때까지
					// 나누어진 i들의 지수들을 제거
					n /= i; // 2^7 * 11이라면 2^7을 없애고 11만 남김
				}
			}
		}

		// 반복문이 종료된 후 n이 1보다 크면 n은 마지막 소인수임
		if (n > 1)
			// 따라서, 마지막으로 결과값 업데이트
			result = result - result / n;
		System.out.println(result);
	}
}
