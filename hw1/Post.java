public class Post{

    private String content;
    private int accountId;
    private int postID;
    private Like[] likes = new Like[1];
    private Comment[] comments = new Comment[1]; 
    
    
    /**
     * Default constructor intentionally empty
     */
    public Post(){
        //intentionally empty  
    }

    /**
     * constructor just takes content of a post
     * after this invoke we increment postid 
     * @param postContent content of a post
     */
    public Post(String postContent){
        this.content = postContent;
    }
    /**
     * 
     * @param id id of a post which is unique for each accounts each posts
     * @param postContent content of a post
     */
    public Post(int id, String postContent){
        this.postID = id; 
        this.content = postContent; 
    }
    /**
     * fully initialization of post constructor.
     * @param id id of a post which is unique for each accounts each posts
     * @param postContent content of a post
     * @param accountId account which shares posts 
     */
    public Post(int id, String postContent, int accountId){
        this.postID = id;
        this.content = postContent;
        this.accountId = accountId;
    }

    /**
     * 
     * @param postContent
     */
    public void addContent(String postContent){
        this.content = postContent;
        postID++; // super.... kullanilabilir.
        // return this.content;
    }
    /**
     * incrementing postid in every new post shared
     * @param postID old post id for incrementing 
     */
    public void incrementPostId(int postID){
        this.postID = postID+1;
    }

    /**
     * Adding like to a post dynamically by incrementing by 1 
     * when every valid like operation done. Each like instance initially
     * has length of 2, then every time new like come lengths of likes 
     * always 1 higher than actual. for Nullptr exception 
     * @param account takes which account that main class interact with post 
     * @param like adding a like which includes like constructor parameters.
     */
    public void addLike(Account account, Like like){

        if(this.likes[0] == null ){
            this.likes = new Like[2];
            this.likes[0] = new Like(likes.length-1,account.getAccountId(), postID);         
        }
        else{
            Like[] temp = new Like[likes.length];

            for(int i = 0; i < temp.length-1 ; i++){
                temp[i] = likes[i];
            }

            this.likes = new Like[temp.length+1];

            for(int i = 0; i < temp.length-1; i++){
                likes[i] = temp[i];
            }

            likes[temp.length-1] = new Like(temp.length, account.getAccountId(), this.postID);
        }
    }
    /**
     * Adding comment to a post dynamically by incrementing by 1 
     * when every valid comment operation done. Each comment instance initially
     * has length of 2, then every time new comments come lengths of comments 
     * always 1 higher than actual. for Nullptr exception 
     * @param account takes which account that main class interact with post 
     * @param comment adding a comment which includes comment constructor parameters.
     */
    public void addComment(Account account, Comment comment){
        if(this.comments[0] == null){
            this.comments = new Comment[2];
            // this.comments[0] = new Comment(1, account.getAccountId(), this.postID,content);
            this.comments[0] = new Comment(1, account.getAccountId(), this.postID,comment.getContent());; 
        }
        else{
            Comment[] temp = new Comment[comments.length];

            for(int i = 0; i< temp.length-1; i++){
                temp[i] = comments[i];
            }

            this.comments = new Comment[temp.length+1];

            for(int i = 0; i < temp.length-1; i++){
                this.comments[i] = temp[i];
            }
            this.comments[temp.length-1] = new Comment(temp.length, account.getAccountId(), this.postID,comment.getContent());
        }
    }

    /**
     * 
     * @return gets postID which is unique for each individual account 
     */
    public int getPostId(){
        return postID;
    }
    /**
     * 
     * @return gets posts content
     */
    public String getContent(){
        return this.content;
    }
    /**
     * 
     * @return likes of a specific posts 
     */
    public Like[] getPostLikes(){
        return this.likes;
    }
    /**
     * 
     * @return comments of o specific posts 
     */
    public Comment[] getPostComment(){
        return this.comments;
    }

    /**
     * 
     * @return gets account id which specific post belongs
     */
    public int getAccountId(){
        return this.accountId;
    }






    



    
}
