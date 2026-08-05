import java.util.Scanner; // user input leke run karna hai

public class subset_sum {

    public static boolean isSubsetSum(int arr[],int idx,int n, int sum){

        if(sum ==0) return true;
        if(n==0  ) return false;
        

        if(sum < arr[idx]) return isSubsetSum(arr,idx+1,n-1  ,sum); 

        return isSubsetSum(arr, idx+1,n-1, sum-arr[idx]) ||isSubsetSum(arr, idx+1, n-1, sum);
        

    }
    public static void main(String[] args){
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        
        int arr[] = {2,3,4};

        boolean hasSubsetSum = isSubsetSum(arr,0,3,5);
        System.out.println(hasSubsetSum);

    }
}
