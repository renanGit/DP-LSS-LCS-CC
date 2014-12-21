
package assign5;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * @author Renan Santana
 */
public class LrgSubM {
    private BufferedReader br;
    LrgSubM(BufferedReader br){
        this.br = br;
    }
    
    class Value{
        private boolean v;
        private int c;
        Value(boolean v){ this.v = v; c = 0; }
        public boolean getV(){ return v; }
        public void setC(int c){ this.c = c; }
        public int getC(){ return c; }
    }
    
    public void largestSubMatrix(){
        String line;
        int size;
        int n1 ,n2 ,n3 , max = 0, max_j = 0, max_i = 0;
        ArrayList<Value> r, prev_r;
        ArrayList<ArrayList<Value>> table = new ArrayList();
        
        try{
            line = br.readLine();
            size = line.length();
            
            // Reading the File
            do{
                r = new ArrayList(size);
                // loop the cols
                for (int i = 0; i < size; i++) {
                    r.add(new Value(line.charAt(i) == '1'));
                    // getV is boolean if 1 or 0
                    // if true set the count to 1
                    if(r.get(i).getV()){ r.get(i).setC(1); }
                }
                table.add(r);
            }while( (line = br.readLine()) != null );
        }catch(Exception e){ System.out.println("Input error."); return; }
        
        // right now the table is full of 1's if the value is 1
        // get the first row
        r = table.get(0);
        for (int i = 1; i < table.size(); i++) {
            // we hold on to the prev row and the current row
            prev_r = r;
            r = table.get(i);
            for (int j = 1; j < size; j++) {
                // if the table is 1  1 we enter here
                //                 1 (1)
                if(prev_r.get(j-1).getV() && prev_r.get(j).getV() &&
                        r.get(j-1).getV() && r.get(j).getV()){
                    // get the top left , top , left count 
                    // we need to compare to get the min of these
                    n1 = prev_r.get(j-1).getC();
                    n2 = prev_r.get(j).getC();
                    n3 = r.get(j-1).getC();

                    if(n1 <= n2 && n1 <= n3){ r.get(j).setC(n1 + 1); }
                    else if(n2 <= n1 && n2 <= n3){ r.get(j).setC(n2 + 1); }
                    else{ r.get(j).setC(n3 + 1); }
                    
                    // keep track of the max
                    if(r.get(j).getC() > max){
                        max = r.get(j).getC();
                        max_j = j;
                        max_i = i;
                    }
                }
            }
        }
        System.out.println("Starting index: (" + (max_i+1-max) + ", " + (max_j+1-max)+")");
        System.out.println("Ending index: (" + (max_i+1) + ", " + (max_j+1)+")");
        System.out.println("Size of sub-square: " + max + "x" + max);
    }
}
