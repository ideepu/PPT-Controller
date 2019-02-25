package com.deepu.mypptcontroller.client;

import java.io.IOException;
import java.net.UnknownHostException;

import com.deepu.mypptcontroller.client.ui.ControlActivity.BackStateHandler;
import android.os.Message;

public class Control extends Client {
	public static final int COM_START = 1;
	public static final int COM_STOP = 2;
	public static final int COM_PREVIOUS = 3;
	public static final int COM_NEXT = 4;
    public static final int COM_BLACK= 5;
    public static final int COM_WHITE = 6;
    public static final int COM_JUMP = 7;
    public static final int COM_CURRENTSLIDE = 8;
    public static final int COM_CLOSE = 9;
	
	private BackStateHandler handler; 
	
	
	public Control(BackStateHandler handler,String ip) {
		super(ip);
		this.handler = handler;
	}

	public void start() {
		new Thread() {
			@Override
			public void run() {
				int result = Client.CONNECT_FAIL;
				try {
					make(COM_START, 0);
					result = Client.CONNECT_SUCC;
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					Message msg = new Message();
					msg.what = BackStateHandler.WHAT;
					msg.arg1 = result;
					handler.sendMessage(msg);
				}
				super.run();
			}
		}.start();
	}

	public void stop() {
		new Thread() {
			@Override
			public void run() {
				int result = Client.CONNECT_FAIL;
				try {
					make(COM_STOP, 0);
					result = Client.CONNECT_SUCC;
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					Message msg = new Message();
					msg.what = BackStateHandler.WHAT;
					msg.arg1 = result;
					handler.sendMessage(msg);
				}
				super.run();
			}
		}.start();
	}

	public void previous() {
		new Thread() {
			@Override
			public void run() {
				int result = Client.CONNECT_FAIL;
				try {
					make(COM_PREVIOUS, 0);
					result = Client.CONNECT_SUCC;
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					Message msg = new Message();
					msg.what = BackStateHandler.WHAT;
					msg.arg1 = result;
					handler.sendMessage(msg);
				}
				super.run();
			}
		}.start();
	}

	public void next() {
		new Thread() {
			@Override
			public void run() {
				int result = Client.CONNECT_FAIL;
				try {
					make(COM_NEXT, 0);
					result = Client.CONNECT_SUCC;
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					Message msg = new Message();
					msg.what = BackStateHandler.WHAT;
					msg.arg1 = result;
					handler.sendMessage(msg);
				}
				super.run();
			}
		}.start();
	}

    public void makeBlack() {
        new Thread() {
            @Override
            public void run() {
                int result = Client.CONNECT_FAIL;
                try {
                    make(COM_BLACK, 0);
                    result = Client.CONNECT_SUCC;
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    Message msg = new Message();
                    msg.what = BackStateHandler.WHAT;
                    msg.arg1 = result;
                    handler.sendMessage(msg);
                }
                super.run();
            }
        }.start();
    }

    public void makeWhite() {
        new Thread() {
            @Override
            public void run() {
                int result = Client.CONNECT_FAIL;
                try {
                    make(COM_WHITE, 0);
                    result = Client.CONNECT_SUCC;
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    Message msg = new Message();
                    msg.what = BackStateHandler.WHAT;
                    msg.arg1 = result;
                    handler.sendMessage(msg);
                }
                super.run();
            }
        }.start();
    }

    public void jump(final int slideNo) {
        new Thread() {
            @Override
            public void run() {
                int result = Client.CONNECT_FAIL;
                try {
                    make(COM_JUMP, slideNo);
                    result = Client.CONNECT_SUCC;
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    Message msg = new Message();
                    msg.what = BackStateHandler.WHAT;
                    msg.arg1 = result;
                    handler.sendMessage(msg);
                }
                super.run();
            }
        }.start();
    }

    public void currentSlide() {
        new Thread() {
            @Override
            public void run() {
                int result = Client.CONNECT_FAIL;
                try {
                    make(COM_CURRENTSLIDE, 0);
                    result = Client.CONNECT_SUCC;
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    Message msg = new Message();
                    msg.what = BackStateHandler.WHAT;
                    msg.arg1 = result;
                    handler.sendMessage(msg);
                }
                super.run();
            }
        }.start();
    }

    public void close() {
        new Thread() {
            @Override
            public void run() {
                int result = Client.CONNECT_FAIL;
                try {
                    make(COM_CLOSE, 0);
                    result = Client.CONNECT_SUCC;
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    Message msg = new Message();
                    msg.what = BackStateHandler.WHAT;
                    msg.arg1 = result;
                    handler.sendMessage(msg);
                }
                super.run();
            }
        }.start();
    }

}
