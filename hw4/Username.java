import java.util.NoSuchElementException;

public class Username {

    private String username;

    public Username(){
        //
    }

    public boolean setUsername(String username) throws Exception {
        if(username.length() == 0){
            throw new Exception("1");
        }
        if(checkIfValidUsername(username)){
            this.username = username;
            return true;
        }
        else 
            return false;
    }

/**
 * check if username is valid include character or not 
 * This function check username if username current character is valid 
 * send substring of username (1 to end of username)
 * @param username given username 
 * @return true if username is valid 
 * @throws NoSuchElementException
 */
    public boolean checkIfValidUsername(String username) throws NoSuchElementException{

        if(username.length() == 0){
            System.out.println("The username is invalid due to an empty username. Try again.");
            throw new NoSuchElementException();
        }

        if(username.length() == 1 && Character.isLetter(username.charAt(0))){
            return true; 
        }

        if(Character.isLetter(username.charAt(0))){
            return checkIfValidUsername(username.substring(1));
        }
        else {
            System.out.println("The username is invalid due to an digit or not character included. Try again.");
            return false;
        }
            
    }
    public String getUsername() {
        return username;
    }

}
