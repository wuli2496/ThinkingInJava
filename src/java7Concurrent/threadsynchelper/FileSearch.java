package java7Concurrent.threadsynchelper;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable {
	private String initPath;
	private String end;
	private List<String> results;
	private Phaser phaser;
	
	public FileSearch(String initPath, String end, Phaser phaser) {
		// TODO Auto-generated constructor stub
		this.initPath = initPath;
		this.end = end;
		this.phaser = phaser;
		results = new ArrayList<>();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		phaser.arriveAndAwaitAdvance();
		
		System.out.printf("%s: Starting.\n", Thread.currentThread().getName());
		File file = new File(initPath);
		if (file.isDirectory()) {
			directoryProcess(file);
		} else {
			fileProcess(file);
		}
		
		if (!checkResults()) {
			return;
		}
		
		filterResults();
		
		if (!checkResults()) {
			return;
		}
		
		showInfo();
		phaser.arriveAndDeregister();
		System.out.printf("%s: Work completed.\n", Thread.currentThread().getName());
	}
	
	private void directoryProcess(File file) {
		File[] list = file.listFiles();
		if (list != null) {
			for (File fi : list) {
				if (fi.isDirectory()) {
					directoryProcess(fi);
				} else {
					fileProcess(fi);
				}
			}
		}
		
	}
	
	private void fileProcess(File file) {
		if (file.getName().endsWith(end)) {
			results.add(file.getAbsolutePath());
		}
		
	}
	
	private void filterResults() {
		List<String> newResults = new ArrayList<>();
		long actualDate = new Date().getTime();
		
		for (int i = 0; i < results.size(); ++i) {
			File file = new File(results.get(i));
			long fileDate = file.lastModified();
			if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1,  TimeUnit.DAYS)) {
				newResults.add(results.get(i));
			}
		}
		
		results = newResults;
	}
	
	private boolean checkResults() {
		if (results.isEmpty()) {
			System.out.printf("%s: Phase %d: 0 results.\n", Thread.currentThread().getName(),
					phaser.getPhase());
			System.out.printf("%s: Phase %d: End.\n", Thread.currentThread().getName(), phaser.getPhase());
			phaser.arriveAndDeregister();
			return false;
		} else {
			System.out.printf("%s : Phase %d: %d results.\n", Thread.currentThread().getName(),
					phaser.getPhase(), results.size());
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}
	
	private void showInfo() {
		for (int i = 0; i < results.size(); ++i) {
			File file = new File(results.get(i));
			System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
		}
		phaser.arriveAndAwaitAdvance();
	}
}
