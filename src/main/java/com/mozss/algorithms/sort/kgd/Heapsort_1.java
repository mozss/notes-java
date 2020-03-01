package com.mozss.algorithms.sort.kgd;

import java.util.Arrays;

public class Heapsort_1 {

    public static void main(String[] argr){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void  sort(int[] arr) {
        //1.够建大顶堆
        for (int i = arr.length / 2; i >= 0 ; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    /**
     *  调整大顶堆（仅是调整的过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param lenght
     * */
    private static void adjustHeap(int[] arr, int i, int lenght) {
        //先取出当前元素i
        int temp = arr[i];
        for(int k= 1 * 2 +1; k <lenght; k = k * 2 + 1 ){
            if (k + 1 <lenght && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
    }

    /**
     * 交换元素
     * @param a
     * @param b
     * @param arr
     * */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[a];
        arr[b] = temp;
    }


































}