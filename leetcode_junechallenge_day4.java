// Reverse String

/*
 * Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 *
*/


/*
 * In this question we will use two pointer approach, first pointer will start from index 0 and second pointer
 * will start from index (length-1) . We will keep swapping the elements until the first pointer doesnot 
 * cross the second pointer.
 */
class Solution {
    public void reverseString(char[] s) {
        int arrayLength = s.length;
        if (arrayLength > 1) {
            int i = 0;
            int j = arrayLength - 1;

            while (i <= j) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }

        }
    }
}
