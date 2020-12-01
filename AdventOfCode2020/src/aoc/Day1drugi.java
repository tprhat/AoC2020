package aoc;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Day1drugi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		Integer[] s = new Integer[2000];
		int i = 0;
		int n = 0;
		while (sc.hasNextInt()) {
			s[i] = sc.nextInt();
			i++;
		}
		n = i;
		sc.close();

		for (i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (i != j && i != k && j != k) {
						if (s[i] + s[j] + s[k] == 2020) {
							System.out.println(s[i] * s[j] * s[k]);
						}
					}
				}
			}
		}
	}

}
