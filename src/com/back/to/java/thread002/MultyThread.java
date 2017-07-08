package com.back.to.java.thread002;

public class MultyThread {

	private static int num = 0;
	
	
	//同步方法的锁是this--谁调就是谁
	//static synchronized 是本类的字节码
	public static synchronized void printNum(String tag) {
		try {
			if(tag.equals("a")) {
				num = 100;
				System.out.println("tag a set num");
				Thread.sleep(1000);
			}else {
				num = 200;
				System.out.println("tag b set num");
			}
			System.out.println("tag:" + tag +"    "+ "num:" +num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		MultyThread m1 = new MultyThread();
		MultyThread m2 = new MultyThread();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				MultyThread.printNum("a");
//				m1.printNum("a");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				MultyThread.printNum("b");
//				m2.printNum("b");
			}
		});
		
		t1.start();
		t2.start();
	}
}
