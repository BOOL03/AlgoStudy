package study_0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_11899_손준혁 {
    static Stack<Character> st_char = new Stack<Character>();
    static Stack<Character> st_restore = new Stack<Character>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] bracket = br.readLine().toCharArray();
        for (int i=0;i<bracket.length;i++){
            st_char.push(bracket[i]);
        }
        int count = 0;
        while(!st_char.isEmpty()){
            if(st_char.pop() == ')'){
                st_restore.push(')');
            }
            else{
                if(st_restore.isEmpty()){
                    count++;
                }
                else{
                    st_restore.pop();
                }
            }
        }
        System.out.println(count+st_restore.size());
    }
}