package com.example.dsandalgo

 class BinarySearch {
    // Returns index of x if it is present in arr[],
    // else return -1
    fun binarySearch(arr: IntArray, x: Int): Int {
        var l = 0
        var r = arr.size - 1
        while (l <= r) {
            val m = l + (r - l) / 2

            // Check if x is present at mid
            if (arr[m] == x)
                return m

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1
            else
                r = m - 1
        }

        // if we reach here, then element was
        // not present
        return -1
    }

    companion object {
        // Driver method to test above
        @JvmStatic
        fun main(args: Array<String>) {
            val ob = BinarySearch()
            val arr = intArrayOf(2, 3, 4, 10, 40)
            val n = arr.size
            val x = 10
            val result = ob.binarySearch(arr, x)
            if (result == -1) println("Element not present") else println(
                "Element found at "
                        + "index " + result
            )
        }
    }
}