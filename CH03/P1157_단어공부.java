package CH03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1157_단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26];
		int max = 0;
		char result = 'a';

		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// ASCII 상 대문자가 먼저
			if (c >= 'a')
				arr[c - 'a']++;
			else
				arr[c - 'A']++;
		}

		for (int i = 0; i < 26; i++) {
			if (arr[i] == max) {
				result = '?';
			} else if (arr[i] > max) {
				max = arr[i];
				result = (char)(i + 'A');
			}
		}
		System.out.println(result);
	}
}
