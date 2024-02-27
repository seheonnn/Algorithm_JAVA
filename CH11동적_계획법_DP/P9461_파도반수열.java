package CH11동적_계획법_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9461_파도반수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int j = 0; j < T; j++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			// N 이 일정 값 이상 커지게 되면 Integer.MAX_VALUE 를 넘게 되므로 long 으로 선언
			long[] D = new long[N + 4];

			D[0] = 0;
			D[1] = 1;
			D[2] = 1;
			D[3] = 1;

			// 4 부터 시작
			for (int i = 4; i < N + 4; i++) {
				D[i] = D[i - 2] + D[i - 3];
			}
			System.out.println(D[N]);
		}
	}
}
