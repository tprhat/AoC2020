package aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> s = new ArrayList<>();
		while (sc.hasNextLine()) {
			s.add(sc.nextLine());
		}
		sc.close();

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (String x : s.get(0).split(",")) {
			list.add(Integer.parseInt(x));
		}
		System.out.println(list);
		while (list.size() != 2020) {
			int k = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(list.size() - 1).equals(list.get(i)))
					k = list.size() - 1 - i;
			}
			list.add(k);
		}
		System.out.println("Part 1: \n" + list.get(2020 - 1));
		list.clear();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (String x : s.get(0).split(",")) {
			list.add(Integer.parseInt(x));
		}
		for (int i = 0; i < list.size() - 1; i++)
			map.put(list.get(i), i);

		while (list.size() != 30000000) {
			int last = list.get(list.size() - 1);
			int k = 0;
			if (map.containsKey(last)) {
				k = list.size() - 1 - map.get(last);
			}
			map.put(last, list.size() - 1);
			list.add(k);
		}
		int part2 = list.get(30000000 - 1);
		System.out.println("Part 2: \n" + part2);

	}

}
