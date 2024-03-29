package baekjoon.CH09트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// TODO 다시하기
public class P14425_문자열찾기_해쉬셋 {
	public static int N, M, cnt;
	public static HashSet<String> hashSet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		cnt = 0;

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		hashSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			hashSet.add(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			if (hashSet.contains(st.nextToken()))
				cnt++;
		}
		System.out.println(cnt);
	}
}
