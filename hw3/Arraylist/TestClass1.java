package Arraylist;

public class TestClass1 {

    public static void main(String[] args) {
        
        Account gizemsungu = new Account(1, "gizemsungu", "10.06.1999", "istanbul");
        
        Post post1  = new Post(1, gizemsungu.getAccountId(), "First Post");
        gizemsungu.sharePost(post1);
        gizemsungu.viewPost();
        
    }
    
}
