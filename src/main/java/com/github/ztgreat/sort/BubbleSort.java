package com.github.ztgreat.sort;

/**
 * 冒泡排序
 * @author ztgreat
 * 思想:
 * 对相邻的元素进行两两比较，顺序相反则进行交换，
 * 这样，每一趟会将最小或最大的元素“浮”到顶端，最终达到完全有序
 */
public class BubbleSort {

    public static void bubbleSort(Integer[] a) {
        int temp=0;
        for (int i=0;i<a.length;i++){
            int min=i;
            for (int j=i+1;j<a.length;j++){
                if(a[j]<a[min]){
                    min=j;
                }
            }
            if (min != i) {
                temp=a[min];
                a[min]=a[i];
                a[i]=temp;
            }
        }
    }
    public static void main(String[] args){
        Integer[] num = { 1, 3, 4, 8, 5, 10, 22, 15, 16 };
        bubbleSort(num);
        for (int i=0;i<num.length;i++){
            System.out.print(num[i]+",");
        }
    }
}
