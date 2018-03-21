/**  
* @Title: FinalizeEscapeGc.java  
* @Package com.jmvtest  
* @Description: TODO  
* @author lgs  
* @date 2018年3月21日  
* @version V1.0  
*/ 
package com.jmvtest;

/**  
* @ClassName: FinalizeEscapeGc  
* @Description: 1、对象可也在GC时自我拯救
* 				2、这种自我拯救的机会只有一次，因为一个对象的finalize()方法最多只会被系统调用一次
* @author lgs  
* @date 2018年3月21日  
*    
*/
public class FinalizeEscapeGc {
	public static FinalizeEscapeGc SAVE_HOOK = null;
	
	public void isAlive() {
		System.out.println("i am alive");
	}
	
	@Override
	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("执行finalize方法");
		FinalizeEscapeGc.SAVE_HOOK = this;
	}
	
	public static void main(String[] args) throws Throwable{
		SAVE_HOOK = new FinalizeEscapeGc();
		
		//对象第一次拯救自己
		SAVE_HOOK = null;
		System.gc();
		// 因为finalize方法优先级低，等待0.5s
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("i am dead!");
		}
		
		// 第二次自救失败
		SAVE_HOOK = null;
		System.gc();
		// 因为finalize方法优先级低，等待0.5s
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("i am dead!");
		}
	}

}
