package boj.chap2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 *  1. 		'(' 괄호인 경우에 스택에 push를 한다.
 *  2. 		')' 괄호인 경우에 스택의 Top을 pop한다.
 *  2-1.	 스택의 Top에 들어있는 인덱스와 현재 ')'의 인덱스가 1 만큼 차이 날 경우 -> pop 후 남은 스택의 사이즈만큼 결과에 더해준다.
 *  2-2.	스택의 Top에 들어있는 인덱스와 현재 ')'의 인덱스가 1 차이가 나지 않는 경우 -> pop 후  결과에 1을 더해준다. 
 */
public class BOJ10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String stick = br.readLine();
		
		Stack<Integer> stack = new Stack<>();
		
		int result = 0;
		
		for(int i = 0; i < stick.length(); i++){
			if(stick.charAt(i) == '('){
				stack.push(i); 
			}
			if(stick.charAt(i) == ')'){ 
				if(stack.peek() == (i-1)){
					stack.pop();
					result += stack.size();
				}else{
					stack.pop();
					result += 1;
				}
			}
		}
		
		System.out.println(result);		
	}// end main

}// end class
