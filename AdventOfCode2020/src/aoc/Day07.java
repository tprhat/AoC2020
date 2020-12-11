package aoc;

import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Day07 {
	public static int n = 0;
	public static List<String> possibleBags = new ArrayList<String>();
	public static String[] s = new String[5000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int i = 0;
		while (sc.hasNextLine()) {
			s[i] = sc.nextLine();
			i++;
		}
		n = i;
		sc.close();

		// shiny gold bags on the right side
		for (i = 0; i < n; i++) {
			String[] split = s[i].split(" contain ")[1].split(", ");
			for (String s1 : split) {
				if (s1.contains("shiny gold bag")) {
					possibleBags.add(s[i].split("contain ")[0].strip());
				}
			}
		}

		boolean newBag = true;
		while (newBag) {
			newBag = false;
			for (i = 0; i < n; i++) {
				String[] split = s[i].split("contain ")[1].split(", ");
				int goNext = 0;
				for (String s1 : split) {
					for (String elem : possibleBags) {
						if (elem.endsWith("s")) {
							elem = elem.substring(0, elem.length() - 1);
						}
						if (s1.contains(elem) && !possibleBags.contains(s[i].split("contain ")[0].strip())) {
							possibleBags.add(s[i].split("contain ")[0].strip());
							newBag = true;
							goNext = 1;
							break;
						}
					}
					if (goNext == 1) {
						break;
					}
				}
			}
		}
		int total = 0;
		Deque<String> possibleBags2 = new ArrayDeque<String>();
		for (i = 0; i < n; i++) {
			if (s[i].split(" contain ")[0].equals("shiny gold bags")) {
				String[] elems = s[i].split(" contain ")[1].split(", ");
				for (String elem : elems) {
					possibleBags2.add(elem);
				}
				break;
			}
		}
		while (!possibleBags2.isEmpty()) {
			String elem = possibleBags2.pop();
			int br = Integer.parseInt(elem.split(" ")[0]);
			total += br;
			String to_check = elem.substring(elem.split(" ")[0].length() + 1);
			if (to_check.endsWith("."))
				to_check = to_check.substring(0, to_check.length() - 1);
			if (!to_check.endsWith("s"))
				to_check = to_check.concat("s");
			to_check = to_check.strip();
			for (i = 0; i < n; i++) {
				if (!s[i].split(" contain ")[1].startsWith("no")) {
					if (s[i].split(" contain ")[0].equals(to_check)) {
						for (String ss : s[i].split(" contain ")[1].split(", ")) {
							int br1 = Integer.parseInt(ss.split(" ")[0]);
							int br2 = br1;
							br1 = br1 * br;
							String dodaj = String.valueOf(br1) + " " + ss.substring(String.valueOf(br2).length());
							possibleBags2.add(dodaj);
						}
					}
				}
			}
		}
		System.out.println(
				"Part 1: Number of bags that can contain at least one shiny gold bag is: " + possibleBags.size());
		System.out.println("Part 2: Number of bags inside of 1 shiny gold bag: " + total);
	}

}
