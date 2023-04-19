

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

    public boolean checkIfValidUsername(String username){

        if(username.length() == 1 && Character.isLetter(username.charAt(0))){
            return true; 
        }

        if(Character.isLetter(username.charAt(0))){
            return checkIfValidUsername(username.substring(1));
        }
        else 
            return false;
    }
}
