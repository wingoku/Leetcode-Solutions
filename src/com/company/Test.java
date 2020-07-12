package com.company;

class Test {
    Test t;
    public  Test getInstance() {
        if(t == null)
            t = new Test();
        return t;
    }

    public void test() {

        firstTest();
//       secondTest();
//       thirdTest();
    }

    private void firstTest() {
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(4);
        list1.next = list2;
        ListNode list3 = new ListNode(3);
        list2.next = list3;

        System.out.println("list1.val: "  + list1.val + " list2.val: "+ list1.next.val + " list3.val: "+ list2.next.val);

        ListNode list4 = new ListNode(5);
        ListNode list5 = new ListNode(6);
        list4.next = list5;
        ListNode list6 = new ListNode(4);
        list5.next = list6;

        addTwoNumbers(list1, list4);
        addTwoNumbersOnline(list1, list4);
    }

    private void secondTest() {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(8);
        list1.next = list2;
        ListNode list4 = new ListNode(0);

        addTwoNumbers(list1, list4);
    }

    private void thirdTest() {
        ListNode list1 = new ListNode(5);

        ListNode list4 = new ListNode(5);

        addTwoNumbers(list1, list4);
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int v) {
            val = v;
        }
    }

    public ListNode addTwoNumbersOnline(ListNode l1, ListNode l2) {

        long start = System.nanoTime();
        int carry = 0;
        ListNode emptyNode = new ListNode(0);
        ListNode currentNode = new ListNode(0);
        ListNode result = currentNode;
        while (emptyNode != l1 || emptyNode != l2) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            currentNode = (currentNode.next = new ListNode(sum %= 10));
            l1 = null != l1.next ? l1.next : emptyNode;
            l2 = null != l2.next ? l2.next : emptyNode;
        }
        if (carry == 1)
            currentNode.next = new ListNode(carry);

        long took = (System.nanoTime() - start);
        System.out.println("RESULT: took: "+ took);
        return result.next;
    }

    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {

        long start = System.nanoTime();
        ListNode traverse1 = list1;
        ListNode traverse2 = list2;

        int carry = 0;
        ListNode testResult = new ListNode(0);
        ListNode first = testResult;
        ListNode last = null;

//        System.out.println("");
        while(traverse1 != null || traverse2 != null) {
            int val1 = 0;
            int val2 = 0;

            if(traverse1 != null) {
                val1 = traverse1.val;
                traverse1 = traverse1.next;
            }

            if(traverse2 != null) {
                val2 = traverse2.val;
                traverse2 = traverse2.next;
            }

            int sum = val1+val2+carry;
            testResult.val = sum % 10;

            carry = sum / 10;
//            System.out.println("sum: "+ testResult.val + " carry: "+ carry);

            testResult.next = new ListNode(carry);
            last = testResult;
            testResult = testResult.next;
        }
        if(last.next != null && last.next.val == 0)
            last.next = null;


        long took = (System.nanoTime() - start);
        System.out.println("Mine RESULT: took: "+ took);
//        while(first != null) {
//            System.out.print(first.val+",");
//            first = first.next;
//        }

        return null;

    }
}