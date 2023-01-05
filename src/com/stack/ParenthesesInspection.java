package com.stack;

import java.util.Stack;

/**
 * @author tomshy 괄호 검사
 */
public class ParenthesesInspection {
	public static void main(String[] args) throws Exception {
		Stack<Character> stack = new Stack<Character>();
		Stack<Integer> stackIndex = new Stack<Integer>();
		String str = "[a+b*{c/(d-e)}]+(d/e)\n";
		int len = str.length();

		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (stack.isEmpty() && (c == ')' || c == '}' || c == ']'))
				throw new Exception("Fail parentheses inspection, size: " + i + ", character: " + c);

			if ('{' == c || '[' == c || '(' == c) {
				stack.push(c);
				stackIndex.push(i);
				continue;
			}
			if (!stack.isEmpty()) {
				char cc = stack.peek();
				if ('(' == cc && ')' == c) {
					stack.pop();
					stackIndex.pop();
				}
				if ('{' == cc && '}' == c) {
					stack.pop();
					stackIndex.pop();
				}
				if ('[' == cc && ']' == c) {
					stack.pop();
					stackIndex.pop();
				}
			}

			if (len == i + 1 && !stack.isEmpty()) {
				char cc = stack.peek();
				int index = stackIndex.peek();
				if (cc == '(')
					cc = ')';
				if (cc == '{')
					cc = '}';
				if (cc == '[')
					cc = ']';
				throw new Exception("Fail parentheses inspection, Check index: " + index + ", character: " + cc);

			}

		}

		System.out.println("Complete parentheses inspection");

	}

}
