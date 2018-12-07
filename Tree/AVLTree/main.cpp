#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;
typedef struct AVLNode *Tree;
typedef int ElementType;
struct AVLNode
{
    int depth; //深度，这里计算每个结点的深度，通过深度的比较可得出是否平衡
    Tree parent; //该结点的父节点，方便操作
    ElementType val; //结点值
    Tree lchild;
    Tree rchild;
    AVLNode(int val=0) //默认构造函数
    {
        parent=NULL;
        depth=0;
        lchild=rchild=NULL;
        this->val=val;
    }
};
Tree insert_val(Tree&,Tree,Tree);
Tree remove(Tree&,ElementType);
Tree remove_val(Tree &,Tree &);
void update_depth(Tree);
int  get_balance(Tree);
int  is_balance(Tree);
Tree *Find_Min(Tree&);
Tree connect34(Tree&,Tree&,Tree&,Tree&,Tree&,Tree&,Tree&);
Tree rotateAt(Tree&,Tree&);
void setchild(Tree &,Tree &,Tree &);

//向AVL树中插入val
//参数：根，插入数据value
//返回:新根结点
Tree Insert(Tree &root,ElementType val)
{
    Tree temp=NULL;
    Tree node=new AVLNode(val);

    //插入结点
    temp=insert_val(root,node,NULL); //调用真正的插入函数

    if (temp)
    {
        update_depth(temp);
        root=rotateAt(root, temp);//检查树是否该调整
    }
    else //无需插入，释放结点
        delete temp;
    return root;
}
//插入函数
//参数：根节点，待插结点，待插结点的父节点
//返回：插入结点
Tree insert_val(Tree &root,Tree node,Tree parent)
{
    if (root==NULL)
    {
        root=node;
        node->parent=parent; //设置当前结点的父结点
        return root;         //返回插入结点
    }
    if (node->val<root->val) //插左子树
        return insert_val(root->lchild, node,root);
    else if(node->val>root->val) //插右子树
        return insert_val(root->rchild, node,root);
    else //已存在该结点，停止插入操作，返回NULL
        return NULL;
}
//3+4重构函数
//参数：见分析
//返回：新根
Tree connect34(Tree &a,Tree &b,Tree &c,Tree &T0,Tree &T1,Tree &T2,Tree &T3)
{
    a->lchild=T0;
    if (T0)
        T0->parent=a;
    a->rchild=T1;
    if(T1)
        T1->parent=a;
    update_depth(a);
    c->lchild=T2;
    if(T2)
        T2->parent=c;
    c->rchild=T3;
    if(T3)
        T3->parent=c;
    update_depth(c);
    b->lchild=a;
    a->parent=b;
    b->rchild=c;
    c->parent=b;
    update_depth(b);
    return b;
}

Tree rotateAt(Tree &root,Tree &node)
{
    Tree son,temp;
    Tree grandson;
    int balance=0; //平衡因子
    while (node!=NULL) //检查其祖先是否需要调整，更新
    {
        update_depth(node); //更新当前结点的高度信息
        balance=is_balance(node); //获取当前结点的平衡因子情况
        if (balance>1 || balance<-1) //平衡因子超标
        {
            if (balance>1) //左子树高
            {
                if (is_balance(node->lchild)>0) //LL型
                {
                    //找祖孙三代,后面的类似
                    son=node->lchild; //找其左孩子
                    grandson=son->lchild; //找其左孩子的左孩子
                    son->parent=node->parent;  //设置更新后的son的父节点
                    temp=node;
                    //重构
                    node=connect34(grandson, son, node, grandson->lchild, grandson->rchild, son->rchild, node->rchild);
                    setchild(son, temp, node);//设置son父节点的孩子为node
                }
                else  //LR型
                {
                    son=node->lchild;
                    grandson=son->rchild;
                    grandson->parent=node->parent;
                    temp=node;
                    node=connect34(son, grandson, node, son->lchild, grandson->lchild, grandson->rchild, node->rchild);
                    setchild(grandson, temp, node); //设置grandson父节点的孩子为node
                }
            }
            else //右子树高
            {
                if (is_balance(node->rchild)<0) //RR型
                {
                    son=node->rchild;
                    grandson=son->rchild;
                    son->parent=node->parent;
                    temp=node;
                    node=connect34(node, son, grandson, node->lchild, son->lchild, grandson->lchild, grandson->rchild);
                    setchild(son, temp, node);  //设置son父节点的孩子为node
                }
                else //RL型
                {
                    son=node->rchild;
                    grandson=son->lchild;
                    grandson->parent=node->parent;
                    temp=node;
                    node=connect34(node, grandson, son, node->lchild, grandson->lchild, grandson->rchild, son->rchild);

                    setchild(grandson, temp, node); //设置grandson父节点的孩子为node

                }
            }
            if (node->parent==NULL) //到达根结点
            {
                root=node; //设置新的根结点
                break; //退出
            }
        }
        node=node->parent; //依次找到其父节点

    }
    return root; //返回新根
}
void setchild(Tree &g,Tree &temp,Tree &node)
{
    if (g->parent)
    {
        if (g->parent->lchild==temp)
            g->parent->lchild=node;
        else
            g->parent->rchild=node;
    }
}
//查找最小结点
Tree *Find_Min(Tree &root)
{
    if (root->lchild)
    {
        return Find_Min(root->lchild);
    }
    return &root;
}

//删除操作
//参数：根，需要删除的结点
//返回值: 返回删除结点的父节点
Tree remove_val(Tree &root,Tree &node)
{
    Tree parent=node->parent;
    Tree temp=NULL;
    //只有左孩子
    if (node->rchild==NULL && node->lchild!=NULL)
    {
        temp=node;
        node=node->lchild; //指向左孩子
        node->parent=temp->parent;
        delete temp;       //释放结点
        update_depth(node); //更新当前结点信息
    }
    else if(node->lchild==NULL && node->rchild!=NULL) //只有右孩子
    {
        temp=node;
        node=node->rchild; //指向右结点
        node->parent=temp->parent;
        delete temp;       //释放结点
        update_depth(node); //更新当前结点信息
    }
    else if(node->rchild==NULL && node->lchild==NULL) //叶子结点
    {
        parent=node->parent; //找到其父节点
        if (parent) //如果父节点存在
        {
            delete node;
            node=NULL;
            update_depth(parent); //更新父节点高度信息
        }
        else //删除的是根
        {
            delete root;
            root=NULL;
        }
    }
    else //既有左孩子也有右孩子，化繁为简
    {
        Tree *tmp=Find_Min(node->rchild); //找到替代元素，temp为叶子结点
        node->val=(*tmp)->val;         //更新值
        //判断当前叶子结点是左孩子还是右孩子。
        parent=(*tmp)->parent;
        delete *tmp;
        *tmp=NULL;
        update_depth(parent);
    }
    return parent;
}

//找到删除的结点，执行删除操作，并根据情况调整AVL树
//参数：根，需要删除的val
//返回：找到删除结点的情况则返回新根，否则返回NULL
Tree remove(Tree &root,ElementType val)
{
    static Tree *temp=NULL;
    if (root==NULL)
    {
        temp=NULL;
        return NULL;
    }
    else if(root->val<val) //在右子树查找
        remove(root->rchild, val);
    else if(root->val>val) //在左子树查找
        remove(root->lchild, val);
    else   //找到了，标记一下
        temp=&root;

    if (temp)
    {
        if (!root->parent) //如果已经返回到最后一次（也就是root是真正的树根）
        {
            Tree tmp=NULL;
            tmp=remove_val(root,*temp);  //执行删除操作
            return rotateAt(root, tmp);
        }
        return *temp;
    }
    return NULL;
}

//获取当前结点的深度
int get_balance(Tree node)
{
    if (node==NULL)
        return 0;
    return node->depth;
}
//返回当前平衡因子
int is_balance(Tree node)
{
    if (node==NULL)
        return 0;
    else
        return get_balance(node->lchild)-get_balance(node->rchild);
}

//更新当前深度
void update_depth(Tree node)
{
    if (node==NULL)
        return;
    else
    {
        int depth_Lchild=get_balance(node->lchild); //左孩子深度
        int depth_Rchild=get_balance(node->rchild); //右孩子深度
        node->depth=max(depth_Lchild,depth_Rchild)+1;
    }
}
//前序
void PreOrder(Tree root)
{
    if (root==NULL)
        return;
    printf("%d ",root->val);
    PreOrder(root->lchild);
    PreOrder(root->rchild);
}
//中序
void InOrder(Tree root)
{
    if (root==NULL)
        return;
    InOrder(root->lchild);
    printf("%d ",root->val);
    InOrder(root->rchild);
}
int main()
{
    Tree root=NULL;
    root = Insert(root, 16);
    root = Insert(root, 3);

    //插入7后LR调整
    root = Insert(root, 7);
    root = Insert(root, 11);

    //插入9后LL调整
    root = Insert(root, 9);

    //插入26后RR调整
    root = Insert(root, 26);

    //插入18后RL调整
    root = Insert(root, 18);
    root = Insert(root, 14);

    //插入15后LR调整
    root = Insert(root, 15);

    printf("插入:\n");
    printf("前序:");
    PreOrder(root);   // 11 7 3 9 18 15 14 16 26
    printf("\n");


    printf("中序:");
    InOrder(root);   // 3 7 9 11 14 15 16 18 26
    printf("\n");


    printf("删除:\n");

    //测试删除叶子结点
//    remove(root, 16);


    //测试删除只有左孩子的结点
//    remove(root, 16);
//    remove(root, 15);


    //测试删除只有右孩子的结点
//    remove(root, 14);
//    remove(root, 15);

    //测试删除有左右孩子的结点
//    remove(root, 18);

    //删除26后进行LR型调整
    remove(root, 26);


    //删除18后进行RR型
    remove(root, 18);


    remove(root, 3);
    remove(root, 9);

    //删除7过进行RL调整
    remove(root, 7);


    //删除11后进行LL调整
    remove(root, 11);

    //把结点删除完
//     remove(root, 15);
//     remove(root, 14);
//     remove(root, 16);

    printf("前序:");
    PreOrder(root);
    printf("\n");
    printf("中序:");
    InOrder(root);
    printf("\n");
    return 0;
}
