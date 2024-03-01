package baekjoon.CH03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1254_팰린드롬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int result = str.length(); // 입력 받은 문자열에 글자를 하나씩 붙이면서 팰린드롬인지 확인

		for (int i = 0; i < str.length(); i++) {
			if (isPalindrome(str.substring(i))) // .subString() 은 해당 index 부터 끝까지의 문자 반환
				break;
			result++;
		}
		System.out.println(result);
	}

	public static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;

		while (start <= end) {
			if (str.charAt(start) != str.charAt(end)) // .charAt() 은 해당 index 의 단일 문자 반환
				return false;
			start++;
			end--;
		}
		return true;
	}
}
