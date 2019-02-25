package server.communication;

import server.control.AbstractControl;
import server.control.OpenOfficeControl;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private int port = 30102;

	public Server() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		AbstractControl control = new OpenOfficeControl(robot);
		try {
			ServerSocket ss = new ServerSocket(port);
			System.out.println("server is ready:");
			while (true) {
				Socket s = ss.accept();
				new ServerThread(s, control).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}

class ServerThread extends Thread {
	private Socket s = null;
	private BufferedReader read = null;
	private PrintStream print = null;
	private AbstractControl control = null;

	public ServerThread(Socket s, AbstractControl control) {
		System.out.println("get connect");
		this.s = s;
		this.control = control;
		try {
			read = new BufferedReader(new InputStreamReader(s.getInputStream()));
			print = new PrintStream(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			String message = null;
			int command = -1;
			while ((message = read.readLine()) != null) {
				try {
					command = Integer.parseInt(message);
				} catch (Exception ex) {
					System.out.println("'" + message + "' not command");
					ex.printStackTrace();
					continue;
				}
				if(command > 100){
					
					control.jump((command - 107));
				}
				else
				switch (command) {
				case AbstractControl.COM_START:
					control.start();
					break;
				case AbstractControl.COM_STOP:
					control.stop();
					break;
				case AbstractControl.COM_PREVIOUS:
					control.previous();
					break;
				case AbstractControl.COM_NEXT:
					control.next();
					break;
				case AbstractControl.COM_VISIBLE:
					control.makeRelease();
					break;
				case AbstractControl.COM_BLACK:
					control.makeBlack();
					break;
				case AbstractControl.COM_WHITE:
					control.makeWhite();
					break;
				case AbstractControl.COM_CURRENTSLIDE:
					control.currentSlide();
					break;
				case AbstractControl.COM_CLOSE:
					control.close();
					break;
				}
				// back the execute command
				print.println("get command:" + command);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!s.isClosed()) {
					s.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}