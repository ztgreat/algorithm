#include <iostream>
#include <cstdlib>
#include <time.h>
using namespace std;

void quick_sort(int *array,int start,int end){

    if(start>=end){
        return;
    }
    int temp=array[start];

    int i= start;

    int j = end;


    while(i<j){

        while (i<j && array[j]>= temp){
            j--;
        }

        if(i<j){
            array[i]=array[j];
            i++;
        }

        while(i<j && array[i]<=temp){
            i++;
        }
        if(i<j){
            array[j]=array[i];
            j--;
        }
    }
    array[i]=temp;
    quick_sort(array,start,i-1);
    quick_sort(array,j+1,end);
}

int main() {

    srand((unsigned)time(NULL));
    int a[10];
    for(int i=0;i<10;i++){
        a[i]= rand()%100;
    }
    cout<<endl;
    quick_sort(a,0,9);
    for(int i=0;i<10;i++){
        printf("%d  ",a[i]);
    }
    return 0;
}