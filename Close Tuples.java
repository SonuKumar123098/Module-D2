//https://course.acciojob.com/idle?question=f89d7e7c-05c2-4633-a4f8-72e0aa3e0e21
import java.util.*;

class Solution{
public static void solve(int n, int[] arr) {
        // Your code here
	      Arrays.sort(arr);
	   int ans=0;
	int j=1;
	for(int i=0;i<n;i++){
		while(j<n && arr[j]-arr[i]<=2) j++;
		int k=j-i-1;
		if(k>=2){
			ans+=((k*(k-1)/2));
		}
	}
System.out.println(ans);
	
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution.solve(n, arr);
    }
}
