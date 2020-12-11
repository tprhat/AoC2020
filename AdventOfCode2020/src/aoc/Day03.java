package aoc;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Day03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		String[] s = new String[2000];
		int i = 0;
		int n = 0;
		while (sc.hasNextLine()) {
			s[i] = sc.nextLine();
			i++;
		}
		n = i;
		sc.close();

		int br = 0;
		long total = 1;
		int x[] = { 1, 3, 5, 7 };
		int pos = 0;
		
		for (i = 1; i < n; i++) {
			pos += x[1];
			if (pos > s[i].length() - 1) {
				pos -= s[i].length();
			}
			if (s[i].charAt(pos) == '#') {
				br++;
			}
		}
		total *= br;
		System.out.println("Part 1: \n" + total);
		
		
		total = 1;
		for (int k = 0; k < 4; k++) {
			br = 0;
			pos = 0;
			for (i = 1; i < n; i++) {
				pos += x[k];
				if (pos > s[i].length() - 1) {
					pos -= s[i].length();
				}
				if (s[i].charAt(pos) == '#') {
					br++;
				}
			}
			total *= br;
		}
		pos = 0;
		br = 0;
		for (i = 2; i < n; i += 2) {
			pos += 1;
			if (pos > s[i].length() - 1) {
				pos -= s[i].length();
			}
			if (s[i].charAt(pos) == '#') {
				br++;
			}
		}
		total *= br;
		System.out.println("Part 2: \n" + total);
	}

}
