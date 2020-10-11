package algo.test;

import org.junit.Test;

import algo.FloydCycleAlgo;
import algo.FloydCycleAlgo.ListNode;
import algo.FloydCycleAlgo.Result;

public class FloydCycleAlgoTest {
	@Test
	public void testFloydCycleAlgo() {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
	
		listNode1.setNext(listNode2);
		listNode2.setNext(listNode3);
	
		
		FloydCycleAlgo floydCycleAlgo = new FloydCycleAlgo();
		Result result = floydCycleAlgo.detectCycle(listNode1);
		System.out.println("cycle: " + result.isCycle() + " start: " + result.getStart() + " cycleLen: " + result.getCycleLen())
;		
	}
	
	
}
