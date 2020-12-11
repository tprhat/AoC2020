package aoc;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Day02 {

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
		
		for(i = 0; i < n; i++) {
			String[] input = s[i].split(" ");
			String[] minmax = input[0].split("-");
			char[] letter = input[1].substring(0, 1).toCharArray();
			int min = Integer.parseInt(minmax[0]);
			int max = Integer.parseInt(minmax[1]);
			int counter = 0;
			for(int j = 0; j < input[2].length(); j ++) {
				if(input[2].charAt(j) == letter[0]) {
					counter++;
				}
			}
			if(counter <= max && counter >= min) {
				br++;
			}
		}
		System.out.println("Part 1: \n" + br);
		br = 0;
		for(i = 0; i < n; i++) {
			String[] input = s[i].split(" ");
			String[] minmax = input[0].split("-");
			char[] letter = input[1].substring(0, 1).toCharArray();
			int min = Integer.parseInt(minmax[0]);
			int max = Integer.parseInt(minmax[1]);
			if(input[2].charAt(min-1) == letter[0] && input[2].charAt(max-1) != letter[0]) {
				br++;
			}
			else if(input[2].charAt(min-1) != letter[0] && input[2].charAt(max-1) == letter[0]) {
				br++;
			}
		
		}
		
		System.out.println("Part 2: \n" + br);
	}

}
