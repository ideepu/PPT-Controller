package server.control;

import java.awt.Robot;

public abstract class AbstractControl {
	protected int KEY_START;
	protected int KEY_STOP;
	protected int KEY_PREVIOUS;
	protected int KEY_NEXT;
	protected int KEY_BLACK;
	protected int KEY_WHITE;
	protected int KEY_JUMP;
	protected int KEY_CURRENTSLIDE;
	protected int KEY_CLOSE;

	public static final int COM_START = 1;
	public static final int COM_STOP = 2;
	public static final int COM_PREVIOUS = 3;
	public static final int COM_NEXT = 4;
	public static final int COM_BLACK = 5;
	public static final int COM_WHITE = 6;
	public static final int COM_VISIBLE = 7;
	public static final int COM_CURRENTSLIDE = 8;
	public static final int COM_CLOSE = 9;
	
	protected Robot robot;

	public void start() {
		System.out.println(" KEY_START ");
		KeyPress.pressKey(robot, KEY_START);
	}

	public void stop() {
		System.out.println(" KEY_STOP ");
		KeyPress.pressKey(robot, KEY_STOP);
	}

	public void previous() {
		System.out.println(" KEY_PREVIOUS ");
		KeyPress.pressKey(robot, KEY_PREVIOUS);
	}

	public void next() {
		System.out.println(" KEY_NEXT ");
		KeyPress.pressKey(robot, KEY_NEXT);
	}
	public void makeBlack() {
		System.out.println(" KEY_BLACK ");
		KeyPress.make(robot, KEY_BLACK);
	}
	public void makeWhite() {
		System.out.println(" KEY_WHITE ");
		KeyPress.make(robot, KEY_WHITE);
	}
	public void makeRelease() {
		System.out.println(" make visible ");
		KeyPress.makeRelease(robot);
	}
	public void jump(int slideNo) {
		System.out.println(" KEY_JUMP ");
		this.KEY_JUMP = slideNo;
		KeyPress.pressJump(robot, KEY_JUMP);
	}
	public void currentSlide() {
		System.out.println(" KEY_CURRENTSLIDE ");
		KeyPress.pressKeyWithShift(robot, KEY_CURRENTSLIDE);
	}
	public void close() {
		System.out.println(" KEY_CLOSE ");
		KeyPress.closeApplication(robot);
	}
	
	
}
