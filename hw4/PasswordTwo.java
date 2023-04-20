public class PasswordTwo {
    
    private final int[] denom = new int[]{4,17,29}; 
    private int password2;

    public PasswordTwo(){

    }

    public boolean setPassword2(int password){

        if(isExactDivision(password, denom, 0) || isInRange(password2))
        {
            this.password2 = password;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isInRange(int password2){
        if(password2 > 10 && password2 < 1000)
            return true;
        else{
            System.out.println("The int password is invalid due to a pasword range (must be in range 10, 1000). Try again.");
            return false;
        }
    }

    public boolean isExactDivision(int password2, int[] denominations, int index){

        if(index < 0)
        {
            return false;
        }

        if(password2 % denominations[index] == 0){
            return true;
        }

        if(password2 > denominations[index] ){
            
            if(!isExactDivision(password2%denominations[index], denominations, index-1)){
                isExactDivision(password2, denominations, index-1);
            }
            password2 = password2 % denominations[index];
        }

        return isExactDivision(password2, denominations, index-1);
    }

    public int getPassword2(){
        return password2;
    }
}
