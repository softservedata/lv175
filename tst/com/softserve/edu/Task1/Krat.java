class Krat{
   public static void main(String[] arg ){
    
             int n =320; System.out.println(n);
             int m =32; System.out.println(m);
      
             for (int s=1;s<(m*n);s++){
                    if(((n%s)==0)&&((m%s)==0))  System.out.println("Kratni="+ s);
       }
   }
}