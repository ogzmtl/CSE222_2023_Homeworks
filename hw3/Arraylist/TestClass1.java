package Arraylist;

import java.util.ArrayList;

public class TestClass1 {

    public static void main(String[] args) {

        boolean isViewedProfile = false; 
        ArrayList<Account> accounts = new ArrayList<Account>();
        Account gizemsungu = new Account(1, "gizemsungu", "10.06.1999", "istanbul");
        Account sibelgulmez = new Account(2, "sibelgulmez", "10.06.1999", "istanbul");
        Account gokhankaya = new Account(3, "gokhankaya", "10.06.1999", "istanbul");
        Account oguzmutlu = new Account(4, "oguzmutlu", "10.06.1999", "istanbul");
        Post post1  = new Post(1, gizemsungu.getAccountId(), "First Post");

        accounts.add(gizemsungu);
        accounts.add(sibelgulmez);
        accounts.add(gokhankaya);
        accounts.add(oguzmutlu);

        // gizemsungu.sharePost(post1);
        // gizemsungu.follow(gokhankaya);
        // gizemsungu.viewPost(gizemsungu, isViewedProfile);
        sibelgulmez.sharePost(post1);
        gizemsungu.follow(sibelgulmez);
        gizemsungu.like(sibelgulmez, post1);
        gizemsungu.viewInteractions(sibelgulmez, accounts);
        System.out.println();

        // gokhankaya.unfollow(gizemsungu);
        sibelgulmez.block(gizemsungu);
        gizemsungu.viewInteractions(sibelgulmez, accounts);
        // gizemsungu.viewProfile(gizemsungu);


        // gizemsungu.viewProfile(sibelgulmez);
        // System.out.println();
        // sibelgulmez.block(gizemsungu);
        // gizemsungu.viewProfile(sibelgulmez);
        // System.out.println();
        // // sibelgulmez.unblock(gizemsungu);
        // gizemsungu.viewProfile(sibelgulmez);
        // gizemsungu.viewProfile(gizemsungu);


        


        // gizemsungu.follow(sibelgulmez);
        // gizemsungu.follow(gokhankaya);
        // sibelgulmez.viewProfile(sibelgulmez);
        // gizemsungu.block(sibelgulmez);
        // gizemsungu.viewProfile(sibelgulmez);
        // gokhankaya.sendMessage(gizemsungu, "Nabersiniz.");

        // gizemsungu.viewInbox(accounts);
        // gokhankaya.viewOutbox(accounts);
        // isViewedProfile = gizemsungu.viewProfile(gizemsungu);
        // gizemsungu.viewPost(gizemsungu, isViewedProfile);

        // Like newLike = gokhankaya.like(gizemsungu,post1);
        // sibelgulmez.like(gizemsungu,post1);
        // gizemsungu.viewInteractions(gizemsungu, accounts);
        // gokhankaya.unlike(gizemsungu, post1,newLike );

        // gizemsungu.viewInteractions(gizemsungu, accounts);
        // gokhankaya.comment(gizemsungu, post1, "Hosgeldin");
        // sibelgulmez.comment(gizemsungu, post1, "Hosgeldin!");

        // gizemsungu.viewInteractions(gizemsungu, accounts);

        

        
    }
    
}
