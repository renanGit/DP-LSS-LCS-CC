
package assign5;

import java.util.ArrayList;

/**
 * @author Renan Santana
 */
public class CoinChg {
    
    public void coinChange(){
        int changeFor, change = 2, tmpChange, prevChange;
        int currency[] = {1,5,10,18,25};
        ArrayList<ArrayList<Integer>> optimalSet = new ArrayList<>();
        ArrayList<Integer> opt;
        
        opt = new ArrayList();  opt.add(0);
        optimalSet.add(opt);    
        
        opt = new ArrayList();  opt.add(1);
        optimalSet.add(opt);
        
        changeFor = 100;    // we will make change for 100 cents

        // Build the table
        while(changeFor >= change){
            for (int i = 0; i < currency.length; i++) {
                // testing if coin piece can give a positive result
                if(change - currency[i] >= 0){

                    // if nothing is in the position
                    // just get the amount of coins of prev + 1
                    // ignore position zero
                    if(optimalSet.size()-1 < change){
                        opt = new ArrayList(optimalSet.get(change - 1));
                        opt.add(currency[i]);
                        optimalSet.add(opt);
                    }
                    else{
                        // prevChange is itself
                        // tmpChange is a suggested change if it is smaller
                        prevChange = opt.size();
                        
                        // this subtle check is if we get a zero return
                        // tmpChange needs to be zero and not the size 
                        // b/c the size in get(0) is 1 when its supposed to be 0
                        if(optimalSet.get(change - currency[i]).get(0) == 0){
                            tmpChange = 0;
                        }
                        else{
                            tmpChange = optimalSet.get(change - currency[i]).size();
                        }
                        
                        // we can improve the optimalSet
                        // we don't want to change the optimalSet if tmpChange +1
                        // is equal to prevChange (this only means a differ order in coins)
                        if(tmpChange < prevChange && tmpChange + 1 != prevChange){
                            if(tmpChange == 0){
                                opt = new ArrayList();
                            }
                            else{
                                opt = new ArrayList(optimalSet.get(change - currency[i]));
                            }
                            opt.add(currency[i]);
                            optimalSet.remove(optimalSet.size()-1);
                            optimalSet.add(opt);
                        }
                    }
                }
                else{ break; }  // we can't get a positive value
            }
            change++;
        }
        
        for (int n = 1; n <= 100; n++) {
            System.out.println("Ammount of change for " + n + " cents: "
                                + optimalSet.get(n).size());
            System.out.print("Change in return: ");
            for (int i = 0; i < optimalSet.get(n).size(); i++) {
                if(i+1 < optimalSet.get(n).size()){
                    System.out.print(optimalSet.get(n).get(i) + ", ");
                }
                else{
                    System.out.print(optimalSet.get(n).get(i) + "\n\n");
                }
            }
        }
    }
}