import java.util.NoSuchElementException;
import java.util.Stack;

public class EncryptionTest {
    public static void main(String[] args) {
       String username1 = "sibelgulmez";
       String username2 = "b";
       String username3 = "c";

       String password1 = "[a]bcd(cb)a";
       String password2 = "psw2";
       String password3 = "psw3";

        // Username username4 = new Username();
        // try{
        //     username4.setUsername(username1);
        // }
        // catch(Exception e){
        //     System.out.println(e);
        // }
        

       System.out.println(checkIfValidUsername(username1));
       System.out.println(containsUserNameSpirit(username1, password1));
       System.out.println(isBalancedPassword(password1));
        


    }

    public static boolean checkIfValidUsername(String username) throws NoSuchElementException{

        if(username.length() == 0){
            throw new NoSuchElementException();
        }

        if(username.length() == 1 && Character.isLetter(username.charAt(0))){
            return true; 
        }

        if(Character.isLetter(username.charAt(0))){
            return checkIfValidUsername(username.substring(1));
        }
        else 
            return false;
    }

    public static boolean  containsUserNameSpirit(String  username,  String  password1){

        Stack<Character> passwordStack = new Stack<Character>();

        for(int i = 0; i < password1.length(); i++){
            passwordStack.push(password1.charAt(i));
            for(int j = 0; j < username.length(); j++){
                if(passwordStack.peek() == username.charAt(j)){
                    return true;
                }
            }
        }
        return false;        
    }

    public static boolean isBalancedPassword(String password1){

        Stack<Character> passwordStack = new Stack<Character>();
        int counter = 0; 
        for(int i = 0; i < password1.length(); i++){

            Character c = password1.charAt(i);
            
            if(c == '{' || c == '[' || c == '('){
                passwordStack.push(c);
                counter++;
            }

            
            if(c == '}'){
                if(passwordStack.empty()){
                    return false;
                }
                else if(passwordStack.pop() != '{'){
                    return false;
                }
            }

            if(c == ']'){
                if(passwordStack.empty()){
                    return false;
                }
                else if(passwordStack.pop() != '['){
                    return false;
                }
            }
            if(c == ')'){
                if(passwordStack.empty()){
                    return false;
                }
                else if(passwordStack.pop() != '('){
                    return false;
                }
            }
        }
        if(passwordStack.empty() && counter > 0)
            return true;
        
        return false;
    }

    public static boolean isPalindromePossible(String password1){

        //TODO  Auto-generated method stub  for 

    }






}