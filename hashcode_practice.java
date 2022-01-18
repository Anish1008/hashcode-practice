import java.util.*;

public class hashcode_practice {
    static int binarySearch(String[] arr, String x)
    {
        // int l = 0, r = arr.length - 1;
        // while (l <= r) {
        //     int m = (l + r) / 2;
        //     System.out.print(x+" "+arr[m]+" ");
        //     int res = x.compareTo(arr[m]);
        //     System.out.println(res);
        //     // Check if x is present at mid
        //     if (res == 0)
        //         return 1;
 
        //     // If x greater, ignore left half
        //     if (res > 0)
        //         l = m + 1;
 
        //     // If x is smaller, ignore right half
        //     else
        //         r = m - 1;
        // }
 
        // return 0;
        for(int i=0;i<arr.length;i++)
        {
            if(x.compareTo(arr[i])==0)
            {
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        ArrayList<String> likes = new ArrayList<String>();
        ArrayList<String> dislikes = new ArrayList<String>();
        sc.nextLine();
        for(int i=1;i<=t;i++)
        {
            int a=sc.nextInt();
            for(int j=0;j<a;j++)
            {
                likes.add(sc.next());
            }
            sc.nextLine();
            a=sc.nextInt();
            for(int j=0;j<a;j++)
            {
                dislikes.add(sc.next());
            }
            sc.nextLine();
        }
        Collections.sort(likes);
        Collections.sort(dislikes);
        HashMap<String, Integer> like_map = new HashMap<>();
        String temp=likes.get(0);
        int count=0;
        // System.out.println(likes);
        String tempo="";
        for(int i=0;i<likes.size();i++)
        {
            // System.out.println(temp);
            tempo=likes.get(i);
            if(temp.compareTo(tempo)==0)
            {
                count++;
                // System.out.println(temp);
            }
            else{
                if(count==0)
                {like_map.put(temp,(count+1));
                // System.out.println(temp2);
                }
                else
                {like_map.put(temp,(count));
                // System.out.println(temp2);
                }

            count=0;
            temp=likes.get(i);
            // System.out.println(temp);
            count+=1;
            }}
            if(count>0)
            {
                like_map.put(likes.get(likes.size()-1),count);
            }
            // System.out.println(like_map);
            HashMap<String, Integer> dislike_map = new HashMap<>();
            String temp2=likes.get(0);
            int count2=0;
            // System.out.println(dislikes);
            // if(dislikes.size()!=0)
            // {
            for(int i=0;i<dislikes.size();i++)
            {
                if(temp2.compareTo(dislikes.get(i))==0)
                {
                    count2++;
                }
                else{
                    if(count2==0)
                    {dislike_map.put(temp2,(count2+1));
                    // System.out.println(temp2);
                    }
                    else
                    {dislike_map.put(temp2,(count2));
                    // System.out.println(temp2);
                    }

                count2=0;
                temp2=dislikes.get(i);
                count2+=1;
            }
        // }
        if(count2>0)
        {
            dislike_map.put(dislikes.get(dislikes.size()-1),count2);
        }}
        String[] like_keys=new String[like_map.size()];
        String[] dislike_keys=new String[dislike_map.size()];
        int m=0;
        for ( String key : like_map.keySet() ) {
            like_keys[m++]=key;
        }
        int n=0;
        for ( String key : dislike_map.keySet() ) {
            dislike_keys[n++]=key;
        }
        int result=0,diff=0;
        // System.out.println(dislike_map+" "+dislike_map.size());
        // System.out.println(like_map+" "+like_map.size());
        ArrayList<String> save = new ArrayList<String>();
        // for (int i = 0; i < dislike_keys.length; i++) {
            
        //     System.out.println(dislike_keys[i]);
        // }
        // System.out.println();
        for(int i=0;i<like_keys.length;i++)
        {
            result=binarySearch(dislike_keys,like_keys[i]);
            // System.out.println(result+" "+like_keys[i]);
            if(result==1)
            {
                diff=like_map.get(like_keys[i])-dislike_map.get(like_keys[i]);
                // System.out.println(diff+" "+like_keys[i]);
                if(diff>0)
                save.add(like_keys[i]);
            }
            else if(result==0)
            {
                save.add(like_keys[i]);
            }
        }
        System.out.print(save.size()+ " ");
        for(int i=0;i<save.size();i++)
        {
            System.out.print(save.get(i)+" ");
        }
        }
    }

