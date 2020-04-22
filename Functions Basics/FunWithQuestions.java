package Lecture3;

public class FunWithQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dec = 32;
		int bin = decToBin(dec);
		// 100000
		System.out.println(bin);
		// 32
		System.out.println(binToDec(bin));
		// 45
		System.out.println(decToAny(37, 8));
		// 31
		System.out.println(AnyToDec(37, 8));
		// 11111
		System.out.println(AnyToAny(37, 8, 2));
		
		
		System.out.println(inverse(4132));

	}

	public static int decToBin(int dec) {
		int bin = 0;
		int tenpowers = 1;
		while (dec != 0) {
			int rem = dec % 2;
			bin = bin + rem * tenpowers;
			tenpowers = tenpowers * 10;
			dec = dec / 2;
		}

		return bin;
	}

	public static int binToDec(int bin) {
        int dec=0;
        int twopowers=1;
        while(bin!=0) {
        	int rem=bin%10;
        	dec=dec+rem*twopowers;
        	twopowers=twopowers*2;
        	bin=bin/10;
        }
        
        return dec;
	}

	public static int decToAny(int dec, int db) {
		int num = 0;
		int tenpowers = 1;
		while (dec != 0) {
			int rem = dec % db;
			num = num + rem * tenpowers;
			tenpowers = tenpowers * 10;
			dec = dec / db;
		}

		return num;
	}

	public static int AnyToDec(int num, int sb) {
		int dec=0;
        int sbpowers=1;
        while(num!=0) {
        	int rem=num%10;
        	dec=dec+rem*sbpowers;
        	sbpowers=sbpowers*sb;
        	num=num/10;
        }
        
       
        
        return dec;
	}

	public static int AnyToAny(int num, int sb, int db) {
         int dec=AnyToDec(num, sb);
         int ans=decToAny(dec, db);
         return ans;
	}
	
	public static int inverse(int num) {
		int power=1;
		int inverse=0;
		int counter=1;
		while(num!=0) {
			int rem=num%10;
			power=1;
			while(rem!=1) {
				power=power*10;
				rem--;
			}
			
			inverse=inverse+power*counter;
			counter++;
			num=num/10;
		}
		
		return inverse;
	}
	

}
