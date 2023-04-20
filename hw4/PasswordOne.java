import java.util.NoSuchElementException;
import java.util.Stack;

public class PasswordOne{

    private String password1;
    public PasswordOne(){

    }

    public boolean setPassword1(String password, String username){
        if(containsUserNameSpirit(username, password) && 
           isBalancedPassword(password) &&
           isPalindromePossible(password))
        {
            this.password1 = password;
            return true;
        }
        return false;
    }

    public boolean containsUserNameSpirit(String  username,  String  password1){
       
        Stack<Character> passwordStack = new Stack<Character>();

        for(int i = 0; i < password1.length(); i++){
            if(Character.isDigit(password1.charAt(i)))
            {
                System.out.println("The string password is invalid due to a digit included. Try again.");
                return false;
            }
                
            passwordStack.push(password1.charAt(i));
            for(int j = 0; j < username.length(); j++){
                if(passwordStack.peek() == username.charAt(j)){
                    return true;
                }
            }
        }
        System.out.println("The string password is invalid due to not contain username spirit. Try again.");
        return false;        
    }

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
    public boolean helper(String password1, StringBuilder mutable, int size, int flag){
        
        if(size == (password1.length()-1)/2){
            return true;
        }
        Character c = mutable.charAt(size);
        String sub = password1.substring((password1.length()-1)-size,size-1);
        if(size == 5){
            System.out.println("sub = : " + sub);
        }
        int index = sub.indexOf(c,0);
    
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
