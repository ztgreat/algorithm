package com.github.ztgreat.sort;

/**
 * 快速排序
 * @author ztgreat
 * 思想:
 * 选一个基数a[x], 小于 a[x] 放在 a[x] 左边,大的放a[x] 右边,然后在递归处理两个小分区。
 */
public class QuickSort {

    public static void quickSort(Integer[] a, int start, int end) {
        if (start >= end)
            return;
        int temp = a[start];
        int i = start;
        int j = end;
        while (i<j){
            while (i<j && a[j]>temp){
                j--;
            }
            if(i<j){
                a[i]=a[j];
            }

            while (i<j && a[i]<temp){
                i++;
            }
            if(i<j){
                a[j]=a[i];
            }
        }
        a[i]=temp;
        quickSort(a,start,i);
        quickSort(a,i+1,end);
    }

    public static void main(String[] args){

        Integer[] num = { 1, 3, 4, 8, 5, 10, 22, 15, 16 };

        quickSort(num,0,num.length-1);

        for (int i=0;i<num.length;i++){
            System.out.print(num[i]+",");
        }

    }
}
