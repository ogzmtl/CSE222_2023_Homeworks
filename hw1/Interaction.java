public class Interaction {
    
    private int interactionId;
    private int accountId;
    private int postId;

    /**
     * No parameter constructor 
     * which is intentionally empty
     */
    public Interaction(){
        //intentionally empty 
    }

    /**
     * super class constructor of like and comment 
     * fully initialization done after this constructor parameters are initialized
     * @param interactionId interaction id which unique for each interaction
     * @param accountId account id which interact with post
     * @param postId interacting postid 
     */
    public Interaction(int interactionId, int accountId, int postId){
        this.accountId = accountId;
        this.interactionId = interactionId;
        this.postId = postId; 
    }

    /**
     * 
     * @return get interaction id which unique for each interaction
     */
    public int getInteractionId(){
        return this.interactionId;
    }

    /**
     * 
     * @return get account id which interact with post
     */
    public int getAccountId(){
        return this.accountId;
    }

    /**
     * 
     * @return gets the interacting postid 
     */
    public int getPostId(){
        return this.postId;
    }

}
