import java.util.Scanner;
class Account{
    int accoutnumber;
    String accName;
    double balance;
    
    void deposite(int val){
        balance+=val;
    }
    void withdraw(int val){
        balance-=val;
    }
    void display(){
        System.out.println("account name "+accName);
        System.out.println("account number "+accoutnumber);
        System.out.println("current balance is "+balance);
    }
}
public class Puppy_Bankings
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Account a1=new Account();
        a1.accName="Puppyluuuuuuu";
        a1.accoutnumber=135;
        a1.balance=3000;
       
        System.out.println("enter \n 1  deposite \n 2.withdraw \n 3.check balance");
        int n=sc.nextInt();
        switch(n){
            case 1:
                System.out.println("enter deposite amount");
                int m=sc.nextInt();
                a1.deposite(m);
                a1.display();
                break;
            
            case 2:
                System.out.println("enter withdraw amount");
                int x=sc.nextInt();
                if(a1.balance>=x){
                a1.withdraw(x);
                a1.display();
                }else{
                    System.out.println("insuffient balance");
                }
                break;
            
            case 3:
                a1.display();
                break;
            
            default :
                System.out.println("enter given choice only");
                break;
        }
    }
}