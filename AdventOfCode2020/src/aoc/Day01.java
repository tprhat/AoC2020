package aoc;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Day01 {

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
		
		outerloop:
		for(i = 0; i < n ; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j) {
					if(s[i] + s[j] == 2020) {
						System.out.println("Part 1: \n" + s[i]* s[j]);
						break outerloop;
					}
				}
			}
		}
		outerloop:
		for (i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (i != j && i != k && j != k) {
						if (s[i] + s[j] + s[k] == 2020) {
							System.out.println("Part 2: \n" + s[i] * s[j] * s[k]);
							break outerloop;
						}
					}
				}
			}
		}
	}

}
