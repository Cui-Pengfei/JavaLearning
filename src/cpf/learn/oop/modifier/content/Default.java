package cpf.learn.oop.modifier.content;
class Default {
	//默认类的属性
	public String s1 = "default.public";
	protected String s2 = "default.protected";
	String s3 = "default.default";
	private String s4 = "default.private";


	public void m1(){
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println();
	}

	protected void m2(){
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println();
	}

	void m3(){
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println();
	}

	private void m4(){
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println();
	}
}
