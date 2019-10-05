package com.github.ztgreat.leetcode.problem_638;


import java.util.*;

class Solution {


    private Integer ans;

    private Integer cnt;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        ans=Integer.MAX_VALUE;
        cnt=0;
        //存放 普通商品或者礼包商品
        List<Node>nodes = new ArrayList<>();

        // 每个商品相当于 一个node
        for (int i=0;i<price.size();i++){
            Node node= new Node();
            node.setPrice(price.get(i));
            node.addProduct(i,1);
            nodes.add(node);
        }

        // 把礼包拆分成一个 node
        for (int i=0;i<special.size();i++){

            Node node= new Node();
            List<Integer> p = special.get(i);
            node.setPrice(p.get(p.size()-1));
            for (int j=0;j<p.size()-1;j++){
                if(p.get(j)!=0){
                    node.addProduct(j,p.get(j));
                }
            }
            nodes.add(node);
        }
        dfs(nodes,needs,0);
        return this.ans;


    }

    public void dfs(List<Node> products, List<Integer> needs,int sum){

        if(checkNeeds(needs)){
            ans=Math.min(ans,sum);
            return;
        }
        if(cnt==products.size()){
            return;
        }
        Node node = products.get(cnt);

        boolean canBuy=canBuy(needs,node);

        if(!canBuy) {
            cnt++;
            dfs(products, needs, sum);
            cnt--;
            return;
        }
        int oldSumm = sum;
        List<Integer> oldNeeds = new ArrayList<>(6);
        for (int k=0;k<needs.size();k++){
            oldNeeds.add(needs.get(k));
        }
        sum+=node.getPrice();
        for (int j=0;j<needs.size();j++){

            if(node.getProduct().containsKey(j)){
                needs.set(j,needs.get(j)-node.getProduct().get(j));
            }
        }
        if(sum<ans){
            dfs(products,needs,sum);
        }
        cnt++;
        dfs(products,oldNeeds,oldSumm);
        cnt--;
    }


    // 检查 购物清单 是否完成了
    private boolean checkNeeds(List<Integer> needs){

        for (int i=0;i<needs.size();i++){
            if (needs.get(i)!=0){
                return false;
            }
        }
        return true;
    }

    // 检查是不是可以买
    private boolean canBuy( List<Integer> needs,Node node){
        HashMap<Integer,Integer> map = node.getProduct();

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){

            if(needs.size()>entry.getKey()  && needs.get(entry.getKey())>=entry.getValue()){

            }else{
                return false;
            }
        }
        return true;
    }
}

class Node{

    private Integer price;

    private HashMap<Integer,Integer>product=new HashMap<>(6);


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public HashMap<Integer, Integer> getProduct() {
        return product;
    }

    public void addProduct(Integer product, Integer count){
        this.product.put(product,count);
    }

}