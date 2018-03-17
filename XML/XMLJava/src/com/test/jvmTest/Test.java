package com.test.jvmTest;

public class Test {
/**
 * 指定 jvm启动的 内存大小:
 * jvm机启动时有一个默认大小 jdk5.0  64m, 
 * 如果我们希望改变jvm机启动的内存大小
 * 可以通过修改 –Xmx? 来处理 ,可以自己指定
 * {
 * 应用程序右键属性->RunDebugSetting-Test(应用程序名)->Edit...->Arguments->VM Arguments
 * 来指定   -Xmx2500m    -Xmx2500   -Xmx2500k   格式  -Xmx?
 * 注意:尽量比预算的内存大一点
 * }
 */
	public static void main(String[] args) {
		byte bytes[]=new byte[1024*1024*1345];
		bytes[0]=0;
		System.out.println(bytes[0]);

	}

}
