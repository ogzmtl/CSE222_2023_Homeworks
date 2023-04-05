package LDLinkedList;

public class Message {
        
    private Integer messageId;
    private Integer senderId; 
    private Integer receiverId; 
    private String content; 

    public Message()
    {
        //intentionally empty
    }

    public Message(int messageId, int senderId, int receiverId, String content)
    {
        this.messageId = messageId;
        this.senderId = senderId; 
        this.receiverId = receiverId; 
        this.content = content; 
    }

    public String getContent()
    {
        return content; 
    }

    public Integer getReceiverId()
    {
        return receiverId;
    }

    public Integer getSenderId()
    {
        return senderId;
    }

    public Integer getMessageId()
    {
        return messageId;
    }

}
