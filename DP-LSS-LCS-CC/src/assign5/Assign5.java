package assign5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Renan Santana
 */
public class Assign5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        int fileArgs = 0;
        
        try {
            System.out.println("File: " + args[fileArgs]);
            System.out.println("****** Largest Square Sub-Matrix ******");
            br = new BufferedReader(new FileReader(args[fileArgs]));
            LrgSubM lsm = new LrgSubM(br);
            lsm.largestSubMatrix();
            System.out.println("****** _________________________ ******\n");
            
            ++fileArgs;
            System.out.println("File: " + args[fileArgs]);
            System.out.println("****** Longest Increasing Subsequence ******");
            br = new BufferedReader(new FileReader(args[fileArgs]));
            LCS lcs = new LCS(br);
            lcs.lcs();
            System.out.println("****** ______________________________ ******\n");
            
            System.out.println("****** Optimal Coin Change ******");
            CoinChg cc = new CoinChg();
            cc.coinChange();
            System.out.println("****** ___________________ ******\n");
            
        } catch (FileNotFoundException e) {
            System.out.println("*** Missing file: " + args[fileArgs] + " ***");
        }

        
        
    }
    
}
