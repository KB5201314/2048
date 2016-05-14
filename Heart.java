
import java.util.*;

public class Heart 
{
	private int[][] nums= new int[4][4];
	private Scanner scan = new Scanner(System.in);
	private int in= 0;
	public Heart(){
		this.rand(3);
		this.screen();
		System.out.println("\n\n\n");
	}
	
	public void input(){
		
		while(true){
			
			try {
				in = scan.nextInt();
				
				switch(in){
					case(2):this.move(0,1);break;
					case(8):this.move(-3,1);break;
					case(4):this.move(0,0);break;
					case(6):this.move(-3,0);break;
					default:throw new InputMismatchException();
					
				}
				break;
			}
			catch (Exception ex) {
				scan.nextLine();
				this.screen();
				System.out.println("Error!!");
				System.out.println("\n\n");
			}
			
		}
		
		this.rand(1);
		this.screen();
		System.out.println("\n\n\n");
		
	}
	
	
	public void move (int i,int way){
		
		//水平way=0//竖直way=1   //左0  右-3   //上0   下-3
		if (way == 0) {

			for (int y =0;y < 4;y++) {//每一行
				ArrayList<Integer> array = new ArrayList<Integer>();

				for (int i_0 = i;i_0 != i + 4;i_0 ++) {
					if (nums[Math.abs(i_0)][y] != 0) {
						array.add(array.size(), nums[Math.abs(i_0)][y]);
					}

					nums[Math.abs(i_0)][y] = 0;
				}


				for (int i_1 = 0;i_1 < array.size() - 1;i_1++) {

					if (array.get(i_1).equals(array.get(i_1 + 1))) {
						array.set(i_1, array.get(i_1) * 2);
						array.remove(i_1 + 1);

					}
				}


				int i_2=i;
				for (int index=0;index < array.size();index++) {
					nums[Math.abs(i_2)][y] = array.get(index);

					i_2++;
				}
			}
		}else{
			
			for(int x =0;x<4;x++){//每一行列
				ArrayList<Integer> array = new ArrayList<Integer>();

				for(int i_0 = i;i_0!= i+4;i_0 ++){
					if(nums[x][Math.abs(i_0)] !=0){
						array.add(array.size(),nums[x][Math.abs(i_0)]);
					}

					nums[x][Math.abs(i_0)] = 0;
				}


				for(int i_1 = 0;i_1 < array.size()-1;i_1++){

					if(array.get(i_1).equals(array.get(i_1+1))){
						array.set(i_1,array.get(i_1)*2);
						array.remove(i_1+1);

					}
				}


				int i_2=i;
				for(int index=0;index<array.size();index++){
					nums[x][Math.abs(i_2)] = array.get(index);

					i_2++;
				}
			}
			
		}
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
		System.out.println("\n\n\n");
		for(int y=0; y<4; y++){
			System.out.println(" ------ ------ ------ ------");
			for(int x =0 ;x<4 ;x++){
				if(nums[x][y]!=0){
					System.out.print("|  "+nums[x][y]+"  |");
				}else{
					System.out.print("|     |");
				}
			}
			System.out.println();
		}
		System.out.println(" ------ ------ ------ ------");
	}
	
}

