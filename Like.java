public class Like extends Interaction {
    
    /**
     * Default constructor for Like class 
     * intentionally empty constructor
     */
    public Like(){
        //intentonally empty
    }
    /**
     * POst like constructor includes super class fields
     * @param interactionId id of like interaction
     * @param accountId account id which has liked post 
     * @param postId liked post od 
     */
    public Like(int interactionId, int accountId, int postId){
        super(interactionId, accountId, postId);
    }

}
