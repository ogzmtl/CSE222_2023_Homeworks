public class TestClass2 {
    
    public static void main(String[] args) throws Exception {

        int loginAccountid = -1; 

        Account[] accounts = new Account[4];      
        int uid = 0; 
        // **************************************************************************************************************
        System.out.println("Step 1 ... Creating accounts...");
        Account gizemsungu = new Account(uid,"gizemsungu","10.03.1995", "Istanbul");
        uid++;
        Account sibelgulmez = new Account(uid,"sibelgulmez","10.03.1995", "Istanbul");
        uid++;
        Account gokhankaya = new Account(uid, "gokhankaya", "10.03.1995", "Istanbul");
        uid++;
        System.out.println();
        accounts[0] = gizemsungu;
        accounts[1] = sibelgulmez;
        accounts[2] = gokhankaya;
        // **************************************************************************************************************
        System.out.print("Step 2... Logging into account (username: " + sibelgulmez.getUsername() + ")...");
        loginAccountid = sibelgulmez.login(loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.println("Step 3... Sharing two posts...");
        Post post3 = new Post(1, "I like Java.", 1);
        Post post4 = new Post(2, "Java the coffeee...",1);
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
        gokhankaya.viewProfile(sibelgulmez, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 8... ");
        gokhankaya.viewPost(sibelgulmez, false, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 9... ");
        gokhankaya.like(sibelgulmez, post3, loginAccountid);
        System.out.println();
        // **************************************************************************************************************
        System.out.print("Step 10... ");
        Comment comment = new Comment("me too!");
        gokhankaya.comment(sibelgulmez, post3, comment, loginAccountid);
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
        System.out.println("Step 13... ");
        loginAccountid = gokhankaya.logout();
        System.out.println();
        // **************************************************************************************************************
        System.out.println("Step 14... Logging into another account (username: " + gizemsungu.getUsername() + ")...");
        loginAccountid = gizemsungu.login(loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.println("Step 15... ");
        gizemsungu.checkingOutbox(loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.println("Step 16... ");
        gizemsungu.checkingInbox(loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 17... ");
        gizemsungu.viewInbox(accounts, loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 18... ");
        gizemsungu.viewProfile(sibelgulmez, loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 19... ");
        gizemsungu.viewPost(sibelgulmez, false, loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 20... ");
        gizemsungu.viewInteractions(sibelgulmez, accounts, loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 21... ");
        gizemsungu.like(sibelgulmez, post3, loginAccountid);
        System.out.println();
        // *************************************************************************************************************
        System.out.print("Step 22... ");
        gizemsungu.viewInteractions(sibelgulmez, accounts, loginAccountid);
        System.out.println();
        // *************************************************************************************************************     
        loginAccountid= gizemsungu.logout();
        System.out.println();
        // *************************************************************************************************************   
        
        //Scenario 2 
        System.out.println();
        System.out.println("SCENEARIO 2");
        System.out.println("------------------\n");

        // *************************************************************************************************************
        //1.a
            System.out.print("Logging into account (username: " + gizemsungu.getUsername() + ")...");
            loginAccountid = gizemsungu.login(loginAccountid);
            System.out.println();
        // *************************************************************************************************************
        //1.b
            System.out.println("Sharing two posts. ");
            Post post1 = new Post(1, "Sharing first post",gizemsungu.getAccountId());
            Post post2 = new Post(2, "Sharing second post",gizemsungu.getAccountId());
            gizemsungu.sharePost(post1,loginAccountid);
            gizemsungu.sharePost(post2,loginAccountid);
        // *************************************************************************************************************
        //1.c
            loginAccountid = gizemsungu.logout();
            System.out.println();
        // *************************************************************************************************************
        //2
            System.out.println("Logging into account (username: " + sibelgulmez.getUsername() + ")...");
            loginAccountid = sibelgulmez.login(loginAccountid);
            System.out.println();

        // *************************************************************************************************************
        //2.a
            sibelgulmez.viewProfile(gizemsungu, loginAccountid);
            System.out.println();
        // *************************************************************************************************************
        //2.b
            sibelgulmez.like(gizemsungu, post1, loginAccountid);
            System.out.println();
        // *************************************************************************************************************
        //2.c 
            loginAccountid = sibelgulmez.logout();
            System.out.println();
        // *************************************************************************************************************

            System.out.println("Logging into account (username: " + gokhankaya.getUsername() + ")...");
            loginAccountid = gokhankaya.login(loginAccountid);
            System.out.println();

        // *************************************************************************************************************
        //3.a
            gokhankaya.viewProfile(gizemsungu, loginAccountid);
            System.out.println();
        // *************************************************************************************************************
        //3.b
            gokhankaya.viewProfile(gizemsungu, loginAccountid);
            Comment comment1 = new Comment("Nice!");
            gokhankaya.comment(gizemsungu, post2, comment1, loginAccountid);
            System.out.println();
        // *************************************************************************************************************
        //3.c 
            Message message3 = new Message(2, gokhankaya.getAccountId(), gizemsungu.getAccountId(), "Hello!");
            gokhankaya.sendMessage(gizemsungu, message3, loginAccountid);
            System.out.println();
        // *************************************************************************************************************
        //3.d 
            loginAccountid = gokhankaya.logout();
            System.out.println();
        // *************************************************************************************************************
        //4
            System.out.print("Logging into account (username: " + gizemsungu.getUsername() + ")...");
            loginAccountid = gizemsungu.login(loginAccountid);
            System.out.println();
        // *************************************************************************************************************
            gizemsungu.viewProfile(gizemsungu, loginAccountid);
            System.out.println();
        // *************************************************************************************************************
            gizemsungu.viewInbox(accounts, loginAccountid);
        // *************************************************************************************************************


    }
}
