
//leetcode 121

#include <iostream>
#include <string.h>
#include <stdio.h>
using namespace std;
int maxProfit(int* prices, int pricesSize) {

    int minPrices = INT32_MAX;
    int maxProfit = 0;

    for(int i=0;i<pricesSize;i++){

        if(prices[i]<minPrices){
            minPrices=prices[i];
        }
        if(prices[i]-minPrices>maxProfit){
            maxProfit = prices[i]-minPrices;
        }

    }
    return maxProfit;

}
int main() {


    return 0;
}