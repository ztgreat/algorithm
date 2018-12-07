#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;
typedef struct TreapNode* Tree;
typedef int ElementType;
struct TreapNode
{
    ElementType val; //���ֵ
    int priority;   //���ȼ�
    Tree lchild;
    Tree rchild;
    TreapNode(int val=0,int priority=0) //Ĭ�Ϲ��캯��
    {
        lchild=rchild=NULL;
        this->val=val;
        this->priority=priority;
    }
};
Tree search(Tree &,ElementType);
void right_rotate(Tree &);
void left_rotate(Tree &);
bool insert_val(Tree &,Tree &);
bool insert(Tree &,ElementType,int);
bool remove(Tree &,ElementType);


//���Һ���
Tree search(Tree &root,ElementType val)
{
    if (!root)
        return NULL;
    else if (root->val>val)
        return search(root->lchild,val);
    else if(root->val<val)
        return  search(root->rchild,val);
    return root;
}
//���뺯��
bool insert(Tree &root,ElementType val=0,int priority=0)
{
    Tree node=new TreapNode(val,priority);
    return insert_val(root, node);
}
//�ڲ����뺯��
//����:����㣬�����Ľ��
bool insert_val(Tree &root,Tree &node)
{
    if (!root)
    {
        root=node; //����
        return true;
    }
    else if(root->val>node->val)
    {
        bool flag=insert_val(root->lchild, node);
        if (root->priority>node->priority) //����Ƿ���Ҫ����
            right_rotate(root);
        return flag;
    }
    else if(root->val<node->val)
    {
        bool flag=insert_val(root->rchild, node);
        if (root->priority>node->priority) //����Ƿ���Ҫ����
            left_rotate(root);
        return flag;
    }
    //�Ѿ����и�Ԫ�أ��ͷŽ��
    delete node;
    return false;

}
//����ת
void right_rotate(Tree &node)
{
    Tree temp=node->lchild;
    node->lchild=temp->rchild;
    temp->rchild=node;
    node=temp;
}
//����ת
void left_rotate(Tree &node)
{
    Tree temp=node->rchild;
    node->rchild=temp->lchild;
    temp->lchild=node;
    node=temp;
}

//ɾ������
bool remove(Tree &root,ElementType val)
{
    if (root==NULL)
        return false;
    else if (root->val>val)
        return remove(root->lchild,val);
    else if(root->val<val)
        return remove(root->rchild,val);
    else //�ҵ�ִ��ɾ������
    {

        Tree *node=&root;
        while ((*node)->lchild && (*node)->rchild)  //�Ӹý�㿪ʼ���µ���
        {
            if ((*node)->lchild->priority<(*node)->rchild->priority) //�Ƚ������Һ������ȼ�
            {
                right_rotate(*node); //����ת
                node=&((*node)->rchild); //���´��������������һ��
            }
            else
            {
                left_rotate(*node); //����ת
                node=&((*node)->lchild); //���´��������������һ��
            }
        }

        //�������������߱����ǣ�Ҷ�ӽ�㣬����ֻ��һ�����ӵ����������ֱ��ɾ����
        if ((*node)->lchild==NULL)
            (*node)=(*node)->rchild;
        else if((*node)->rchild==NULL)
            (*node)=(*node)->lchild;
        return true;
    }
}


//ǰ��
void PreOrder(Tree root)
{
    if (root==NULL)
        return;
    printf("%d ",root->val);
    PreOrder(root->lchild);
    PreOrder(root->rchild);
}
//����
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

    insert(root,11,6);
    insert(root,7,13);
    insert(root,14,14);
    insert(root,3,18);
    insert(root,9,22);
    insert(root,18,20);
    insert(root,16,26);
    insert(root,15,30);
    insert(root,17,12);
    printf("����:\n");
    printf("ǰ��:");
    PreOrder(root);
    printf("\n");
    printf("����:");
    InOrder(root);
    printf("\n");
    printf("ɾ��:\n");
    remove(root,11);
    printf("ǰ��:");
    PreOrder(root);
    printf("\n");
    printf("����:");
    InOrder(root);
    printf("\n");


    return 0;
}
