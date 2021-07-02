package cpf.poker;

//解决问题时，突然想到，为什么不把参与者写成一个类，真是傻逼了。。。。。。

/**
 * 要解决问题：
 * 双方各执一手牌，分先手、后手
 * 找到一种出牌顺序，使得先手一方获胜
 * <p>
 * 问题分析：
 * 递归两个字符串：hand(first, behind)
 * 结果是first赢，或behind赢，
 * first赢：对于first的某一出牌顺序， behind递归完所有可能性都无法获胜，
 * behind赢：对于first的所有出牌序列，behind都能找到一种可以获胜的出牌顺序...
 * 递归结束的标志是first或者behind某一方为null
 * <p>
 * <p>
 * <p>
 * 出牌数量是不限制的，从1到num都要试一遍
 * 如果后手者可以赢，就要回溯，
 * 出牌需要合法 ----->出牌合法化检测
 * 接牌者出牌数量一定与出牌者数量一致，减少了计算量
 * <p>
 * 解决尝试：
 * 可以使用String来存储牌型，String类提供了丰富的方法...
 * 出掉的牌要拆减掉String中的那些字符...
 * 可出牌数量是不确定的，出牌顺序也不确定，可以挨着也可以不挨着...
 */
public class Poker{
	public static void main(String[] args){


	}//end main

	/**
	 * 出牌方法.
	 *
	 * @param first  表示先手者，注意，先手后手在每一轮都是相对的.
	 * @param behind 表示后手者.
	 */
	public void hand(String first, String firstName, String behind, String behindName){
		if(first == null || behind == null){

			if(first == null){
				System.out.println(firstName + "赢了");
				System.out.println();
				System.out.println();
			}else{
				System.out.println(behindName + "赢了");
				System.out.println();
				System.out.println();
			}

			return;//任何一个人出完牌就要结束了
		} else{
			int firstLength = first.length();//先手还有多少牌
			int behindLength = behind.length();//后手还有多少牌

			String outPoker = "";//表示本轮要出的牌

			//本步：先手者可能出牌数量不限，每种出牌都是一个分支，但需要合法出牌
			for(int outLength = 1; outLength < firstLength; outLength++){
				//先检测是否有合法的outLength张牌可以出，合法的可能不止一种，1不用检测...
				//合法的outLength张组合要用String承接，后续要用
				//重点是：如何使每一种合法的情况都不重复地找出来？
				//对于每一种情况，都要裁剪first后，判断behind的情况

				//outLength个指针指向first的各个牌，指针移动形成不同的组合
				int[] outPoint = new int[outLength];
				for(int index = 0; index < outPoint.length; index++){
					outPoint[index] = first.charAt(index);//从first根部开始组合
				}

				//此循环表示：对于每一种outLength，有可能有不同的组合
				do{
					for(int index = 0; index < outPoint.length; index++){
						outPoker += first.charAt(outPoint[index]);//把组合的字符拼接起来
					}

					if(isLegal(outPoker)){
						//合法就出牌
						putout(first, outPoint);
						System.out.println();

						//对于first的出牌，应该先检测behind是否有接得住的牌
						//1.接不住，就没啥选择，只能由first再出牌
						//2.接得住，才有选择是否出牌的权利 2.1出牌 2.2不出牌

					}

				}while(true);

			}
		}
	}//end hand


	/**
	 * 检查要出的牌是否符合斗地主要求.
	 * @param outPoker 本次要出的牌.
	 * @return true表示合法，false表示不合法
	 */
	public boolean isLegal(String outPoker){
		return true;
	}

	/**
	 * 出牌，在first字符串中剔除掉要出的牌.
	 * @param handPoker 手中现有的牌.
	 * @param outPoint 要出的牌在handpoker中的下标.
	 */
	public void putout(String handPoker, int[] outPoint){

	}


}//end public class
