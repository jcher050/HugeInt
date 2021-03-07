
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author cheryjeff
 */
public class HugeInt implements Cloneable
{
    private LinkedList<Byte> digits; 
    
    
         public HugeInt ( )
         {
            digits = new LinkedList<> ();
            
         }
    
    
         public void setValue (int value) 
         {
         
        /* gets an integer (like 1234) as input parameter and stores its digits 
           in the linked list in the same order as they appear in the input 
           integer; e.g. for input equal to 1234, digit 1 is placed at the 
           beginning of the list; while digit 4 is the placed at the end.  */
            
           String numb = String.valueOf(value);
           int inInt = 0;
           
               for (int i=0; i< numb.length(); i++)
                   {
                     inInt = Integer.parseInt(String.valueOf(numb.charAt(i)));
                     digits.add( (byte) inInt);
                     //System.out.println("Integer Value : " + digits.getLast());
                   }
                  
          }
        
        public void setValue (long value) 
        {
            
         /* Same as previous method; except the input type is long integer. */
            
            String numb = String.valueOf(value);
            int inInt = 0;
           
               for (int i=0; i< numb.length(); i++)
                   {
                     inInt = Integer.parseInt(String.valueOf(numb.charAt(i)));
                     digits.add( (byte) inInt);
                     //System.out.println( "Long Value : "  + digits.getLast());
                   }
                  
         
        }
        
        public int getValue () 
        {
            
            /* returns −1 if the number stored in the linked list is too large 
            to be fit in a Java int variable and returns the integer value of 
            the stored number otherwise.  */
            
              ListIterator<Byte> process = digits.listIterator();

              if(digits.size()>10)

                    { return -1; }

              else 
              {
                  String tempint = ""; 
                  int temp;
                  
                  for (int i = 0; i<digits.size(); i++)
                  {
                      tempint += String.valueOf(digits.get(i));
                  }
                 
                  return Integer.parseInt(tempint);
              }
                     

        }

        public HugeInt clone () 
        { 
            /* creates a copy of the integer stored in the linked list and 
               returns the result as another HugeInt */
        
            return this.clone();
            
        }
        public long log () 
        {
          /* counts and returns the number of digits 
            stored in the linked list.  */ 
            
            return digits.size();
            
        }
        
        public HugeInt modExp (long n)
        { 
            /* calculates the remainder of the stored integer when
               dividing it by 10n and returns the result in the form 
              of another HugeInt */
              
            

            if(n >= digits.size())

               {
                   return this;
               }

       LinkedList<Byte> templist;
       templist =(LinkedList<Byte>)digits.subList((int)(digits.size()-(n-1)), digits.size());


                

                HugeInt anotherHugeInt = new HugeInt();

                anotherHugeInt.digits = templist;
              
                return anotherHugeInt;

            
        }


public HugeInt quotientExp (long n) 
        {
            /* calculates the quotient of the integer stored in the linked list 
               when dividing it by 10n and returns the result in the form of 
            another HugeInt. */  

          if(n>=digits.size())

             {
                 return new HugeInt();
             }

         LinkedList<Byte> templist;
         templist =(LinkedList<Byte>)digits.subList(0, (int)(digits.size()-n));


                        HugeInt anotherHugeInt=new HugeInt();
                        anotherHugeInt.digits = templist;
                        //anotherHugeInt.setValue(result);

                        return anotherHugeInt;
            
        }

public HugeInt timesExp (long n)
        {  /* calculate the product of 10n and the integer stored in the linked 
               lists and returns the result in the form of another HugeInt */
        
           LinkedList<Byte> templist;
           templist =(LinkedList<Byte>)digits.subList(0, digits.size());

          
          for (int i = 0; i<n; i++)
          {
              templist.addLast((byte)0);
          }
          
           HugeInt temphuge = new HugeInt();
           temphuge.digits = templist;
         
           return temphuge;

        
        }


public HugeInt add (HugeInt h)
        { 
            /* adds h with the integer stored in the linked list and returns 
            the result as another HugeInt. */
            
            long bothValue = this.getValue() + h.getValue();

            HugeInt anotherhugeInt = new HugeInt(  );

            anotherhugeInt.setValue(bothValue);

            return anotherhugeInt;
            
        }

public void addSet (HugeInt h) 
       { 
           /* adds h with the integer stored in the linked list and writes the 
           result back on the linked list. */
           
           long bothValue = this.getValue() + h.getValue();

           this.setValue(bothValue);
           
           
        }


    public int recursiveModNine()
        { 
            /* returns the remainder of the integer stored in the linked list 
               when dividing it by 9. The easiest way to find the remainder of 
               an integer like 235 when dividing it by nine is to calculate 
               the remainder of 2+3+5 instead. Use this idea to implement 
               recursiveModNine method in a recursive manner. 
               Method recur- siveModNine must be able to calculate the 
               remainder of a huge integer like 1011111 − 1 when 
               dividing it by 9. For example, recursiveModNine (1011111 − 1) 
               first sums the digits of the input integer and then calls itself 
               for the calculated sum. It does the same operations recursively   
               until it reaches a one-digit integer. See below for details:
          
               recursiveModeNine (1011111 − 1) =recursiveModeNine (99 . . . 9) 
                                                                   11111 times 
                                               =recursiveModeNine (99999)
                                               =recursiveModeNine (45) 
                                               =recursiveModeNine (9) 
                                               =0;
            */
            
            
            if (digits.size()>1)
            { 
              LinkedList<Byte> templist;
              templist =(LinkedList<Byte>)digits;
            
              ListIterator<Byte> listIterator = templist.listIterator();
            
            int sum = 0;
           
            while (listIterator.hasNext()) 
            {
                sum += templist.getLast();
                templist.removeLast();
                
            }
            HugeInt temphuge = new HugeInt();
            temphuge.setValue(sum);
            return temphuge.recursiveModThree();
            
            

           }
            else 
            {
                int z = digits.getFirst();
                return (z%9);
            }
            
            
        }

public int recursiveModThree ()
        { 
            /* returns the remainder of the integer stored in the linked list 
            when dividing it by 3. To implement this method, use the same idea 
            mentioned for the previous method. */
            
            if (digits.size()>1)
            { 
              LinkedList<Byte> templist;
              templist =(LinkedList<Byte>)digits;
            
              ListIterator<Byte> listIterator = templist.listIterator();
            
            int sum = 0;
           
            while (listIterator.hasNext()) 
            {
                sum += templist.getLast();
                templist.removeLast();
                
            }
            HugeInt temphuge = new HugeInt();
            temphuge.setValue(sum);
            return temphuge.recursiveModThree();
            
           }
            else 
            {
                int z = digits.getFirst();
                return (z%3);
            }
            
          
            
        }
        


}

        