package boj.chap2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*  커서 왼쪽으로 한칸 옮김 (L) -> O(1)
 *  커서 오른쪽으로 한칸 옮김(D) -> O(1)
 *  커서 왼쪽의 문자삭제 (B) -> O(N) 
 *  커서 왼쪽에 문자 추가(P $) -> O(N) 
 *  
 *   즉 O(N^2) 수행시간 , But 조건에 따라 60만*60만 = 3600억 이므로 수행시간 초과.
 *   
 *   따라서 커서를 중심으로 커서 앞의 문자는 왼쪽 스택으로, 커서 뒤의 문자는  오른쪽 스택에 넣어준다. -> O(N) 
 */

public class BOJ1406 {

	static Stack<Character> left;
	static Stack<Character> right;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		left = new Stack<>();
		right = new Stack<>();
		
		String editor = br.readLine();
		
		// 초기는 커서가 가장 오른쪽에 있으므로, left 스택에 푸시.
		for(int i = 0; i < editor.length(); i++){
			left.push(editor.charAt(i));
		}
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++){
			String inst = br.readLine();	
			instEditor(inst);
		}//end for
		
		while(!left.isEmpty())
			right.push(left.pop());
		while(!right.isEmpty())
			System.out.print(right.pop());
				
	}//end main

	private static void instEditor(String inst) {
		char temp;

		switch(inst.charAt(0)){
			case 'L':
				if(left.size() == 0) return;
				temp = left.pop();
				right.push(temp);
				break;
			case 'D':
				if(right.size() == 0) return;
				temp = right.pop();
				left.push(temp);
				break;
			case 'B':
				if(left.size() == 0) return;
				temp = left.pop();
				break;
			case 'P':
				temp = inst.charAt(2);
				left.push(temp);
				break;
		}
		
	}//end changeCursor(String inst)

}//end class
