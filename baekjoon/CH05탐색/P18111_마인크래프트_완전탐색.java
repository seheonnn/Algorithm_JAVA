package baekjoon.CH05탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P18111_마인크래프트_완전탐색 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] block = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				block[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, block[i][j]);
				max = Math.max(max, block[i][j]);
			}
		}

		int min_time = Integer.MAX_VALUE;
		int highest = 0;
		for (int h = min; h <= max; h++) {
			int time = 0;
			int inven = B;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (h > block[i][j]) { // 해당 칸의 높이가 목표 높이보다 작다면
						time += h - block[i][j]; // 인벤토리에서 그 차이만큼 블럭 꺼내서 설치
						inven -= h - block[i][j];
					} else if (h < block[i][j]) { // 행당 칸의 높이가 목표 높이보다 크다면
						time += (block[i][j] - h) * 2; // 차이만큼 해당 칸의 블럭 제거 후 인벤토리에 저장
						inven += block[i][j] - h;
					}
				}
			}

			if (inven < 0)
				continue;

			if (min_time >= time) { // 시간의 최솟값
				min_time = time;
				highest = Math.max(highest, h); // 땅 높이의 최댓값
			}
		}
		System.out.println(min_time + " " + highest);
	}
}
