public class total_path_count {  //source(i,j) < = destination(m,n)


    public static Integer totalPath(int i, int j, int m, int n){

        if(i==m &&j==n) return 1;
        if(i>m || j>n) return 0;

        return totalPath( i, j+1, m, n) + totalPath( i+1, j, m, n);
    }
    public static void main(String[] args){

        int count = totalPath( 0,3, 3,3);
        System.out.println(count);
    }
}
