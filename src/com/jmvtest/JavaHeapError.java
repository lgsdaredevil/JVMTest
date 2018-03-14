/**  
* @Title: JavaHeapError.java  
* @Package com.jmvtest  
* @Description: TODO(用一句话描述该文件做什么)  
* @author dared  
* @date 2018年3月14日  
* @version V1.0  
*/ 
package com.jmvtest;

import java.util.ArrayList;
import java.util.List;

/**  
* @ClassName: JavaHeapError  
* @Description: 测试JVM的OutOfMemoryError异常  
* @author lgs  
* @date 2018年3月14日  
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
