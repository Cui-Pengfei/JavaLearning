package cpf.houserent.domain;

public class House{
	//编号 房主 电话 地址 月租 状态(未出租、已出租)
	private int id;//编号自增长，但不能设置为static，因为之后还要显示不同对象的不同编号，
	//编号应该与对象对应，编号自增长应该另想办法...
	private String master;
	private String phone;
	private String address;
	private int rentPerMonth;
	private String state;

	public void show(){
		//编号 房主 电话 地址 月租 状态(未出租、已出租)
		System.out.println(id + "\t\t" + master + "\t\t" + phone + "\t\t" + address + "\t\t"
				+ rentPerMonth + "\t\t" + state);
	}

	//constructor 两个
	public House(){
	}
	public House(String master, String phone, String address, int rentPerMonth, String state){
		this.master = master;
		this.phone = phone;
		this.address = address;
		this.rentPerMonth = rentPerMonth;
		this.state = state;
	}
	//get\set
	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getMaster(){
		return master;
	}

	public void setMaster(String master){
		this.master = master;
	}

	public String getPhone(){
		return phone;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public int getRentPerMonth(){
		return rentPerMonth;
	}

	public void setRentPerMonth(int rentPerMonth){
		this.rentPerMonth = rentPerMonth;
	}

	public String getState(){
		return state;
	}

	public void setState(String state){
		this.state = state;
	}
}
