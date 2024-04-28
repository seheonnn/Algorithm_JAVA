package baekjoon.CH10조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO 다시하기
public class P13251_조약돌꺼내기_조합 {

	public static int M, K, T;
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
			D[i] = Integer.parseInt(st.nextToken());
			T += D[i];
		}
		st = new StringTokenizer(bf.readLine());
		K = Integer.parseInt(st.nextToken());
		ans = 0.0;
		for (int i = 0; i < M; i++) {
			if (D[i] >= K) {
				probability[i] = 1.0;
				for (int j = 0; j < K; j++) {
					probability[i] *= (double)(D[i] - j) / (T - j);
				}
			}
			ans += probability[i];
		}
		System.out.println(ans);
	}
}
