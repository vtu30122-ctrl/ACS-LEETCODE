class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Find the kth node
        ListNode kth = head;

        for (int i = 0; i < k; i++) {
            if (kth == null) {
                return head;
            }
            kth = kth.next;
        }

        // Reverse the k nodes
        ListNode prev = kth;
        ListNode current = head;

        while (current != kth) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Recursively reverse the remaining groups
        head.next = reverseKGroup(kth, k);

        return prev;
    }
}