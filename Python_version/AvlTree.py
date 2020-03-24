from TreeStats import TreeStats
from Node import Node
class AvlTree (TreeStats):
   # private Node root
    def __init__(self):
       self.root=None
    def max(a, b):
        if a>b:
            return a
        return b
    
    def getRoot(self):
        return self.root
    
    def printAvlTree(self):
        self.printTree(self.root)
    
    def innerToString(self,string,root):
        if root==None:
            return string
        string=self.innerToString(string,root.left)
        if string!=None:
            string+=str(root.key)
        else:
            string=str(root.key)
        string+=" "
        string=self.innerToString(string,root.right)
        return string
    
    def toString(self):
        str=""
        str=self.innerToString(str,self.root)
        if len(str)>0:
            str=str[:-1]
        return str
    
    def search(self,key):
        return searchSubtree(self.root,key)
    
    def rotateLeft(self,root):
        rootRight=root.right
        rootRightLeft=rootRight.left
        rootRight.left=root
        root.right=rootRightLeft
        root.height=max(self.getHeight(root.left),self.getHeight(root.right))+1
        root.sum=self.getSum(root.left)+self.getSum(root.right)+root.key*root.count
        root.size=self.getSize(root.left)+self.getSize(root.right)+root.count
        rootRight.height=max(self.getHeight(rootRight.left),self.getHeight(rootRight.right))+1
        rootRight.sum=self.getSum(rootRight.left)+self.getSum(rootRight.right)+root.key*rootRight.count
        rootRight.size=self.getSize(rootRight.left)+self.getSize(rootRight.right)+rootRight.count
        return rootRight
    
    def rotateRight(self,root):
        rootLeft=root.left
        rootLeftRight=rootLeft.right
        rootLeft.right=root
        root.left=rootLeftRight
        root.height=max(self.getHeight(root.left),self.getHeight(root.right))+1
        root.sum=self.getSum(root.left)+self.getSum(root.right)+root.key*root.count
        root.size=self.getSize(root.left)+self.getSize(root.right)+root.count
        rootLeft.height=max(self.getHeight(rootLeft.left),self.getHeight(rootLeft.right))+1
        rootLeft.sum=self.getSum(rootLeft.left)+self.getSum(rootLeft.right)+rootLeft.key*rootLeft.count
        rootLeft.size=self.getSize(rootLeft.left)+self.getSize(rootLeft.right)+rootLeft.count
        return rootLeft
    
    def innerInsert(self,current, insertNode):
        if current==None:
            return insertNode
        if insertNode.key<current.key:
            current.left=self.innerInsert(current.left,insertNode)
        elif insertNode.key>current.key:
            current.right=self.innerInsert(current.right,insertNode)
        else:
            current.count+=1
            current.sum+=current.key
            current.size+=1
            return current
        


        current.height=max(self.getHeight(current.left),self.getHeight(current.right))+1
        current.sum=self.getSum(current.left)+self.getSum(current.right)+current.key*current.count
        current.size=self.getSize(current.left)+self.getSize(current.right)+current.count
        diff=self.getDiff(current)

        #left-left
        if diff>1 and current.left.key>insertNode.key:
            return self.rotateRight(current)
        #right-right
        if diff<-1 and current.right.key<insertNode.key:
            return self.rotateLeft(current)
        #left-right
        if diff>1 and current.left.key<insertNode.key:
            current.left=self.rotateLeft(current.left)
            return self.rotateRight(current)
        
        #right-left
        if diff<-1 and current.right.key>insertNode.key:
            current.right = self.rotateRight(current.right)
            return self.rotateLeft(current)
        
        return current

    def insert(self,key):
        insertNode=Node(key)
        self.root= self.innerInsert(self.root,insertNode)
        return insertNode

    def delete(self,key):
       self.root= self.innerDelete(self.root,key)
    
    def innerDelete(self, root, key):
        if root==None:
            return root
        if key<root.key:
            root.left=self.innerDelete(root.left,key)
        elif key>root.key:
            root.right=self.innerDelete(root.right,key)
        else:
            if root.count>1:
                root.count-=1
                root.sum-=root.key
                root.size-=1
                return root
            

            if root.size==1:
                root=None
                return root
            
            elif root.left!=None and root.right!=None:
                tmp=self.getMin(root.right)
                root.key=tmp.key
                root.right=self.innerDelete(root.right,tmp.key)
            else:
                if root.right!=None:
                    root=root.right
                else:
                    root=root.left
            
            
        if root==None:
            return root
        root.height=max(self.getHeight(root.left),self.getHeight(root.right))+1
        root.sum=self.getSum(root.left)+self.getSum(root.right)+root.key*root.count
        root.size=self.getSize(root.left)+self.getSize(root.right)+root.count
        diff=self.getDiff(root)

        #left-left
        if diff>1 and self.getDiff(root.left)>-1:
            return self.rotateRight(root)
        #right-right
        if diff<-1 and self.getDiff(root.right)<1:
            return self.rotateLeft(root)
        #left-right
        if diff>1 and self.getDiff(root.left)<0:
            root.left=rotateLeft(root.left)
            return self.rotateRight(root)
            
        #right left
        if diff<-1 and self.getDiff(root.right)>0:
            root.right=rotateRight(root.right)
            return self.rotateLeft(root)
        return root
    





