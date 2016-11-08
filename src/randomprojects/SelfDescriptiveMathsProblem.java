/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomprojects;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Gamer
 */
public class SelfDescriptiveMathsProblem {
    private int[] numbers = new int[10];
    private int roundCounter = 0;
    private int runCounter = 0;
    private int sixTwoOneCounter = 0;
    
    private void reset() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 0;
        }
    }
    
    private void randomise() {
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10);
            if (numbers[i] > 9) {
                System.out.println("NUMBER IS " + numbers[i]);
                numbers[i] = 9;
            }
        }
    }
    
    public void run() {
        reset();
        //main();
        brute();
    }
    
    private void brute() {
        int[] bruteNums = new int[10];
        int a = 0;
        long c = 1;
        int d = 100;
        for (bruteNums[0] = 0; bruteNums[0] < 10; bruteNums[0]++) {
            for (bruteNums[1] = 0; bruteNums[1] < 10; bruteNums[1]++) {
                for (bruteNums[2] = 0; bruteNums[2] < 10; bruteNums[2]++) {
                    for (bruteNums[3] = 0; bruteNums[3] < 10; bruteNums[3]++) {
                        for (bruteNums[4] = 0; bruteNums[4] < 10; bruteNums[4]++) {
                            for (bruteNums[5] = 0; bruteNums[5] < 10; bruteNums[5]++) {
                                for (bruteNums[6] = 0; bruteNums[6] < 10; bruteNums[6]++) {
                                    for (bruteNums[7] = 0; bruteNums[7] < 10; bruteNums[7]++) {
                                        for (bruteNums[8] = 0; bruteNums[8] < 10; bruteNums[8]++) {
                                            for (bruteNums[9] = 0; bruteNums[9] < 10; bruteNums[9]++) {
                                                if (checkAnswer(bruteNums)) {
                                                    System.out.println("Answer: " + printNums(bruteNums));
                                                    a++;
                                                }
                                                if (checkSixTwoOne(bruteNums)) {
                                                    //System.out.println("BOOOM!!!!");
                                                }
                                                if (c % 100000000 == 0) {
                                                    //System.out.println("Round #" + --d);
                                                }
                                                c++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("There are " + a + (a == 1 ? " answer" : " answers"));
    }
    
    private void main() {
        randomise();
        System.out.println("New: " + printNums(numbers));
        while (!checkAnswer(numbers) && roundCounter <= 1000) {
            //if (runCounter % 10 == 0) {
            //    System.out.println(roundCounter + ": " + printNums());
            //}
            adjustNums();
            roundCounter++;
        }
        if (checkSixTwoOne(numbers)) {
            sixTwoOneCounter++;
        } else {
            System.out.println(roundCounter + ": " + printNums(numbers));
        }
        if (roundCounter <= 1000) {
            runCounter++;
            run();
        }
        runCounter--;
        if (runCounter < 1) {
            System.out.println(sixTwoOneCounter + " x 6 2 1 0 0 0 1 0 0 0");
        }
    }
    
    private void adjustNums() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = countNums(numbers, i);
        }
    }
    
    private boolean checkSixTwoOne(int[] nums) {
        int[] sixTwoOne = {6, 2, 1, 0, 0, 0, 1, 0, 0, 0};
        if (Arrays.equals(nums, sixTwoOne)) {
            return true;
        }
        //System.out.println("The numbers " + printNums(nums) + "doesn't equal 6 2 1");
        return false;
    }
    
    private boolean checkAnswer(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != countNums(nums, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkAnswerBug(int[] nums) {
        System.out.println("Nums: " + printNums(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != countNums(nums, i)) {
                System.out.println(nums[i] + " != " + countNums(nums, i));
                return false;
            }
        }
        return true;
    }
    
    private int countNums(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    
    private String printNums(int[] nums) {
        String numString = "";
        for (int num : nums) {
            numString += num + " ";
        }
        return numString;
    }
}
