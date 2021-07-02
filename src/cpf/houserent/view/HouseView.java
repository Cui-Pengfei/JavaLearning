package cpf.houserent.view;

import cpf.houserent.domain.House;
import cpf.houserent.service.HouseService;
import cpf.houserent.utils.Utility;

/**
 * 出租系统界面
 */
public class HouseView{


	/**
	 * 主菜单界面，调用各个函数，分别实现各个功能.
	 */
	public void mainMenu(){

		boolean lope = true;

		int choice;

		do{
			System.out.println("============房屋出租系统界面==============");
			System.out.println("\t\t\t1 新 增 房 源");
			System.out.println("\t\t\t2 查 找 房 屋");
			System.out.println("\t\t\t3 删 除 房 屋");
			System.out.println("\t\t\t4 修 改 房 屋 信 息");
			System.out.println("\t\t\t5 房 屋 列 表");
			System.out.println("\t\t\t6 退 出");

			System.out.print("请选择服务:");
			choice = Utility.getBoundInt(1, 6);

			switch(choice){
				case 1:
					addHouse();
					break;
				case 2:
					searchHouse();
					break;
				case 3:
					deleteHouse();
					break;
				case 4:
					updateHouse();
					break;
				case 5:
					showHouse();
					break;
				case 6:
					System.out.println("\t\t\t6 退 出");
					lope = false;
					break;
			}

		}while(lope);

	}

	/**
	 * 1.添加房屋函数，此处只做界面，具体业务、数据放在service内的addHouse，
	 * 此处调用它即可.
	 */
	public void addHouse(){
		//编号 房主 电话 地址 月租 状态(未出租、已出租)
		//编号 自增长，因此不用输入
		System.out.println("请根据提示输入以下信息");
		System.out.print("房主：");
		String master = Utility.getBoundStr(4);
		System.out.print("电话：");
		String phone = Utility.getBoundStr(12);
		System.out.print("地址：");
		String address = Utility.getBoundStr(20);
		System.out.print("月租：");
		int rentPerMonth = Utility.getBoundInt(1, 99999999);
		System.out.print("状态：");
		String state = Utility.getBoundStr(3);

		House house = new House(master, phone, address, rentPerMonth, state);
		if(new HouseService().addHouse(house)){
			System.out.println("房源添加成功！");
		}else{
			System.out.println("房屋添加失败...");
		}
	}

	//2.查找房屋
	public void searchHouse(){
		if(HouseService.getHouseQuantity() == 0){
			System.out.println("暂时没有房源信息...");
			return;
		}
		//	想要根据不同的条件来查找房源
		//	编号 房主 电话 地址 月租 状态(未出租、已出租)
		//这里简单的用一个地址来查找，并且要实现模糊查找
		System.out.print("请输入您的查找地址(暂时只支持地址查找)：");
		String address = Utility.getBoundStr(20);
		House[] result = new HouseService().searchHouse(address);
		if(result == null){
			System.out.println("没有找到符合该条件的房源...");
		}else{
			System.out.println("查找结果如下：");
			//编号 房主 电话 地址 月租 状态(未出租、已出租)
			System.out.println("编号" + "\t\t" + "房主" + "\t\t" + "电话" + "\t\t" + "地址"
					+ "\t\t" + "月租" + "\t\t" + "状态");
			for(House house : result){
				house.show();
			}
		}
	}

	//3.删除房屋(此处只做根据id删除房源)
	public void deleteHouse(){
		if(HouseService.getHouseQuantity() == 0){
			System.out.println("暂时没有房源信息...");
			return;
		}
		System.out.print("请输入您要删除的房源编号：");
		int choice = Utility.getBoundInt(1, HouseService.getHouseQuantity());
		//编号 房主 电话 地址 月租 状态(未出租、已出租)
		System.out.println("编号" + "\t\t" + "房主" + "\t\t" + "电话" + "\t\t" + "地址"
				+ "\t\t" + "月租" + "\t\t" + "状态");
		HouseService.getHouses()[choice - 1].show();
		System.out.print("以上是您选中要删除的房源信息，您是否确定要删除？(y/n)");
		char confirm = Utility.confirm();
		if(confirm == 'y' || confirm == 'Y'){
			if(new HouseService().deleteHouse(choice)){
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败...");
			}
		}else{
			System.out.println("暂不删除房源");
		}

	}

	//4.修改房屋信息(提供根据id修改房源信息)
	public void updateHouse(){
		if(HouseService.getHouseQuantity() == 0){
			System.out.println("暂时没有房源信息....");
			return;
		}
		System.out.print("请输入您想要修改的房源id：");
		int choice = Utility.getBoundInt(1, HouseService.getHouseQuantity());
		System.out.println("以下是你要修改的房源信息：");
		//编号 房主 电话 地址 月租 状态(未出租、已出租)
		System.out.println("编号" + "\t\t" + "房主" + "\t\t" + "电话" + "\t\t" + "地址"
				+ "\t\t" + "月租" + "\t\t" + "状态");
		HouseService.getHouses()[choice -1].show();
		System.out.print("您是否仍要修改？(y/n):");
		char confirm = Utility.confirm();
		if(confirm == 'y' || confirm == 'Y'){
			new HouseService().updateHouse(choice);//确定调用业务层函数修改信息
		}else{
			System.out.println("暂时不修改...");
		}

	}

	//5.展示房源信息
	public void showHouse(){
		if(HouseService.getHouseQuantity() == 0){
			System.out.println("当前没有房源，等待添加...");
		}else{
			//编号 房主 电话 地址 月租 状态(未出租、已出租)
			System.out.println("编号" + "\t\t" + "房主" + "\t\t" + "电话" + "\t\t" + "地址"
					+ "\t\t" + "月租" + "\t\t" + "状态");
			for(House house : HouseService.getHouses()){
				house.show();//展示房屋信息
			}
		}
	}

}
