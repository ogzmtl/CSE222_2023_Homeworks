package Arraylist;

import java.util.ArrayList;

public class TestClass4 {
    public static void main(String[] args) throws Exception 
    {
        double startTime = System.currentTimeMillis();

        int loginAccountid = -1;
        boolean isViewedProfile = false; 
        ArrayList<Account> accounts = new ArrayList<Account>();
        Account gizemsungu = new Account(1, "gizemsungu", "10.06.1999", "istanbul");
        // createAccount(accounts, gizemsungu); 
        Account sibelgulmez = new Account(2, "sibelgulmez", "10.06.1999", "istanbul");
        // createAccount(accounts, sibelgulmez); 
        Account gokhankaya = new Account(3, "gokhankaya", "10.06.1999", "istanbul");
        // createAccount(accounts, gokhankaya); 
        Account oguzmutlu = new Account(4, "oguzmutlu", "10.06.1999", "istanbul");
        // createAccount(accounts, oguzmutlu); 
        Account account5 = new Account(5, "account5", "10.06.1999", "istanbul");
        Account account6 = new Account(6, "account6", "10.06.1999", "istanbul");
        Account account7 = new Account(7, "account7", "10.06.1999", "istanbul");
        Account account8 = new Account(8, "account8", "10.06.1999", "istanbul");
        Account account9 = new Account(9, "account9", "10.06.1999", "istanbul");
        Account account10 = new Account(10, "account10", "10.06.1999", "istanbul");

        // Post post1  = new Post(1, gizemsungu.getAccountId(), "First Post");
    
        accounts.add(gizemsungu);
        accounts.add(sibelgulmez);
        accounts.add(gokhankaya);
        accounts.add(oguzmutlu);
        accounts.add(account5);
        accounts.add(account6);
        accounts.add(account7);
        accounts.add(account8);
        accounts.add(account9);
        accounts.add(account10);
        // createAccount(accounts, gizemsungu); 

        // **************************************************************************************************************
        System.out.print("Step 2... Logging into account (username: " + sibelgulmez.getUsername() + ")...");
        loginAccountid = sibelgulmez.login(loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.println("Step 3... Sharing two posts...");
        Post post3 = new Post(1,sibelgulmez.getAccountId(), "I like C but java is not bad.");
        Post post4 = new Post(2,sibelgulmez.getAccountId(),"Love rainy days in Kasimpasa...");
        sibelgulmez.sharePost(post3, loginAccountid);
        sibelgulmez.sharePost(post4, loginAccountid);
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
        System.out.print("Step 6... Logging into another account (username: " + gokhankaya.getUsername() + ")...");
        loginAccountid = gokhankaya.login(loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 7... ");
        gokhankaya.like(sibelgulmez, post4, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 8... ");
        gokhankaya.follow(sibelgulmez, loginAccountid); 
        gokhankaya.follow(account10, loginAccountid);
        gokhankaya.follow(oguzmutlu, loginAccountid); 
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 9... ");
        Comment newComment = new Comment("Weather is cold in here!");
        gokhankaya.comment(sibelgulmez, post4,newComment,loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 11... ");
        gokhankaya.sendMessage(oguzmutlu, "Your data Grade is FF!", loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 12... ");
        loginAccountid = gokhankaya.logout();
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 13... Logging into another account (username: " + sibelgulmez.getUsername() + ")...");
        loginAccountid = sibelgulmez.login(loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 14... ");
        isViewedProfile = sibelgulmez.viewProfile(sibelgulmez, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 15... ");
        sibelgulmez.viewInteractions(sibelgulmez, accounts, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 16... ");
        sibelgulmez.block(gokhankaya, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 17... ");
        isViewedProfile = sibelgulmez.viewProfile(sibelgulmez, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 18... ");
        sibelgulmez.viewInteractions(sibelgulmez, accounts, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 19... ");
        sibelgulmez.unblock(gokhankaya, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 20... ");
        isViewedProfile = sibelgulmez.viewProfile(sibelgulmez, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 21... ");
        sibelgulmez.viewInteractions(sibelgulmez, accounts, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        sibelgulmez.showHistory(loginAccountid);
        double stopTime = System.currentTimeMillis();
        double mapLLPut = (double) (stopTime - startTime);
        System.out.println(mapLLPut); 
    }
    
    public static boolean createAccount(ArrayList<Account> accounts, Account newAccount){

        for(int i = 0; i < accounts.size(); i++)
        {
            if(accounts.get(i).getUsername() == newAccount.getUsername())
            {
                System.out.println("Username is already taken");
                return false; 
            }
        }
        accounts.add(new Account(accounts.size()+1,newAccount.getUsername(),
                                 newAccount.getBirthdate(), newAccount.getLocation()));
        return true;
    }
}
