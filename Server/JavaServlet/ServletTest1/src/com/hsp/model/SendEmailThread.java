package com.hsp.model;

public class SendEmailThread extends Thread{
	@Override
	public void run() {
		int i=0;
		try {
			while(true){
				//ÿ����һ���ӣ���ȥɨ��sendmail, �����Ƿ��ż�Ӧ��������
				Thread.sleep(10*1000);
				System.out.println("���� ��"+(++i)+"�ʼ�");//javamail
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}


