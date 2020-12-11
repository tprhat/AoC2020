package aoc;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Day06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		String[] s = new String[5000];
		int i = 0;
		int n = 0;
		while (sc.hasNextLine()) {
			s[i] = sc.nextLine();
			i++;
		}
		n = i;
		sc.close();

		Set<String> br = new HashSet<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		int total = 0;
		int total2 = 0;
		int numOfPersons = 0;
		for (i = 0; i < n; i++) {
			if (s[i].equals("")) {
				total += br.size();
				br.clear();
				for (Integer count : map.values()) {
					if (count == numOfPersons) {
						total2++;
					}
				}
				map.clear();
				numOfPersons= 0;
				continue;
			}
			char[] elems = s[i].toCharArray();

			for (char elem : elems) {
				String element = elem + "";
				br.add(element);
				if (map.containsKey(element)) {
					Integer count = map.get(element);
					count++;
					map.put(element, count);
				}
				else {
					map.put(element, 1);	
				}
				
			}
			numOfPersons++;
		}
		for (Integer count : map.values()) {
			if (count == numOfPersons) {
				total2++;
			}
		}
		total += br.size();
		System.out.println("1. part: 'Yes' answers by anyone in the group: " + total);
		System.out.println("2. part: 'Yes' answers by everyone in the group: " + total2);
	}

}
