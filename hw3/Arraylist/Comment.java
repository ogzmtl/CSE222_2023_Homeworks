package Arraylist;

public class Comment extends Interaction{
    
    String content; 
    
    public Comment(){
        //intentionally empty
    }

    public Comment(int interactionId, int accountId, int postId, String content)
    {
        super(interactionId, accountId, postId);
        this.content = content; 
    }

    public Comment(String content)
    {
        this.content = content; 
    }

    public String getContent()
    {
        return this.content; 
    }


}
