/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitlab;

/**
 *
 * @author Владислав
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GitLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //hello world
        ArrayList <String> myList = new ArrayList<>(); 
        myList.add("My name");
        myList.add("is");
        myList.add("Wlodzizlaw.");
        myList.add("I'm");
        myList.add("20 years");
        myList.add("old.");
        System.out.println("myList is: ");
        for (Object m: myList) {
            System.out.println(m);
        }
        System.out.println("----Adding string 'hello world'");
        addString(myList, "hello world");
        printList(myList);
        System.out.println("----Deleting string 'hello world'");
        deleteString(myList, "hello world");
        printList(myList);
        System.out.println("----Adding similar string 'old.' and counting similarities");
        myList.add("old.");
        System.out.println("Counter = " + count(myList));
        System.out.println("----Reversing string:");
        reverseStrings(myList);
        System.out.println("----Character stats:");
        chStatistics(myList);
        System.out.println("----Searching string:");
        searchStr(myList, "I'm");
        System.out.println("----Initializing by a file:");
        initByFile("D:\\Учёба\\5 семестр\\ПИСм\\Лабы\\lab7\\gitLab\\src\\gitlab\\texty.txt");
        System.out.println("----Sorting by string length:");
        countLengthes(myList);
        printList(myList);
        System.out.println("----Comparing inner unequal objects:");
        compareInnerObjects(myList, 1, 2);
        System.out.println("----Comparing inner equal objects:");
        compareInnerObjects(myList, 5, 6);
        System.out.println("----Static add 1:");
        staticAdd(myList, "hello world");
        System.out.println("----Static add 2:");
        staticAdd(myList, "hello pism");
        System.out.println("----Static add 3:");
        staticAdd(myList, "hello git");
        System.out.println("----XML Writing:");
        xmlWriter(myList);
    }
    
    public static void addString(ArrayList <String> lst, String toAdd) { // adding
        lst.add(toAdd);
    }
    
    public static void deleteString(Collection col,String del){
        col.remove(del);
    }
    
    public static void xmlWriter(ArrayList <String> lst) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Учёба\\5 семестр\\ПИСм\\Лабы\\lab7\\gitLab\\src\\gitlab\\my.xml"));
            bw.write("<?xml version=\"1.0\"?>\n");
            bw.write("<strings>\n");
            for (Object o: lst) {
                bw.write("<string>" + o.toString() + "</string>\n");
            }
            bw.write("</strings>\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int count(ArrayList <String> lst) { // count similar elements
        int counter = 0;
        for (int i = 0; i < lst.size(); i++) {
            for (int j = i + 1; j < lst.size(); j++) {
                if (lst.get(i).equals(lst.get(j))) {
                    counter++;
                }
            }
        }
        return counter;
    }
    
    public static void reverseStrings(ArrayList <String> lst) { // reversing strings in a collection
        for (int i = 0; i < lst.size(); i++) {
            StringBuilder sb = new StringBuilder(lst.get(i));
            System.out.println(sb.reverse());
        }
    }
    
    public static void chStatistics(ArrayList <String> lst) { // prints character statistics
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < lst.size(); i++) {
            String str = lst.get(i);
            
            for (int j = 0; j < str.length(); j++) {
                Integer n = map.get(str.charAt(j));
                if (n == null) {
                    map.put(str.charAt(j), 1);
                } else {
                    map.put(str.charAt(j), ++n);
                }
            }
           
        }
        System.out.println(map);
    }
    
    public static void searchStr(ArrayList <String> lst, String str) { // searches substring
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).contains(str)) {
                System.out.println("Substring is found");
            }
        }
    }
    
    public static void initByFile(String filename) { // initializing by a file
        ArrayList <String> lst = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = br.readLine()) != null) {
                lst.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        printList(lst);
    }
    
    public static void compareInnerObjects(ArrayList <String> lst, int firstIndex, int secondIndex) {
        if (lst.get(firstIndex).equals(lst.get(secondIndex))) {
            System.out.println("Objects are equal");
        } else {
            System.out.println("Objects are not equal");
        }
    }
    
    public static void countLengthes(ArrayList <String> lst) { // count string lengthes
        String[] str = lst.toArray(new String[lst.size()]);
        for (int i = 0; i < str.length; i++) {
            String min = str[i];
            int min_i = i;
            for (int j = i + 1; j < lst.size(); j++) {
            if (lst.get(j).length() < min.length()) {
                min = str[j];
                min_i = j;
            }
            }
            if (i != min_i) {
                String tmp = str[i];
                str[i] = str[min_i];
                str[min_i] = tmp;
            }
        }
        for (int i = 0; i < str.length; i++){
            System.out.println(str[i]);
        }
    }
    
    public static void staticAdd(ArrayList <String> lst, String toAdd) {
        lst.add(toAdd);
        if (lst.size() > 7) {
            lst.remove(0);  
        }
        printList(lst);
    }
    
    public static void printList(ArrayList <String> lst) {
        System.out.println("Now list is:");
        for (Object o: lst) {
            System.out.println(o);
        }
    }
}

