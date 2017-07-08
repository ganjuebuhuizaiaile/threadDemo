package com.back.to.java.thread003;

public class RunThread extends Thread {
	/*volatile强制让线程去主内存里操作值*/
	/*本来是每个线程放了一个线程要用的变量的拷贝，运行时直接去自己的线程块儿操作（JDK1.5以后的修改）*/
	private boolean isRunning = true;

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		System.out.println("进入run");
		while(isRunning == true) {
			
		}
		System.out.println("退出run");
	}
	
	public static void main(String[] args) throws InterruptedException {
		RunThread thread = new RunThread();
		
		thread.start();
		
		Thread.sleep(1000);
		
		thread.setRunning(false);
		
		System.out.println(thread.isRunning);
	}
}
