// https://course.acciojob.com/idle?question=24900630-902b-4f83-a34c-27576ca35dd4
import java.util.*;
// import java.util.Scanner;

class Solution {
	    static void printSumTricky(int n, int mat[][], int k)
    {
        // Your code here
		// make a prefix sum array of given matrix
		for(int i=0;i<n;i++){
			for(int j=1;j<n;j++){
				mat[i][j]+=mat[i][j-1];
			}
		}
		for(int i=0;i<n;i++){
			for(int j=1;j<n;j++){
				mat[j][i]+=mat[j-1][i];
			}
		}
		for(int i=0;i<=n-k;i++){
			ArrayList<Integer>ans=new ArrayList<>();
			for(int j=0;j<=n-k;j++){
				int a=0,b=0;
				if(i>0){
					a=mat[i-1][j+k-1];
				}
				if(j>0) b=mat[i+k-1][j-1];
				int c=0;
				if(i>0 && j>0 )c=mat[i-1][j-1];
				int sum=mat[i+k-1][j+k-1]-a-b+c;
				ans.add(sum);
			}
			for(int x:ans){
				System.out.print(x+" ");
			}
			System.out.println();
		}
			
     }
}

public class Main{
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int k= sc.nextInt();
		Solution.printSumTricky(n, matrix, k);
	}
}

