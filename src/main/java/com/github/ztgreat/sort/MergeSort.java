package com.github.ztgreat.sort;

/**
 * 归并排序
 * @author ztgreat
 */
public class MergeSort {


    public static void mergeSort(Integer[] a,int start,int end) {

        if(start>=end){
            return;
        }
        int mid = (start+end)/2;

        mergeSort(a,start,mid);
        mergeSort(a,mid+1,end);
        merge(a,start,mid,end);
    }

    public static void merge(Integer[] a,int start,int mid,int end) {

        int[] temp = new int[end - start+ 1];
        int i = start;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= end) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + start] = temp[k2];
        }
    }


    public static void main(String[] args){
        Integer[] num = { 1, 3, 4, 8, 5, 10, 22, 15, 16 };
        mergeSort(num,0,num.length-1);
        for (int i=0;i<num.length;i++){
            System.out.print(num[i]+",");
        }
    }

}
