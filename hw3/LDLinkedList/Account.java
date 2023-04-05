package LDLinkedList;


public class Account {
    private final String LIKE = "You liked ";
    private final String UNLIKE = "You unliked ";
    private final String FOLLOWED = "You followed ";
    private final String UNFOLLOWED = "You unfollowed ";
    private final String COMMENTED = "You commented ";
    private final String UNCOMMENTED = "You uncommented ";
    private final String VIEW = "You viewed "; 
    private final String BLOCK = "You block ";
    private final String UNBLOCK = "You unblock ";
    private final String SHARE = "You share ";
    private final String MESSAGE = "You send a Message to ";

    private Integer accountId; 
    private String username; 
    private String birthdate;
    private String location;
    private LDLinkedList<Post> posts = new LDLinkedList<Post>(); 
    private LDLinkedList<Account> followers = new LDLinkedList<Account>();
    private LDLinkedList<Account> following = new LDLinkedList<Account>();
    private LDLinkedList<Message> inbox = new LDLinkedList<Message>();
    private LDLinkedList<Message> outbox = new LDLinkedList<Message>();
    private LDLinkedList<Account> blocked = new LDLinkedList<Account>();
    private LDLinkedList<String> history = new LDLinkedList<String>();


    public Account()
    {
        //intentionally empty 
    }

    public Account(int accountId, String username, String birthdate, String location )
    {
        this.accountId = accountId;
        this.username = username;
        this.birthdate = birthdate;
        this.location = location; 
    }

    public int login(int loginAccountId)
    {
        if(loginAccountId == -1 ) {
            return this.getAccountId();
        }
        if(loginAccountId == this.getAccountId()){
            return this.getAccountId();
        }
        else{
            System.out.println("Unable to login "+this.getUsername() +" account, please be sure logged out.");
            return loginAccountId;
        }
    }

    public int logout()
    {
        System.out.println("Logging out from account (username: "+ this.getUsername() + ")...");
        return -1;
    }

    public void sharePost(Post post, int loginAccountId)
    {
        
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }
        posts.add(post); 
        history.add(SHARE + "post id:" +post.getpostId());

    }

    public void sharePost(String content, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }

        Integer postId = posts.size();
        Post tempPost = new Post(postId+1, this.accountId, content);
        posts.add(tempPost);      

        history.add(SHARE + "post id:" +postId+1);
    }

    public Like like(Account account, Post post, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return null; 
        }
        Like tempLike = new Like(this.getAccountId(), 0, post.getpostId());
        System.out.println("Liking " + account.getUsername() + "'s posts...' ");
        account.getPosts().get(post.getpostId()-1).addLike(tempLike);
        history.add(LIKE + account.getUsername() + "'s post id: "+ post.getpostId());
        return tempLike;
    }

    public void unlike(Account account, Post post, Like like, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }
        System.out.println("Unliking " + account.getUsername() + "'s posts...' ");
        account.getPosts().get(post.getpostId()-1).getLikes().remove(like);

        history.add(UNLIKE + account.getUsername() + "'s post id: "+ post.getpostId());
    }

    private void unlike(Post post, Like like)
    {
        getPosts().get(post.getpostId()-1).getLikes().remove(like);
        history.add(UNLIKE + getUsername() + "'s post id: "+ post.getpostId());
    }
    
    public Comment comment(Account account, Post post, String content, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return null; 
        }
        Comment tempComment = new Comment(0, accountId, post.getpostId(), content);
        account.getPosts().get(post.getpostId()-1).addComment(tempComment);

        history.add(COMMENTED + account.getUsername() + "'s post id:" 
                   + account.getPosts().get(tempComment.getPostId()));
        return tempComment;
    }
    public Comment comment(Account account, Post post, Comment comment, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return null; 
        }
        Comment tempComment = new Comment(0, accountId, post.getpostId(), comment.getContent());
        account.getPosts().get(post.getpostId()-1).addComment(tempComment);

        history.add(COMMENTED + account.getUsername() + "'s post id:" 
                   + account.getPosts().get(tempComment.getPostId()-1));
        return tempComment;
    }

    public void uncomment(Account account, Post post, Comment comment, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }
        account.getPosts().get(post.getpostId()-1).getComments().remove(comment);
        
        history.add(UNCOMMENTED + account.getUsername() + "'s post id:" 
                   + account.getPosts().get(comment.getPostId()));
    }

    public void uncomment(Post post, Comment comment)
    {
        getPosts().get(post.getpostId()-1).getComments().remove(comment);
        
        history.add(UNCOMMENTED + getUsername() + "'s post id:" 
                    + getPosts().get(comment.getPostId()-1));
    }

    public void comment(Account account, Comment comment, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }
        account.getPosts().get(comment.getPostId()).addComment(comment);

        history.add(COMMENTED + account.getUsername() + "'s post id:" 
                   + account.getPosts().get(comment.getPostId()));
    }

    public void follow(Account account, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }
        if((account.getUsername() == this.username) || !isValidFollowing(account) || isBlocked(account) || isBlockedByAccount(account)){
            System.out.println("Unable to follow. ");
            return;
        }        
        following.add(account);
        account.getFollowers().add(this);
        
        history.add(FOLLOWED + account.getUsername());
    }
    public void unfollow(Account account, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }
        following.remove(account);
        account.getFollowers().remove(this);
        history.add(UNFOLLOWED + account.getUsername());
    }

    public void sendMessage(Account account, String content, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }

        if(!isValidFollowing(account) || isBlocked(account) || isBlockedByAccount(account))
        {
            System.out.println("Unable to send message");
        }

        Message tempMessage = new Message(account.getInbox().size()+1,
                                          this.accountId,
                                          account.getAccountId(),
                                          content );

        sendMessage(account, tempMessage, loginAccountId); 
        history.add(MESSAGE + account.getUsername());

    }
    public void viewPost(Account account, boolean isViewedProfile, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }

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
        history.add(VIEW + account.getUsername() + "'s posts");
    }

    public boolean viewProfile(Account account, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return false; 
        }

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
        
        
        history.add(VIEW + account.getUsername() + " profile");
        return true;
    }

    public void sendMessage(Account account, Message message, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }
        try{
            account.getInbox().add(message);
            this.getOutbox().add(message);
            history.add(MESSAGE + account.getUsername());
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        //check Message includes.

    }


    private boolean isValidFollowing(Account account)
    {
        for(Account i : following)
        {
            if(i.getUsername() == account.getUsername()) return false; 
        }
        return true; 
    }

    public void viewInbox(LDLinkedList<Account> accounts, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }
        System.out.println("Viewing inbox ...\n------------------");

        try{
            for(int i = 0; i < getInbox().size(); i++)
            {
                System.out.println("Message ID: "+ getInbox().get(i).getMessageId());
                System.out.println("From: "+ accounts.get(getInbox().get(i).getSenderId()-1).getUsername());
                System.out.println("To: "+ this.getUsername());
                System.out.println("Message: "+ getInbox().get(i).getContent());
                System.out.println("---------------------");
            }
            history.add(VIEW + "inbox messages");
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public void viewOutbox(LDLinkedList<Account> accounts, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }

        System.out.println("Viewing outbox ...\n------------------");

        for(int i = 0; i < getOutbox().size(); i++)
        {
            System.out.println("Message ID: "+ getOutbox().get(i).getMessageId());
            System.out.println("From: "+ this.getUsername());
            System.out.println("To: "+ accounts.get(getOutbox().get(i).getReceiverId()-1).getUsername());
            System.out.println("Message: "+ getOutbox().get(i).getContent());
            System.out.println("---------------------");
        }
        history.add(VIEW + "outbox messages");
    }
    public boolean isBlocked(Account account)
    {
        try{

        }catch(Exception e){
            e.printStackTrace();
        }
        for(int i = 0; i < this.getBlocked().size(); i++)
        {
            if(this.getBlocked().get(i).getUsername() == account.getUsername()) return true; 
        }
        return false; 
    }

    public void viewInteractions(Account targetAccount, LDLinkedList<Account> accounts, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }

        int numComment = 1; 
        System.out.println("Viewing "+ targetAccount.getUsername() + "'s posts' interactions...");
        System.out.println("-----------------------------------------");
        try{

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
                System.out.println("------------------------");
            }
            history.add(VIEW + targetAccount.getUsername() + "'s posts.");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public boolean isBlockedByAccount(Account account)
    {
        try{
            for(int i = 0; i < account.getBlocked().size(); i++)
            {
                if(account.getBlocked().get(i).getUsername() == this.username) return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }

    public void block(Account account, int loginAccountId)
    {
        if(isBlocked(account))
            return;
        try
        {
            if(isInFollowing(account))
            {
                unfollow(account, loginAccountId);
            }
            if(isInFollowers(account))
            {
                // try{
                    account.getFollowing().remove(this);
                    getFollowers().remove(account);
                // }catch(Exception e){
                //     System.out.println("Blocking Object issue " + e.getMessage());
                // }

            }

            removeLikeInBlocking(account);
            removeAccountLikeInBlocking(account);
            removeCommentInBlocking(account);
            removeAccountCommentInBlocking(account);

            blocked.add(account);       
            history.add(BLOCK + account.getUsername());
        }catch(Exception e){
            System.out.println("Blocking Issue");
            e.printStackTrace();
        }
 
    }

    public void unblock(Account account, int loginAccountId)
    {
        if(loginAccountId != this.getAccountId())
        {
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return; 
        }

        if(isBlocked(account))
        {
            blocked.remove(account);
            history.add(UNBLOCK + account.getUsername());
        }
    }
    private void removeLikeInBlocking(Account account)
    {
        try{
            for(int i = 0; i < account.getPosts().size(); i++)
            {
                if(account.getPosts().get(i).getLikes().size() != 0)
                {
                    for(int j = 0; j < account.getPosts().get(i).getLikes().size(); j++)
                    {
                        if(account.getPosts().get(i).getLikes().get(j).getAccountId() == getAccountId())
                            account.unlike(account.getPosts().get(i),
                                      account.getPosts().get(i).getLikes().get(j));
                    }
                }
            }
        }catch(Exception e)
        {
            System.out.println("An error occured" + e.getMessage());
        }

    }
    private void removeAccountLikeInBlocking(Account account)
    {
        try{
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
        }catch(Exception e){
            System.out.println("An error occured " + e.getMessage());
        }

    }

    private void removeCommentInBlocking(Account account)
    {
        try{
            for(int i = 0; i < account.getPosts().size(); i++)
            {
                if(account.getPosts().get(i).getComments().size() != 0)
                {
                    for(int j = 0; j < account.getPosts().get(i).getComments().size(); j++)
                    {
                        if(account.getPosts().get(i).getComments().get(j).getAccountId() == getAccountId())
                            account.uncomment(account.getPosts().get(i),
                                      account.getPosts().get(i).getComments().get(j));
                    }
                }
            }
        }catch(Exception e){
            System.out.println("An error occured " + e.getMessage());
        }

    }

    private void removeAccountCommentInBlocking(Account account)
    {
        try{
            for(int i = 0; i < this.getPosts().size(); i++)
            {
                if(getPosts().get(i).getComments().size() != 0)
                {
                    for(int j = 0; j < getPosts().get(i).getComments().size(); j++ )
                    {
                        if(getPosts().get(i).getComments().get(j).getAccountId() == account.getAccountId())
                            uncomment(getPosts().get(i),getPosts().get(i).getComments().get(j));
                    }
                }
            }
        }catch(Exception e){
            System.out.println("An error occured " + e.getMessage());
        }

    }

    public void checkingOutbox(int loginAccountId){
        if(loginAccountId != this.getAccountId()){
            System.out.println("Unable to view outbox, Different account currently logged in.");
            return;
        }
        System.out.print("Checking outbox...");
        System.out.println("\nThere is/are "+ (this.outbox.size()) +" message(s) in the outbox");
    }

    /**
     * checks the coming messages
     * @param loginAccountId login check
     */
    public void checkingInbox(int loginAccountId){
        if(loginAccountId != this.getAccountId()){
            System.out.println("Unable to view inbox, Different account currently logged in.");
            return;
        }
        System.out.print("Checking inbox...");
        System.out.println("\nThere is/are "+ (this.inbox.size()) +" message(s) in the inbox");
    }

    private boolean isInFollowing(Account account)
    {
        try{
            for(int i = 0; i < following.size(); i++)
            {
                if(following.get(i).getUsername() == account.getUsername())return true;
            }
        }catch(Exception e){
            System.out.println("An error occured " + e.getMessage());
        }

        return false;
    }

    private boolean isInFollowers(Account account)
    {
        try{
            for(int i = 0; i < account.getFollowing().size(); i++)
            {
                if(account.getFollowing().get(i).getUsername() == this.getUsername())return true;
            }
        }catch(Exception e){
            System.out.println("An error occured " + e.getMessage());
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

    public LDLinkedList<Post> getPosts()
    {
        return posts;
    }

    public LDLinkedList<Account> getFollowers()
    {
        return followers;
    }

    public LDLinkedList<Account> getFollowing()
    {
        return following;
    }

    public LDLinkedList<Account> getBlocked()
    {
        return this.blocked;
    }

    public LDLinkedList<Message> getInbox()
    {
        return inbox; 
    }
    public LDLinkedList<Message> getOutbox()
    {
        return outbox;
    }

    public LDLinkedList<String> getHistory()
    {
        return history;
    }
}
