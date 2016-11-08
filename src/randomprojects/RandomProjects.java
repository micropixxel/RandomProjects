/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomprojects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import javax.swing.JFrame;

/**
 *
 * @author Gamer
 */
public class RandomProjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RandomProjects rp = new RandomProjects();
        //rp.rachelRileyMathProblemSolver();
        //rp.buckyIntermediateTut();
        //BuckyApplet ba = new BuckyApplet();
        //ReadFile rf = new ReadFile();
        //rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //SelfDescriptiveMathsProblem sdmp = new SelfDescriptiveMathsProblem();
        //sdmp.run();
        GulBil gb = new GulBil();
        gb.run();
    }
    
    private void rachelRileyMathProblemSolver() {
        // Choose 4 numbers between 1-9; w,x,y,z; and put them in 4 boxes; upper left, upper right, lower left and lower right
        // Then sum the 4 axis; upper, lower, left, right. How many different will sum 100?
        // Ex: 5,2,1,9 = 52+19+51+29 = 151
        ArrayList<int[]> solutions = new ArrayList<>();
        for (int upperLeft = 1; upperLeft <= 9; upperLeft++) {
            for (int upperRight = 1; upperRight <= 9; upperRight++) {
                for (int lowerLeft = 1; lowerLeft <= 9; lowerLeft++) {
                    for (int lowerRight = 1; lowerRight <= 9; lowerRight++) {
                        int upper = upperLeft*10 + upperRight;
                        int lower = lowerLeft*10 + lowerRight;
                        int left = upperLeft*10 + lowerLeft;
                        int right = upperRight*10 + lowerRight;
                        int sum = upper + lower + left + right;
                        if (sum == 100) {
                            int[] solution = {upperLeft, upperRight, lowerLeft, lowerRight};
                            solutions.add(solution);
                        }
                    }
                }
            }
        }
        System.out.println("Solutions: " + solutions.size());
        int i = 1;
        for (int[] solution : solutions) {
            int upperLeft = solution[0];
            int upperRight = solution[1];
            int lowerLeft = solution[2];
            int lowerRight = solution[3];
            int upper = upperLeft*10 + upperRight;
            int lower = lowerLeft*10 + lowerRight;
            int left = upperLeft*10 + lowerLeft;
            int right = upperRight*10 + lowerRight;
            String line1 = "Solution #" + i;
            String line2 = "---------";
            String line4 = "| " + upperLeft + " | " + upperRight + " |";
            String line5 = "| " + lowerLeft + " | " + lowerRight + " |";
            System.out.println(line1);
            System.out.println(line2);
            System.out.println(line4 + " " + upper + "+" + lower + "=" + (upper+lower));
            System.out.println(line2);
            System.out.println(line5 + " " + left + "+" + right + "=" + (left+right));
            System.out.println(line2);
            System.out.println("");
            i++;
        }
    }
    
    private void buckyIntermediateTut() {
        System.out.println("Play with words:");
        String[] words = {"funky", "chunky", "furry", "baconator"};
        
        for (String w : words) {
            // startsWith
            if (w.startsWith("fu")) {
                System.out.println("F U! ... Also " + w);
            }
            
            // endsWith
            if (w.endsWith("unky")) {
                System.out.println("Now " + w);
            }
            
            if (w.contains("bacon")) {
                System.out.println("Mmm...bacon! " + w.replace("bacon", "BACON"));
            }
        }
        
        String s = "buckyrobertsbuckyroberts";
        
        System.out.println("Index of k: " + s.indexOf("rob", 7));
        
        String a = "Cookie ";
        String b = "Monster";
        System.out.println("" + a.concat(b));
        System.out.println("" + b.toUpperCase());
        System.out.println("" + a.trim() + b);
        
        System.out.println("\nPlay with recursion:");
        long f = 13;
        System.out.println("Factoral of " + f + " = " + fact(f));
        
        System.out.println("\nPlay with collections:");
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String[] samewords = {"chunky", "furry"};
        
        for (String x : words) {
            list1.add(x);
        }
        list2.addAll(Arrays.asList(samewords));
        
        for (int i = 0; i < list1.size(); i++) {
            System.out.printf("%s ", list1.get(i));
        }
        System.out.println("");
        
        // Disjoint checks to see whether 2 lists are completely different from eachother
        if(!Collections.disjoint(list2, list1)) {
            System.out.println("Lists contain some of the same elements!");
        }
        
        // Stack, push & pop
        System.out.println("\tStacks");
        Stack<String> stack = new Stack<>();
        stack.push("First");
        printStack(stack);
        stack.push("Second");
        printStack(stack);
        stack.push("Third");
        printStack(stack);
        
        stack.pop();
        printStack(stack);
        stack.pop();
        printStack(stack);
        stack.pop();
        printStack(stack);
        
        // Queue
        System.out.println("\tQueues");
        PriorityQueue<String> q = new PriorityQueue<>();
        q.offer("First");
        q.offer("Second");
        q.offer("Third");
        System.out.printf("%s ", q);
        System.out.println("");
        
        System.out.printf("%s \n", q.peek());
        q.poll();
        System.out.printf("%s \n", q);
        
        // HashSet (Sets are collections that doesn't allow duplicates)
        System.out.println("\tSets");
        String[] things = {"apple", "bob", "ham", "bob", "bacon"};
        List<String> list = Arrays.asList(things);
        System.out.printf("%s \n", list);
        
        Set<String> set = new HashSet<>(list);
        System.out.printf("%s \n", set);
        
        //Generic methods
        System.out.println("\nPlay with generic methods:");
        Integer[] iray = {1, 2, 3, 4, 5, 6};
        Character[] cray = {'M', 'a', 'g', 'n', 'u', 's'};
        
        printMe(iray);
        printMe(cray);
        
        System.out.println("" + max(23, 42, 1));
        System.out.println("" + max("Google", "Apple", "Yahoo"));
    }
    
    private <T extends Comparable<T>> T max(T a, T b, T c) {
        T m = a;
        if (b.compareTo(m) > 0) {
            m = b;
        }
        if (c.compareTo(m) > 0) {
            m = c;
        }
        return m;
    } 
    
    private <T> void printMe(T[] x) {
        for (T b : x) {
            System.out.printf("%s ", b);
        }
        System.out.println("");
    }
    
    private void printStack(Stack<String> s) {
        if(s.isEmpty()) {
            System.out.println("Empty, LIKE YOUR HEAD! HAHA!");
        } else {
            System.out.printf("%s TOP\n", s);
        }
    }
    
    private long fact(long n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n-1);
        }
    }
}
