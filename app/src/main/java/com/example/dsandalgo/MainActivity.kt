package com.example.dsandalgo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tree = BinaryTree()
        tree.main()
        val myArray =TestArrays()
        myArray.main()

        val a1 = a
        a1.main(arrayOf("5","2","3","1","1","3"))
    }


    fun getMiddleElement(){
        var list : MyLinkedlist = MyLinkedlist()
        list.addFirst(7)
        list.addFirst(8)
        list.addFirst(1)
        list.addFirst(5)
        list.addFirst(2)
        list.findMiddleElement()
    }

    fun getIntersectionNode(){
        var list1 : MyLinkedlist = MyLinkedlist()
        list1.addFirst(15)
        list1.addFirst(10)
        list1.addFirst(9)
        list1.addFirst(6)
        list1.addFirst(5)
        list1.addFirst(2)
        list1.addFirst(3)

        var list2: MyLinkedlist = MyLinkedlist().apply {
            addFirst(15)
            addFirst(10)
            addFirst(9)
            addFirst(4)
            addFirst(8)
        }

        val ht= Hashtable<String,MyLinkedlist.Node>()
        var count =0
         while(list1.size() != 0){
             ht.put(count.toString(),list1.getNodeAt(count))
             count++
         }
        var cnt =0
        while(list2.size() !=0){
            if (ht.containsValue(list2.getNodeAt(cnt))){
                println("FIND INTER"+list2.getNodeAt(cnt))
            }
            cnt++
        }
    }



}
