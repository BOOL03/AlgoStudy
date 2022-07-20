package study_0707;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_17136_이다영  {
	private static int min=1001;
	
	public static void main(String[] args)throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int map[][]=new int[10][10];
		int count[]=new int[6];
		for(int i=0;i<10;i++) {
			String line[]=bf.readLine().split(" ");
			for(int j=0;j<10;j++) {
				map[i][j]=Integer.parseInt(line[j]);
			}
		}
		DFS(map,0,0,count);
		if(min==1001)
			min=-1;
		System.out.print(min);
	}
	
	public static void DFS(int map[][],int x,int y,int count[]) {
		if(over(count)) {
			return;
		}
		if(x==9 && y==9) {
			int sum=0;
			if(map[x][y]==1) {
				sum=1;
			}
			for(int i=1;i<6;i++) {
				if(count[i]>5) {
					return;
				}
				sum+=count[i];
			}
			if(min>sum) {
				int s=10;
			}
			min=Math.min(min, sum);
			return;
		}
		else {
			if(map[x][y]==0) {
				if(y==9) {
					DFS(map,x+1,0,count);
				}
				else {
					DFS(map,x,y+1,count);
				}
			}
			else {
				for(int i=5;i>0;i--) {
					if(x+i-1>=10 || y+i-1>=10) {
						continue;
					}
					if(verification(map,i,x,y)) {
						attach(i,map,count,x,y);
						if(y==9) {
							DFS(map,x+1,0,count);
						}
						else {
							DFS(map,x,y+1,count);
						}
						remove(i,map,count,x,y);
					}
				}
			}

		}
	}

	public static boolean verification(int map[][],int w,int x,int y) {
		for(int i=0;i<w;i++) {
			for(int j=0;j<w;j++) {
				if(map[x+i][y+j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	public static void attach(int w,int map[][],int count[],int x,int y) {
		for(int i=0;i<w;i++) {
			for(int j=0;j<w;j++) {
				map[x+i][y+j]=0;
			}
		}
		count[w]++;
	}
	public static void remove(int w,int map[][],int count[],int x,int y) {
		for(int i=0;i<w;i++) {
			for(int j=0;j<w;j++) {
				map[x+i][y+j]=1;
			}
		}
		count[w]--;
	}
	public static boolean over(int count[]) {
		for(int i=1;i<6;i++) {
			if(count[i]>5) {
				return true;
			}
		}
		return false;
	}

}
