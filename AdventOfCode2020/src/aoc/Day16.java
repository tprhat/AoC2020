package aoc;

import java.util.*;
import java.util.Map.Entry;

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

		otherTickets.clear();
		otherTickets.addAll(temp);
		ArrayList<ArrayList<Integer>> cols = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < map.keySet().size(); i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for (String x : otherTickets) {
				tmp.add(Integer.parseInt(x.split(",")[i]));
			}
			cols.add(tmp);
		}
		HashMap<String, ArrayList<Integer>> combos = new HashMap<String, ArrayList<Integer>>();
		ArrayList<Integer> check = new ArrayList<Integer>();
		for (Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			ArrayList<Integer> toAdd = new ArrayList<Integer>();
			check = entry.getValue();
			for (int i = 0; i < cols.size(); i++) {
				boolean fits = true;
				for (int x : cols.get(i)) {
					if (!((x >= check.get(0) && x <= check.get(1)) || (x >= check.get(2) && x <= check.get(3)))) {
						fits = false;
						break;
					}
				}
				if (fits) {
					toAdd.add(i);
				}
			}
			combos.put(entry.getKey(), toAdd);
		}
		boolean change = true;
		while (change) {
			change = false;
			HashMap<String, ArrayList<Integer>> beggining = new HashMap<String, ArrayList<Integer>>();
			beggining.putAll(combos);
			for (Entry<String, ArrayList<Integer>> entry : combos.entrySet()) {
				if (entry.getValue().size() == 1) {
					int x = entry.getValue().get(0);
					for (Entry<String, ArrayList<Integer>> entry1 : combos.entrySet()) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						if (!entry1.getKey().equals(entry.getKey())) {
							for (int y : entry1.getValue()) {
								if (x != y) {
									list.add(y);
									change = true;
								}
							}
							combos.put(entry1.getKey(), list);
						}
					}
					if(beggining.equals(combos))
						change = false;
				}
			}
		}
		long prod = 1;
		for (Entry<String, ArrayList<Integer>> entry : combos.entrySet()) {
			if(entry.getKey().startsWith("departure")) {
				prod *= myTicket.get(entry.getValue().get(0));
			}
		}
		System.out.println("Part 2: \n" + prod);
	}

}
