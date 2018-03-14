/**  
* @Title: JavaVMStackSOF.java  
* @Package com.jmvtest  
* @Description: TODO  
* @author lgs  
* @date 2018年3月14日  
* @version V1.0  
*/ 
package com.jmvtest;

/**  
* @ClassName: JavaVMStackSOF  
* @Description: 虚拟机栈和本地方法栈内存溢出，StackOverflowError
* @author lgs  
* @date 2018年3月14日  
* 
* VM Args: -Xss128k   
*/
public class JavaVMStackSOF {
	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack leanth:" + oom.stackLength);
			throw e;
		}
		
	}

}
