//https://leetcode.com/problems/car-pooling/
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int stop[]=new int[1002];
		for(int i=0;i<trips.length;i++){
			stop[trips[i][1]+1]+=trips[i][0];
			stop[trips[i][2]+1]-=trips[i][0];
		}
		for(int i=1;i<1001;i++){
			stop[i]+=stop[i-1];
				if(stop[i]>capacity) return false;
		}
		return true;
    }
}
