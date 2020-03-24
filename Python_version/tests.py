import unittest
from AvlTree import AvlTree
class tests(unittest.TestCase):
    def test_add1(self):
        tree=AvlTree()
        tree.insert(12)
        tree.insert(1)
        tree.insert(5)
        self.assertEqual("1 5 12",tree.toString())

    def test_add2(self):
        tree=AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        self.assertEqual("0 1 2 3 4 5 6 7 8 9 10",tree.toString())

    def test_delete1(self):
        tree=AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        tree.delete(5)
        self.assertEqual("0 1 2 3 4 6 7 8 9 10",tree.toString())

    def test_delete2(self):
        tree=AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        tree.delete(5)
        tree.delete(10)
        tree.delete(0)
        self.assertEqual("1 2 3 4 6 7 8 9",tree.toString())

    def test_delete3(self):
        tree=AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        for i in range(10,-1,-1):
            tree.delete(i)
        self.assertEqual("",tree.toString())

    def test_sum1(self):
        tree=AvlTree()
        tree.insert(156)
        tree.insert(999)
        self.assertEqual(1155,tree.getSum(tree.getRoot()))
    
    
    def test_sum2(self):
        tree=AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        self.assertEqual(55,tree.getSum(tree.getRoot()))
    
    
    def test_sum3(self):
        tree= AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        tree.delete(0)
        self.assertEqual(55,tree.getSum(tree.getRoot()))
    
    
    def test_sum4(self):
        tree= AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        tree.delete(9)
        tree.delete(1)
        self.assertEqual(45,tree.getSum(tree.getRoot()))
    
    
    def test_avg1(self):
        tree= AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        self.assertEqual(5.0,tree.getAvg(tree.getRoot()),0.00001)
    
    
    def test_avg2(self):
        tree= AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        tree.delete(0)
        self.assertEqual(5.5,tree.getAvg(tree.getRoot()),0.00001)
    
    
    def test_avg3(self):
        tree= AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        for i in range(0,11):
            tree.delete(i)
        self.assertEqual(0,tree.getAvg(tree.getRoot()),0.00001)
    
    
    def test_med1(self):
        tree= AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        self.assertEqual(5.0,tree.getMed(tree.getRoot()),0.00001)
    
    
    def test_med2(self):
        tree= AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        tree.delete(5)
        self.assertEqual(5.0,tree.getMed(tree.getRoot()),0.00001)
    
    
    def test_med3(self):
        tree= AvlTree()
        for i in range(10,-1,-1):
            tree.insert(i)
        for i in range(1,11):
            tree.delete(i)
        self.assertEqual(0,tree.getMed(tree.getRoot()),0.00001)
    
    
    def test_med4(self):
        tree= AvlTree()
        for i in range(1,11):
            tree.insert(i)
        self.assertEqual(5.5,tree.getMed(tree.getRoot()),0.00001)
    
    
    def test_med5(self):
        tree= AvlTree()
        for i in range(1,13):
            tree.insert(i)
        self.assertEqual(6.5,tree.getMed(tree.getRoot()),0.00001)
    
    
    def searchTest01(self):
        tree= AvlTree()
        for i in range(1,13):
            tree.insert(i)
        self.assertEqual(5,tree.search(5).key)
    





    
   

    

if __name__ == '__main__':
    unittest.main()
