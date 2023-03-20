public class Comment extends Interaction{

    private String content; 

    /**
     * no parameter constructor 
     * intentionally empty
     */
    public Comment(){
        //intentionally empty
    }

    /**
     * If interactionid, accountid and postid assigns in a instance of a class
     * we only now content of a comment so this constructor helps us to just knowing 
     * content of a content of a comment interaction
     * @param content content of comment interaction
     */
    public Comment(String content){
        this.content = content;
    }

    /**
     * invokes super class 3 parameter constructor for initialization
     * then initialize content of comment 
     * @param interactionId interaction id which unique for each interaction
     * @param accountId account id which interact with post
     * @param postId interacting postid 
     * @param content content of an interaction
     */
    public Comment(int interactionId, int accountId, int postId, String content ){
        super(interactionId, accountId, postId);
        this.content = content;
    }
    
    /**
     * 
     * @return content of comment
     */
    public String getContent(){
        return this.content;
    }
    
}
