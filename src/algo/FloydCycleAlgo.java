package algo;

import lombok.Data;

public class FloydCycleAlgo {
	@Data
	public static class ListNode<T> {
		private T val;
		private ListNode<T> next;
		
		public ListNode(T x) {
			val = x;
			next = null;
		}
		
		@Override
		public String toString() {
			return "val: " + val; 
		}
	}
	
	@Data
	public static class Result<T> {
		private ListNode<T> start;
		private int cycleLen;
		private boolean cycle;
		
		Result() {
			start = null;
			cycleLen = 0;
			cycle = false;
		}
	}
	
	public <T> Result<T> detectCycle(ListNode<T> head) {
		if (head == null) {
			return new Result<>();
		}
		
		ListNode<T> hare = head;
		ListNode<T> tortoise = head;
		while (hare != null) {
			tortoise = tortoise.next;
			if (hare.next != null) {
				hare = hare.next.next;
			} else {
				return new Result<>();
			}
			
			if (hare == tortoise) {
				Result result = new Result<>();
				result.cycle = true;
				ListNode<T> ptr = head;
				while (ptr != tortoise) {
					ptr = ptr.next;
					tortoise = tortoise.next;
				}
				result.start = ptr;
				
				int len = 0;
				do {
					ptr = ptr.next;
					++len;
				} while (ptr != tortoise);
				result.cycleLen = len;
				
				return result;
			}
		}
		return new Result<>();
	}
}
