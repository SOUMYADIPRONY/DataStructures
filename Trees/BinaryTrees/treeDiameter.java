package dataStructures.Trees.BinaryTrees;

public class treeDiameter
{
    static class Node{
        int data;
        Node left, right;

        public Node(int item){
            data = item;
            left = right = null;
        }
    }
    static class Height{
        int h;
    }
    Node root;

    int diameterOpt(Node root, Height height){
        Height lh = new Height();
        Height rh = new Height();
        if(root == null){
            height.h = 0;
            return 0;
        }
        int ldiameter = diameterOpt(root.left, lh);
        int rdiameter = diameterOpt(root.right, rh);

        height.h = Math.max(lh.h, rh.h) + 1;
        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
    }
    int diameter(){
        Height height = new Height();
        return diameterOpt(root, height);
    }
    static int height(Node node){
        if(node == null)
            return 0;
        return (1 + Math.max(height(node.left), height(node.right)));
    }
    public static void main(String[] args){
        treeDiameter tree = new treeDiameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diamter of given Binary tree is: " +tree.diameter());
    }
}
