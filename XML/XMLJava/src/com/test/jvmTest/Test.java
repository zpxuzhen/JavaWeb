package com.test.jvmTest;

public class Test {
/**
 * ָ�� jvm������ �ڴ��С:
 * jvm������ʱ��һ��Ĭ�ϴ�С jdk5.0  64m, 
 * �������ϣ���ı�jvm���������ڴ��С
 * ����ͨ���޸� �CXmx? ������ ,�����Լ�ָ��
 * {
 * Ӧ�ó����Ҽ�����->RunDebugSetting-Test(Ӧ�ó�����)->Edit...->Arguments->VM Arguments
 * ��ָ��   -Xmx2500m    -Xmx2500   -Xmx2500k   ��ʽ  -Xmx?
 * ע��:������Ԥ����ڴ��һ��
 * }
 */
	public static void main(String[] args) {
		byte bytes[]=new byte[1024*1024*1345];
		bytes[0]=0;
		System.out.println(bytes[0]);

	}

}
