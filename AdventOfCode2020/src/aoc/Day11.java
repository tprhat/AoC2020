package aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day11 {
	static final char free = 'L';
	static final char occupied = '#';
	static final char floor = '.';

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> s = new ArrayList<>();
		while (sc.hasNextLine()) {
			s.add(sc.nextLine());
		}
		sc.close();
		List<String> s1 = new ArrayList<>();
		List<String> part2 = new ArrayList<String>();
		part2.addAll(s);
		int len = s.get(0).length();
		boolean init = true;
		while (!s1.equals(s)) {
			if (init) {
				s1.addAll(s);
				init = false;
			}
			s.clear();
			s.addAll(s1);
			for (int i = 0; i < s.size(); i++) {
				for (int j = 0; j < len; j++) {
					if (s.get(i).charAt(j) == floor)
						continue;
					int br = 0;
					try {
						if (s.get(i - 1).charAt(j - 1) == occupied) {
							br++;
						}
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						if (s.get(i - 1).charAt(j) == occupied) {
							br++;
						}
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						if (s.get(i - 1).charAt(j + 1) == occupied) {
							br++;
						}
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						if (s.get(i).charAt(j - 1) == occupied) {
							br++;
						}
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						if (s.get(i).charAt(j + 1) == occupied) {
							br++;
						}
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						if (s.get(i + 1).charAt(j - 1) == occupied) {
							br++;
						}
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						if (s.get(i + 1).charAt(j) == occupied) {
							br++;
						}
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						if (s.get(i + 1).charAt(j + 1) == occupied) {
							br++;
						}
					} catch (IndexOutOfBoundsException e) {
					}

					if (br == 0 && s.get(i).charAt(j) == free) {
						char[] repl = s1.get(i).toCharArray();
						repl[j] = occupied;
						s1.set(i, String.valueOf(repl));
					} else if (br >= 4 && s.get(i).charAt(j) == occupied) {
						char[] repl = s1.get(i).toCharArray();
						repl[j] = free;
						s1.set(i, String.valueOf(repl));
					}
				}
			}
		}
		int seatsOccupied = 0;
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < len; j++) {
				if (s.get(i).charAt(j) == occupied)
					seatsOccupied++;
			}
		}
		System.out.println("Part 1: \n" + seatsOccupied);
		s1.clear();
		s.clear();
		s.addAll(part2);
		init = true;
		while (!s1.equals(s)) {
			if (init) {
				s1.addAll(s);
				init = false;
			}
			s.clear();
			s.addAll(s1);
			for (int i = 0; i < s.size(); i++) {
				for (int j = 0; j < len; j++) {
					if (s.get(i).charAt(j) == floor)
						continue;
					int k = i;
					int l = j;
					int br = 0;
					//up
					while(k >= 0) {
						k--;
						try {
						if(s.get(k).charAt(l) != floor) {
							if(s.get(k).charAt(l) == occupied) {
								br++;
							}
							break;
						}
						}catch(IndexOutOfBoundsException e) {
							break;
						}
						
					}
					//down
					k = i;
					l = j;
					while(k < len) {
						k++;
						try {
							if(s.get(k).charAt(l) != floor) {
								if(s.get(k).charAt(l) == occupied) {
									br++;
								}
								break;
							}
						}catch(IndexOutOfBoundsException e) {
							break;
						}
						
					}
					//left
					k = i;
					l = j;
					while(l >= 0) {
						l--;
						try {
							if(s.get(k).charAt(l) != floor) {
								if(s.get(k).charAt(l) == occupied) {
									br++;
								}
								break;
							}
						}catch(IndexOutOfBoundsException e) {
							break;
						}
						
					}
					//right
					k = i;
					l = j;
					while(l < len) {
						l++;
						try {
							if(s.get(k).charAt(l) != floor) {
								if(s.get(k).charAt(l) == occupied) {
									br++;
								}
								break;
							}
						}catch(IndexOutOfBoundsException e) {
							break;
						}
						
					}
					//up left
					k = i;
					l = j;
					while(k >= 0 && l >= 0) {
						k--;
						l--;
						try {
							if(s.get(k).charAt(l) != floor) {
								if(s.get(k).charAt(l) == occupied) {
									br++;
								}
								break;
							}
						}catch(IndexOutOfBoundsException e) {
							break;
						}
						
					}
					//up right
					k = i;
					l = j;
					while(k >= 0 && l < len) {
						k--;
						l++;
						try {
							if(s.get(k).charAt(l) != floor) {
								if(s.get(k).charAt(l) == occupied) {
									br++;
								}
								break;
							}
						}catch(IndexOutOfBoundsException e) {
							break;
						}
						
					}
					//down left
					k = i;
					l = j;
					while(k < len && l >= 0) {
						k++;
						l--;
						try {
							if(s.get(k).charAt(l) != floor) {
								if(s.get(k).charAt(l) == occupied) {
									br++;
								}
								break;
							}
						}catch(IndexOutOfBoundsException e) {
							break;
						}
						
					}
					//down right
					k = i;
					l = j;
					while(k < len && l < len) {
						k++;
						l++;
						try {
							if(s.get(k).charAt(l) != floor) {
								if(s.get(k).charAt(l) == occupied) {
									br++;
								}
								break;
							}
						}catch(IndexOutOfBoundsException e) {
							break;
						}
						
					}
					if (br == 0 && s.get(i).charAt(j) == free) {
						char[] repl = s1.get(i).toCharArray();
						repl[j] = occupied;
						s1.set(i, String.valueOf(repl));
					} else if (br >= 5 && s.get(i).charAt(j) == occupied) {
						char[] repl = s1.get(i).toCharArray();
						repl[j] = free;
						s1.set(i, String.valueOf(repl));
					}
				}
				
			}
		}
		seatsOccupied = 0;
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < len; j++) {
				if (s.get(i).charAt(j) == occupied)
					seatsOccupied++;
			}
		}
		System.out.println("Part 2: \n" + seatsOccupied);

	}

}
