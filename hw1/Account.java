public class Account {

    private String username;
    static int userID; 
    private String birthDate; 
    protected int uID;
    private String location; 
    protected int accountId;

    private Account[] following = new Account[1];
    private Account[] followers = new Account[1];
    private Post[] posts = new Post[1];
    protected Message[] inbox = new Message[1];
    private Message[] outbox = new Message[1];
    private Account[] blockedAccounts = new Account[1];

    //dokumantasyon yapilacak.
    /**
     * Empty no parameter constructor intentionally
     */
    public Account(){
        //empty
    }

    /**
     * Fully parameter constructor includes all information about account 
     * @param uid user id of account giving outside of class 
     * @param username  username which is unique
     * @param birthDate birthdate of account
     * @param location location where account lives
     */
    public Account(int uid, String username, String birthDate, String location){
        this.accountId = uid;
        this.username = username;
        this.birthDate = birthDate;
        this.location = location;
        System.out.println("An account with username " + this.username + " has been created.");
    }
    /**
     * includes only username of the account 
     * @param username username which is unique 
     */
    public Account(String username){
        this.username = username;
        userID++;
    }
    /**
     * creating account with only user information without location
     * @param username unique username
     * @param birthDate user birthday
     */   
    public Account(String username, String birthDate)
    {
        this.username = username;
        this.birthDate = birthDate;
        //if username is unique increase userID 
        userID++; 
        this.uID = userID;
    }
    /**
     * user id incrementing by static (not using in this homework)
     * @param username unique username
     * @param birthDate account birthday
     * @param location account location
     */
    public Account(String username, String birthDate, String location)
    {
        this.username = username;
        this.birthDate = birthDate;
        this.location = location; 
        //if username is unique increase userID 
        userID++; 
        this.uID = userID;
    }
    /**
     * checks the account is logged in or not
     * if loginaccount of test class is -1 then no account logged in currently 
     * if loginaccountid which sent from test class is equal to the this.accoutid then current account logged in 
     * else of these conditions another account tries to reach logging in
     * this function keeps this information and process it  
     * @param loginAccountId gets from testclass which keeps current logged in account id if -1 then no logged in account
     * @return  current loginAccountid
     */
    public int login(int loginAccountId){
        // System.out.println("Logging into an account (username: "+ this.getUsername() + ")...");
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

    /**
     * if some account logged out then in testclass loginaccountid have to be -1 
     * confirm that any account logged in 
     * @return -1 constant all accounts logged out.
     */
    public int logout(){
        System.out.println("Logging out from account (username: "+ this.getUsername() + ")...");
        return -1;
    }

    /**
     * sets the user id  inside of class 
     * @param uidOld old user id
     */
    public void setUserID(int uidOld){
        this.uID = uidOld+1;
    }

    /**
     * views the profile.
     * checks login account 
     * checks blocked by or blocking accounts
     * Then view user information and profile information
     * @param newAccount account which viewing the profile 
     * @param loginAccountid login account check 
     * @return if viewing is successful then returns true otherwise false
     */
    public boolean viewProfile(Account newAccount, int loginAccountid){

        if(!checkLogin(loginAccountid)){
            System.out.println("Unable to view profile, Different account or no account currently logged in.");
            return false;
        }

        int followingNumber = newAccount.getFollowing().length - 1; 
        int followerNumber = newAccount.getFollowers().length -1; 
        int postNum = newAccount.getPosts().length -1;

        if(checkBlocked(newAccount) && checkblock(newAccount)){
            System.out.println("Viewing " + newAccount.getUsername() + " profile...");
            System.out.println("--------------------------------------");
            System.out.print( "User ID: " + (newAccount.accountId+1) + "\n" +
                            "Username: " + newAccount.username + "\n" +
                            "Location: " + newAccount.location + "\n" +
                            "Birth Date: " + newAccount.birthDate + "\n" +
                            newAccount.username + " is following " + followingNumber + " account(s) and has " + followerNumber + " follower(s)."+ "\n"
            );
            if(followingNumber != 0){
                Account[] followingAccounts = new Account[newAccount.getFollowing().length];
                followingAccounts = newAccount.getFollowing();
                System.out.print(newAccount.username + " is following: " );
                if(followingAccounts[0] != null ){
                    for(int i = 0; i < followingNumber; i++){
                        System.out.print(followingAccounts[i].username + ", ");
                    }
                }
                System.out.println();
            }

            
            if(followerNumber != 0){
                System.out.print("The followers of "+newAccount.username + " are: ");
                Account[] followerAccounts = new Account[newAccount.getFollowers().length];
                followerAccounts = newAccount.getFollowers();
                if(followerAccounts[0] != null ){
                    for(int i = 0; i < followerNumber; i++){
                        System.out.print(followerAccounts[i].username + ", ");
                    }
                }
                System.out.println();
            }
            System.out.println(newAccount.username + " has " + postNum + " posts.");

            return true;
        }
        else{
            System.out.println("UNABLE TO VIEW "+newAccount.getUsername()+"'s PROFILE (BLOCKED)");
            return false;
        }
    }
    /**
     * following the account, add following to the current account and add follower to followed account
     * checks logged in 
     * checks blocked or not 
     * @param newAccount account which want to follow
     * @param loginAccountid login check
     * @return returns followed account to add follower to that accounts profile 
     */
    public Account follow(Account newAccount, int loginAccountid){
        
        if(!checkLogin(loginAccountid)){
            System.out.println("Unable to follow profile, Different account currently logged in.");
            return newAccount;
        }
        
        if(this.following[0] == null && checkBlocked(newAccount) && checkblock(newAccount)){
            this.following = new Account[2];
            this.following[0] = newAccount;
            // this.following[0] = newAccount;
            // this.following[1] = new Account();
            return addFollower(newAccount);
        }
        else{
            if(isValidtoFollow(newAccount)){
                Account[] temp = new Account[this.following.length];
                for(int i = 0; i<this.following.length; i++){
                    temp[i] = this.following[i];
                }
    
                this.following = new Account[temp.length+1];
                for(int i = 0; i<temp.length-1; i++){
                    // this.following[i] = new Account();
                    this.following[i] = temp[i];   
                }
                this.following[temp.length-1] = new Account();
                this.following[temp.length-1] = newAccount; 
                return addFollower(newAccount);
            }
            System.out.println("Already Following");
            return newAccount;
        }
    }
    /**
     * checks validity of accounts following
     * checks blocked or not 
     * checks following account in account list
     * @param newAccount checking account 
     * @return if account is blocked return false
     */
    private boolean isValidtoFollow(Account newAccount){

        if(!checkBlocked(newAccount) && !checkblock(newAccount))return false;
        if(newAccount == this) return false;
        for(int i = 0; i < this.following.length -1;i++ ){
            if(newAccount == this.following[i]) return false;
        }
        return true;
    }
    
    /**
     * adding follower to target account. helper method of follow method
     * increment target account follower account number and followers field by one 
     * @param newAccount tarrget account of incrementing follower account by one 
     * @return new target account
     */
    public Account addFollower(Account newAccount){

        if(newAccount.followers[0] == null){
            newAccount.followers = new Account[2];
            newAccount.followers[0] = this;
        }
        else{
            Account[] temp = new Account[newAccount.followers.length];
            for(int i = 0; i<temp.length; i++){
                temp[i] = newAccount.followers[i];
            }
            newAccount.followers = new Account[temp.length+1];
            
            for(int i = 0; i<temp.length ; i++){
                // newAccount.followers[i] = new Account();
                newAccount.followers[i] = temp[i];
            }

            newAccount.followers[temp.length-1] = this;
        }
        return newAccount;
    }
    /**
     * like method with constructor like class 
     * takes all accounts and like class then search posts in accounts with the help of like classes information that give us to search. 
     * @param accounts  all accounts in the program 
     * @param like like class constructior which includes, interactionid postid...
     */
    public void like(Account[] accounts, Like like){
        
        if(isValidtoSendMessage(accounts[like.getAccountId()]) && checkBlocked(accounts[like.getAccountId()])){
            accounts[like.getAccountId()].getPosts()[like.getPostId()].addLike(this, like);
            return; 
        }
        else{
            System.out.println("Follow for like");
        }
    }

    /**
     * overriding of like method buy only take which accounts which post liking information
     * check logged in 
     * @param accounts targetaccount for liking a post
     * @param post post of target account
     * @param loginAccountId login check 
     */
    public void like(Account accounts, Post post, int loginAccountId){
        if(!checkLogin(loginAccountId)){
            System.out.println("Unable to like post, Different account currently logged in.");
            return;
        }
        // if(isValidtoSendMessage(accounts)){
            // System.out.println("aaaaa " + post.getPostId());
        if(checkBlocked(accounts) && checkblock(accounts)){
            System.out.println("Liking " + accounts.getUsername() + "'s posts...' ");
            accounts.getPosts()[post.getPostId()-1].addLike(this, new Like(post.getPostLikes().length-1, this.accountId, post.getPostId()));
            return;
        }
        else{
            System.out.println("UNABLE TO LIKE"+ accounts.getUsername()+ "'s POST. (BLOCKED) ");
        }
        // }
        // else{
        //     System.out.println("Follow for like");
        // }
    }
    /**
     * leave a comment dynamically inside ti target accounts target post 
     * checks logged in
     * checks blocking 
     * @param accounts target account to see posts 
     * @param post target post to interact a comment 
     * @param comment comment interaction 
     * @param loginAccountId login check
     */
    public void comment(Account accounts, Post post, Comment comment, int loginAccountId){

        if(!checkLogin(loginAccountId)){
            System.out.println("Unable to comment to Post, Different account currently logged in.");
            return;
        }
        // if(isValidtoSendMessage(accounts)){
            System.out.println("Adding a comment on a post of " + accounts.getUsername());
            accounts.getPosts()[post.getPostId()-1].addComment(this, comment);
        // }
        // else{
        //     System.out.println("Follow for comment");
        // }
    }
    /**
     * Viewing the likes and comments of a post 
     * check login accounts
     * @param targetAccount target account to see interaction
     * @param accounts all accounts in the program
     * @param loginAccountId login check 
     */
    public void viewInteractions(Account targetAccount, Account[] accounts, int loginAccountId){
        if(!checkLogin(loginAccountId)){
            System.out.println("Unable to comment to Post, Different account currently logged in.");
            return;
        }
        System.out.println("Viewing "+ targetAccount.getUsername() + " posts' interactions...");
        System.out.println("---------------------------------");
        for(int i = 0; i < targetAccount.posts.length-1; i++){
            System.out.println("(PostID: " + targetAccount.posts[i].getPostId() + "): " +targetAccount.posts[i].getContent());

            if((targetAccount.posts[i].getPostLikes().length-1) == 0){
                System.out.println("The post has no like.");
            }
            else{
                System.out.print("The post was liked by the following account(s) : ");
                for(int j = 0 ; j < targetAccount.posts[i].getPostLikes().length-1; j++){
                    System.out.print(accounts[targetAccount.posts[i].getPostLikes()[j].getAccountId()].getUsername()+", ");
                }
                System.out.println();
            }

            if((targetAccount.posts[i].getPostComment().length-1) == 0){
                System.out.println("The post has no comment.");
            }
            else{
                System.out.print("\nThe post has "+ (targetAccount.posts[i].getPostComment().length -1)+" comment(s)");
                for(int j = 0 ; j < targetAccount.posts[i].getPostComment().length-1; j++){
                    System.out.println();
                    System.out.print("Comment " + (j+1) + ": ");
                    System.out.print("'" + accounts[targetAccount.posts[i].getPostComment()[j].getAccountId()].getUsername()+"' said "+"'"+ targetAccount.posts[i].getPostComment()[j].getContent()+" '");
                }
            }
            
            System.out.println("\n--------------");
        }
    }
    /**
     * shares a post dynamically 
     * @param post post class which includes content
     * @param loginAccountId login check
     */
    public void sharePost(Post post, int loginAccountId){
        if(loginAccountId != this.getAccountId()){
            System.out.println("Unable to share post, Different account currently logged in.");
            return;
        }
        if(posts[0] == null ){
            posts = new Post[2];
            posts[0] = post; 
            posts[0].incrementPostId(posts.length-2);
            return;
        }
        else{
            Post[] temp = new Post[posts.length];

            for(int i = 0 ; i<temp.length; i++){// -1 yaz hata verirse
                temp[i] = this.posts[i];
            }

            this.posts = new Post[temp.length+1];

            for(int i = 0; i < temp.length-1; i++){
                this.posts[i] = temp[i];
            }
            this.posts[temp.length-1] = post;
            // this.posts[temp.length] = new Post();
        }
    }
    /**
     * send a message to followed account 
     * check login information 
     * check blocked information 
     * check follow information 
     * @param newAccount targetaccount of sending message
     * @param newMessage message content and message id of message class 
     * @param loginAccountId login check
     */
    public void sendMessage(Account newAccount, Message newMessage, int loginAccountId){

        if(!checkLogin(loginAccountId)){
            System.out.println("Unable to send Message, Different account currently logged in.");
            return;
        }
        if(!checkBlocked(newAccount) || !checkblock(newAccount)){
            System.out.println("UNABLE TO SEND MESSAGE TO "+newAccount.getUsername()+". (BLOCKED)");
            return;
        }
        if(!isValidtoSendMessage(newAccount)){
            System.out.println("Follow for message.");
            return;
        }
        System.out.println("Sending a message to " + newAccount.getUsername() + "...");
        if(outbox[0] == null){
            this.outbox = new Message[2];
            this.outbox[0] = newMessage;
            sendMessageInbox(newAccount, newMessage);
            return;
        }
        else{
            Message[] temp = new Message[this.outbox.length];

            for(int i = 0; i < temp.length -1; i++){
                temp[i] = this.outbox[i];
            }

            this.outbox = new Message[temp.length+1];

            for(int i = 0; i < temp.length-1; i++){
                this.outbox[i] = temp[i];
            }

            this.outbox[temp.length-1] = newMessage;
            sendMessageInbox(newAccount, newMessage);
            return;
        }
        
    }
    /**
     * this is generic function for all operations that have to operate specific process accounts have to be follow target account 
     * this function check that situation
     * @param newAccount target account of checking in following field
     * @return if is valid to create a process like message, like, comment returns true
     */
    private boolean isValidtoSendMessage(Account newAccount){ //private
        for(int i = 0; i < this.following.length -1; i++){
            if(newAccount == this.following[i]) return true;
        }
        return false; 
    }
    /**
     * Send a message to receivers inbox dynamically 
     * @param newAccount target account 
     * @param newMessage message content
     */
    private void sendMessageInbox(Account newAccount, Message newMessage){ // private

        if(newAccount.inbox[0]== null){
            newAccount.inbox = new Message[2];
            // newAccount.inbox[0] = new Message();
            newAccount.inbox[0] = newMessage; 
        }
        else{
            Message[] temp = new Message[newAccount.inbox.length];

            for(int i = 0; i< temp.length-1; i++){
                temp[i] = newAccount.inbox[i];
            }

            newAccount.inbox = new Message[temp.length+1];

            for(int i = 0; i < temp.length-1; i++){
                newAccount.inbox[i] = temp[i];
            } 
            newAccount.inbox[temp.length-1] = newMessage; 
        }
    }
    /**
     * view messages of received 
     * check login information
     * @param accounts all account in the program
     * @param loginAccountId login check
     */
    public void viewInbox(Account[] accounts, int loginAccountId){
        if(!checkLogin(loginAccountId)){
            System.out.println("Unable to comment to Post, Different account or no account currently logged in.");
            return;
        }
        System.out.println("Viewing Inbox ...");

        for(int i = 0 ; i< this.inbox.length-1; i++){
            System.out.println("------------------");
            System.out.println("Message ID: " + (this.inbox[i].getMessageID()-1));
            System.out.println("From: " + accounts[this.inbox[i].getSenderID()].getUsername());
            System.out.println("To: " + accounts[this.inbox[i].getReceiverID()].getUsername());
            System.out.println("Message: " + this.inbox[i].getContent());
        }
    }
    
    /**
     * viewing post of specific account 
     * check login 
     * check blocked situation
     * @param newAccount target account which has post 
     * @param viewed checks the viewProfile method before invoking viewPost method 
     * @param loginAccountId login check
     */
    public void viewPost(Account newAccount, boolean viewed, int loginAccountId){

        if(!checkLogin(loginAccountId)){
            System.out.println("Unable to view Post, Different account currently logged in.");
            return;
        }
        //viewed kullanilabilir.
        if(newAccount == this ){
            System.out.println("Viewing " + newAccount.getUsername() + " 's posts...");
            System.out.println("--------------------");
            for(int i = 0 ; i < this.posts.length-1; i ++){
                System.out.println("(Post ID: "+ this.posts[i].getPostId()+ ") " + this.posts[i].getContent());            }
        }
        // if(isValidtoSendMessage(newAccount) && viewed )
        else{
            System.out.println("Viewing " + newAccount.getUsername() + " 's posts...");
            System.out.println("--------------------");
            for(int i = 0 ; i < newAccount.posts.length-1; i ++){
                System.out.println("(Post ID: "+ newAccount.posts[i].getPostId()+ ") " + newAccount.posts[i].getContent());
            }
        }
    }

    /**
     * checks the send messages
     * @param loginAccountId login check
     */
    public void checkingOutbox(int loginAccountId){
        if(!checkLogin(loginAccountId)){
            System.out.println("Unable to view outbox, Different account currently logged in.");
            return;
        }
        System.out.print("Checking outbox...");
        System.out.println("\nThere is/are "+ (this.outbox.length-1) +" message(s) in the outbox");
    }

    /**
     * checks the coming messages
     * @param loginAccountId login check
     */
    public void checkingInbox(int loginAccountId){
        if(!checkLogin(loginAccountId)){
            System.out.println("Unable to view inbox, Different account currently logged in.");
            return;
        }
        System.out.print("Checking inbox...");
        System.out.println("\nThere is/are "+ (this.inbox.length-1) +" message(s) in the inbox");
    }
    /**
     * sets a blocked account which user wants to block 
     * @param account blocked account 
     * @param loginAccountId login check 
     */
    public void block(Account account, int loginAccountId){
        if(!checkLogin(loginAccountId)){
            System.out.println("Unable to unblock, Different account or any account currently logged in.");
            return;
        }
        if(this.blockedAccounts[0] == null){
            System.out.println("Blocking "+ account.username+"...");
            this.blockedAccounts = new Account[2];
            this.blockedAccounts[0] = account;
        }
        else{
            System.out.println("Blocking "+ account.username+"...");
            Account[] temp = new Account[this.blockedAccounts.length];

            for(int i = 0; i< temp.length-1; i++){
                temp[i] = this.blockedAccounts[i];
            }

            this.blockedAccounts = new Account[temp.length+1];

            for(int i = 0; i< temp.length-1; i++){
                this.blockedAccounts[i] = temp[i];
            }
            this.blockedAccounts[temp.length-1] = account;
        }
    }

    /**
     * prints the blocked accounts 
     * @param loginAccountId login check
     */
    public void showBlokedAccounts(int loginAccountId){
        if(!checkLogin(loginAccountId)){
            System.out.println("Unable to unblock, Different account or any account currently logged in.");
            return;
        }
        System.out.println("Blocked Accounts.");
        for(int i = 0; i<this.blockedAccounts.length-1; i++ ){
            System.out.println(this.blockedAccounts[i].getUsername());
        }
    }

    /**
     * check if current user blocked by another account 
     * @param account checking account 
     * @return if false current user blocked by target account otherwise true
     */
    private boolean checkBlocked(Account account){

        for(int i = 0; i<account.getBlockedAccounts().length-1; i++ ){
            if(this == account.getBlockedAccounts()[i]) return false;
        }
        return true;
    }
    /**
     * checking current users block accounts 
     * @param account that user wants to find blocked or not by himself/herself
     * @return if true account is not blocked, false account is blocked 
     */
    private boolean checkblock(Account account){
        for(int i = 0; i<this.blockedAccounts.length-1; i++ ){
            if(account == this.blockedAccounts[i]) return false;
        }
        return true;
    }

    /**
     * check the current account is logged in or another account logged in 
     * @param loginAccountId login check parameter
     * @return if true current account logged in, otherwise false
     */
    private boolean checkLogin(int loginAccountId){
        if(loginAccountId == this.getAccountId()) return true;
        else return false;
    }

    public Account[] getBlockedAccounts(){
        return this.blockedAccounts;
    }

    public Message[] getInboxMessage(){
        return this.inbox;
    }
    
    public Post[] getPosts(){
        return this.posts;
    }
    public String getUsername(){
        return username;
    }

    public static int getUserID(){
        return userID;
    }
    
    public int getUID(){
        return this.uID;
    }

    public String getBirthDate(){
        return this.birthDate;
    }

    public String getLocation(){
        return this.location; 
    }

    public int getPostNumber(){
        return this.posts.length;
    }

    public Account[] getFollowers(){
        return this.followers;
    }

    public Account[] getFollowing(){
        return this.following;
    }

    public int getPostNum(){
        return posts.length;
    }

    public Message[] getOutboxMessage(){
        return this.outbox;
    }
    
    public int getAccountId(){
        return this.accountId;
    }
}
