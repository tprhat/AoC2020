package aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> s = new ArrayList<>();
		while (sc.hasNextLine()) {
			s.add(sc.nextLine());
		}
		sc.close();
		Map<String, String> map = new HashMap<String, String>();
		String mask = "";
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).startsWith("mask")) {
				mask = s.get(i).split(" = ")[1];
				continue;
			}
			String mem = s.get(i).split(" = ")[0];
			mem = mem.substring(4, mem.length() - 1);
			String num = s.get(i).split(" = ")[1];
			num = Integer.toBinaryString(Integer.parseInt(num));
			while (num.length() != 36) {
				num = '0' + num;
			}
			char[] maskArray = mask.toCharArray();
			char[] numArray = num.toCharArray();
			String out = "";
			for (int j = 0; j < mask.length(); j++) {
				if (maskArray[j] == '1' || maskArray[j] == '0') {
					out += maskArray[j];
				} else {
					out += numArray[j];
				}
			}
			map.put(mem, out);
		}
		long sum = 0;
		for (String x : map.values()) {
			sum += Long.parseLong(x, 2);
		}
		System.out.println("Part 1: \n" + sum);
		map.clear();
		//part 2
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).startsWith("mask")) {
				mask = s.get(i).split(" = ")[1];
				continue;
			}
			String mem = s.get(i).split(" = ")[0];
			mem = mem.substring(4, mem.length() - 1);
			String num = Integer.toBinaryString(Integer.parseInt(mem));
			String value = s.get(i).split(" = ")[1];
			while (num.length() != 36) {
				num = '0' + num;
			}
			char[] maskArray = mask.toCharArray();
			char[] numArray = num.toCharArray();
			String out = "";
			int br = 0;
			for (int j = 0; j < mask.length(); j++) {
				if (maskArray[j] == '0')
					out += numArray[j];
				else if (maskArray[j] == '1')
					out += '1';
				else {
					out += 'X';
					br++;
				}
			}
			List<String> binary = new ArrayList<String>();
			for (int j = 0; j < Math.pow(2, br); j++) {
				binary.add(Integer.toBinaryString(j));
			}

			for (int k = 0; k < binary.size(); k++) {
				char[] array = out.toCharArray();
				int l = 1;
				for (int j = array.length - 1; j >= 0; j--) {
					if (array[j] == 'X') {
						if (binary.get(k).length() - l >= 0) {
							array[j] = binary.get(k).charAt(binary.get(k).length() - l);
							l++;
						} else {
							array[j] = '0';

						}
					}
				}
				map.put(String.valueOf(array), value);
			}
		}
		sum = 0;
		for (String x : map.values()) {
			sum += Long.parseLong(x);
		}
		System.out.println("Part 2: \n" + sum);
	}

}
