
//leetcode 530 easy

//leetcode 783 也是一样的
/**
 * 思路:
 * 既然是一颗bst,那么中序遍历结果,就是一个有序 序列
 * 那么最小值一定在 有序序列 的相邻两个节点(这里的节点指中序遍历结果中的节点,而不是原bst节点)产生
 * 递归遍历:中序的时候处理,记录最小值和前一个节点，方便回溯的时候进行比较和更新
 */

#include <iostream>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

int getMin(struct TreeNode* root,int *preValue,int *min) {

    if(root == NULL){
        return *min;
    }
    getMin(root->left,preValue,min);
    if(*preValue!=-1 && root->val-*preValue< *min){
        *min= root->val-*preValue;
    }
    *preValue=root->val;
    getMin(root->right,preValue,min);
    return *min;
}

int getMinimumDifference(struct TreeNode* root) {
    int preValue=-1;
    int min=1000000000;
    return getMin(root,&preValue,&min);
}

int main() {

    return 0;
}