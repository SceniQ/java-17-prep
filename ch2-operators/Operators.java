public class Operators{
	//float egg = 2.0 / 9; // DOES NOT COMPILE
	//int tadpole = (int)5 * 2L; // DOES NOT COMPILE
	//short frog = 3 -2.0;// DOES NOT COMPILE
	public static void main(String... x){
		//	float num1 = 3;
		//short num = 10;
		//num *= num1;
		//System.out.println(num);
		
		 //int ph = 7, vis = 2;
 //boolean clear = vis > 1 & (vis < 9 || ph < 2);
 //boolean safe = (vis > 2) && (ph++ > 1);
 //boolean tasty = 7 <= --ph;
 //System.out.println(clear + "-" + safe + "-" + tasty);
 
		for(int i = 5; i>=1;i--){
			for(int j = 1; j<=5;j++){
				if(i ==j)
					System.out.print("*");
				else
					System.out.print(j);
			}
			System.out.println();
		}
		
		//int note = 1 * 2 + (long)3; // does not compile
		int note = 1 * 2 + (short)3; 
		short melody = (byte)(double)(note *= 2);
		double song = melody;
		float symphony = (float)((song == 1_000f) ? song * 2L : song);
		
		System.out.println(testSwitchExpr(Integer.parseInt(x[0])));
	}
	
	private static String testSwitchExpr(int testNum){
		String love = switch(testNum) {
				case 1 -> "Goldfish";
				case 2 -> "Trout";
				default -> {yield "Swordfish";}
		};
		
		return love;
	}

}