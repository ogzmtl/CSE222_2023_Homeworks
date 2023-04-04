package LinkedList;

public class Interaction {
    
    private Integer interactionId;
    private Integer accountId;
    private Integer postId;
    
    public Interaction()
    {
        //intentionally empty
    }

    public Interaction(int interactionId, int accountId, int postId)
    {
        this.interactionId = interactionId;
        this.accountId = accountId;
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
