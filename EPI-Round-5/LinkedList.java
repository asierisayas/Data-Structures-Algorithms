/**
 * Merge Two Sorted Lists
 */
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode curr1 = l1;
    ListNode curr2 = l2;
    ListNode head = new ListNode(0);
    ListNode headCurr = head;
    
    while (curr1 != null && curr2 != null) {
        if (curr1.val <= curr2.val) {
            headCurr.next = curr1;
            curr1 = curr1.next;
        } else {
            headCurr.next = curr2;
            curr2 = curr2.next;
        }
        headCurr = headCurr.next;
    }
    
    headCurr.next = curr1 != null ? curr1 : curr2;
    
    return head.next;
}

/**
 * Reverse a single sublist
 */
public ListNode reverseList(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    ListNode next;
    
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    
    return prev;
}

/**
 * Test for cyclicity
 */
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

/**
 * Implement cyclic right shift for singly linked list
 */
public ListNode rotateRight(ListNode head, int k) {
    if (head == null)
        return head;
    
    int size = 1;
    ListNode curr = head;
    
    while (curr.next != null) {
        size++;
        curr = curr.next;
    }
    
    int shift = k % size;
    curr.next = head;
    curr = head;
    
    int moves = size - shift - 1;
    while (moves-- > 0) {
        curr = curr.next;
    }
    
    head = curr.next;
    curr.next = null;
    
    return head;
}

/**
 * Implement even-odd merge
 */
public ListNode oddEvenList(ListNode head) {
    ListNode oddHead = new ListNode(0);
    ListNode evenHead = new ListNode(0);
    ListNode oddCurr = oddHead;
    ListNode evenCurr = evenHead;
    ListNode curr = head;
    
    boolean isOdd = true;
    
    while (curr != null) {
        if (isOdd) {
            oddCurr.next = curr;
            oddCurr = oddCurr.next;
        } else {
            evenCurr.next = curr;
            evenCurr = evenCurr.next;
        }
        isOdd = !isOdd;
        curr = curr.next;
    }
    evenCurr.next = null;
    oddCurr.next = evenHead.next;
    
    return oddHead.next;
}

/**
 * Implement List Pivoting
 */
public ListNode partition(ListNode head, int x) {
    ListNode lessThanX = new ListNode(0);
    ListNode xOrGreater = new ListNode(0);
    ListNode currLess = lessThanX;
    ListNode currGreater = xOrGreater;
    ListNode curr = head;
    
    while (curr != null) {
        if (curr.val < x) {
            currLess.next = curr;
            currLess = currLess.next;
        } else {
            currGreater.next = curr;
            currGreater = currGreater.next;
        }
        curr = curr.next;
    }
    currGreater.next = null;
    currLess.next = xOrGreater.next;
    
    return lessThanX.next;
}

/**
 * Add List-Based Integers
 */
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode currOne = l1;
    ListNode currTwo = l2;
    ListNode newHead = new ListNode(0);
    ListNode curr = newHead;
    
    int carry = 0;
    int sum = 0;
    while (currOne != null || currTwo != null) {
        sum = carry;
        if (currOne != null) {
            sum += currOne.val;
            currOne = currOne.next;
        }
        
        if (currTwo != null) {
            sum += currTwo.val;
            currTwo = currTwo.next;
        }
        
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (sum > 9) {
            carry = 1;
        } else {
            carry = 0;
        }
    }
    
    if (carry == 1) {
        curr.next = new ListNode(1);
    }
    
    return newHead.next;
}