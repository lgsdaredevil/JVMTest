/**  
* @Title: JavaHeapError.java  
* @Package com.jmvtest  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author dared  
* @date 2018��3��14��  
* @version V1.0  
*/ 
package com.jmvtest;

import java.util.ArrayList;
import java.util.List;

/**  
* @ClassName: JavaHeapError  
* @Description: ����JVM��OutOfMemoryError�쳣  
* @author lgs  
* @date 2018��3��14��  
* 
* VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
*/
public class JavaHeapError {
	static class OOMObject{}
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		while (true) {
			list.add(new OOMObject());
		}
		
	}

}
