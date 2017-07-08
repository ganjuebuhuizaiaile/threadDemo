package com.back.to.java.thread004;

import java.util.concurrent.atomic.AtomicInteger;

public class VolitileNoAtomic extends Thread {

	private static volatile int count = 0;
//	private static AtomicInteger count = new AtomicInteger(0);
	
	private static void addCount() {
		for(int i = 0; i<1000; i++) {
			count++;
//			count.incrementAndGet();
		}
		System.out.println(count);
	}
	
	@Override
	public void run() {
		addCount();
	}

	public static void main(String[] args) throws InterruptedException {
		VolitileNoAtomic[] arr = new VolitileNoAtomic[10];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = new VolitileNoAtomic();
		}
		for(int i = 0; i<arr.length; i++) {
			arr[i].start();
		}
		Thread.sleep(5000);
		System.out.println(count);
	}
}
