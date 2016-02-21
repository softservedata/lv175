class FriendlyCouple{
 public static void main(String[] arg ){
    int k, i, j, s1, s2, d=0;
   int n =150; System.out.println(n);
   int m =2000; System.out.println(m);
    for  (i=n; i <m; i++)
    {       s1 = 0;
            for (k=1; k<i; k++)
                
            {
                if (i%k==0) s1=s1+k;
            }
            for(j=n; j<=m; j++)
            {
                s2 = 0;
                for(k=1; k<j; k++)
                {
                    if (j%k==0) s2=s2+k;
                }
                if ((s1==j)&&(s2==i)) {d=d+1; System.out.println(d+". i="+i+"; j="+j);} 
             }
     }
   System.out.println("Finish");
    }
}