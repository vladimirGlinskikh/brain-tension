package kz.zhelezyaka.addTwoNumbers;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Используем фиктивный заголовочный узел, чтобы упростить создание нового списка
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        int carry = 0; // Переменная для хранения переноса

        // Пока есть ненулевые узлы в одном из списков или есть перенос
        while (l1 != null || l2 != null || carry > 0) {
            // Берём текущие цифры (если узел закончился, то берём 0)
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Считаем сумму текущей позиции + перенос
            int sum = x + y + carry;
            carry = sum / 10; // Вычисляем перенос (например, 15 -> перенос 1)
            int remainder = sum % 10; // Остаточная цифра (например, 15 -> цифра 5)

            // Добавляем новую вершину в результирующий список
            current.next = new ListNode(remainder);
            current = current.next;

            // Двигаемся вперёд по спискам, если они ещё не кончились
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Возвращаем голову результирующего списка (пропуская фиктивную головную вершину)
        return dummyHead.next;
    }
}