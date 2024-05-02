package baekjoon.CH10조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO 다시하기
public class P13251_조약돌꺼내기_조합 {

	public static int M, K, T; // M : 색의 종류, K : 선택 조약돌의 개수, T : 전체 조약돌의 개수
	public static int[] D;
	public static double[] probability;
	public static double ans;

	public static void main(String[] args) throws IOException {
		D = new int[51];
		probability = new double[51];
		T = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			// D 배열에 각 조약돌의 개수 저장
			D[i] = Integer.parseInt(st.nextToken());
			// T 변수에 모든 조약돌의 개수 더하기
			T += D[i];
		}
		st = new StringTokenizer(bf.readLine());
		K = Integer.parseInt(st.nextToken());
		ans = 0.0;
		for (int i = 0; i < M; i++) {
			// 선택 조약돌의 개수보다 현재 색 조약돌의 개수가 적으면 모두 같은색으로 뽑을 확률은 0이므로 D[i] >= K인 경우만
			if (D[i] >= K) {
				probability[i] = 1.0;
				for (int j = 0; j < K; j++) {
					// i 색으로 모두 뽑을 확률 = i 색을 모두 뽑을 확률 * 현재 색 개수 - K / 전체 색 개수 - K
					probability[i] *= (double)(D[i] - j) / (T - j);
				}
			}
			ans += probability[i];
		}
		System.out.println(ans);
	}
}
