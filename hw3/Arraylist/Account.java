package Arraylist;
import java.util.ArrayList;

public class Account{

    private Integer accountId; 
    private String username; 
    private String birthdate;
    private String location;
    private ArrayList<Post> posts = new ArrayList<Post>(); 
    private ArrayList<Account> followers = new ArrayList<Account>();
    private ArrayList<Account> following = new ArrayList<Account>();
    // private ArrayList<Message> messages = new ArrayList<Message>();

    public Account()
    {
        //intentionally empty
    }
    public Account(int accountId, String username, String birthdate, String location)
    {
        this.accountId = accountId;
        this.username = username; 
        this.birthdate = birthdate;
        this.location = location; 
    }

    public void sharePost(Post post)
    {
        posts.add(post); 
    }

    public void sharePost(String content)
    {
        Integer postId = posts.size();
        Post tempPost = new Post(postId+1, this.accountId, content);
        posts.add(tempPost);      
    }

    public void viewPost()
    {
        for(int i = 0; i < posts.size(); i++)
        {
            System.out.println(posts.get(i).getContent());
        }
    }

    public void like(Account account, Post post)
    {
        Like tempLike = new Like(account.getAccountId(), 0, post.getpostId());

        account.getPosts().get(post.getpostId()).addLike(tempLike);
    }

    public void follow(Account account)
    {
        following.add(account);
        account.getFollowers().add(this);
    }

    public Integer getAccountId()
    {
        return accountId;
    }

    public String getUsername()
    {
        return username;
    }

    public String getBirthdate()
    {
        return birthdate;
    }

    public String getLocation()
    {
        return location;
    }

    public ArrayList<Post> getPosts()
    {
        return posts;
    }

    public ArrayList<Account> getFollowers()
    {
        return followers;
    }

    public ArrayList<Account> getFollowing()
    {
        return following;
    }

    // public ArrayList<Message> getMessages()
    // {
    //     return messages; 
    // }

}