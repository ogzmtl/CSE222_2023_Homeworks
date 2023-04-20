import java.util.NoSuchElementException;
import java.util.Stack;

public class PasswordOne{

    private String password1;
    public PasswordOne(){

    }

    public boolean setPassword1(String password, String username){
        if(password.length() < 8 ){
            System.out.println("The string password is invalid due to its length. Try again.");
            return false;
        }
        if(containsUserNameSpirit(username, password) && 
           isBalancedPassword(password) &&
           isPalindromePossible(password))
        {
            this.password1 = password;
            return true;
        }
        return false;
    }
/**
 * checks the password includes the user name letter
 * i send all password characters into the passwordstack data structure 
 * and in every sent i check if password and username includes same letter 
 * Also check password contains any digit number if it includes digit number 
 * return false otherwise return true
 * @param username string given username 
 * @param password1 given password
 * @return boolean if password contains same letter 
 */
    public boolean containsUserNameSpirit(String  username,  String  password1){
       
        Stack<Character> passwordStack = new Stack<Character>(); // O(1)
        Character c; // O(1)
        int counter = 0;
        for(int i = 0; i < password1.length(); i++){//for loop =  O(n)
            if(Character.isDigit(password1.charAt(i)))
            {
                System.out.println("The string password is invalid due to a digit included. Try again.");
                return false;
            }
                
            passwordStack.push(password1.charAt(i));
            c = password1.charAt(i);
            if(c == '{' || c == '[' || c == '(' ||c == '}' || c == ']' || c == ')'){
                counter++;
            }
            
            for(int j = 0; j < username.length(); j++){
                // System.out.println(c);
                // System.out.println(passwordStack.peek()+"\n");
                // System.out.println(counter);
                    if(passwordStack.peek() == username.charAt(j)){
                        return true;
                    }

            }
        }
        if(counter < 2){
            System.out.println("The string password is invalid due to brackets. Try again.");
            return false;
        }
        System.out.println("The string password is invalid due to not contain username spirit. Try again.");
        return false;        
    }
/**
 * This function check balanced or not of the password string 
 * This function pushes all of the brackets in the stack any letter or digit value is not pushed into the stack
 * Then close brackets observed this function check whether last stack member which is pop() is same type of the brackets
 * same type but opening bracket if it is true stack delete openin brackets and so on. At the end if stack empty
 * returns true otherwise false
 * @param password1 string password which includes brackets
 * @return true if password contains balanced brackets
 */
    public boolean isBalancedPassword(String password1){
        if(password1.length() == 0 ){
            throw new NoSuchElementException();
        }
        Stack<Character> passwordStack = new Stack<Character>();
        int counter = 0; 
        for(int i = 0; i < password1.length(); i++){

            Character c = password1.charAt(i);

            if(Character.isDigit(c))
                return false;
            
            if(c == '{' || c == '[' || c == '('){
                passwordStack.push(c);
                counter++;
            }

            
            if(c == '}'){
                if(passwordStack.empty()){
                    System.out.println("The string password is invalid due to not inbalancing. Try again.");
                    return false;
                }
                else if(passwordStack.pop() != '{'){
                    System.out.println("The string password is invalid due to not inbalancing. Try again.");
                    return false;
                }
            }

            if(c == ']'){
                if(passwordStack.empty()){
                    System.out.println("The string password is invalid due to not inbalancing. Try again.");
                    return false;
                }
                else if(passwordStack.pop() != '['){
                    System.out.println("The string password is invalid due to not inbalancing. Try again.");
                    return false;
                }
            }
            if(c == ')'){
                if(passwordStack.empty()){
                    System.out.println("The string password is invalid due to not inbalancing. Try again.");
                    return false;
                }
                else if(passwordStack.pop() != '('){
                    System.out.println("The string password is invalid due to not inbalancing. Try again.");
                    return false;
                }
            }
        }
        if(passwordStack.empty() && counter > 0)
            return true;
        System.out.println("The string password is invalid due to inbalancing. Try again.");
        return false;
    }
    /**
     *Sends the password to the helper function without any brackets and mutable string
     */
    public boolean isPalindromePossible(String password1){

        StringBuilder mutableString = new StringBuilder();
        String tempPassword = "";
         for(int i = 0; i < password1.length(); i++){
            Character c = password1.charAt(i);
            if(Character.isDigit(c)){
                System.out.println("The string password is invalid due to not inbalancing. Try again.");
                return false;
            }
            
            if(c == '{' || c == '[' || c == '(' ||c == '}' || c == ']' || c == ')'){
                
            }
            else {
                mutableString.append(c);
                tempPassword = tempPassword + c;
            }
            
         }
        //  System.out.println(tempPassword.length());
        //  System.out.println(tempPassword);
         return helper(tempPassword, mutableString, tempPassword.length()-1, 0);
    }

    /**
     * This function is used to check if the password convertible to palindrome structure
     * first index set to the at the end of password string and divide from 0 to until that character index
     * substring created function checks the character through this substring. If it is in the first index 
     * function just invokes itself and decrease its size
     * Then second from the end of password string will check the character through this substring but 
     * this substring is not not include first and current index (so if index = 5 and length = 6 substring includes (1, 4) characters)
     * if string found in index>0 that we make simple change in that characters with using index and length -size math operations
     * if there are one character which has length is 1this function set this character into to the middle of the mutable string and
     * returns the same index 
     * if there are more than one character which length is 1 flag control this character and returns true if more than one 
     * @param password1
     * @param mutable helper for change unmutable string characters 
     * @param size size of current string buffer
     * @param flag check if there are more than one character length 1
     * @return true if convertible to palindrome
     */
    private boolean helper(String password1, StringBuilder mutable, int size, int flag){

        if(size == (password1.length()-1)/2){
            return true;
        }
        Character c = mutable.charAt(size);
        String sub = password1.substring((password1.length()-1)-size,size-1);
        int index = sub.indexOf(c,0);
        // System.out.println(index);
        if((password1.length()-1)-size == size-1)
            if(c == password1.charAt(size-1))
                return true;
    
        if(index == 0){
            return helper(password1, mutable,size-1, flag);
        }
        else if(index != -1){
            index = (password1.length()-1)-size + index;
            Character temp = password1.charAt((password1.length()-1) - size);
            mutable.setCharAt((password1.length()-1)  - size, mutable.charAt(index));
            mutable.setCharAt(index, temp);
            password1 = mutable.toString().replaceAll(",", "");
            return helper(password1,  mutable,size-1, flag);
        }
        else{

            if((password1.length()-1) % 2 != 0)
            {
                System.out.println("The string password is invalid due to not palindrom. Try again.");
                return false;
            }
            else{
                if(flag == 0 ){
                    flag = 1;
                    Character temp = password1.charAt((password1.length()-1)/2);
                    mutable.setCharAt((password1.length()-1)/2, c);
                    mutable.setCharAt(size, temp);
                    password1 = mutable.toString().replaceAll(",", "");
                    return helper(password1,  mutable, size, flag);
                }
                else{
                    System.out.println("The string password is invalid due to not palindrom. Try again.");
                    return false;
                }
            }
        }
    
    }
    public String getPassword1(){
        return password1;
    }
    
}
