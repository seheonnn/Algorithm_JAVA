package CH03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO 다시
public class P12891_DNA비밀번호 {

	static int checkSecret = 0;
	static int[] checkArr = new int[4];
	static int[] myArr = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = bf.readLine().split(" ");

		int S = Integer.parseInt(temp[0]);
		int P = Integer.parseInt(temp[1]);

		char[] A = bf.readLine().toCharArray(); // 중요

		String[] lst = bf.readLine().split(" ");

		int count = 0;

		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(lst[i]);
			if (checkArr[i] == 0)
				checkSecret++;

		}
		for (int i = 0; i < P; i++) {
			Add(A[i]);
		}

		if (checkSecret == 4)
			count++;

		// 슬라이딩 윈도우 처리
		for (int i = P; i < S; i++) {
			int j = i - P;
			Add(A[i]);
			Remove(A[j]);
			if (checkSecret == 4)
				count++;
		}
		System.out.println(count);
		bf.close();
	}

	private static void Add(char c) {
		switch (c) {
			case 'A':
				myArr[0]++;
				if (myArr[0] == checkArr[0])
					checkSecret++;
				break;
			case 'C':
				myArr[1]++;
				if (myArr[1] == checkArr[1])
					checkSecret++;
				break;
			case 'G':
				myArr[2]++;
				if (myArr[2] == checkArr[2])
					checkSecret++;
				break;
			case 'T':
				myArr[3]++;
				if (myArr[3] == checkArr[3])
					checkSecret++;
				break;
		}
	}

	private static void Remove(char c) {
		switch (c) {
			case 'A':
				if (myArr[0] == checkArr[0])
					checkSecret--;
				myArr[0]--;
				break;
			case 'C':
				if (myArr[1] == checkArr[1])
					checkSecret--;
				myArr[1]--;
				break;
			case 'G':
				if (myArr[2] == checkArr[2])
					checkSecret--;
				myArr[2]--;
				break;
			case 'T':
				if (myArr[3] == checkArr[3])
					checkSecret--;
				myArr[3]--;
				break;
		}
	}

}
