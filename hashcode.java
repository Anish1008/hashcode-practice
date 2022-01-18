import java.util.*;
class hashcode{
    void accept(){
        int n=new java.util.Scanner(System.in).nextInt();
        java.util.Scanner sc=new java.util.Scanner(System.in);
        String l="",dl="";
        int a;
        sc.nextLine();
        for(int i=1;i<=n;i++)
        {
            a=sc.nextInt();
            for(int j=1;j<=a;j++)
                l+=sc.next()+" ";
            sc.nextLine();
            a=sc.nextInt();
            for(int j=1;j<=a;j++)
                dl+=sc.next()+" ";
            sc.nextLine();
        }
        //System.out.println(like+" @ "+dislike);
        StringTokenizer st=new StringTokenizer(l);
        String like[]=new String[st.countTokens()];
        st=new StringTokenizer(dl);
        String dislike[]=new String[st.countTokens()];
        like=l.split(" ");
        dislike=dl.split(" ");String f="";
        for(int i=0;i<like.length;i++)
        {
            String temp=like[i];
            int cntr=1;
            if(like[i].equals(""))
            {
                continue;
            }
            for(int j=i+1;j<like.length;j++)
                if(like[j].equals(temp))
                {
                    cntr++;
                    like[j]="";
                }
            for(int j=0;j<dislike.length;j++)
                if(dislike[j].equals(temp))
                {
                    cntr--;
                }
            if(cntr>0)
                f+=temp+" ";
        }
        st=new StringTokenizer(f);    
        f=st.countTokens()+" "+f;
        System.out.println(f.trim());
    }
    public static void main(String args[]){
        new hashcode().accept();
    }
}