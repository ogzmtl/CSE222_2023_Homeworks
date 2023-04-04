package LinkedList;

import java.util.LinkedList;

public class Post {
    
    private Integer postId; 
    private Integer accountId;
    private String content; 
    private LinkedList<Like> likes = new LinkedList<Like>(); 
    private LinkedList<Comment> comments = new LinkedList<Comment>();

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

    public LinkedList<Comment> getComments()
    {
        return this.comments;
    }

    public LinkedList<Like> getLikes()
    {
        return this.likes;
    }
}
