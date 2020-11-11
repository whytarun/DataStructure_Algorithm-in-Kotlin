package com.example.dsandalgo

import java.util.*

class TestArrays{
    fun main(){
        val arr = arrayOf(10,20,30,3)
        val missArr = arrayOf(1, 2, 4, 5, 6)
        val palStr = "madam"
        val missDuplArra = arrayOf(4, 3, 6, 2, 1, 1)
        val noOfThreshold =arrayOf(2,3,1,1,3)
        val max = findMax(arr,arr.size)
        val res =checkPalindraome(palStr)
        val miss = findMissingNo(missArr,missArr.size)
        duplAndMissingNums(missDuplArra,missDuplArra.size)
    }

    fun findMax(arrs :Array<Int>, length :Int) :Int{
        if (length == 1)
            return arrs.first()
          return max(findMax(arrs, length-1), arrs[length-1])
    }

    fun max(a1 : Int, a2 :Int): Int {
        if (a1 > a2)
            return a1
        return a2
    }

    fun reverseArray(lst :ArrayList<Int>, n:Int){
        for (i in lst.indices){
            // first value store in a variable
            if (i < n-1) {
                var t = lst[i]
                //last value to first
                lst[i] = lst[n - i - 1]
                //first value to last
                lst[n - i - 1] = t
            }
            println("After"+lst)
        }

    }

    fun checkPalindraome(str :String):Boolean{
            var i = 0
            var j = str.length-1
        while(i <j){
            if (str[i] != str[j])
                return false
            i = i+1
            j = j-1


        }
        return true
    }

    fun printSubStr(
        str: String, low: Int, high: Int
    ) {
        println(
            str.substring(
                low, high + 1
            )
        )
    }

    // This function prints the longest
    // palindrome substring of str[].
    // It also returns the length of the
    // longest palindrome
    fun longPalSubstring(str: String) :Int{
        val n = str.length

        val table = Array(n) {BooleanArray(n)}

        //if length =1
        var maxLength = 1
        for (i in 0 until n)
            table[i][i] = true

        // if length =2
        var start = 0
        for (i in 0 until n-1)
            if(str[i] == str[i+1]) {
                table[i][i + 1] = true
                start = i
                maxLength =2
            }

        //if length is >2
        // .. means till print from 0 to 10
        // until means it will print 0 to 9 [last value will be excluded]
        for ( k in 3..n){
            for ( i in 0 until n-k+1){
                val j = i + k - 1
                if (table[i + 1][j - 1]
                    && str[i] == str[j]){
                    table[i][j] = true
                    if(k> maxLength){
                        start = i
                        maxLength = k
                    }
                }
            }
        }
        print("Longest palindrome substring is; ")
        printSubStr(
            str, start,
            start + maxLength - 1
        )
        return maxLength
    }


    fun findMissingNo(arr :Array<Int>, n:Int) :Int{
        var i:Int
        var total: Int
        total = (n+1) * (n+2)/2
        i =0
        while(i < n) {
            total = total -arr[i]
            i++
           }
        return total
        }

     private fun duplAndMissingNums(arrs: Array<Int>, n :Int){
         val ht = Hashtable<Int,Boolean>()

         for ( i in arrs) {
              if (ht.get(i) == null)
                  ht.put(i,true)
             else
                  println("VALUE IS REPEATING="+i)
             }
         for (i  in 1..arrs.size) {
             if (ht[i] == null)
                 println("MISSING NUMBER="+i)
         }
     }

    fun mergeTwoSortedArrays(arr1 :Array<Int>, arr2: Array<Int>){
        val firstLen = arr1.size
        val secLen = arr2.size
        val merge =IntArray(firstLen + secLen)
        var i =0
        var j = 0
        var k= 0
        var x :Int
        print("Array 1: ")
        x =0
        while(x< firstLen){
            println(arr1[x].toString() + " ")
            x++
        }
        print("Array 2: ")
        x=0
        while(x <secLen){
            println(arr2[x].toString() +" ")
            x++
        }
        while( i < firstLen && j < secLen){
            if (arr1[i] < arr2[j])
                merge[k++] = arr1[i++]
            else
                merge[k++] = arr2[j++]
        }

        x =0
        while( x < firstLen+secLen){
            println("MERGE ARRAY"+merge[x].toString()+" ")
            x++
        }
    }

    //addition of two numbers

    val sum = { a: Int , b :Int -> a + b}


}

