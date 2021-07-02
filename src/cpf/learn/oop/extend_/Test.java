package cpf.learn.oop.extend_;

public class Test{
	public static void main(String[] args){

		Pupil pupil = new Pupil();
		pupil.setName("jack");
		pupil.setGender('男');
		pupil.setStudentID("201509050149");
		pupil.setAge(13);
		pupil.setSchool("五中");
		pupil.exam();
		pupil.showInfo();

		System.out.println("=============");

		Graduate graduate = new Graduate("cpf", '男', 25, "420621", "五中", "201509", 125);
		graduate.exam();
		graduate.showInfo();

		System.out.println("父类protected filed : " + graduate.subject);
		System.out.println("父类default field : " + graduate.studentID);

	}//end main
}//end class
