package server.control;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class KeyPress {
	
	public static void pressKey(Robot robot, int keyvalue) {
		robot.keyPress(keyvalue);
		robot.keyRelease(keyvalue);
	}

	public static void pressKeyWithShift(Robot robot, int keyvalue) {
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(keyvalue);
		robot.keyRelease(keyvalue);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	public static void make(Robot robot, int keyvalue) {
		robot.keyPress(keyvalue);
	}
	public static void makeRelease(Robot robot) {
		robot.keyRelease(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_B);
	}
	
	public static void  pressJump(Robot robot, int keyvalue){
		int slideNo = keyvalue;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		LinkedList<Integer> stackrelease = new LinkedList<Integer>();
		while(keyvalue > 0){
			stack.push(keyvalue % 10);
			keyvalue = (int) keyvalue / 10;
		}
		
		//pressing the number
		while (!stack.isEmpty()) {
		   switch(stack.pop()){
		   case 0:
			   robot.keyPress(KeyEvent.VK_0);
			   stackrelease.push(0);
			   break;
		   case 1:
			   robot.keyPress(KeyEvent.VK_1);
			   stackrelease.push(1);
			   break;
		   case 2:
			   robot.keyPress(KeyEvent.VK_2);
			   stackrelease.push(2);
			   break;
		   case 3:
			   robot.keyPress(KeyEvent.VK_3);
			   stackrelease.push(3);
			   break;
		   case 4:
			   robot.keyPress(KeyEvent.VK_4);
			   stackrelease.push(4);
			   break;
		   case 5:
			   robot.keyPress(KeyEvent.VK_5);
			   stackrelease.push(5);
			   break;
		   case 6:
			   robot.keyPress(KeyEvent.VK_6);
			   stackrelease.push(6);
			   break;
		   case 7:
			   robot.keyPress(KeyEvent.VK_7);
			   stackrelease.push(7);
			   break;
		   case 8:
			   robot.keyPress(KeyEvent.VK_8);
			   stackrelease.push(8);
			   break;
		   case 9:
			   robot.keyPress(KeyEvent.VK_9);
			   stackrelease.push(9);
			   break;
		   }
		}
		//pressing enter after the number
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		//releasing keys for number
		while (!stackrelease.isEmpty()) {
			   switch(stackrelease.pop()){
			   case 0:
				   robot.keyRelease(KeyEvent.VK_0);
				   break;
			   case 1:
				   robot.keyRelease(KeyEvent.VK_1);
				   break;
			   case 2:
				   robot.keyRelease(KeyEvent.VK_2);
				   break;
			   case 3:
				   robot.keyRelease(KeyEvent.VK_3);
				   break;
			   case 4:
				   robot.keyRelease(KeyEvent.VK_4);
				   break;
			   case 5:
				   robot.keyRelease(KeyEvent.VK_5);
				   break;
			   case 6:
				   robot.keyRelease(KeyEvent.VK_6);
				   break;
			   case 7:
				   robot.keyRelease(KeyEvent.VK_7);
				   break;
			   case 8:
				   robot.keyRelease(KeyEvent.VK_8);
				   break;
			   case 9:
				   robot.keyRelease(KeyEvent.VK_9);
				   break;
			   }
			}	
		
	}
	

	public static void closeApplication(Robot robot) {
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F4);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_F4);
	}

}