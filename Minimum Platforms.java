//https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
class schedule{
    int arrival;
    int departure;
    schedule(int a, int b){
        this.arrival=a;
        this.departure=b;
    }
}
class sortByArrival implements Comparator<schedule>{
    public int compare(schedule a,schedule b){
        return a.arrival-b.arrival;
    }
}
class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        schedule[]schedules=new schedule[n];
        for(int i=0;i<n;i++){
            schedules[i]=new schedule(arr[i],dep[i]);
        }
        Arrays.sort(schedules,new sortByArrival());
        PriorityQueue<Integer>q=new PriorityQueue<>();
        q.add(schedules[0].departure);
        int cnt=1;
        for(int i=1;i<n;i++){
            if(q.peek()>=schedules[i].arrival){
                cnt++;
            }else q.remove();
            q.add(schedules[i].departure);
        }
        return cnt;
    }
}
