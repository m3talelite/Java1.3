package Controller;

import View.ViewingFrame;

public class Main {

	public static void main(String args[])
	{
		new Main();
	}
	
	
	public Main(){
		System.out.println("Start of the program\n");
		
		//TODO: Initialize everything (not only the frame)
		new MainControl();
		new ViewingFrame();
		
		System.out.println("End of the program");
	}
	
	public void readTextFile(){
		
	}
	
	public void writeTextFile(){
		
	}
	
	public void readObjectFile(){
		
	}
	
	public void writeObjectFile(){
		
	}
}
