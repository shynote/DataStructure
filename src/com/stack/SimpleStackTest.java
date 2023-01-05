package com.stack;

import java.util.Stack;

public class SimpleStackTest {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		if(stack.empty()) {
			stack.push(1);
			stack.push(2);
			stack.push(3);
		}
		
		if( !stack.empty()) {
			if(stack.peek() == 3 )
				stack.pop();
		}
		
		if( stack.search(3) == -1)
		{
			System.out.println( "3 is poped!");
		}
	}

}
