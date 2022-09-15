package com.daythree;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String sequence;
        Scanner file;

        int [] zeroCount = new int[12];
        int [] oneCount = new int[12];

        ArrayList<String> dataArray1 = new ArrayList<String>(1000);
        ArrayList<String> dataArray2 = new ArrayList<String>(1000);

        file = new Scanner(new File("C:\\Users\\aleks\\IdeaProjects\\AoC_day3\\src\\com\\daythree\\data.txt"));
        while (file.hasNext()) {
            sequence = file.nextLine();
            dataArray1.add(sequence);
            dataArray2.add(sequence);
        }

        for (String x: dataArray1) {
            if (x.charAt(0)=='0') zeroCount[0]++;
            else if (x.charAt(0)=='1') oneCount[0]++;
        }

        file = new Scanner(new File("C:\\Users\\aleks\\IdeaProjects\\AoC_day3\\src\\com\\daythree\\data.txt"));
        while (file.hasNext()) {
            sequence = file.nextLine();
            if (zeroCount[0]>oneCount[0]) {
                if (sequence.charAt(0)=='1') dataArray1.remove(sequence);
            } else if (zeroCount[0]<=oneCount[0]) {
                if (sequence.charAt(0)=='0') dataArray1.remove(sequence);
            }
        }

        for (int abc=1; abc<12; abc++) {
            for (String x : dataArray1) {
                if (x.charAt(abc) == '0') zeroCount[abc]++;
                else if (x.charAt(abc) == '1') oneCount[abc]++;
            }

            file = new Scanner(new File("C:\\Users\\aleks\\IdeaProjects\\AoC_day3\\src\\com\\daythree\\data.txt"));
            while (file.hasNext()) {
                sequence = file.nextLine();
                if (zeroCount[abc] > oneCount[abc]) {
                    if (sequence.charAt(abc) == '1') dataArray1.remove(sequence);
                } else if (zeroCount[abc] <= oneCount[abc]) {
                    if (sequence.charAt(abc) == '0') dataArray1.remove(sequence);
                }
            }
        }

//        for (int abc=0; abc<12; abc++) {
//            System.out.println(zeroCount[abc]);
//            System.out.println(oneCount[abc]);
//            System.out.println(dataArray.stream().count());
//        }

        for (int z=0;z<12;z++) {
            zeroCount[z]=0;
            oneCount[z]=0;
        }

        for (String x: dataArray2) {
            if (x.charAt(0)=='0') zeroCount[0]++;
            else if (x.charAt(0)=='1') oneCount[0]++;
        }
        file = new Scanner(new File("C:\\Users\\aleks\\IdeaProjects\\AoC_day3\\src\\com\\daythree\\data.txt"));
        while (file.hasNext()) {
            sequence = file.nextLine();
            if (zeroCount[0]>oneCount[0]) {
                if (sequence.charAt(0)=='0') dataArray2.remove(sequence);
            } else if (zeroCount[0]<=oneCount[0]) {
                if (sequence.charAt(0)=='1') dataArray2.remove(sequence);
            }
        }

        for (int abc=1; abc<12; abc++) {
            for (String x : dataArray2) {
                if (x.charAt(abc) == '0') zeroCount[abc]++;
                else if (x.charAt(abc) == '1') oneCount[abc]++;
            }

            file = new Scanner(new File("C:\\Users\\aleks\\IdeaProjects\\AoC_day3\\src\\com\\daythree\\data.txt"));
            while (file.hasNext()) {
                sequence = file.nextLine();
                if (zeroCount[abc] > oneCount[abc]) {
                    if (sequence.charAt(abc) == '0') dataArray2.remove(sequence);
                } else if (zeroCount[abc] <= oneCount[abc]) {
                    if (sequence.charAt(abc) == '1') dataArray2.remove(sequence);
                }

                if (dataArray2.stream().count()==1) break;
            }

            System.out.println(dataArray2.stream().count());
        }

        System.out.println(dataArray1);
        System.out.println(dataArray2);
    }
}
