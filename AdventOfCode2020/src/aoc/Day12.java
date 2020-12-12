package aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> s = new ArrayList<>();
		while (sc.hasNextLine()) {
			s.add(sc.nextLine());
		}
		sc.close();
		int direction = 90;
		int[] pos = {0,0}; //pos[0] = x, pos[1] = y
		for(int i = 0; i < s.size(); i++) {
			char move = s.get(i).charAt(0);
			int dist = Integer.parseInt(s.get(i).substring(1));
			
			if(move == 'N') {
				pos[0] += dist;
			}
			if(move == 'S') {
				pos[0] -= dist;
 			}
			if(move == 'W') {
				pos[1] -= dist;
			}
			if(move == 'E') {
				pos[1] += dist;
			}
			if (move == 'L') {
				direction -= dist;
				if(direction < 0)
					direction = 360 + direction;
			}
			if (move == 'R') {
				direction += dist;
				if(direction >= 360)
					direction = direction - 360;
			}
			if(move == 'F') {
				switch (direction) {
				case 0:
					pos[0] += dist;
					break;
				case 90:
					pos[1] += dist;
					break;
				case 180:
					pos[0] -= dist;
					break;
				case 270:
					pos[1] -= dist;
				}
				
			}
		}
		int sum = Math.abs(pos[0]) + Math.abs(pos[1]);
		System.out.println("Part 1: \n" + sum);
		pos[0] = 0;
		pos[1] = 0;
		int[] waypoint = {1,10};
		for(int i = 0; i < s.size(); i++) {
			char move = s.get(i).charAt(0);
			int dist = Integer.parseInt(s.get(i).substring(1));
			if(move == 'N') {
				waypoint[0] += dist;
			}
			if(move == 'S') {
				waypoint[0] -= dist;
 			}
			if(move == 'W') {
				waypoint[1] -= dist;
			}
			if(move == 'E') {
				waypoint[1] += dist;
			}
			if(move == 'L') {
				int temp;
				switch(dist) {
				case 90:
					temp = waypoint[1];
					waypoint[1] = -waypoint[0];
					waypoint[0] = temp;
					break;
				case 180:
					waypoint[0] = -waypoint[0];
					waypoint[1] = - waypoint[1];
					break;
				case 270:
					temp = waypoint[0];
					waypoint[0] = -waypoint[1];
					waypoint[1] = temp;
					break;	
				}
			}
			if(move == 'R') {
				int temp;
				switch(dist) {
				case 90:
					temp = waypoint[0];
					waypoint[0] = -waypoint[1];
					waypoint[1] = temp;
					break;	
				case 180:
					waypoint[0] = -waypoint[0];
					waypoint[1] = -waypoint[1];
					break;
				case 270:
					temp = waypoint[1];
					waypoint[1] = -waypoint[0];
					waypoint[0] = temp;
					break;
				}
			}
			if(move == 'F') {
				pos[0] += dist * waypoint[0];
				pos[1] += dist * waypoint[1];
			}
		}
		sum = Math.abs(pos[0]) + Math.abs(pos[1]);
		System.out.println("Part 2: \n" + sum);
	}

}
