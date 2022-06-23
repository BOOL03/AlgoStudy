package study_0620;

import java.util.*;
import java.io.*;

public class BJ_16120_조현빈 {
    public static void main(String[] args) throws Exception {
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int pCount = 0;
        if (str.length() == 1 && str.equals("P")) {
            System.out.println("PPAP");
            System.exit(0);
        }

        if (str.length() == 2 || str.length() == 3) {
            System.out.println("NP");
            System.exit(0);
        }

        if (str.length() == 4 && str.equals("PPAP")) {
            System.out.println("PPAP");
            System.exit(0);
        }

        if (str.charAt(0) == 'A' || str.charAt(1) == 'A' || str.charAt(str.length() - 1) == 'A') {
            System.out.println("NP");
            System.exit(0);
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'P') {
                pCount++;
            } else if (pCount > 1 && str.charAt(i + 1) == 'P') {
                pCount--;
                i++;
            } else {
                System.out.println("NP");
                System.exit(0);
            }
        }

        if (pCount == 1) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
