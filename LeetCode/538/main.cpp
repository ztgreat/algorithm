
//leetcode 538 easy

/**
 * 思路:
 * 既然是一颗bst,那么中序遍历结果,就是一个有序 序列
 * 比该节点大的值,一定在其右边，因此递归的方式可以先从右子树出发,
 * 进行中序遍历,在回溯的过程中记录更新值
 */

#include <iostream>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

void convert(struct TreeNode* root,int *sum) {


    if(root==NULL){
        return;
    }
    convert(root->right,sum);
    *sum +=root->val;
    root->val=*sum;
    convert(root->left,sum);
}

struct TreeNode* convertBST(struct TreeNode* root) {

    int sum =0;
    convert(root,&sum);
    return root;
}


int main() {

    return 0;
}