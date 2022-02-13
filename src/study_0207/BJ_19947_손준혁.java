package study_0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_19947_손준혁 {
	/*
    1년마다 5%의 이율을 얻는 투자 (A)
    3년마다 20%의 이율을 얻는 투자 (B)
    5년마다 35%의 이율을 얻는 투자 (C)
    */
    static int H, Y;
    static long[] pay_array;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        pay_array = new long[Y+1];
        pay_array[0] = H;
        fun();
    }
    static void fun(){
        for (int i=1;i<=Y;i++){
            pay_array[i] = (long) Math.floor(pay_array[i-1]*1.05);
            if (i>=3){
                pay_array[i] = (long) Math.max(Math.floor(pay_array[i-3]* 1.2), pay_array[i]);
            }
            if(i>=5){
                pay_array[i] = (long) Math.max(Math.floor(pay_array[i-5]* 1.35), pay_array[i]);
            }
        }
        System.out.println(pay_array[Y]);
    }
}
