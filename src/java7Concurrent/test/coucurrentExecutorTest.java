package java7Concurrent.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import java7Concurrent.Executor.FactorialCalculator;
import java7Concurrent.Executor.ResultTask;
import java7Concurrent.Executor.Server;
import java7Concurrent.Executor.Task;
import java7Concurrent.Executor.TaskValidator;
import java7Concurrent.Executor.UserValidator;

public class coucurrentExecutorTest {
	
	@Test
	public void testExecutor() {
		Server server = new Server();
		final int N = 100;
		for (int i = 0; i < N; ++i) {
			Task task = new Task("Task " + i);
			server.executeTask(task);
		}
		
		server.endServer();
	}
	
	@Test
	public void testCallable() {
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
		
		List<Future<Integer>> resultLists = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 10; ++i) {
			Integer number = random.nextInt(10);
			System.out.printf("Task %d, number:%d\n", i, number);
			FactorialCalculator calculator = new FactorialCalculator(number);
			Future<Integer> result = executor.submit(calculator);
			resultLists.add(result);
		}
		
		do {
			System.out.printf("Main: Number of Completed Tasks: %d\n", executor.getCompletedTaskCount());
			for (int i = 0; i < resultLists.size(); ++i) {
				Future<Integer> result = resultLists.get(i);
				System.out.printf("Main: Task %d: done: %s\n", i, result.isDone());
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (executor.getCompletedTaskCount() < resultLists.size());
		
		System.out.printf("Main: Results\n");
		for (int i = 0; i < resultLists.size(); ++i) {
			Future<Integer> result = resultLists.get(i);
			Integer number = null;
			try {
				number = result.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			
			System.out.printf("Main: Task %d, result: %d\n", i, number);
		}
		
		executor.shutdown();
		
		try {
			executor.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCallableString() {
		String username = "test";
		String password = "test";
		
		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("DataBase");
		
		TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
		TaskValidator dbTask = new TaskValidator(dbValidator, username, password);
		
		List<TaskValidator> taskList = new ArrayList<>();
		taskList.add(ldapTask);
		taskList.add(dbTask);
		
		ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();
		String result;
		
		try {
			result = executor.invokeAny(taskList);
			System.out.printf("Main: Result: %s\n", result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		executor.shutdown();
		System.out.printf("Main: End of the Execution\n");
	}
}
