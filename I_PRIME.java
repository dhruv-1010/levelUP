import java.util.*;
public class Main
{
	public static void main(String[] args) {
	       // base case == head > n/2 i return 1 else 0
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    double arr[] = new double[n];
	    for(int i = 0;i<n;i++) arr[i] = sc.nextDouble();
	    double[][] dp = new double[n+1][n+1];
	    for(double[]i : dp) Arrays.fill(dp,-1.0);
	    System.out.println(rec(arr,0,(n+1)/2,dp));
    }
    public static double rec(double[] arr,int i,int head,double[][] dp){
        if(head == 0) return 1.0;
        if(i >=arr.length) return 0.0;
        if(dp[i][head]!=-1.0) return dp[i][head];
        double ans = arr[i]*(rec(arr,i+1,head-1,dp)) + (1-arr[i])*(rec(arr,i+1,head,dp));
        return dp[i][head] = ans;
    }
}
