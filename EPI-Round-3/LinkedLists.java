/*
8.1 Merge two sorted lists
*/
public Node mergeLists(Node first, Node snd) {

    Node dummy = new Node(0);
    Node curr = dummy;

    while (first != null && snd != null) {
        if (first.val <= snd.val) {
            curr.next = first;
            first = first.next;
        } else {
            curr.next = snd;
            snd = snd.next;
        }

        curr = curr.next;
    }

    curr.next = first != null ? first : snd;

    return dummy.next;
}

/*
8.9 Implement cyclic right shift for singly linked list
*/
public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k < 1) {
        return head;
    }
    ListNode curr = head;
    int count = 1;
    while (curr.next != null) {
        curr = curr.next;
        count++;
    }
    curr.next = head;
    
    k %= count;
    
    int stepsToNewHead = count - k;
    curr = head;
    
    while (--stepsToNewHead > 0) {
        curr = curr.next;
    }
    
    ListNode newHead = curr.next;
    curr.next = null;
    
    return newHead;
    
}