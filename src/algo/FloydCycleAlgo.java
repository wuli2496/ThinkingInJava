package algo;

import lombok.Data;

public class FloydCycleAlgo {
	@Data
	public static class ListNode {
		private int val;
		private ListNode next;
		
		public ListNode(int x) {
			val = x;
			next = null;
		}
		
		@Override
		public String toString() {
			return "val: " + val; 
		}
	}
	
	@Data
	public static class Result {
		private ListNode start;
		private int cycleLen;
		private boolean cycle;
		
		Result() {
			start = null;
			cycleLen = 0;
			cycle = false;
		}
	}
	
	public Result detectCycle(ListNode head) {
		if (head == null) {
			return new Result();
		}
		
		ListNode hare = head;
		ListNode tortoise = head;
		while (hare != null) {
			tortoise = tortoise.next;
			if (hare.next != null) {
				hare = hare.next.next;
			} else {
				return new Result();
			}
			
			if (hare == tortoise) {
				Result result = new Result();
				result.cycle = true;
				ListNode ptr = head;
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
		return new Result();
	}
}
