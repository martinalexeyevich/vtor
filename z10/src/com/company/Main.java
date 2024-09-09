package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int kolvo = Integer.parseInt(scanner.nextLine());
        ArrayList<ArrayList<String[]>> listMega = new ArrayList<>();

        for (int i = 0; i<kolvo; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            ArrayList<String[]> list = new ArrayList<>();
            for (int j=0; j<n; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                String nig = scanner.nextLine().substring(1);
                String[] nigger = new String[3];
                nigger[0] = String.valueOf(a);
                nigger[1] = String.valueOf(b);
                nigger[2] = nig;
                list.add(nigger);
            }
            listMega.add(list);
        }

        for (int i = 0; i<kolvo; i++) {
            ArrayList<String[]> list = listMega.get(i);
            ArrayList<ArrayList<String>> baz = new ArrayList<>();
            for (int j = 0; j<list.size(); j++) {
                ArrayList<String> nigro = new ArrayList<>(Arrays.asList(list.get(j)));
                for (int m = 0; m<list.size(); m++) {
                    if (list.get(m)[1].equals(list.get(j)[0]) == true) nigro.add(list.get(m)[0]);
                }
                baz.add(nigro);
            }

            ArrayList<ArrayList<String>> firsts = new ArrayList<>();
            for (int j=0; j<baz.size(); j++) {
                ArrayList<String> nigro = baz.get(j);
                if (nigro.get(1).equals("-1") == true) firsts.add(nigro);
            }

            ArrayList<String> t;
            for (int m = 0; m< firsts.size(); m++) {
                for (int j = m+1; j < firsts.size(); j++) {
                    if (Integer.parseInt(firsts.get(j).get(0)) < Integer.parseInt(firsts.get(m).get(0))) {
                        t = firsts.get(j);
                        firsts.set(j, firsts.get(m));
                        firsts.set(m, t);
                    }
                }
            }

            for (int j = 0; j<firsts.size(); j++) {
                ArrayList<String> nigro = firsts.get(j);
                if (nigro.get(1).equals("-1") == true) {
                    String[] strings = new String[nigro.size()-3];
                    for (int y = 3; y<nigro.size(); y++) {
                        strings[y-3] = nigro.get(y);
                    }
                    int nig = nigro.size();;
                    for (int y = 3; y<nig; y++) nigro.remove(3);
                    strings = swap(strings);
                    for (int y = 0; y<strings.length; y++) nigro.add(strings[y]);
                    System.out.println(nigro.get(2));
                    ArrayList<String> strList = new ArrayList<>();
                    if (nig>3) System.out.println("|"); else System.out.println();
                    int level = 1;
                    strList.add("|");
                    for (int y = 3; y<nig; y++) {
                        for (int z = 0; z< baz.size(); z++) if (baz.get(z).get(0).equals(nigro.get(y)))
                        pechatPotomk(baz.get(z), strList, baz, level);}
                }
            }

        }

    }

    static public void pechatPotomk (ArrayList<String> list, ArrayList<String> strList,
                                     ArrayList<ArrayList<String>> megaList, int level) {
        String[] strings = new String[list.size()-3];
        for (int y = 3; y<list.size(); y++) {
            strings[y-3] = list.get(y);
        }
        int nig = list.size();
        for (int y = 3; y<nig; y++) list.remove(3);
        strings = swap(strings);
        for (int y = 0; y<strings.length; y++) list.add(strings[y]);

        if (strList.get(strList.size()-1).equals("   ")) {
            while (strList.get(strList.size()-1).equals("   ")) strList.remove(strList.size()-1);
        strList.set(strList.size()-1, "|");}

        for (String str : strList) System.out.print(str);
        System.out.println("--"+list.get(2));

        for (int i =0; i<megaList.size(); i++) {
            if (megaList.get(i).get(0).equals(list.get(1)) &&
                    megaList.get(i).get(megaList.get(i).size()-1).equals(list.get(0)))
                strList.set(level-1, "   ");
        }

        if (nig>3) {strList.add("|");
            if (strList.get(strList.size()-2).equals("   ") == false) strList.set(strList.size()-2, "|  ");
            for (String str : strList) System.out.print(str); System.out.println();}
        else {for (String str:strList) System.out.print(str); System.out.println();}

        for (int i = 3; i<list.size(); i++) {
            for (int z = 0; z< megaList.size(); z++) if (megaList.get(z).get(0).equals(list.get(i)))
            pechatPotomk(megaList.get(z), strList, megaList, level+1);}
    }

    static public String[] swap(String[] strings) {
        String t = "";
        for (int i = 0; i< strings.length; i++) {
            for (int j = i+1; j< strings.length; j++) {
                if (Integer.parseInt(strings[j]) < Integer.parseInt(strings[i])) {
                    t = strings[i];
                    strings[i] = strings[j];
                    strings[j] = t;
                }
            }
        }
        return strings;
    }
}
