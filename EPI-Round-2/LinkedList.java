//8.3 Test for cyclicity
//Write a program that takes LL and returns if there's a cycle or not
public boolean hasCycle(ListNode head) {
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            return true;
        }
    }
    
    return false;
}
/*
8.4 Test for overlapping Lists - no cycle
Write a program that takes two cycle-free LL and determines if there
exists a node that is common to both lists
*/
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null)
        return null;
    
    int lenA = getLength(headA);
    int lenB = getLength(headB);
    
    ListNode currA = headA;
    ListNode currB = headB;
    
    if (lenA > lenB) {
        for (int i = 0; i < lenA - lenB; i++) {
            currA = currA.next;
        }
    }
    
    if (lenB > lenA) {
        for (int i = 0; i < lenB - lenA; i++) {
            currB = currB.next;
        }
    }
    
    while (currA != null) {
        if (currA == currB)
            return currA;
        currA = currA.next;
        currB = currB.next;
    }
    
    return null;
}

public int getLength(ListNode head) {
    int count = 0;
    ListNode curr = head;
    while (curr != null) {
        count++;
        curr = curr.next;
    }
    
    return count;
}

/*
8.8 Remove Duplicates from a Sorted List
Write a program that takes as input a signly linked list of integers
in sorted order, and removes duplicates from it. 
*/
public ListNode deleteDuplicates(ListNode head) {
    if (head == null)
        return null;
    ListNode curr = head;
    
    while (curr.next != null) {
        if (curr.val == curr.next.val) {
            curr.next = curr.next.next;
        } else {
            curr = curr.next;
        }
    }
    
    return head;
}

/*
8.9 Implement a Cyclic Right Shift for Singly Linked Lists
Write a program that takes as input a LL and a nonnegative integer k, 
and returns the list cyclically shifted to the right by k. 
*/
public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

    int count = 1;
    ListNode curr = head;
    while (curr.next != null) {
        count++;
        curr = curr.next;
    }
    curr.next = head;
    curr = head;
    k %= count;
    for (int i = 0; i < k; i++) {
        curr = curr.next;
    }
    
    ListNode newHead = curr.next;
    curr.next = null;
    
    return newHead;
}

/*
8.12 Implement list pivoting
Implement a function which takes as input a singly linked list and an integer
k and performs a pivot of the list with respect to k. The relative ordering
of nodes appear before k, and after k, must remain unchanged; the same
must hold for nodes holding keys equal to k. 
*/
public ListNode partition(ListNode head, int x) {
    ListNode l1 = new ListNode(0);
    ListNode newHead = l1;
    ListNode l2 = new ListNode(0);
    ListNode l2head = l2;
    
    ListNode curr = head;
    while (curr != null) {
        if (curr.val < x) {
            l1.next = curr;
            l1 = l1.next;
        } else {
            l2.next = curr;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    l2.next = null;
    l1.next = l2head.next;
    
    return newHead.next;
}