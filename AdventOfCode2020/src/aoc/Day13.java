package aoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> s = new ArrayList<>();
		while (sc.hasNextLine()) {
			s.add(sc.nextLine());
		}
		sc.close();
		
		int sum = Integer.parseInt(s.get(0));
		List<Integer> list = new ArrayList<>();
		for(String x : s.get(1).split(",")) {
			if(!x.equals("x")) {
				list.add(Integer.parseInt(x));
				
			}
		}
		List<Integer> listmax = new ArrayList<>();
		listmax.addAll(list);
		boolean change = true;
		while(change) {
			change = false;
			for(int i = 0 ; i < list.size(); i++) {
				if(listmax.get(i) < sum) {
					listmax.set(i, listmax.get(i) + list.get(i));
					change = true;
				}
			}
		}
		int min = Collections.min(listmax);
		int j = 0;
		for(int i = 0; i < listmax.size(); i++) {
			if(listmax.get(i) == min)
				j = list.get(i);
		}
		int multi = j * (min - sum);
		System.out.println("Part 1: \n" + multi);
		list.clear();
		for(String x : s.get(1).split(",")) {
			if(!x.equals("x")) {
				list.add(Integer.parseInt(x));
			}
			else {
				list.add(-1);
			}
		}
		long time = 0;
		long k = 0;
		long step = 1;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == -1) {
				continue;
			}
			for(k = time; ;k+=step) {
				if((k+i) % list.get(i) == 0) {
					time = k;
					break;
				}
			}
			step *= list.get(i);
		}
		System.out.println("Part 2: \n" + time);
	}

}
