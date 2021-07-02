package cpf.learn.myTool;

/**
 * @author CPF 创建于： 2021/6/18 0:28
 */
public class ClassAbout{
	/**
	 * 获得对象的类名，不含包名.
	 * @param object 要获得类名的那个对象
	 * @return 返回类名 String
	 */
	public static String getClassName(Object object){
		String className = object.getClass().getName();
		int lastPointIndex = className.lastIndexOf(".");
		//这里新建StringBuilder是为了使用它的delete()方法，+1是为了删除最后一个点(.)
		className = new StringBuilder(className).delete(0, lastPointIndex + 1).toString();
		return className;
	}
}
