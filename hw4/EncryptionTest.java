import java.util.NoSuchElementException;
import java.util.Stack;

public class EncryptionTest {
    public static void main(String[] args) {
       String username1 = "sibelgulmez";
       String password1 = "a(bc)ba";
       int password2 = 75;

        Username username = new Username();
        PasswordOne psw1 = new PasswordOne();
        PasswordTwo psw2 = new PasswordTwo();

        try{
            System.out.println(username.setUsername(username1));
            System.out.println(psw1.setPassword1(password1, username.getUsername()));
            System.out.println(psw2.setPassword2(password2));
        }catch(Exception e){
            System.out.println(e);
        }
        // Username username4 = new Username();
        // try{
        //     username4.setUsername(username1);
        // }
        // catch(Exception e){
        //     System.out.println(e);
        // }
        

    //    System.out.println(checkIfValidUsername(username1));
    //    System.out.println(containsUserNameSpirit(username1, password1));
    //    System.out.println(isBalancedPassword(password1));
    // //    System.out.println(isPalindromePossible(password1));
    //     int[] denom = new int[]{4,17,29}; 
    //     System.out.println(isExactDivision(54,denom,denom.length-1 ));

    //     System.out.println(isPalindromePossible("{(abba)cac}"));
        //aba


    }

    // public static boolean checkIfValidUsername(String username) throws NoSuchElementException{

    //     if(username.length() == 0){
    //         throw new NoSuchElementException();
    //     }

    //     if(username.length() == 1 && Character.isLetter(username.charAt(0))){
    //         return true; 
    //     }

    //     if(Character.isLetter(username.charAt(0))){
    //         return checkIfValidUsername(username.substring(1));
    //     }
    //     else 
    //         return false;
    // }

    // public static boolean  containsUserNameSpirit(String  username,  String  password1){

    //     Stack<Character> passwordStack = new Stack<Character>();

    //     for(int i = 0; i < password1.length(); i++){
    //         if(Character.isDigit(password1.charAt(i)))
    //             return false;
    //         passwordStack.push(password1.charAt(i));
    //         for(int j = 0; j < username.length(); j++){
    //             if(passwordStack.peek() == username.charAt(j)){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;        
    // }

    // public static boolean isBalancedPassword(String password1){

    //     Stack<Character> passwordStack = new Stack<Character>();
    //     int counter = 0; 
    //     for(int i = 0; i < password1.length(); i++){

    //         Character c = password1.charAt(i);

    //         if(Character.isDigit(c))
    //             return false;
            
    //         if(c == '{' || c == '[' || c == '('){
    //             passwordStack.push(c);
    //             counter++;
    //         }

            
    //         if(c == '}'){
    //             if(passwordStack.empty()){
    //                 return false;
    //             }
    //             else if(passwordStack.pop() != '{'){
    //                 return false;
    //             }
    //         }

    //         if(c == ']'){
    //             if(passwordStack.empty()){
    //                 return false;
    //             }
    //             else if(passwordStack.pop() != '['){
    //                 return false;
    //             }
    //         }
    //         if(c == ')'){
    //             if(passwordStack.empty()){
    //                 return false;
    //             }
    //             else if(passwordStack.pop() != '('){
    //                 return false;
    //             }
    //         }
    //     }
    //     if(passwordStack.empty() && counter > 0)
    //         return true;
        
    //     return false;
    // }

    // public static boolean isPalindromePossible(String password1){

    //     StringBuilder mutableString = new StringBuilder();
    //     String tempPassword = "";
    //      for(int i = 0; i < password1.length(); i++){
    //         Character c = password1.charAt(i);
    //         if(Character.isDigit(c))
    //             return false;
            
    //         if(c == '{' || c == '[' || c == '(' ||c == '}' || c == ']' || c == ')'){
                
    //         }
    //         else {
    //             mutableString.append(c);
    //             tempPassword = tempPassword + c;
    //         }
            
    //      }
    //     //  System.out.println(tempPassword.length());
    //     //  System.out.println(tempPassword);
    //      return helper(tempPassword, mutableString, tempPassword.length()-1, 0);
    // }
    // public static boolean helper(String password1, StringBuilder mutable, int size, int flag){
        
    //     if(size == (password1.length()-1)/2){
    //         return true;
    //     }
    //     Character c = mutable.charAt(size);
    //     String sub = password1.substring((password1.length()-1)-size,size-1);
    //     if(size == 5){
    //         System.out.println("sub = : " + sub);
    //     }
    //     int index = sub.indexOf(c,0);
    //     int temp1 = (password1.length()-1)-size + index;
    //     System.out.println(temp1);
    //     System.out.println(c + ":" + index+ "\n");
    
    //     if(index == 0){
    //         return helper(password1, mutable,size-1, flag);
    //     }
    //     else if(index != -1){
    //         index = (password1.length()-1)-size + index;
    //         Character temp = password1.charAt((password1.length()-1) - size);
    //         mutable.setCharAt((password1.length()-1)  - size, mutable.charAt(index));
    //         mutable.setCharAt(index, temp);
    //         System.out.println(mutable.toString().replaceAll(",", ""));
    //         System.out.println(size-1);
    //         password1 = mutable.toString().replaceAll(",", "");
    //         return helper(password1,  mutable,size-1, flag);
    //     }
    //     else{

    //         if((password1.length()-1) % 2 != 0)
    //             return false;
    //         else{
    //             if(flag == 0 ){
    //                 System.out.print("AAAAAAa");
    //                 flag = 1;
    //                 Character temp = password1.charAt((password1.length()-1)/2);
    //                 mutable.setCharAt((password1.length()-1)/2, c);
    //                 mutable.setCharAt(size, temp);
    //                 password1 = mutable.toString().replaceAll(",", "");
    //                 return helper(password1,  mutable, size, flag);
    //             }
    //             else return false;
    //         }
    //     }
    
    // }

    public static boolean isExactDivision(int password2, int[] denominations, int index){

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
}