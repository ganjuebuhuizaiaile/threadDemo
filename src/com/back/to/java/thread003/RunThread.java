package com.back.to.java.thread003;

public class RunThread extends Thread {
	/*volatileǿ�����߳�ȥ���ڴ������ֵ*/
	/*������ÿ���̷߳���һ���߳�Ҫ�õı����Ŀ���������ʱֱ��ȥ�Լ����߳̿��������JDK1.5�Ժ���޸ģ�*/
	private boolean isRunning = true;

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		System.out.println("����run");
		while(isRunning == true) {
			
		}
		System.out.println("�˳�run");
	}
	
	public static void main(String[] args) throws InterruptedException {
		RunThread thread = new RunThread();
		
		thread.start();
		
		Thread.sleep(1000);
		
		thread.setRunning(false);
		
		System.out.println(thread.isRunning);
	}
}
