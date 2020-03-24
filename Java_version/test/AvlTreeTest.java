import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AvlTreeTest {
    @Test
    public void AddTest01(){
        AvlTree tree=new AvlTree();
        tree.insert(12);
        tree.insert(1);
        tree.insert(5);
        assertEquals("1 5 12",tree.toString());
    }
    @Test
    public void AddTest02(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        assertEquals("0 1 2 3 4 5 6 7 8 9 10",tree.toString());
    }
    @Test
    public void DeleteTest01(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        tree.delete(5);
        assertEquals("0 1 2 3 4 6 7 8 9 10",tree.toString());
    }
    @Test
    public void DeleteTest02(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        tree.delete(5);
        tree.delete(10);
        tree.delete(0);
        assertEquals("1 2 3 4 6 7 8 9",tree.toString());
    }
    @Test
    public void sumTest01(){
        AvlTree tree=new AvlTree();
        tree.insert(156);
        tree.insert(999);
        assertEquals(1155,tree.getSum(tree.getRoot()));
    }
    @Test
    public void sumTest02(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        assertEquals(55,tree.getSum(tree.getRoot()));
    }
    @Test
    public void sumTest03(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        tree.delete(0);
        assertEquals(55,tree.getSum(tree.getRoot()));
    }
    @Test
    public void sumTest04(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        tree.delete(9);
        tree.delete(1);
        assertEquals(45,tree.getSum(tree.getRoot()));
    }
    @Test
    public void avgTest01(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        assertEquals(5.0,tree.getAvg(tree.getRoot()),0.00001);
    }
    @Test
    public void avgTest02(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        tree.delete(0);
        assertEquals(5.5,tree.getAvg(tree.getRoot()),0.00001);
    }
    @Test
    public void avgTest03(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        for(int i=0;i<11;i++)
        tree.delete(i);
        assertEquals(0,tree.getAvg(tree.getRoot()),0.00001);
    }
    @Test
    public void medTest01(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        assertEquals(5.0,tree.getMed(tree.getRoot()),0.00001);
    }
    @Test
    public void medTest02(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        tree.delete(5);
        assertEquals(5.0,tree.getMed(tree.getRoot()),0.00001);
    }
    @Test
    public void medTest03(){
        AvlTree tree=new AvlTree();
        for(int i=10;i>-1;i--)
            tree.insert(i);
        for(int i=0;i<11;i++)
            tree.delete(i);
        assertEquals(0,tree.getMed(tree.getRoot()),0.00001);
    }
    @Test
    public void medTest04(){
        AvlTree tree=new AvlTree();
        for(int i=1;i<11;i++)
            tree.insert(i);
        assertEquals(5.5,tree.getMed(tree.getRoot()),0.00001);
    }
    @Test
    public void medTest05(){
        AvlTree tree=new AvlTree();
        for(int i=1;i<13;i++)
            tree.insert(i);
        assertEquals(6.5,tree.getMed(tree.getRoot()),0.00001);
    }
    @Test
    public void searchTest01(){
        AvlTree tree=new AvlTree();
        for(int i=1;i<13;i++)
            tree.insert(i);
        assertEquals(5,tree.search(5).key);
    }

}
