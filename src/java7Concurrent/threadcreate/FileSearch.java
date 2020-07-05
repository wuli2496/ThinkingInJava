package java7Concurrent.threadcreate;

import java.io.File;

public class FileSearch implements Runnable {
	
	private String initPath;
	private String fileName;
	
	public FileSearch(String initPath, String fileName) {
		this.initPath = initPath;
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		File file = new File(initPath);
		if (file.isDirectory()) {
			try {
				directoryProcess(file);
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.printf("%s : The search has been interrupted\n", Thread.currentThread().getName());
			}
		}
	}

	private void directoryProcess(File file) throws InterruptedException {
		File[] list = file.listFiles();
		if (list != null) {
			for (File fi : list) {
				if (fi.isDirectory()) {
					directoryProcess(fi);
				} else {
					fileProcess(file);
				}
			}
		}
		
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}
	
	private void fileProcess(File file) throws InterruptedException {
		if (file.getName().equals(fileName)) {
			System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
		}
		
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}
}
