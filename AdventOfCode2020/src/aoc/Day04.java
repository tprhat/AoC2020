package aoc;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Day04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		String[] s = new String[2000];
		int i = 0;
		int n = 0;
		while (sc.hasNextLine()) {
			s[i] = sc.nextLine();
			i++;
		}
		n = i;
		sc.close();

		int br = 0;
		int total = 0;

		for (i = 0; i < n; i++) {

			if (s[i].equals("")) {

				if (br == 7)
					total++;
				br = 0;
				continue;
			}
			String[] split = s[i].split(" ");
			for(String string : split) {
				if(string.startsWith("byr")) {
					br++;
				}
				if(string.startsWith("eyr")) {
					br++;
				}
				if(string.startsWith("iyr")) {
					br++;
				}
				if(string.startsWith("hgt")) {
					br++;
				}
				if(string.startsWith("hcl")) {
					br++;
				}
				if(string.startsWith("ecl")) {
					br++;
				}
				if(string.startsWith("pid")) {
					br++;
				}
				
			}
		}
		if(br == 7)
			total++;
		System.out.println("Part 1: \n" + total);
		total = 0;
		br = 0;
		for (i = 0; i < n; i++) {

			if (s[i].equals("")) {

				if (br == 7)
					total++;
				br = 0;
				continue;
			}
			String[] split = s[i].split(" ");
			for (String string : split) {
				String[] splt = string.split(":");
				if (splt[0].equals("byr")) {
					try {
						if (Integer.parseInt(splt[1]) <= 2002 && Integer.parseInt(splt[1]) >= 1920) {
							br++;
						}
					} catch (Exception e) {
						continue;
					}
				}

				if (splt[0].equals("iyr")) {
					try {
						if (Integer.parseInt(splt[1]) <= 2020 && Integer.parseInt(splt[1]) >= 2010) {
							br++;
						}
					} catch (Exception e) {
						continue;
					}
				}
				if (splt[0].equals("eyr")) {
					try {
						if (Integer.parseInt(splt[1]) <= 2030 && Integer.parseInt(splt[1]) >= 2020) {
							br++;
						}
					} catch (Exception e) {
						continue;
					}
				}
				if (splt[0].equals("hgt")) {
					try {
						if (splt[1].endsWith("cm")) {
							if (Integer.parseInt(splt[1].substring(0, 3)) >= 150
									&& Integer.parseInt(splt[1].substring(0, 3)) <= 193) {
								br++;
							}
						} else if (splt[1].endsWith("in")) {
							if (Integer.parseInt(splt[1].substring(0, 2)) >= 59
									&& Integer.parseInt(splt[1].substring(0, 2)) <= 76) {
								br++;
							}
						}
					} catch (Exception e) {
						continue;
					}
				}

				if (splt[0].equals("hcl")) {
					if (splt[1].startsWith("#")) {
						splt[1] = splt[1].substring(1);
						if (splt[1].matches("[a-f0-9]{6}")) {
							br++;
						}
					}
				}

				if (splt[0].equals("ecl")) {
					if (splt[1].equals("amb")) {
						br++;
					} else if (splt[1].equals("blu")) {
						br++;
					} else if (splt[1].equals("brn")) {
						br++;
					} else if (splt[1].equals("gry")) {
						br++;
					} else if (splt[1].equals("grn")) {
						br++;
					} else if (splt[1].equals("hzl")) {
						br++;
					} else if (splt[1].equals("oth")) {
						br++;
					}
				}
				if (splt[0].equals("pid")) {
					if (splt[1].matches("[0-9]{9}")) {

						br++;
					}
				}

			}

		}

		// check for the last element
		if (br == 7)
			total++;
		System.out.println("Part 2: \n" + total);
	}

}
