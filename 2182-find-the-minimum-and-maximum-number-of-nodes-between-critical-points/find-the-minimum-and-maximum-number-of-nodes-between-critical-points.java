/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head.next ;
        ArrayList<Integer> list = new ArrayList<>() ;
        int prev = head.val ;
        int i = 1 ;
        while( temp.next != null){
            if( (temp.val > prev && temp.val > temp.next.val) || (temp.val < prev && temp.val < temp.next.val) ) list.add(i) ;
            i++ ;
            prev = temp.val ;
            temp = temp.next ;
        }   

        int[] ans = new int[2] ;
        Arrays.fill(ans,-1) ;
        if( list.size() < 2 ) return ans ;
        int mindist = list.get(1)-list.get(0) ;
        for(i = 1 ; i < list.size()-1 ; i++){
            mindist = Math.min(mindist,list.get(i+1)-list.get(i)) ;
        }
        ans[0] = mindist ;
        ans[1] = list.get(list.size()-1) - list.get(0) ;

        return ans ;
    }
}