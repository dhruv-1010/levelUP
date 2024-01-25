public class Main
{
	public static void main(String[] args) {
        // [2,3,5]
        // 0 - 1000
        // 
        // now the size can be >=15
        int[] prime = {0.3,0.6,0.8};
        int n = 1000;
        System.out.println(Count(prime,n));
	}
	public static int Count(int[] prime,int n){
	    int lim = 1<<prime.length;
	    int ans = 0;
	    for(int i = 0;i<lim;i++){
	       // if bitcount is odd we add to ans 
	       // if bitcount is even we subtract from ans
	       if((fastcount(i)& 1)!=0){
	           ans+=Intersection(prime,n,i);
	       }
	    }
	    return ans;
	}
	public static int Intersection(int[] prime,int n,int level){
	   // the Intersection 
	   int p =1;
	   int pos = 0;
	   while(level > 0){
	       if((level&1)!=0){
	           p*=prime[pos];
	       }
	       pos++;
	       level=level>>1;
	   }
	   return n/p;
	}
	public static int fastcount(int n){
	    int count = 0;
	    while(n>0){
	        n = (n & (n-1));
	        count++;
	    }
	    return count;
	}
}
