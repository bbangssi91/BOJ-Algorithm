package boj.chap2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   * 9012 괄호문제
    여는괄호 '(' 가 나오면 스택에  +1
    닫는 괄호 ')' 가 나오면 스택에 -1 을 이용하여 
    스택 사이즈가 0보다 작은 경우 조건이 성립이 안되므로 "NO" 리턴
    조건이 성립될 경우 "YES" 리턴
   
 */

public class BOJ9012 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int test_case = 0; test_case < T; test_case++)
		{
			String con = br.readLine();
			String result = isValid(con);

			System.out.println(result);
		}// end test_case
		
	}//end main

	private static String isValid(String con) {
		int cnt = 0;
		
		for(int i = 0; i < con.length(); i++){
			if(con.charAt(i) == '('){
				cnt += 1;
			}
			else{
				cnt -= 1;
			}
			
			if(cnt < 0) return "NO";
		}
		
		if(cnt == 0) return "YES";
		else return "NO";
	}// end isValid();
	
}// end class
