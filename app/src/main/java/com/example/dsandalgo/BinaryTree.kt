package com.example.dsandalgo

 class Node(var data: Int) {
    var left: Node?
    var right: Node? = null

    init {
        left = right
    }
}

 class BinaryTree {
    var root: Node? = null

       fun main(){
         val tree = BinaryTree()
         tree.root = Node(2)
         tree.root!!.left = Node(7)
         tree.root!!.right = Node(5)
         tree.root!!.left!!.right = Node(6)
         tree.root!!.left!!.right!!.left = Node(1)
         tree.root!!.left!!.right!!.right = Node(11)
         tree.root!!.right!!.right = Node(9)
         tree.root!!.right!!.right!!.left = Node(4)
           println("MAX value" +findMax(tree.root))
           println("Min value" +findMin(tree.root))

     }

     fun findMax(node: Node?):Int {
         if (node == null)
             return Int.MIN_VALUE
         var res = node.data
         val lres =findMax(node.left)
         val rres = findMax(node.right)
         if (lres > res)
             res = lres
         if (rres > res)
             res = rres
         return res
     }

     fun findMin(node: Node?):Int{
         if(node == null)
             return Int.MAX_VALUE

         var resMin =node.data
         var lres = findMin(node.left)
         var rres = findMin(node.right)
         if (lres < resMin)
             resMin = lres
         if (rres < resMin)
             resMin = rres
         return resMin


     }

     fun findHeight(node: Node?) : Int{
         if(node == null)
             return 0
         var lh =findHeight(node.left)
         var rh = findHeight(node.right)

         if (lh > rh)
             return lh+1
         else if (rh > lh)
             return rh+1
        return 0
     }

     fun searchkey(node: Node?, key:Int) : Node? {
         if(node == null || node.data == key)
             return node

         if (root!!.data > key)
             return searchkey(root!!.left, key)

         return searchkey(root!!.right, key)

     }

     fun insertNode(node: Node?, key: Int) :Node? {
         //if root is null then tree is empty send
         if(node == null)
             return Node(key)

         if(key < node.data)
             node.left =insertNode(node.left,key)
         else if  (key > node.data)
             node.right = insertNode(node.right,key)

         return node
     }


 }