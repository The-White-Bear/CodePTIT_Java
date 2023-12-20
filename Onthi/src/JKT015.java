import java.util.Scanner;

public class JKT015 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String res=solve(s);
        System.out.println(res);
    }
    public static String solve(String s)
    {
        StringBuilder res=new StringBuilder();
        int cursor=0;
        for(int i=0;i<s.length();i++)
        {
          if(s.charAt(i)=='-'&&cursor>0)
          {
              cursor-=1;
              res.deleteCharAt(cursor);
          } else if (s.charAt(i)=='<') {
             if(cursor>0)
             {
                 cursor-=1;
             }
          } else if (s.charAt(i)=='>') {
              if(cursor<res.length())
              {
                  cursor+=1;
              }
          }
          else
          {
              res.insert(cursor,s.charAt(i));
              cursor+=1;
          }
        }
        return res.toString();
    }
}

