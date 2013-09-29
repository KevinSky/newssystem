package kevin.news.thrift;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException {
//		Class clazz = Class.forName("kevin.news.thrift.NewsService$Client");
//		Constructor cs[] = clazz.getConstructors();
//		System.out.println(cs.length);
//
//		for (Constructor c : cs) {
//			Type[] types = c.getGenericParameterTypes();
//			Class[] ts = c.getParameterTypes();
//			
//			String str = c.toGenericString() + "," + ts.length;
//			for (Type t : types) {
//				str += "," + t.getClass().getSimpleName();
//			}
//			System.out.println(str);
//		}
		Class[] params = new Class[1];
		params[0] = org.apache.thrift.protocol.TProtocol.class;
		Constructor constructor = Class.forName("kevin.news.thrift.NewsService$Client").getConstructor(
				params);
	}
}
