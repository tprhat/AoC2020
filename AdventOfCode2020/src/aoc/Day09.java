package aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Long> s = new ArrayList<Long>();
		while (sc.hasNextLine()) {
			s.add(Long.valueOf(sc.nextLine()));
		}
		sc.close();
		Long num = null;
		int n = 0;
		for (int i = 25; i < s.size(); i++) {
			int br = 0;
			outerloop: for (int j = i - 25; j < i; j++) {
				for (int k = i - 25; k < i; k++) {
					if (j != k) {
						if (s.get(j) + s.get(k) == s.get(i)) {
							br++;
							break outerloop;
						}
					}
				}
			}
			if (br == 0) {
				num = s.get(i);
				n = i;
				System.out.println("Part 1: First number without XMAS property:\n" + num);
			}
		}
		for (int i = 0; i < n; i++) {
			Long sum = s.get(i);
			Long min = s.get(i);
			Long max = s.get(i);
			for (int j = i + 1; j < n; j++) {
				sum += s.get(j);
				if (s.get(j) < min)
					min = s.get(j);
				if (s.get(j) > max)
					max = s.get(j);
				if ((long) sum == (long) num) {
					long minmax = (long) min + (long) max;
					System.out.println("Part 2: Sum of smallest and largest number in cotiguous range:\n" + minmax);
				} else if (sum > num)
					break;
			}
		}
	}

}
