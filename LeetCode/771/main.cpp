
//leetcode 771 easy

/**
 * J里面的每个字符是个宝石，保证不重复。S中的每个字符是一个石头，
 * 有可能出现重复。统计有多少个石头恰好也是宝石。
 *
 */
#include <iostream>
#include <string.h>
#include <stdio.h>
int numJewelsInStones(char* J, char* S) {


    int jLen = strlen(J);
    int sLen=strlen(S);
    int ans=0;
    for (int j = 0; j <jLen ; j++) {

        for(int s=0;s<sLen;s++){

            if(J[j]==S[s]){
                ans++;
            }

        }

        
    }
    return ans;
    


}

int main() {

    std::cout << numJewelsInStones("aA","aAAbbbb");
    return 0;
}