import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_K_Closest_Day2 {

	public static void main(String[] args) {
		
		Find_K_Closest_Day2 test = new Find_K_Closest_Day2();
		int[] arr = {1,2,3,4,5};
		int k = 4, x = 3;
		
		System.out.println(test.findClosestElements(arr,k,x));

	}
	
	public List<Integer> getArray(int[] arr,int start,int end){
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i=start;i<=end;i++)
			res.add(arr[i]);
		
		return res;
	}
	
	
	 public List<Integer> findClosestElements(int[] arr, int k, int x) {
		 
		 if(x<=arr[0])
			 return getArray(arr, 0, k-1);
		 
		 if(x>=arr[arr.length-1])
			 return getArray(arr,arr.length-k , arr.length-1);
		 
		 int idx = Arrays.binarySearch(arr, x);
		 
		 if(idx<0)
			 idx=-idx-1;
		 
		 int left = Math.max(0, idx-k);
		 int right = Math.min(idx+k,arr.length-1);
		 
		 while(right-left+1>k) {
			 int absL = Math.abs(arr[left]-x);
			 int absR = Math.abs(arr[right]-x);
			 
			 if(absL>absR) {
				 left++;
			 }else {
				 right--;
			 }
		 }
		 
		 return getArray(arr, left, right);
	 }

}
