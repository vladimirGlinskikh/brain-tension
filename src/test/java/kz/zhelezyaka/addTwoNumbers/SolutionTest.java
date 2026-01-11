package kz.zhelezyaka.addTwoNumbers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    // Вспомогательный метод для преобразования массива в связанный список
    private ListNode arrayToList(int[] arr) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummyHead.next;
    }

    // Вспомогательный метод для перевода связанного списка в строку
    private String listToString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(" ");
            node = node.next;
        }
        return sb.toString().trim();
    }

    @Test
    void addTwoNumbers() {
        // Пример 1: 342 + 465 = 807
        ListNode l1 = arrayToList(new int[]{2, 4, 3});
        ListNode l2 = arrayToList(new int[]{5, 6, 4});
        ListNode result = Solution.addTwoNumbers(l1, l2);
        assertEquals("7 0 8", listToString(result));

        // Пример 2: 0 + 0 = 0
        l1 = arrayToList(new int[]{0});
        l2 = arrayToList(new int[]{0});
        result = Solution.addTwoNumbers(l1, l2);
        assertEquals("0", listToString(result));

        // Пример 3: 9999999 + 9999 = 10009998
        l1 = arrayToList(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = arrayToList(new int[]{9, 9, 9, 9});
        result = Solution.addTwoNumbers(l1, l2);
        assertEquals("8 9 9 9 0 0 0 1", listToString(result));
    }
}