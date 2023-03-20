public class Message {

    private int messageID;
    private int senderID; 
    private int receiverID;
    private String content;


    /**
     * Default empty constructor of Message class
     */
    public Message(){
        //intentionally empty
    }
    /**
     * Contructor that includes only content value
     * helps class to create id of message after initialization
     * @param content String Message content 
     */
    public Message(String content){
        this.content = content; 
    }
    /**
     * Constructor which includes content and senderid after initialization
     * @param content String Message content 
     * @param senderID Message sender accountid 
     */
    public Message(String content, int senderID){
        this.content = content;
        this.senderID = senderID;
    }
    /**
     * Constructor which includes content, senderid and receiver id after initialization
     * Does not include messageid because after initialization message id found by length of inbox/outbox count 
     * @param content Message content 
     * @param senderID Message sender accountid 
     * @param receiverID Message receiver accountid 
     */
    public Message(String content, int senderID, int receiverID){
        this.content = content; 
        this.senderID = senderID;
        this.receiverID = receiverID;    
    }
    /**
     *  Constructor which includes Messageid, content, senderid and receiver id after fully initialization
     * @param messageId Message id, length of accounts specific messages 
     * @param senderID Message sender accountid 
     * @param receiverId Message receiver accountid 
     * @param content Message content 
     */
    public Message(int messageId, int senderID, int receiverId, String content){
        this.content = content; 
        this.senderID = senderID;
        this.receiverID = receiverId;
        this.messageID = messageId;    
    }


    /**
     * gets messageid 
     * @return  messageid 
     */
    public int getMessageID(){
        return this.messageID;
    }
    /**
     * 
     * @return senderid
     */
    public int getSenderID(){
        return this.senderID;
    }

    /**
     * 
     * @return receiverid
     */
    public int getReceiverID(){
        return this.receiverID;
    }
    
    /**
     * 
     * @return content of message
     */
    public String getContent(){
        return this.content;
    }
}
