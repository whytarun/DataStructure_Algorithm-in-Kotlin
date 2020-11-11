package com.example.dsandalgo

class MyLinkedlist {
     inner class Node internal constructor(data: Int){
            var data = 0
            var next : Node? = null
         init {
             this.data = data
         }
     }

    private var head: Node? = null
    private var tail: Node? = null
    private var elementCount: Int = 0

    /* basic methods*/
     public fun size(): Int{
        return elementCount
    }

    private fun isEmpty(): Boolean {
        return elementCount == 0
    }

    override fun toString(): String {
        var curr :Node? = head
        var sb = StringBuilder()
        sb.append("[")
        while(curr != null){
            sb.append(curr.data)
            if(curr.next != null){
                sb.append(",")
            }
            curr = curr.next
        }
        sb.append("]")
        return sb.toString()
    }
    /*adds and mods methods*/

    fun addFirstNode(node :Node){
        if(head == null){
            head = node
            tail = node
        }else {
            node.next = head
            head = node
        }
        elementCount++
    }

    fun addFirst(value :Int){
        val node = Node(value)
        addFirstNode(node)
    }

    fun addLastNode(node:Node){
        if (head == null){
            head = node
            tail = node
        }else if (head == tail){
            head!!.next = node
            tail = node
        }else{
            node.next = tail
            tail = node
        }
        elementCount++
    }

    fun addLast(value: Int){
        val node =Node(value)
        addLastNode(node)
    }

    fun addNodeAt(node: Node, idx: Int){
        if(idx == 0)
            addFirstNode(node)
        else if (idx == elementCount)
            addLastNode(node)
        else{
            val prev =getNodeAt(idx-1)
            val curr =prev.next
            prev.next = node
            node.next =curr
        }
    }

    @Throws(Exception::class)
    fun addAt(idx: Int, data: Int){
        if(idx < 0 || idx > elementCount){
            throw java.lang.Exception("Invalid location")
        }
        val node =Node(data)
        addNodeAt(node,idx)
    }

    /* remove */
    fun removeFirstNode() :Node{
        val node: Node = head!!
        if(elementCount == 1){
            head = null
            tail = null
        }else {
            head = head!!.next
            node!!.next = null

        }
        elementCount--
        return node
    }
    //.get
    @Throws(Exception::class)
    fun getNodeAt(idx: Int) :Node{
        var idx =idx
        var curr =head
        while (idx-- > 0){
            curr =curr!!.next
        }
        return curr!!
    }

    /*find the middle element*/

    fun findMiddleElement(){
        var slow = head!!
        var fast = head!!
        while(fast != null && fast.next != null){
            fast = fast.next!!.next!!
            slow = slow.next!!
        }
        println("MIDDLE VALUE="+slow.data)
    }


}