package site.systemDesign.lruCache;

public class ListNode<T> {
    public T value;
    public ListNode<T> prev;
    public ListNode<T> next;
    public int val;

    public ListNode(T value, ListNode<T> prev, ListNode<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public ListNode() {

    }
}