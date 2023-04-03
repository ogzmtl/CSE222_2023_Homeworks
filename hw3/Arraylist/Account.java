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
    private ArrayList<Message> inbox = new ArrayList<Message>();
    private ArrayList<Message> outbox = new ArrayList<Message>();
    private ArrayList<Account> blocked = new ArrayList<Account>();

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

    public void viewPost(Account account, boolean isViewedProfile)
    {
        if(isBlocked(account) || isBlockedByAccount(account) || !isViewedProfile)
        {
            System.out.println("Unable to view Post.");
            return;
        }

        System.out.println("Viewing " +account.getUsername()+"'s posts...");

        for(int i = 0; i < account.getPosts().size(); i++)
        {
            System.out.print("(Post ID: " +account.getPosts().get(i).getpostId() + ") "+
                             account.getUsername() +": ");
            System.out.println(account.getPosts().get(i).getContent());
        }
    }

    public Like like(Account account, Post post)
    {
        Like tempLike = new Like(this.getAccountId(), 0, post.getpostId());
        // System.out.println(account.getPosts().get(post.getpostId()-1).getContent());
        account.getPosts().get(post.getpostId()-1).addLike(tempLike);
        return tempLike;
    }

    public void unlike(Account account, Post post, Like like)
    {
        account.getPosts().get(post.getpostId()-1).getLikes().remove(like);
    }

    public void unlike(Post post, Like like)
    {
        getPosts().get(post.getpostId()-1).getLikes().remove(like);
    }

    public void comment(Account account, Post post, String content)
    {
        Comment tempComment = new Comment(0, accountId, post.getpostId(), content);
        account.getPosts().get(post.getpostId()-1).addComment(tempComment);

    }

    public void comment(Account account, Comment comment)
    {
        account.getPosts().get(comment.getPostId()).addComment(comment);
        
    }

    public void follow(Account account)
    {
        if((account.getUsername() == this.username) || !isValidFollowing(account) || isBlocked(account) || isBlockedByAccount(account)){
            System.out.println("Unable to follow. ");
            return;
        }        
        following.add(account);
        account.getFollowers().add(this);
    }

    public void unfollow(Account account)
    {
        following.remove(account);
        account.getFollowers().remove(this);
    }

    public void sendMessage(Account account, String content)
    {
        if(!isValidFollowing(account) || isBlocked(account) || isBlockedByAccount(account))
        {
            System.out.println("Unable to send message");
        }

        Message tempMessage = new Message(account.getInbox().size()+1,
                                          this.accountId,
                                          account.getAccountId(),
                                          content );

        sendMessage(account, tempMessage); 
    }

    public boolean viewProfile(Account account)
    {
        if(isBlocked(account) || isBlockedByAccount(account))
        {
            System.out.println("Unable to view Profile");
            return false; 
        }

        System.out.println("Viewing " + account.getUsername() + "'s profile...");
        System.out.println("------------------------");

        System.out.println("User ID: "+ account.getAccountId());
        System.out.println("Username: " + account.getUsername());
        System.out.println("Location: " + account.getLocation());
        System.out.println("Birth Date: " + account.getBirthdate());
        System.out.println(account.getUsername() +" is following "+ 
                           account.getFollowing().size()+ " account(s) and has " +
                           account.getFollowers().size() + " follower(s).");
        
        System.out.print(account.getUsername() + " is following: ");

        for(int i = 0; i < account.getFollowing().size(); i++)
        {
            System.out.print(account.getFollowing().get(i).getUsername() +", ");
        }
        System.out.println();
        System.out.print(account.getUsername() + "'s' follower(s): ");

        for(int i = 0; i < account.getFollowers().size(); i++)
        {
            System.out.print(account.getFollowers().get(i).getUsername() +", ");
        }
        System.out.println();
        System.out.println(account.getUsername() + " has " + 
                           account.getPosts().size() +" posts.");
        
        return true;
    }
    public void sendMessage(Account account, Message message)
    {
        //check Message includes.
        account.getInbox().add(message);
        this.getOutbox().add(message);
    }


    public boolean isValidFollowing(Account account)
    {
        for(Account i : following)
        {
            if(i.getUsername() == account.getUsername()) return false; 
        }
        return true; 
    }

    public void viewInbox(ArrayList<Account> accounts)
    {
        
        System.out.println("Viewing inbox ...\n------------------");

        for(int i = 0; i < getInbox().size(); i++)
        {
            System.out.println("Message ID: "+ getInbox().get(i).getMessageId());
            System.out.println("From: "+ accounts.get(getInbox().get(i).getSenderId()-1).getUsername());
            System.out.println("To: "+ this.getUsername());
            System.out.println("Message: "+ getInbox().get(i).getContent());
            System.out.println("---------------------");
        }

    }
    public void viewOutbox(ArrayList<Account> accounts)
    {
        System.out.println("Viewing outbox ...\n------------------");

        for(int i = 0; i < getOutbox().size(); i++)
        {
            System.out.println("Message ID: "+ getOutbox().get(i).getMessageId());
            System.out.println("From: "+ this.getUsername());
            System.out.println("To: "+ accounts.get(getOutbox().get(i).getReceiverId()-1).getUsername());
            System.out.println("Message: "+ getOutbox().get(i).getContent());
            System.out.println("---------------------");
        }
    }

    public boolean isBlocked(Account account)
    {
        for(int i = 0; i < this.getBlocked().size(); i++)
        {
            if(this.getBlocked().get(i).getUsername() == account.getUsername()) return true; 
        }
        return false; 
    }

    public void viewInteractions(Account targetAccount, ArrayList<Account> accounts)
    {
        int numComment = 1; 
        System.out.println("Viewing "+ targetAccount.getUsername() + "'s posts' interactions...");
        System.out.println("-----------------------------------------");

        for(Post i : targetAccount.getPosts())
        {
            System.out.println("(PostID: " + i.getpostId() + "): " +i.getContent());     
            
            if(i.getLikes().size() != 0 )
            {
                System.out.print("The post was liked by the following account(s): ");   
                for(Like j: i.getLikes())
                {
                    System.out.print(accounts.get(j.getAccountId()-1).getUsername()+ ", ");
                }
                System.out.println();
            }
            else
            {
                System.out.println("The post has no likes.");
            }

            if (i.getComments().size() != 0)
            {
                System.out.println("The post has "+ i.getComments().size() +" comment(s)...");   
                for(Comment j: i.getComments())
                {
                    System.out.print("Comment "+ numComment + ": " );
                    System.out.println("' " + accounts.get(j.getAccountId()-1).getUsername()+ "' "
                                     +"said '" + j.getContent() + "'");
                    numComment++;
                }
                numComment=1;
            }
            else
            {
                System.out.println("The post has no comments.");
            }
        }
    }

    public boolean isBlockedByAccount(Account account)
    {
        for(int i = 0; i < account.getBlocked().size(); i++)
        {
            if(account.getBlocked().get(i).getUsername() == this.username) return true;
        }
        return false;
    }

    public void block(Account account)
    {
        if(isBlocked(account))
            return;

        if(isInFollowing(account))
        {
            unfollow(account);
        }
        if(isInFollowers(account))
        {
            account.getFollowing().remove(this);
            getFollowers().remove(account);
        }
        removeLikeInBlocking(account);
        removeAccountLikeInBlocking(account);

        blocked.add(account);        
    }

    public void unblock(Account account)
    {
        if(isBlocked(account))
        {
            blocked.remove(account);
        }
    }
    private void removeLikeInBlocking(Account account)
    {
        for(Post i : account.getPosts())
        {
            if(i.getLikes().size() != 0)
            {
                for(Like j : i.getLikes())
                {
                    if(j.getAccountId() == this.getAccountId()) unlike(account, i, j);
                }
            }
        }
    }
    private void removeAccountLikeInBlocking(Account account)
    {

        for(int i = 0; i < this.getPosts().size(); i++)
        {
            if(getPosts().get(i).getLikes().size() != 0)
            {
                for(int j = 0; j < getPosts().get(i).getLikes().size(); j++ )
                {
                    if(getPosts().get(i).getLikes().get(j).getAccountId() == account.getAccountId())
                        unlike(getPosts().get(i),getPosts().get(i).getLikes().get(j));
                }
            }
        }
    }
    
    private boolean isInFollowing(Account account)
    {
        for(int i = 0; i < following.size(); i++)
        {
            if(following.get(i).getUsername() == account.getUsername())return true;
        }
        return false;
    }

    private boolean isInFollowers(Account account)
    {
        for(int i = 0; i < account.getFollowing().size(); i++)
        {
            if(account.getFollowing().get(i).getUsername() == this.getUsername())return true;
        }
        return false; 
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

    public ArrayList<Account> getBlocked()
    {
        return this.blocked;
    }

    public ArrayList<Message> getInbox()
    {
        return inbox; 
    }
    public ArrayList<Message> getOutbox()
    {
        return outbox;
    }

}