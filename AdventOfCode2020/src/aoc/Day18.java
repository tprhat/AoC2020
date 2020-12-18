package aoc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Day18 {
	private static List<String> s = new ArrayList<>();

	public static long applyOp(char op, long b, long a) {
		switch (op) {
		case '+':
			return a + b;
		case '*':
			return a * b;
		}
		return 0;
	}
	
	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		else
			return true;
	}

	public static boolean hasPrecedence2(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if (op2 == '*' && op1 == '+')
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			s.add(sc.nextLine().replace(" ", ""));
		}
		sc.close();
		long sum = 0;
		for(int k = 0; k < 2; k++){
			sum = 0;
		for (String x : s) {
			char[] array = x.toCharArray();
			Deque<Long> nums = new ArrayDeque<Long>();
			Deque<Character> ops = new ArrayDeque<Character>();
			for (int i = 0; i < array.length; i++) {
				if (array[i] >= '0' && array[i] <= '9') {
					StringBuffer sbuf = new StringBuffer();
					
					while (i < array.length && array[i] >= '0' && array[i] <= '9')
						sbuf.append(array[i++]);
					nums.push(Long.parseLong(sbuf.toString()));
					i--;
				} else if (array[i] == '(') {
					ops.push(array[i]);
				} else if (array[i] == ')') {
					while (ops.peek() != '(')
						nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
					ops.pop();
				} else if (array[i] == '+' || array[i] == '*') {
					if(k == 0) {
					while (!ops.isEmpty() && hasPrecedence(array[i], ops.peek()))
						nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
					}
					else {
						while (!ops.isEmpty() && hasPrecedence2(array[i], ops.peek()))
							nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
					}
					ops.push(array[i]);
				}
			}
			while (!ops.isEmpty())
				nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));

			sum += nums.pop();
		}
		if(k == 0) {
			System.out.println("Part 1:\n" + sum);			
		}
		else
			System.out.println("Part 2:\n" + sum);
	}
	}

}
