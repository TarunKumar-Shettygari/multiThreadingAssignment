package com.accolite.au;

public class EvenoddTest extends Thread{
	public static void main(String[] args) {
		Evenodd eo=new Evenodd(true);
		Thread t1=new Thread() {
			public void run() {
				while(true) {
					eo.printEven();
				}
			}
		};
		Thread t2=new Thread() {
			public void run() {
				while(true) {
					eo.printOdd();
				}
			}
		};
		t1.start();
		t2.start();
	}

}
