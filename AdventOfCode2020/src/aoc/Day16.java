package aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day16 {
	private static List<String> s = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			s.add(sc.nextLine());
		}
		sc.close();

		List<String> constraints = new ArrayList<String>();
		List<Integer> myTicket = new ArrayList<Integer>();
		List<String> otherTickets = new ArrayList<String>();
		int var = 0;

		for (String x : s) {
			if (x.equals(""))
				continue;
			if (x.startsWith("your ticket")) {
				var = 1;
				continue;
			}
			if (x.startsWith("nearby ticket")) {
				var = 2;
				continue;
			}
			if (var == 0) {
				constraints.add(x);
			}
			if (var == 1) {
				for (String y : x.split(",")) {
					myTicket.add(Integer.parseInt(y));
				}
			}
			if (var == 2) {
				otherTickets.add(x);
			}
		}
		Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		for (String x : constraints) {
			String name = x.split(": ")[0];
			String nums = x.split(": ")[1].split(" or ")[0] + "-" + x.split(": ")[1].split(" or ")[1];
			String[] num = nums.split("-");
			ArrayList<Integer> toCheck = new ArrayList<Integer>();
			for (int i = 0; i < num.length; i++)
				toCheck.add(Integer.parseInt(num[i]));
			map.put(name, toCheck);
		}
		int sum = 0;
		ArrayList<String> temp = new ArrayList<String>();
		for (String x : otherTickets) {
			List<Integer> nums = new ArrayList<Integer>();
			for (String y : x.split(",")) {
				nums.add(Integer.parseInt(y));
			}
			int j = 0;
			for (int z : nums) {
				int i = 0;
				for (List<Integer> toCheck : map.values()) {
					if ((z >= toCheck.get(0) && z <= toCheck.get(1)) || (z >= toCheck.get(2) && z <= toCheck.get(3))) {
						i++;
					}
				}
				if (i == 0) {
					sum += z;
					j = 1;
				}
			}
			if (j == 0) {
				temp.add(x);
			}
		}
		System.out.println("Part 1: \n" + sum);

//		otherTickets.clear();
//		otherTickets.addAll(temp);
//		ArrayList<ArrayList<Integer>> cols = new ArrayList<ArrayList<Integer>>();
//		for (int i = 0; i < map.keySet().size(); i++) {
//			ArrayList<Integer> tmp = new ArrayList<Integer>();
//			for (String x : otherTickets) {
//				tmp.add(Integer.parseInt(x.split(",")[i]));
//			}
//			cols.add(tmp);
//		}
		
	}

}
