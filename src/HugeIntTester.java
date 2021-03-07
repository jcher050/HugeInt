
import java.util.Scanner;
/**
 *
 * @author cheryjeff
 */
public class HugeIntTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //calling and initializing the sc method
        //initializing integer to 0
        Scanner sc = new Scanner(System.in);
        int inInt = 0;
         
        // calling and initializing bigint 
        HugeInt bigint = new HugeInt();
        
        
//        System.out.println("Please enter a number ");
//        inInt = sc.nextInt();
//        bigint.setValue(inInt);
        
        System.out.println("Please enter a number ");
        long inlong = sc.nextLong();
        bigint.setValue(inlong);
       
        
        //System.out.println( bigint.getValue() );
        
        
        
       System.out.println("mod 9 = " + bigint.recursiveModNine() );
       // System.out.println(" mod 3 = " + bigint.recursiveModThree());
        

   


        
        
        
        
        
    }
    
}
