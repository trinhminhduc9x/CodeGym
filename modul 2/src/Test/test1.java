package Test;


import java.util.Arrays;

public class test1 {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1,4,5, 3};
        Arrays.sort(arr1);
        int sum1 =0;
        int sum2 =0;
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < (arr1.length); i++) {
            System.out.println(arr1[i]);
            sum1 += arr1[i];
            sum2 += arr1[arr1.length-1-i];
            if(sum1==sum2){
                System.out.println(i-1);
            }
        }
    }
}
