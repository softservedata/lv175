class Three{
    
  public static void main(String[] arg ){
    
boolean sw=false;
int n = 19; n = n*n; 
System.out.println(n);

       while(n>0){  
         if (n%10==3) {sw=true; break;}
         n=n/10;
       }
       
 if (sw==true) System.out.println("ͺ");
 else System.out.println("νε ͺ");
  }
}