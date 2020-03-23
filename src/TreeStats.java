public class TreeStats {
    public Node getMin(Node root){
        if(root.left==null)
            return root;
        return getMin(root.left);
    }
    public int getHeight(Node root){
        if(root==null)
            return 0;
        return root.height;
    }
    public int getSum(Node root){
        if(root==null)
            return 0;
        return root.sum;
    }
    public int getSize(Node root){
        if(root==null)
            return 0;
        return root.size;
    }
    public double getAvg(Node root){
        if(root==null)
            return 0;
        return (double)root.sum/root.size;
    }
    public double getMed(Node root){
        if(root==null)
            return 0;
        if(root.size%2==1)
            return select(root,root.size/2+1).key;
        else
            return (double)(select(root,root.size/2).key+select(root,root.size/2+1).key)/2;
    }
    public Node select(Node root, int rank){
        if(root==null)
            return null;
        int r;
        if(root.left!=null)
            r=root.left.size+1;
        else
            r=1;
        if(rank==r)
            return root;
        else if(rank<r)
            return select(root.left,rank);
        else
            return select(root.right,rank-r);
    }
    public int getDiff(Node root){
        if(root==null)
            return 0;
        return getHeight(root.left)-getHeight(root.right);
    }
    public Node searchSubtree(Node root,int key){
        if(root==null)
            return null;
        if(root.key==key)
            return root;
        if(key<root.key)
            return searchSubtree(root.left,key);
        else
            return searchSubtree(root.right,key);
    }
    public void printTree(Node root){
        if(root!=null){
            printTree(root.left);
            for(int i=0;i<root.count;i++)
                System.out.println(root.key);
            printTree(root.right);
        }
    }
}
