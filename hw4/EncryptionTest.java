public class EncryptionTest {
    public static void main(String[] args) {
       String username1 = "sibelgulmez";
       String password1 = "{(abba)cac}";
       int password2 = 33;
    //    final int[] denom = new int[]{4,17,29}; 
        Username username = new Username();
        PasswordOne psw1 = new PasswordOne();
        PasswordTwo psw2 = new PasswordTwo();

        try{
            boolean USERNAME = username.setUsername(username1);
            boolean PASSWORD1 = psw1.setPassword1(password1, username.getUsername());
            boolean PASSWORD2 = psw2.setPassword2(password2);

            if(USERNAME && PASSWORD1 && PASSWORD2){
                System.out.println("The username and passwords are valid. The door is opening, please wait...");
            }

            // System.out.println(psw1.setPassword1(password1, username.getUsername()));
            // System.out.println(psw2.setPassword2(password2));
            // System.out.println(isExactDivision(password2,denom , denom.length -1));
        }catch(Exception e){
            System.out.println(e);
        }

    }
}