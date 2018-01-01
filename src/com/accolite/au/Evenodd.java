package com.accolite.au;

public class Evenodd {
	int c;
	boolean isodd;
	Evenodd(boolean isodd){
		this.isodd=isodd;
		if(isodd==true)
			c=1;
		else
			c=0;
	}
	synchronized void printEven() {
		while(isodd)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(c+" is even");
		c++;
		isodd=true;
		notifyAll();
	}
	synchronized void printOdd() {
		while(!isodd)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(c+" is odd");
		c++;
		isodd=false;
		notifyAll();
	}

}
