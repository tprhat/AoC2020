package aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day15 {
	private static List<String> s = new ArrayList<>();
	
	
	
	public static int day15(int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (String x : s.get(0).split(",")) {
			list.add(Integer.parseInt(x));
		}
		for (int i = 0; i < list.size() - 1; i++)
			map.put(list.get(i), i);

		while(list.size() != num) {
			int last = list.get(list.size() - 1);
			int k = 0;
			if (map.containsKey(last)) {
				k = list.size() - 1 - map.get(last);
			}
			map.put(last, list.size() - 1);
			list.add(k);
		}
		return list.get(num - 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			s.add(sc.nextLine());
		}
		sc.close();

		System.out.println("Part 1: \n" + day15(2020));
		System.out.println("Part 2: \n" + day15(30000000));
		

	}

}
