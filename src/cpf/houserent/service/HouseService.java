package cpf.houserent.service;

import cpf.houserent.domain.House;
import cpf.houserent.utils.Utility;

/**
 * 服务层，具体做事情的
 */
public class HouseService{
	static private House[] houses;//数组充当数据库，存储房屋信息
	static private int houseQuantity;//房源数量，也就是houses的长度，初始默认值是0

	//添加房屋信息
	public boolean addHouse(House newHouse){
		houseQuantity++;//房源数量加一，就算一开始为零，现在也是1了，对建数组很便利
		newHouse.setId(houseQuantity);//数量即为编号，实现自增长
		House[] newHouses = new House[houseQuantity];
		newHouses[houseQuantity - 1] = newHouse;//把新房屋添加入数组

		for(int index = 0; index < houseQuantity - 1; index++){//以前的数据复制一份
			newHouses[index] = houses[index];
		}
		houses = newHouses;//完成扩容
		return true;
	}

	//删除房源(此处只实现根据id来删除)，删除某个房源时，其他受影响的id都要改变
	public boolean deleteHouse(int id){
		//根据id可以直接定位到那个要被删除的房源
		House[] newHouses = new House[houseQuantity - 1];//删除房源，房源数组长度减一
		for(int i = 0; i < houseQuantity; i++){
			if(houses[i].getId() < id){//在被删除的房子前，都是挨个赋值到新数组
				newHouses[i] = houses[i];//巧妙的是，故意漏掉choice不选
			}else if(houses[i].getId() > id){//被选择之后，每个房源id-1,再复制到新数组
				houses[i].setId(houses[i].getId() - 1);
				newHouses[i - 1] = houses[i];//i跳了以下，但在新数组那里不可以跳
			}
		}
		houseQuantity--;//别忘了删除房源时候，数量减一
		houses = newHouses;
		return true;
	}

	//修改房屋信息
	public boolean updateHouse(int id){
		boolean lope = true;
		char confirm;
		System.out.println("编号(不可修改)" + "\t\t" + "1.房主" + "\t\t" + "2.电话" + "\t\t" +
				"3.地址" + "\t\t" + "4.月租" + "\t\t" + "5.状态");
		do{
			System.out.print("请选择您您要修改的选项：");
			int choice = Utility.getBoundInt(1, 5);
			switch(choice){
				case 1:
					System.out.print("房主修改为：");
					String master = Utility.getBoundStr(4);
					houses[id - 1].setMaster(master);
					break;
				case 2:
					System.out.print("电话修改为：");
					String phone = Utility.getBoundStr(12);
					houses[id - 1].setPhone(phone);
					break;
				case 3:
					System.out.print("地址修改为");
					String address= Utility.getBoundStr(20);
					houses[id - 1].setAddress(address);
					break;
				case 4:
					System.out.print("月租修改为：");
					int rentPerMonth = Utility.getBoundInt(1, 99999999);
					houses[id - 1].setRentPerMonth(rentPerMonth);
					break;
				case 5:
					System.out.print("状态修改为：");
					String state = Utility.getBoundStr(3);
					houses[id - 1].setState(state);
					break;
				default:
					System.out.println("选择有误，必须是1-5");
					break;
			}//end switch
			System.out.println("更新该房屋信息如下");
			System.out.println("编号" + "\t\t" + "房主" + "\t\t" + "电话" + "\t\t" + "地址"
					+ "\t\t" + "月租" + "\t\t" + "状态");
			houses[id -1].show();
			System.out.print("是否继续修改该房屋信息？(y/n)");
			confirm = Utility.confirm();
			if(confirm == 'N' || confirm == 'n'){//不更新就退出修改循环
				lope = false;
			}
		}while(lope);
		return true;
	}

	//查找房屋(暂时只支持地址查找)
	public House[] searchHouse(String address){
		if(address == null){
			System.out.println("条件错误！查找条件不能为空...");
			return null;
		}
		//要实现模糊查找，有一个字符一样就应该返回它
		String existAddress;
		House[] result = null;
		for(House house : houses){//每个房源都查找
			existAddress = house.getAddress();
			HouseLabel:
			for(int i = 0; i < address.length(); i++){//对于查找条件的每一个字符
				for(int j = 0; j < existAddress.length(); j++){//现存的地址都要遍历每个字符
					if(address.charAt(i) == existAddress.charAt(j)){
						result = Utility.extendArray(result, house);//向下转型
						break HouseLabel;//这个房源就结束查询，接着下一个房源
					}
				}
			}
		}
		return result;//没查到返回的就是null
	}

	//get\set
	public static House[] getHouses(){
		return houses;
	}

	public static void setHouses(House[] houses){
		HouseService.houses = houses;
	}

	public static int getHouseQuantity(){
		return houseQuantity;
	}

	public static void setHouseQuantity(int houseQuantity){
		HouseService.houseQuantity = houseQuantity;
	}
}
