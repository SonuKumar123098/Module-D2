//https://course.acciojob.com/idle?question=57531c66-6db6-46df-a636-7b5c1a24662d
import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(boolean[] boxes, int ci, int ti, int lb){
    // write your code here
	  if(ci>ti){
		  for(int i=0;i<boxes.length;i++){
			  if(boxes[i]) System.out.print("i");
			  else System.out.print("-");
		  }
		  System.out.println();
		  return;
	  }
	  for(int id=lb+1;id<boxes.length;id++){
		  boxes[id]=true;
		  combinations(boxes,ci+1,ti,id);
		  boxes[id]=false;
	  }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int R = Integer.parseInt(br.readLine());
    combinations(new boolean[N], 1, R, -1);
  }

}

//ci - current index of item
//ti - total index of items
//lb - last box index
