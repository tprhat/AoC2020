package aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> s = new ArrayList<>();
		while (sc.hasNextLine()) {
			s.add(Integer.parseInt(sc.nextLine()));
		}
		sc.close();
		int[] counter = new int[3];
		int joltCurrent = 0;
		s.sort(null);
		s.add(s.get(s.size()-1) + 3);
		while(true) {
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < s.size(); i++) {
				if(s.get(i) - joltCurrent <= 3 && s.get(i) - joltCurrent > 0) {
					list.add(s.get(i));
				}
			}
			if(!list.isEmpty()) {
				list.sort(null);
				if(list.get(0) - joltCurrent == 1) {
					counter[0]++;
				}
				else if(list.get(0) - joltCurrent == 2) {
					counter[1]++;
				}
				else if(list.get(0) - joltCurrent == 3) {
					counter[2]++;
				}
				joltCurrent = list.get(0);
			}
			else {
				break;
			}
		}
		int prod = counter[0] * counter[2];
		System.out.println("Part 1 : 3-diff * 1-diff is:\n" + prod);
		int[] tribonacci = {0, 1, 1, 2, 4, 7, 13};
		int prev = 0;
        long result = 1;
        int consecutiveCount = 1;
        
        for(int i : s) {
        	if(i == prev + 1)
        		consecutiveCount++;
        	else {
        		result *= tribonacci[consecutiveCount];
        		consecutiveCount = 1;
        	}
        	prev = i;
        }
        System.out.println("Part 2: Distinct ways:\n" + result);
	}

}
