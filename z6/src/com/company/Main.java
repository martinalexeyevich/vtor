package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int kolvo = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[kolvo];

        for (int i = 0; i<kolvo; i++) strings[i] = scanner.nextLine();

        for (int i = 0; i<kolvo; i++) {
            int x = 0;
            int y = 0;
            String[] hz = new String[1];
            hz[0] = "";
            char[] nig = strings[i].toCharArray();
            for (int m = 0; m<nig.length; m++) {
                if (nig[m] == 'L') x = left(hz[y], x);
                else if (nig[m] == 'R') x = right(hz[y], x);
                else if (nig[m] == 'U') {x = up(hz, x, y);
                if (y !=0) y--;}
                else if (nig[m] == 'D') {x = down(hz, x, y);
                if (y != hz.length-1) y++;}
                else if (nig[m] == 'E') x = end(hz[y], x);
                else if (nig[m] == 'B') x = home(hz[y], x);
                else if (nig[m] == 'N') {hz = enter(hz, x, y); x=0; y++;}
                else {hz[y] = letters(hz[y], x, nig[m]); x++;}
            }
            for (int j = 0; j< hz.length; j++) {
                System.out.println(hz[j]);
            }
            System.out.println("-");
        }

    }

    public static int home(String string, int x) {

        x = 0;
        return x;
    }

    public static int end(String string, int x) {
        if (string.length()>0) {x = string.length();
        return x;}
        else return 0;
    }

    public static int up(String[] strings, int x, int y) {
        if (y != 0) {
            if (x > strings[y-1].length()) x = strings[y-1].length();
        }
        return x;
    }

    public static int down(String[] strings, int x, int y) {
        if (y != strings.length-1) {
            if (x > strings[y+1].length()) x = strings[y+1].length();
        }
        return x;
    }

    public static String letters(String string, int x, char c) {
        char[] ch = string.toCharArray();
        char[] ch1 = new char[string.length()+1];
        for (int i=0; i<x; i++) ch1[i] = ch[i];
        ch1[x] = c;
        for (int i = x+1; i<ch1.length; i++) ch1[i] = ch[i-1];
        return String.valueOf(ch1);
    }

    public static int right(String string, int kurs) {
        if (kurs<string.length()) kurs++;
        return kurs;
    }

    public static int left(String string, int kurs) {
        if (kurs>0) kurs--;
        return kurs;
    }

    public static String[] enter(String[] strings, int x, int y) {
        if (x == strings[y].length()) {
            String[] nigger = new String[strings.length+1];
            for (int i = 0; i<y+1; i++) nigger[i] = strings[i];
            nigger[y+1] = "";
            for (int i = y+2; i< nigger.length; i++) nigger[i] = strings[i-1];
            return nigger;
        }
        else {
            char[] ch = strings[y].toCharArray();
            char[] ch1 = new char[x];
            char[] ch2 = new char[strings[y].length()-x];
            System.arraycopy(ch, 0, ch1, 0, ch1.length );
            System.arraycopy(ch, ch1.length, ch2, 0, ch2.length );
            String[] nigger = new String[strings.length+1];
            for (int i=0; i<y; i++) nigger[i] = strings[i];
            for (int i = y+2; i< nigger.length; i++) nigger[i] = strings[i-1];
            nigger[y] = String.valueOf(ch1);
            nigger[y+1] = String.valueOf(ch2);
            x = 0;
            y++;
            return nigger;
        }

    }

}
