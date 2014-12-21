
package assign5;

import java.io.BufferedReader;

/**
 *
 * @author Renan Santana
 */
public class LCS {
    private String str1, str2;
    private BufferedReader br;
    LCS(BufferedReader br){
        this.br = br;
    }
    
    
    public void lcs(){
        int m, n;
        
        try {
            str1 = br.readLine();
            str2 = br.readLine();
            m = str1.length();
            n = str2.length();
        } catch (Exception e) {
            System.out.println("LCS: Possible missing string.");
            return;
        }
        int table[][] = new int[m+1][n+1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // ignore the first row and col
                // else if() the chars are the same
                // else not the same 
                if(i == 0 || j == 0){ table[i][j] = 0; }
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    // diagonal + 1
                    table[i][j] = table[i-1][j-1] + 1;
                }
                else{
                    // max of either the top or the left
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                }
            }
        }
        
        int i = m, j = n;
        String seq = "";
        // this works backwards to the top right corner
        while(i > 0 && j > 0){
            // if current position both chars are equal go diagonal
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                seq = str1.charAt(i-1) + seq;
                i--; j--;
            }
            while(true){
                // if() go up until the count doesn't match
                // else if() go left until the count doesn't match
                // else the current has to be a match break
                if(j > 0 && table[i][j] == table[i][j - 1]){ j--; }
                else if(i > 0 && table[i][j] == table[i - 1][j]){ i--; }
                else{ break; }
            }
        }
        System.out.println("Sequence: " + seq + "\nLength of Sequence String: " 
                + seq.length() + "\nLongest Sequence in Table: " + table[m][n]);
    }
}
