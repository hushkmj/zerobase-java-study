import java.util.Arrays;

public class Permutation {
    // 1,2,3,4 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 X)의 각 결과를 출력하시오.
    void permutation(
            int[] arr
            , int depth
            , int n
            , int r
            , boolean[] visited
            , int[] out
    ){
        if (depth == r){
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i=0; i<n; i++){
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth +1, n, r, visited, out);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
    //     Test code
        int n = 4;
        int r =3;
        int [] arr = {1,2,3,4};
        boolean[] visited = new boolean[n];
        int[] out = new int[r];

        Permutation p = new Permutation();
        p.permutation(arr, 0, n, r, visited, out);
    }
}
