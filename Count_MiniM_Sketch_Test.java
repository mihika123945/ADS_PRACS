import java.util.Scanner;

class Count_MiniM_Sketch
{
/*Declaration*/
    private int[] H_1;
    private int[] H_2;
    private int[] H_3;
    private int SizE;
    private static int DEFAULT_SIZE = 11;
 
/* here comes constructor */
    public Count_MiniM_Sketch()
    {
        SizE = DEFAULT_SIZE;
        H_1 = new int[ SizE ];
        H_2 = new int[ SizE ];
        H_3 = new int[ SizE ];
    }

/* This is the function to clear all our counters */
    public void clear()
    {
        SizE = DEFAULT_SIZE;
        H_1 = new int[ SizE ];
        H_2 = new int[ SizE ];
        H_3 = new int[ SizE ];
    }
/* This is the function to insert Values */
    public void insert(int ValuE)
    {
        int HasH_1 = HasH_FunctioN1(ValuE);
        int HasH_2 = HasH_FunctioN2(ValuE);
        int HasH_3 = HasH_FunctioN3(ValuE);
        /** increment counters **/
        H_1[ HasH_1 ]++;
        H_2[ HasH_2 ]++;
        H_3[ HasH_3 ]++;
    }
/* This id the function to get the sketch count */
    public int sketchCount(int ValuE)
    {
        int HasH_1 = HasH_FunctioN1(ValuE);
        int HasH_2 = HasH_FunctioN2(ValuE);
        int HasH_3 = HasH_FunctioN3(ValuE);
        return MiniM( H_1[ HasH_1 ], H_2[ HasH_2 ], H_3[ HasH_3 ] );
    }
    private int MiniM(int a, int b, int c)
    {
   
/*Hunting for the minimum*/
        int MiniM = a;
        if (b < MiniM)
            MiniM = b;
        if (c < MiniM)
            MiniM = c;
        return MiniM;
    }
                                                 /* HasH_function#1 */
    private int HasH_FunctioN1(int ValuE)
    {
        return ValuE % SizE;
    }
                                                  /* HasH_function#2 */
    private int HasH_FunctioN2(int ValuE)
    {
        return ((ValuE * (ValuE + 3)) % SizE);
    }
                                                  /* HasH_function#3 */
    private int HasH_FunctioN3(int ValuE)
    {
        return (SizE-1)-ValuE%SizE;
    }
                                                  /*Lets see all the tables */
    public void print()
    {
        System.out.println("\n The counter tables are as follows: \n");
        System.out.print("H_1 : ");
        for (int i=0;i<SizE;i++)
        {System.out.print(H_1[i] +" ");}
        System.out.print("\n H_2 : ");
        for (int i=0;i<SizE;i++)
        {System.out.print(H_2[i] +" ");}
        System.out.print("\n H_3 : ");
        for (int i=0;i<SizE;i++)
        {System.out.print(H_3[i] +" ");}
        System.out.println();
    }}
 
public class Count_MiniM_Sketch_Test                 /*Remember to save the file with this name*/
{
    public static void main(String[] args)            /*Main() function*/
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("implementing Count-Min Sketch in java\n\n");
        
/* Here comes the object of our class Count MiniM Sketch */
        Count_MiniM_Sketch cms_var = new Count_MiniM_Sketch();
 
        char ChaR;
/*  While true, perform the operations as follows */
        do    
        {    
            System.out.println("\n Operations:::\n");
            System.out.println("1. Would you like to Insert? ");11
            System.out.println("2. What is the sketch count?");
            System.out.println("3. Do you wish to clear the counter?");
 /*taking input the selected choice of operation from user*/
            int c = scan.nextInt();            
            switch(c)
            {
            case 1 : 
                System.out.println("Enter the integer Value:");
                cms_var.insert(scan.nextInt() ); 
                break; 
                         
            case 2 :                 
                System.out.println("Enter the integer Value");
                int ValuE = scan.nextInt();
                System.out.println("\n Sketch count for "+ ValuE +" = "+ cms_var.sketchCount( ValuE )); 
                break; 
                       
            case 3 : 
                cms_var.clear();
                System.out.println("Your counter is clear\n");
                break;
            default : 
                System.out.println("Oops! that's a wrong entry\n ");
                break;   
            }
/* Here comes the counter table */
            cms_var.print();  
 
            System.out.println("\n Would you like to continue? (Type y or n) \n");
            ChaR= scan.next().charAt(0);  
                      
        } while (ChaR== 'Y'|| ChaR== 'y');
    }
}