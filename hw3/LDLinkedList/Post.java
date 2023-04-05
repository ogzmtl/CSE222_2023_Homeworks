package LDLinkedList;

public class Post {
    
    private Integer postId; 
    private Integer accountId;
    private String content; 
    private LDLinkedList<Like> likes = new LDLinkedList<Like>(); 
    private LDLinkedList<Comment> comments = new LDLinkedList<Comment>();

    public Post(){
        //intentionally empty
    }

    public Post(int postId, int accountId, String content)
    {
        this.accountId = accountId; 
        this.postId = postId;
        this.content = content; 
    }

    public void addLike(Like like ){
        this.likes.add(like);
    }

    public void addComment(Comment comment)
    {
        this.comments.add(comment);
    }
    
    public void removeLike(Like like)
    {
        this.likes.remove(like);
    }

    public void removeComment(Comment comment)
    {
        this.comments.remove(comment);
    }

    public Integer getaccountId()
    {
        return this.accountId;
    }
    
    public Integer getpostId()
    {
        return this.postId;
    }

    public String getContent()
    {
        return this.content;
    }

    public LDLinkedList<Comment> getComments()
    {
        return this.comments;
    }

    public LDLinkedList<Like> getLikes()
    {
        return this.likes;
    }
}
