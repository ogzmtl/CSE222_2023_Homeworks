public class EncryptionTest {
    public static void main(String[] args) {
       String username1 = "siba";
       String password1 = "{(abba)casc}";
       int password2 = 75;
    //    final int[] denom = new int[]{4,17,29}; 
        Username username = new Username();
        PasswordOne psw1 = new PasswordOne();
        PasswordTwo psw2 = new PasswordTwo();

        // try{
        //     boolean USERNAME = username.setUsername(username1);
        //     boolean PASSWORD1 = psw1.setPassword1(password1, username.getUsername());
        //     boolean PASSWORD2 = psw2.setPassword2(password2);

        //     if(USERNAME && PASSWORD1 && PASSWORD2){
        //         System.out.println("The username and passwords are valid. The door is opening, please wait...");
        //     }

        //     // System.out.println(psw1.setPassword1(password1, username.getUsername()));
        //     // System.out.println(psw2.setPassword2(password2));
        //     // System.out.println(isExactDivision(password2,denom , denom.length -1));
        // }catch(Exception e){
        //     System.out.println(e);
        // }
        int[] P = {4,4,2,4};
        int[] S = {5,5,2,5};
        System.out.println(solution(P, S));
    }
    // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


    public static int solution(int[] P, int[] S) {
       int a = 0; 
       int b = 0;
       int counter = 0; 
       int temp= 10; 
       int flag = 0;

       for(int i = 0; i < P.length; i++){
           a += P[i]; 
       }
        for(int i = 0; i < S.length; i++){
            b = S[i];
            counter = 1;
            for(int j = i+1; j < S.length; j++){
                if(b < a)
                {
                    b += S[j];
                    counter++;
                    flag = 1; 
                }
                else{
                    j = S.length;
                }
            }
            if(counter < temp && flag == 1 && b >= a)
                    temp = counter; 
            flag = 0; 
       }

       return temp;
    }

}