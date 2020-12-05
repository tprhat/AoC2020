package aoc;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Day5 {

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
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		int hSeatNum = 0;
		int row = 0;
		int col = 0;
		int rowCount = 7;
		for(i = 0; i < n; i++) {
			int min = 0;
			int max = 127;
			for(int j = 0; j < rowCount; j++) {
				if(j == rowCount - 1) {
					if(s[i].charAt(j) == 'F') {
						row = min;
					}
					else if(s[i].charAt(j) == 'B') {
						row = max;
					}
					break;
				}
				if (s[i].charAt(j) == 'F') {
					max = (min + max) / 2;
				}
				if(s[i].charAt(j) == 'B') {
					if(min + max % 2 != 0)
						min = min + 1;
					min = (min + max) / 2;
				}
			}
			int l = 0;
			int r = 7;
			for(int j = rowCount; j < rowCount + 3 ; j++) {
				if(j == rowCount + 2 ) {
					if(s[i].charAt(j) == 'L') {
						col = l;
					}
					else if(s[i].charAt(j) == 'R') {
						col = r;
					}
					break;
				}
				if (s[i].charAt(j) == 'L') {
					r = (l + r) / 2;
				}
				if(s[i].charAt(j) == 'R') {
					if(l + r % 2 != 0)
						l += 1;
					l = (l + r) / 2;
				}
			}
			hSeatNum = hSeatNum < row * 8 + col ? row * 8 + col : hSeatNum;
			set.add(row * 8 + col);
		}
		System.out.println("Highest seat number is: " + hSeatNum);
		for(i = set.first() ; i < set.last(); i ++) {
			if(!set.contains(i)) {
				System.out.println("My seat number is: "  + i);
			}
		}
		
	}

}
