public class PasswordTwo {
    
    private int[] denom = new int[]{4,17,29}; 
    private int password2;
/**
 * empty constructor
 */
    public PasswordTwo(){

    }

/**
 * sets the password2 which must be in range 10 and 1000 or denominators are divide with some coefficient
 * @param password integer password
 * @return if all check conditions are true password2 will set and returns true
 */
    public boolean setPassword2(int password){

        if(isInRange(password))
        {
            if(isExactDivision2(password, denom, denom.length-1))
            {
                this.password2 = password;
                return true;
            }
            else{
                System.out.println("The int password is invalid due to denominators do not divide password. Try again.");
                return false;
            }
        }
        else{
            return false;
        }
    }
    /**
     * checks if the password is in range 10, 1000
     * @param password2 given password
     * @return true if password is in range
     */
    public boolean isInRange(int password2){
        if(password2 > 10 && password2 < 10000)
            return true;
        else{
            System.out.println("The int password is invalid due to a pasword range (must be in range 10, 10000). Try again.");
            return false;
        }
    }

    /**
     * Check if the password exact divisibile by denominators 
     * if denominors last higher than the password then i check remain part is 0 or not 
     * then if it is not i decrease index of denominators and do same check with that index of denom array 
     * if all true then this function returns true
     * @param password2 given password
     * @param denominations constant denominators
     * @param index begining from the last index (denominator index)
     * @return if isExact division catch return true otherwise return false
     */
    public boolean isExactDivision2(int password2, int[] denominations, int index){

        if(index < 0)
        {
            return false;
        }

        if(password2 % denominations[index] == 0){
            return true;
        }

        if(password2 > denominations[index] ){
            
            if(!isExactDivision2(password2%denominations[index], denominations, index-1)){
                isExactDivision2(password2, denominations, index-1);
            }
            password2 = password2 % denominations[index];
        }

        return isExactDivision2(password2, denominations, index-1);
    }
    public boolean isExactDivision(int password2, int[] denominations, int index){

        if(index < 0)
        {
            return false;
        }

        if(password2 % denominations[index] == 0){
            return true;
        }
        // System.out.println(password2);
        if(password2 > denominations[index]){
            
            // password2 -= denominations[index];
            if(!isExactDivision(password2-denominations[index], denominations, index)){
                return isExactDivision(password2, denominations, index-1);
            }
            else return true;
            // if(!isExactDivision(password2-denominations[index], denominations, index-1)){
            //     isExactDivision(password2, denominations, index-1);
            // }
            // password2 = password2 % denominations[index];
        }
        else{
            return isExactDivision(password2, denominations, index-1);
        }
        
    }
/**
 * get the password
 * @return password2
 */
    public int getPassword2(){
        return password2;
    }
}
