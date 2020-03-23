public class AvlTree extends TreeStats {
    private Node root;
    public static int max(int a, int b){
        if(a>b)
            return a;
        return b;
    }
    public Node getRoot(){
        return this.root;
    }
    public void printAvlTree(){
        printTree(this.root);
    }
    private String innerToString(String str,Node root){
        if(root==null)
            return str;
        str=innerToString(str,root.left);
        str+=Integer.toString(root.key);
        str+=" ";
        str=innerToString(str,root.right);
        return str;
    }
    public String toString(){
        String str=new String();
        str=innerToString(str,this.root);
        if(str.length()>0)
            str=str.substring(0, str.length() - 1);
        return str;
    }
    public Node search(int key){
        return searchSubtree(this.root,key);
    }
    private Node rotateLeft(Node root){
        Node rootRight=root.right;
        Node rootRightLeft=rootRight.left;
        rootRight.left=root;
        root.right=rootRightLeft;
        root.height=max(getHeight(root.left),getHeight(root.right))+1;
        root.sum=getSum(root.left)+getSum(root.right)+root.key*root.count;
        root.size=getSize(root.left)+getSize(root.right)+root.count;
        rootRight.height=max(getHeight(rootRight.left),getHeight(rootRight.right))+1;
        rootRight.sum=getSum(rootRight.left)+getSum(rootRight.right)+root.key*rootRight.count;
        rootRight.size=getSize(rootRight.left)+getSize(rootRight.right)+rootRight.count;
        return rootRight;
    }
    private Node rotateRight(Node root){
        Node rootLeft=root.left;
        Node rootLeftRight=rootLeft.right;
        rootLeft.right=root;
        root.left=rootLeftRight;
        root.height=max(getHeight(root.left),getHeight(root.right))+1;
        root.sum=getSum(root.left)+getSum(root.right)+root.key*root.count;
        root.size=getSize(root.left)+getSize(root.right)+root.count;
        rootLeft.height=max(getHeight(rootLeft.left),getHeight(rootLeft.right))+1;
        rootLeft.sum=getSum(rootLeft.left)+getSum(rootLeft.right)+rootLeft.key*rootLeft.count;
        rootLeft.size=getSize(rootLeft.left)+getSize(rootLeft.right)+rootLeft.count;
        return rootLeft;
    }
    public Node insert(int key){
        Node insertNode=new Node(key);
        this.root= innerInsert(this.root,insertNode);
        return insertNode;
    }
    private Node innerInsert(Node current, Node insertNode){
        if(current==null)
            return insertNode;
        if(insertNode.key<current.key)
            current.left=innerInsert(current.left,insertNode);
        else if(insertNode.key>current.key)
            current.right=innerInsert(current.right,insertNode);
        else{
            current.count+=1;
            current.sum+=current.key;
            current.size+=1;
            return current;
        }


        current.height=max(getHeight(current.left),getHeight(current.right))+1;
        current.sum=getSum(current.left)+getSum(current.right)+current.key*current.count;
        current.size=getSize(current.left)+getSize(current.right)+current.count;
        int diff=getDiff(current);

        //left-left
        if(diff>1&&current.left.key>insertNode.key)
            return rotateRight(current);
        //right-right
        if(diff<-1&&current.right.key<insertNode.key)
            return rotateLeft(current);
        //left-right
        if(diff>1&&current.left.key<insertNode.key){
            current.left=rotateLeft(current.left);
            return rotateRight(current);
        }
        //right-left
        if(diff<-1&&current.right.key>insertNode.key) {
            current.right = rotateRight(current.right);
            return rotateLeft(current);
        }
        return current;
    }
    public void delete(int key){
        root=innerDelete(this.root,key);
    }
    private Node innerDelete(Node root,int key){
        if(root==null)
            return root;
        if(key<root.key)
            root.left=innerDelete(root.left,key);
        else if(key>root.key)
            root.right=innerDelete(root.right,key);
        else{
            if(root.count>1){
                root.count-=1;
                root.sum-=root.key;
                root.size-=1;
                return null;
            }

            if(root.size==1){
                root=null;
                return root;
            }
            else if(root.left!=null&&root.right!=null){
                Node tmp=getMin(root.right);
                root.key=tmp.key;
                root.right=innerDelete(root.right,tmp.key);
            }else{
                if(root.right!=null)
                    root=root.right;
                else
                    root=root.left;
            }
        }
            if(root==null)
                return root;
            root.height=max(getHeight(root.left),getHeight(root.right))+1;
            root.sum=getSum(root.left)+getSum(root.right)+root.key*root.count;
            root.size=getSize(root.left)+getSize(root.right)+root.count;
            int diff=getDiff(root);

            //left-left
            if(diff>1&&getDiff(root.left)>-1)
                return rotateRight(root);
            //right-right
            if(diff<-1&&getDiff(root.right)<1)
                return rotateLeft(root);
            //left-right
            if(diff>1&&getDiff(root.left)<0){
                root.left=rotateLeft(root.left);
                return rotateRight(root);
            }
            //right left
            if(diff<-1&&getDiff(root.right)>0){
                root.right=rotateRight(root.right);
                return rotateLeft(root);
            }

            return root;
    }
}

