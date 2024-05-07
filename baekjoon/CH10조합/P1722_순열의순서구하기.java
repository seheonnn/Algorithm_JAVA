package baekjoon.CH10조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO 다시하기
public class P1722_순열의순서구하기 {

	public static int N, Q;
	public static long[] F;
	public static int[] S;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		F = new long[21]; // 각 자리별로 만들 수 있는 경우의 수 저장 -> 팩토리얼 형태
		S = new int[21]; // 순열을 담는 배열
		visited = new boolean[21]; // 숫자의 사용 유무 저장 배열

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 순열의 길이
		st = new StringTokenizer(br.readLine());
		Q = Integer.parseInt(st.nextToken()); // 문제의 종류 1이면 순열 출력, 2이면 순서 출력

		F[0] = 1;
		for (int i = 1; i <= N; i++) {
			// 팩토리얼 초기화 -> 각 자릿수에서 만들 수 있는 경우의 수
			F[i] = F[i - 1] * i;
		}

		if (Q == 1) {
			long K = Long.parseLong(st.nextToken()); // 몇 번째 순열을 출력할지(K번째)
			for (int i = 1; i <= N; i++) {
				int cnt = 1; // 해당 자리에서 몇 번째 숫자를 사용해야 할지를 정하는 변수
				for (int j = 1; j <= N; j++) {
					// 이미 사용한 숫자는 다시 사용할 수 없음
					if (!visited[j]) {
						// 주어진 K 에 따라 각 자리에 들어갈 수 있는 수 찾기
						if (K <= cnt * F[N - i]) {
							K -= ((cnt - 1) * F[N - i]);
							S[i] = j;
							visited[j] = true;
							break;
						}
						cnt++;

					}
				}
			}
			for (int i = 1; i <= N; i++) {
				System.out.print(S[i] + " ");
			}
		} else { // Q == 2인 경우
			long K = 1;
			for (int i = 1; i <= N; i++) {
				S[i] = Integer.parseInt(st.nextToken());
				long cnt = 0;
				for (int j = 1; j < S[i]; j++) {
					// 미사용 숫자 개수만큼 카운트
					if (!visited[j]) {
						cnt++;
					}
				}
				// 자릿수에 따라 순서 더하기
				K += cnt * F[N - i];
				visited[S[i]] = true;
			}
			System.out.println(K);
		}
	}
}
