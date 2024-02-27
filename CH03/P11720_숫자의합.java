package CH03;

import java.util.Scanner;

// 3-1 11720
public class P11720_숫자의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String sNum = sc.next();
		int sum = 0;
		for (int i = 0; i < sNum.length(); i++) {
			sum += sNum.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}
