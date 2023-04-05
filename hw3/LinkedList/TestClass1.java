package LinkedList;

import java.util.LinkedList;

public class TestClass1 {

    public static void main(String[] args) {

        int loginAccountid = -1;
        boolean isViewedProfile = false; 
        LinkedList<Account> accounts = new LinkedList<Account>();
        Account gizemsungu = new Account(1, "gizemsungu", "10.06.1999", "istanbul");
        Account sibelgulmez = new Account(2, "sibelgulmez", "10.06.1999", "istanbul");
        Account gokhankaya = new Account(3, "gokhankaya", "10.06.1999", "istanbul");
        Account oguzmutlu = new Account(4, "oguzmutlu", "10.06.1999", "istanbul");
        // Post post1  = new Post(1, gizemsungu.getAccountId(), "First Post");

        accounts.add(gizemsungu);
        accounts.add(sibelgulmez);
        accounts.add(gokhankaya);
        accounts.add(oguzmutlu);
        System.out.println("Step 2... Logging into account (username: " + sibelgulmez.getUsername() + ")...");
        loginAccountid = sibelgulmez.login(loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.println("Step 3... Sharing two posts...");
        Post post1 = new Post(1,sibelgulmez.getAccountId(),"I like Java.");
        Post post2 = new Post(2,sibelgulmez.getAccountId(),"Java the coffeee...");
        sibelgulmez.sharePost(post1, loginAccountid);
        sibelgulmez.sharePost(post2, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.println("Step 4... Following gizemsungu and gokhankaya...");
        sibelgulmez.follow(gizemsungu, loginAccountid);
        sibelgulmez.follow(gokhankaya, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 5... ");
        loginAccountid = sibelgulmez.logout();
        System.out.println();
        
        // **************************************************************************************************************
        System.out.println("Step 6... Logging into another account (username: " + gokhankaya.getUsername() + ")...");
        loginAccountid = gokhankaya.login(loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 7... ");
        isViewedProfile = gokhankaya.viewProfile(sibelgulmez, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 8... ");
        gokhankaya.viewPost(sibelgulmez, isViewedProfile, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 9... ");
        gokhankaya.like(sibelgulmez, post1, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 10... ");
        Comment comment = new Comment("me too!");
        gokhankaya.comment(sibelgulmez, post1, comment, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.println("Step 11... Following sibelgulmez and gizemsungu... ");
        gokhankaya.follow(sibelgulmez, loginAccountid);
        gokhankaya.follow(gizemsungu, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 12... ");
        Message message1 = new Message(1, gokhankaya.getAccountId(), gizemsungu.getAccountId(), "This homework is too easy!");
        gokhankaya.sendMessage(gizemsungu, message1, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 13... ");
        loginAccountid = gokhankaya.logout();
        System.out.println();
        // **************************************************************************************************************
        System.out.println("Step 14... Logging into another account (username: " + gizemsungu.getUsername() + ")...");
        loginAccountid = gizemsungu.login(loginAccountid);
        System.out.println();
        // *************************************************************************************************************

        System.out.print("Step 15... ");
        gizemsungu.checkingOutbox(loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 16... ");
        gizemsungu.checkingInbox(loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 17... ");
        gizemsungu.viewInbox(accounts, loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 18... ");
        isViewedProfile = gizemsungu.viewProfile(sibelgulmez, loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 19... ");
        gizemsungu.viewPost(sibelgulmez, isViewedProfile, loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 20... ");
        gizemsungu.viewInteractions(sibelgulmez, accounts, loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 21... ");
        gizemsungu.like(sibelgulmez, post1, loginAccountid);
        gizemsungu.like(sibelgulmez,post2, loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 22... ");
        gizemsungu.viewInteractions(sibelgulmez, accounts, loginAccountid);
        System.out.println();
        // *************************************************************************************************************     
        loginAccountid = gizemsungu.logout();
        System.out.println();
        // *************************************************************************************************************   
    }
    
}
