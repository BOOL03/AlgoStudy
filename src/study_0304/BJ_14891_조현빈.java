package study_0304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14891_조현빈 {

	static class Gear {
		char[] status = new char[8];
		char   top;
		char   left;
		char   right;
		int    rotateDir;

		public Gear(String str) {
			this.status    = str.toCharArray();
			this.rotateDir = 0;
			setGear();
		}

		public void setRotateDir(int rotateDir) {
			this.rotateDir = rotateDir;
		}

		public void setGear() {
			top   = status[0];
			left  = status[6];
			right = status[2];
		}

		public void rotate() {
			if (rotateDir == 1) rightRotate();
			else if (rotateDir == -1) leftRotate();
			setGear();
		}

		public void leftRotate() {
			char tmp = status[0];
			for (int i = 0; i < 7; i++) {
				status[i] = status[i + 1];
			}
			status[7] = tmp;
		}

		public void rightRotate() {
			char tmp = status[7];
			for (int i = 6; i > -1; i--) {
				status[i + 1] = status[i];
			}
			status[0] = tmp;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		Gear[]         gear = new Gear[4];
		int            sum  = 0;
		for (int i = 0; i < 4; i++) {
			gear[i] = new Gear(br.readLine());
		}

		int             K  = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int k = 0; k < K; k++) {

			for (int i = 0; i < 4; i++) {
				gear[i].setRotateDir(0);
			}

			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			gear[num].setRotateDir(dir);

			for (int i = num; i > 0; i--) {
				if (gear[i].left != gear[i - 1].right) gear[i - 1].setRotateDir(-gear[i].rotateDir);
				else break;
			}

			for (int i = num; i < 3; i++) {
				if (gear[i].right != gear[i + 1].left) gear[i + 1].setRotateDir(-gear[i].rotateDir);
				else break;
			}

			for (int i = 0; i < 4; i++) {
				gear[i].rotate();
			}
		}

		for (int i = 0; i < 4; i++) {
			if (gear[i].top == '1') sum += Math.pow(2, i);
		}

		System.out.println(sum);
	}
}
