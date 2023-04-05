package Arraylist;

import java.util.ArrayList;

public class Post {
    
    private Integer postId; 
    private Integer accountId;
    private String content; 
    private ArrayList<Like> likes = new ArrayList<Like>(); 
    private ArrayList<Comment> comments = new ArrayList<Comment>();

    public Post(){
        //intentionally empty
    }

    public Post(String content)
    {
        this.content = content;
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

    public ArrayList<Comment> getComments()
    {
        return this.comments;
    }

    public ArrayList<Like> getLikes()
    {
        return this.likes;
    }



}
