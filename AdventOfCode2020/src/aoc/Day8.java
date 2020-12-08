package aoc;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Day8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int i = 0;
		String[] s = new String[5000];
		Integer[] var_used = new Integer[5000];
		int n = 0;
		while (sc.hasNextLine()) {
			s[i] = sc.nextLine();
			var_used[i] = 0;
			i++;
		}
		n = i;
		sc.close();
		i = 0;
		int global = 0;
		while (var_used[i] == 0) {
			var_used[i] = 1;
			if (s[i].startsWith("nop")) {
				i++;
				continue;
			}
			if (s[i].startsWith("jmp")) {
				int ss;
				if (s[i].split(" ")[1].startsWith("-")) {
					ss = Integer.parseInt(s[i].split(" ")[1]);
				} else {
					ss = Integer.parseInt(s[i].split(" ")[1].substring(1));
				}
				i += ss;
				continue;
			}
			if(s[i].startsWith("acc")) {
				int br;
				if (s[i].split(" ")[1].startsWith("-")) {
					br = Integer.parseInt(s[i].split(" ")[1]);
				} else {
					br = Integer.parseInt(s[i].split(" ")[1].substring(1));
				}
				global += br;
				i++;
				continue;
			}
		}
		i = 0;
		int global1 = 0;
		int c = 0;
		int broke = 0;
		String[] s1 = s.clone();
		for (c = 0; c < n; c++) {
			s = s1.clone();
			if(s[c].startsWith("acc")) {
				continue;
			}
			else {
				if(s[c].startsWith("nop")) {
					s[c] = s[c].replace("nop", "jmp");
				}
				else if(s[c].startsWith("jmp")) {
					s[c] = s[c].replace("jmp", "nop");
				}
			}
			i = 0;
			Arrays.fill(var_used, 0);
			global1 = 0;
			while (var_used[i] == 0) {
				var_used[i] = 1;
				if (s[i].startsWith("nop")) {
					i++;
				}
				else if (s[i].startsWith("jmp")) {
					int ss;
					if (s[i].split(" ")[1].startsWith("-")) {
						ss = Integer.parseInt(s[i].split(" ")[1]);
					} else {
						ss = Integer.parseInt(s[i].split(" ")[1].substring(1));
					}
					i += ss;
				}
				else if (s[i].startsWith("acc")) {
					int br;
					if (s[i].split(" ")[1].startsWith("-")) {
						br = Integer.parseInt(s[i].split(" ")[1]);
					} else {
						br = Integer.parseInt(s[i].split(" ")[1].substring(1));
					}
					global1 += br;
					i++;
				}
				if (i == n) {
					broke = 1;
					break;
				}
			}
			if(broke == 1)
				break;
		}
		System.out.println("Part 1:\n" + global);
		System.out.println("Part 2:\n" + global1);
	}

}
