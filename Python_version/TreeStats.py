class TreeStats:
    def getMin(self,root):
        if root.left==None:
            return root
        return self.getMin(root.left)
    
    def getHeight(self, root):
        if root==None:
            return 0
        return root.height
    
    def getSum(self, root):
        if root==None:
            return 0
        return root.sum
    
    def getSize(self, root):
        if root==None:
            return 0
        return root.size
    
    def getAvg(self, root):
        if root==None:
            return 0
        return root.sum/root.size
    
    def getMed(self, root):
        if root==None:
            return 0
        if root.size%2==1:
            return self.select(root,root.size//2+1).key
        else:
            return float(self.select(root,root.size//2).key+self.select(root,root.size//2+1).key)/2
    
    def select(self, root, rank):
        if root==None:
            return None
        if root.left!=None:
            r=root.left.size+1
        else:
            r=1
        if rank==r:
            return root
        elif rank<r:
            return self.select(root.left,rank)
        else:
            return self.select(root.right,rank-r)
    
    def getDiff(self, root):
        if root==None:
            return 0
        return self.getHeight(root.left)-self.getHeight(root.right)
    
    def searchSubtree(self, root, key):
        if root==None:
            return None
        if root.key==key:
            return root
        if key<root.key:
            return searchSubtree(root.left,key)
        else:
            return searchSubtree(root.right,key)
    
    def printTree(self, root):
        if root!=None:
            self.printTree(root.left)
            for i in range(0,root.count):
                print(root.key)
            self.printTree(root.right)



