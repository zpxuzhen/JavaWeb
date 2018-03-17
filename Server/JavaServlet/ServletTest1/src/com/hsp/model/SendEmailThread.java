package com.hsp.model;

public class SendEmailThread extends Thread{
	@Override
	public void run() {
		int i=0;
		try {
			while(true){
				//每休眠一分钟，就去扫表sendmail, 看看那份信件应当被发出
				Thread.sleep(10*1000);
				System.out.println("发出 第"+(++i)+"邮件");//javamail
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}


