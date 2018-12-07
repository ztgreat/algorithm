#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;
typedef struct SplayNode *Tree;
typedef int ElementType;
struct SplayNode
{
    Tree parent; //�ý��ĸ��ڵ㣬�������
    ElementType val; //���ֵ
    Tree lchild;
    Tree rchild;
    SplayNode(int val=0) //Ĭ�Ϲ��캯��
    {
        parent=NULL;
        lchild=rchild=NULL;
        this->val=val;
    }
};

bool search(Tree &,ElementType);
Tree *search_val(Tree&,ElementType,Tree&);
bool insert(Tree &,ElementType);
Tree left_single_rotate(Tree&,Tree);
Tree right_single_rotate(Tree &,Tree );
void LR_rotate(Tree&,Tree );
void RL_rotate(Tree&,Tree );
void right_double_rotate(Tree&,Tree );
void left_double_rotate(Tree&,Tree );
void SplayTree(Tree &,Tree);
void up(Tree &,Tree );
Tree *Find_Min(Tree &);
void remove(Tree &,ElementType);

//���Һ���������������
//����:����㣬��Ҫ���ҵ�val
//����:true or false
bool search(Tree &root,ElementType val)
{

    Tree parent=NULL;
    Tree *temp=NULL;
    temp=search_val(root,val, parent);
    if (*temp && *temp!=root)
    {
        SplayTree(root,*temp);
        return true;
    }
    return false;
}

//����Ĳ��Һ���
//����:������Ҫ���ҵ�val,���ڵ�ָ��
//�ɹ�:��������
//ʧ�ܣ�����������,�������Ĳ������
Tree *search_val(Tree &root,ElementType val,Tree &parent)
{
    if (root==NULL)
        return &root;
    if (root->val>val)
        return search_val(root->lchild,val,parent=root);
    else if(root->val<val)
        return search_val(root->rchild,val,parent=root);
    return &root;
}

//���뺯��
//������������Ҫ�����val
//����:true or false
bool insert(Tree &root,ElementType val)
{
    Tree *temp=NULL;
    Tree parent=NULL;
    //�Ȳ��ң�����ɹ���������룬���򷵻ظý������á�
    temp=search_val(root,val,parent);

    if (*temp==NULL) //��Ҫ��������
    {
        Tree node=new SplayNode(val);
        *temp=node; //��Ϊ�������ͣ���������ֱ�Ӹ�ֵ�����˺ܶ��ˡ�
        node->parent=parent; //���ø��ڵ㡣
        return true;
    }
    return false;
}
//����������
//����:������ת���(��ת����)
//����:��ǰ�����е��¸�
Tree left_single_rotate(Tree &root,Tree node)
{
    if (node==NULL)
        return NULL;
    Tree parent=node->parent; //�丸���
    Tree grandparent=parent->parent; //���游���
    parent->rchild=node->lchild; //�����丸�ڵ���Һ���
    if (node->lchild) //��������������node������ӵĸ��ڵ���Ϣ
        node->lchild->parent=parent;
    node->lchild=parent; //����node����������Ϣ
    parent->parent=node; //����ԭ���ڵ����Ϣ
    node->parent=grandparent;

    if (grandparent) //�����游���ӽ�����Ϣ
    {

        if (grandparent->lchild==parent)
            grandparent->lchild=node;
        else
            grandparent->rchild=node;
    }
    else //�������游�ڵ㣬��ԭ���ڵ�Ϊ������ô��ת��nodeΪ��
        root=node;
    return node;
}
//����������
//����:������ת���(��ת����)
//����:��ǰ�����е��¸�
Tree right_single_rotate(Tree &root,Tree node)
{
    if (node==NULL)
        return NULL;
    Tree parent,grandparent;
    parent=node->parent;
    grandparent=parent->parent;
    parent->lchild=node->rchild;
    if (node->rchild)
        node->rchild->parent=parent;
    node->rchild=parent;
    parent->parent=node;
    node->parent=grandparent;
    if (grandparent)
    {
        if (grandparent->lchild==parent)
            grandparent->lchild=node;
        else
            grandparent->rchild=node;
    }
    else
        root=node;
    return node;

}
//˫��������LR�ͣ�����AVL������
//������������󽫱�����������Ľ��
void LR_rotate(Tree &root,Tree node)
{
    left_single_rotate(root,node); //����
    right_single_rotate(root,node);//����
}
//˫��������RL�ͣ�����AVL������
//������������󽫱�����������Ľ��
void RL_rotate(Tree&root,Tree node)
{
    right_single_rotate(root,node); //���Һ���
    left_single_rotate(root,node);
}

//���ε���������
//������������󽫱�����������Ľ��
void right_double_rotate(Tree &root,Tree node)
{
    right_single_rotate(root,node->parent); //�������丸�ڵ�
    right_single_rotate(root,node);         //��������Լ�
}
//���ε���������
//������������󽫱�����������Ľ��
void left_double_rotate(Tree &root,Tree node)
{
    left_single_rotate(root,node->parent);
    left_single_rotate(root,node);
}
//Splay��������
void SplayTree(Tree &root,Tree node)
{
    while (root->lchild!=node && root->rchild!=node && root!=node) //��ǰ��㲻�Ǹ������߲�����������Һ��ӣ���������������ת����
        up(root, node);
    if (root->lchild==node) //��ǰ���Ϊ�������ӣ�ֻ�����һ�ε�����
        root=right_single_rotate(root, node);
    else if(root->rchild==node) //��ǰ���Ϊ�����Һ��ӣ�ֻ�����һ�ε�����
        root=left_single_rotate(root, node);
}

//���������ѡ��ͬ����ת��ʽ
void up(Tree &root,Tree node)
{
    Tree parent,grandparent;
    int i,j;
    parent=node->parent;
    grandparent=parent->parent;
    i=grandparent->lchild==parent ? -1:1;
    j=parent->lchild==node ?-1:1;
    if (i==-1 && j==-1) //AVL���е�LL��
        right_double_rotate(root, node);
    else if(i==-1 && j==1) //AVL���е�LR��
        LR_rotate(root, node);
    else if(i==1 && j==-1) //AVL���е�RL��
        RL_rotate(root, node);
    else                    //AVL���е�RR��
        left_double_rotate(root, node);
}

//������ǰ��������С���
//����:����С��������
Tree *Find_Min(Tree &root)
{
    if (root->lchild)
        return Find_Min(root->lchild);
    return &root;
}

//ɾ������
void remove(Tree &root,ElementType val)
{
    Tree parent=NULL;
    Tree *temp;
    Tree *replace;
    Tree replace2;
    temp=search_val(root,val, parent); //�Ƚ��в��Ҳ���
    if(*temp) //������ҵ���
    {
        if (*temp!=root) //�ж��Ƿ��Ǹ���㣬���Ǹ���㣬����Ҫ�����������
            SplayTree(root, *temp);

        //���Ƹ������߱������Ǹ��������ɾ�����Ȳ鿴�Ƿ������Ԫ��
        if (root->rchild)
        {
            //�����Ԫ��
            replace=Find_Min(root->rchild); //�ҵ��滻Ԫ��
            root->val=(*replace)->val;  //�滻
            if ((*replace)->lchild==NULL) //������Ϊ��
            {
                replace2=*replace;
                *replace=(*replace)->rchild; //�ؽ����Һ���
                delete replace2;

            }
            else if((*replace)->rchild==NULL) //������Ϊ��
            {
                replace2=*replace;
                *replace=(*replace)->lchild; //�ؽ�������
                delete replace2;
            }
        }
        else
        {
            //�����Ԫ�أ����ֱ�������������������������Ƿ�Ϊ�ն����Դ���
            replace2=root;
            root=root->lchild;
            delete replace2;
        }
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
    insert(root, 11);
    insert(root, 7);
    insert(root, 18);
    insert(root, 3);
    insert(root, 9);
    insert(root, 16);
    insert(root, 26);
    insert(root, 14);
    insert(root, 15);

    search(root,14);
    printf("����14:\n");
    printf("ǰ��:");
    PreOrder(root);
    printf("\n");
    printf("����:");
    InOrder(root);
    printf("\n");

//    remove(root,16);
//    remove(root,26);
//    remove(root,11);
    remove(root,16);
    printf("ɾ��16:\n");
    printf("ǰ��:");
    PreOrder(root);
    printf("\n");
    printf("����:");
    InOrder(root);
    printf("\n");
    return 0;
}
