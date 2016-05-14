
import java.util.*;

public class Heart 
{
	private int[][] nums= new int[4][4];
	
	public Heart(){
		this.rand(3);
	}
	
	public void move (int i,int way){
		
		//水平way=0//竖直way=1   //左0  右-3   //上0   下-3
		int i_0= i+3;//保存<i的原值+3>为i_0，即末尾的位置
		
		
		//System.out.println(233333);
		
		
		//横
		if(way ==0){
			for(int y =0;y<4;y++){//每一行
			
			System.out.println("第"+y+"行");
				while(i!=i_0){
					if (nums[Math.abs(i)][y] != 0) {//如果abs(i)处的值不为0
					
						System.out.println(Math.abs(i) +"处的值不为0");
						//for (int i_1 = i + 1 ;i_1!= i_0+1;i_1++) {//备份i的值为i_1
						boolean b_1 =nums[Math.abs(i + 1)][y] == 0;
						System.out.println("下一个为零");
						if (nums[Math.abs(i)][y] == nums[Math.abs(i + 1)][y] || b_1) {
							System.out.println("加");
							nums[Math.abs(i)][y] += nums[Math.abs(i + 1)][y];

							for (int i_1 = i + 1;i_1 != i_0;i_1++) {//前移
								nums[Math.abs(i_1)][y] = nums[Math.abs(i_1 + 1)][y];
								nums[Math.abs(i_1 + 1)][y]=0;
							}
							//break;//找到同值，处理后跳出
							System.out.println("前移结果");
							
							System.out.println();
						}
						if(!b_1){
						i++;//跃进
						}
						
						
					} else {//abs(i)处为0
						//System.out.println("50");
						
						if (i == i_0 - 3) {
							int i_1;
							boolean b =false;
							for (i_1 = i + 1;i_1 != i_0 + 1;i_1++) {
								if (nums[Math.abs(i_1)][y] != 0) {
									b = true;//判断该行是否有非零数
									break;
								}

							}
							if (b) {

								while (i_1 < i_0 + 1) {//前移
									nums[Math.abs(i)][y] = nums[Math.abs(i_1)][y];
									nums[Math.abs(i_1)][y]=0;
									i_1++;
									i++;
								}
								i = i_0 - 3;//i取回初始值
							} else {//该行无非零的数
								System.out.println("该行无");
								break;
							}

						}
					}


				}
			}
		}
		
		
	}
	
	
	//判断空位
	public boolean find(){
		boolean b = false;
		for(int[] nums_0:nums){
			for (int num :nums_0) {
				if (num==0) {
					b = true;
					break;
					
				}
			}
			if(b==true){
				break;
			}
		}
		return b;
	}
	
	//随机生成
	private void rand(int i){
		while (i > 0) {
			int x = (int)(Math.random() * 4);
			int y = (int)(Math.random() * 4);
			if (nums[x][y] == 0) {
				nums[x][y] = 2;
				i--;
			}
		}
	}
	//显示
	public void screen(){
		for(int x=0; x<4; x++){
			for(int y =0 ;y<4 ;y++){
				System.out.print("| "+nums[x][y]+" |");
			}
			System.out.println();
		}
	}
	
}

