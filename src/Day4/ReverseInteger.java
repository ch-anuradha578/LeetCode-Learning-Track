package Day4;

public class ReverseInteger {
	public int reverse(int x) {
        int reverse = 0;
        int rem;
        boolean isNegative = x<0;
        x=Math.abs(x);

        while(x>0){
            if(reverse>Integer.MAX_VALUE/10){
                return 0;
            }
            rem = x%10;
            reverse = (reverse*10)+rem;
            x/=10;
        }
        return isNegative ? -reverse : reverse;
    }

	public static void main(String[] args) {
		ReverseInteger solution = new ReverseInteger();
		int x = 123;
		int y = -123;
		int Xresult = solution.reverse(x);
		int Yresult = solution.reverse(y);
		System.out.println("Input Integer is: " + x + "," + y);
		System.out.println("Reverse Integer is: " + Xresult + "," + Yresult);
	}
}
