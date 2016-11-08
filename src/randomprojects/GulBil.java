/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomprojects;

/**
 *
 * @author Gamer
 */
public class GulBil {
    
    private int verified;
    // Find out how many car licence plates has a double number, e.g. 66 or 1212
    public void run() {
        verified = 0;
        for (int i = 10000; i < 100000; i++) {
            if (checkLicence(i)) verified++;
        }
        System.out.println("Of 90000 licence plates, " + verified + " are ''yellow''");
        float tmp = (float)verified / 90000 * 100;
        System.out.println("That means " + tmp + "% of all cars are 'yellow'");
    }
    
    private boolean checkLicence(int licence) {
        String licStr = Integer.toString(licence);
        String[] licLet = licStr.split("");
        //System.out.println("licStr: " + licStr + " - licLet: " + licLet[0] + ", " + licLet[1] + ", " + licLet[2] + ", " + licLet[3] + ", " + licLet[4]);
        int[] licNum = {Integer.parseInt(licLet[1]), Integer.parseInt(licLet[2]), Integer.parseInt(licLet[3]), Integer.parseInt(licLet[4]), Integer.parseInt(licLet[5])};
        //System.out.println("licNum[4]: " + licNum[4]);
        int[] licNumDouble = {(licNum[0]*10)+licNum[1], (licNum[2]*10)+licNum[3], (licNum[1]*10)+licNum[2], (licNum[3]*10)+licNum[4]};
        
        if (licNum[0] == licNum[1]) {
            return true;
        } else if (licNum[1] == licNum[2]) {
            return true;
        } else if (licNum[2] == licNum[3]) {
            return true;
        } else if (licNum[3] == licNum[4]) {
            return true;
        } else if (licNumDouble[0] == licNumDouble[1]) {
            return true;
        } else if (licNumDouble[2] == licNumDouble[3]) {
            return true;
        }
        
        return false;
    }
}
