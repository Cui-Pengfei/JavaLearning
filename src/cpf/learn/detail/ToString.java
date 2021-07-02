package cpf.learn.detail;

public class ToString{
	public static void main(String[] args){

		System.out.println(new Who());
	    /*
	 	void PrintStream.println(object)
	 	        String String.valueOf(object)
	 	                object.toString()

		public String toString() {
	        return getClass().getName() + "@" + Integer.toHexString(hashCode());
	    }
	    */

	}//end main
}//end class

class Who{
	private String name = "who";

	@Override
	public String toString(){
		return "Who{" +
				"name='" + name + '\'' +
				'}';
	}
}
