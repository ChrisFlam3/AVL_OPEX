public class Node {
    int key,height,count,sum,size;
    Node left,right;
    public Node(int key){
        this.key=key;
        this.height=1;
        this.count=1;
        this.left=null;
        this.right=null;
        this.sum=key;
        this.size=1;
    }
}
