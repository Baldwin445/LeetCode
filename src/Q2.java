import utils.ListNode;

public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0, count = 0;
        ListNode answer = null;
        while(l1 != null && l2 != null){
            count = l1.val + l2.val + add;
            if(count > 9) add = 1;
            else add = 0;
            answer = new ListNode(count%10, answer);
            answer = answer.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            count = add + l1.val;
            if(count > 9) add = 1;
            else add = 0;
            answer = new ListNode(count%10, answer);
            answer = answer.next;
            l1 = l1.next;
        }

        while (l2 != null){
            count = add + l2.val;
            if(count > 9) add = 1;
            else add = 0;
            answer = new ListNode(count%10, answer);
            answer = answer.next;
            l2 = l2.next;
        }

        if(add == 1) answer = new ListNode(1, answer);
        if(getValue(l1)+getValue(l2) == 0)
            return new ListNode(0);

        return answer;
    }





    public ListNode addTwoNumbersERROR(ListNode l1, ListNode l2) {
        //超出int范围，必定WA
        int a = getValue(l1), b = getValue(l2);
        long count = a+b;

        if(count == 0)
            return new ListNode(0);

        long temp = count, length=0;
        while (temp > 0){
            length++;
            temp/=10;
        }

        ListNode answer = null;
        while(length>0){
            length--;
            long div = (long) Math.pow(10,length);
            answer = new ListNode((int) (count/div), answer);
            count %= div;
        }
        return answer;

    }

    public int getValue(ListNode l1){
        int a=0, times=1;
        while (l1 != null){
            a += l1.val*times;
            l1 = l1.next;
            times*=10;
        }
        return a;
    }


}
