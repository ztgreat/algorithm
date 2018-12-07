#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;
typedef struct AVLNode *Tree;
typedef int ElementType;
struct AVLNode
{
    int depth; //��ȣ��������ÿ��������ȣ�ͨ����ȵıȽϿɵó��Ƿ�ƽ��
    Tree parent; //�ý��ĸ��ڵ㣬�������
    ElementType val; //���ֵ
    Tree lchild;
    Tree rchild;
    AVLNode(int val=0) //Ĭ�Ϲ��캯��
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

//��AVL���в���val
//������������������value
//����:�¸����
Tree Insert(Tree &root,ElementType val)
{
    Tree temp=NULL;
    Tree node=new AVLNode(val);

    //������
    temp=insert_val(root,node,NULL); //���������Ĳ��뺯��

    if (temp)
    {
        update_depth(temp);
        root=rotateAt(root, temp);//������Ƿ�õ���
    }
    else //������룬�ͷŽ��
        delete temp;
    return root;
}
//���뺯��
//���������ڵ㣬�����㣬������ĸ��ڵ�
//���أ�������
Tree insert_val(Tree &root,Tree node,Tree parent)
{
    if (root==NULL)
    {
        root=node;
        node->parent=parent; //���õ�ǰ���ĸ����
        return root;         //���ز�����
    }
    if (node->val<root->val) //��������
        return insert_val(root->lchild, node,root);
    else if(node->val>root->val) //��������
        return insert_val(root->rchild, node,root);
    else //�Ѵ��ڸý�㣬ֹͣ�������������NULL
        return NULL;
}
//3+4�ع�����
//������������
//���أ��¸�
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
    int balance=0; //ƽ������
    while (node!=NULL) //����������Ƿ���Ҫ����������
    {
        update_depth(node); //���µ�ǰ���ĸ߶���Ϣ
        balance=is_balance(node); //��ȡ��ǰ����ƽ���������
        if (balance>1 || balance<-1) //ƽ�����ӳ���
        {
            if (balance>1) //��������
            {
                if (is_balance(node->lchild)>0) //LL��
                {
                    //����������,���������
                    son=node->lchild; //��������
                    grandson=son->lchild; //�������ӵ�����
                    son->parent=node->parent;  //���ø��º��son�ĸ��ڵ�
                    temp=node;
                    //�ع�
                    node=connect34(grandson, son, node, grandson->lchild, grandson->rchild, son->rchild, node->rchild);
                    setchild(son, temp, node);//����son���ڵ�ĺ���Ϊnode
                }
                else  //LR��
                {
                    son=node->lchild;
                    grandson=son->rchild;
                    grandson->parent=node->parent;
                    temp=node;
                    node=connect34(son, grandson, node, son->lchild, grandson->lchild, grandson->rchild, node->rchild);
                    setchild(grandson, temp, node); //����grandson���ڵ�ĺ���Ϊnode
                }
            }
            else //��������
            {
                if (is_balance(node->rchild)<0) //RR��
                {
                    son=node->rchild;
                    grandson=son->rchild;
                    son->parent=node->parent;
                    temp=node;
                    node=connect34(node, son, grandson, node->lchild, son->lchild, grandson->lchild, grandson->rchild);
                    setchild(son, temp, node);  //����son���ڵ�ĺ���Ϊnode
                }
                else //RL��
                {
                    son=node->rchild;
                    grandson=son->lchild;
                    grandson->parent=node->parent;
                    temp=node;
                    node=connect34(node, grandson, son, node->lchild, grandson->lchild, grandson->rchild, son->rchild);

                    setchild(grandson, temp, node); //����grandson���ڵ�ĺ���Ϊnode

                }
            }
            if (node->parent==NULL) //��������
            {
                root=node; //�����µĸ����
                break; //�˳�
            }
        }
        node=node->parent; //�����ҵ��丸�ڵ�

    }
    return root; //�����¸�
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
//������С���
Tree *Find_Min(Tree &root)
{
    if (root->lchild)
    {
        return Find_Min(root->lchild);
    }
    return &root;
}

//ɾ������
//������������Ҫɾ���Ľ��
//����ֵ: ����ɾ�����ĸ��ڵ�
Tree remove_val(Tree &root,Tree &node)
{
    Tree parent=node->parent;
    Tree temp=NULL;
    //ֻ������
    if (node->rchild==NULL && node->lchild!=NULL)
    {
        temp=node;
        node=node->lchild; //ָ������
        node->parent=temp->parent;
        delete temp;       //�ͷŽ��
        update_depth(node); //���µ�ǰ�����Ϣ
    }
    else if(node->lchild==NULL && node->rchild!=NULL) //ֻ���Һ���
    {
        temp=node;
        node=node->rchild; //ָ���ҽ��
        node->parent=temp->parent;
        delete temp;       //�ͷŽ��
        update_depth(node); //���µ�ǰ�����Ϣ
    }
    else if(node->rchild==NULL && node->lchild==NULL) //Ҷ�ӽ��
    {
        parent=node->parent; //�ҵ��丸�ڵ�
        if (parent) //������ڵ����
        {
            delete node;
            node=NULL;
            update_depth(parent); //���¸��ڵ�߶���Ϣ
        }
        else //ɾ�����Ǹ�
        {
            delete root;
            root=NULL;
        }
    }
    else //��������Ҳ���Һ��ӣ�����Ϊ��
    {
        Tree *tmp=Find_Min(node->rchild); //�ҵ����Ԫ�أ�tempΪҶ�ӽ��
        node->val=(*tmp)->val;         //����ֵ
        //�жϵ�ǰҶ�ӽ�������ӻ����Һ��ӡ�
        parent=(*tmp)->parent;
        delete *tmp;
        *tmp=NULL;
        update_depth(parent);
    }
    return parent;
}

//�ҵ�ɾ���Ľ�㣬ִ��ɾ���������������������AVL��
//������������Ҫɾ����val
//���أ��ҵ�ɾ����������򷵻��¸������򷵻�NULL
Tree remove(Tree &root,ElementType val)
{
    static Tree *temp=NULL;
    if (root==NULL)
    {
        temp=NULL;
        return NULL;
    }
    else if(root->val<val) //������������
        remove(root->rchild, val);
    else if(root->val>val) //������������
        remove(root->lchild, val);
    else   //�ҵ��ˣ����һ��
        temp=&root;

    if (temp)
    {
        if (!root->parent) //����Ѿ����ص����һ�Σ�Ҳ����root��������������
        {
            Tree tmp=NULL;
            tmp=remove_val(root,*temp);  //ִ��ɾ������
            return rotateAt(root, tmp);
        }
        return *temp;
    }
    return NULL;
}

//��ȡ��ǰ�������
int get_balance(Tree node)
{
    if (node==NULL)
        return 0;
    return node->depth;
}
//���ص�ǰƽ������
int is_balance(Tree node)
{
    if (node==NULL)
        return 0;
    else
        return get_balance(node->lchild)-get_balance(node->rchild);
}

//���µ�ǰ���
void update_depth(Tree node)
{
    if (node==NULL)
        return;
    else
    {
        int depth_Lchild=get_balance(node->lchild); //�������
        int depth_Rchild=get_balance(node->rchild); //�Һ������
        node->depth=max(depth_Lchild,depth_Rchild)+1;
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
    root = Insert(root, 16);
    root = Insert(root, 3);

    //����7��LR����
    root = Insert(root, 7);
    root = Insert(root, 11);

    //����9��LL����
    root = Insert(root, 9);

    //����26��RR����
    root = Insert(root, 26);

    //����18��RL����
    root = Insert(root, 18);
    root = Insert(root, 14);

    //����15��LR����
    root = Insert(root, 15);

    printf("����:\n");
    printf("ǰ��:");
    PreOrder(root);   // 11 7 3 9 18 15 14 16 26
    printf("\n");


    printf("����:");
    InOrder(root);   // 3 7 9 11 14 15 16 18 26
    printf("\n");


    printf("ɾ��:\n");

    //����ɾ��Ҷ�ӽ��
//    remove(root, 16);


    //����ɾ��ֻ�����ӵĽ��
//    remove(root, 16);
//    remove(root, 15);


    //����ɾ��ֻ���Һ��ӵĽ��
//    remove(root, 14);
//    remove(root, 15);

    //����ɾ�������Һ��ӵĽ��
//    remove(root, 18);

    //ɾ��26�����LR�͵���
    remove(root, 26);


    //ɾ��18�����RR��
    remove(root, 18);


    remove(root, 3);
    remove(root, 9);

    //ɾ��7������RL����
    remove(root, 7);


    //ɾ��11�����LL����
    remove(root, 11);

    //�ѽ��ɾ����
//     remove(root, 15);
//     remove(root, 14);
//     remove(root, 16);

    printf("ǰ��:");
    PreOrder(root);
    printf("\n");
    printf("����:");
    InOrder(root);
    printf("\n");
    return 0;
}
