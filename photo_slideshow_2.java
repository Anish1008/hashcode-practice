import java.util.*;
public class photo_slideshow_2 {
    public static HashMap<String, Integer> sortByValueInt(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static ArrayList<Integer> sort_by_tags(ArrayList<Integer> horizontal,ArrayList<Integer> tags_count) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i =0; i<horizontal.size();i++)
        {
            map.put(String.valueOf(horizontal.get(i)),tags_count.get(horizontal.get(i)));
        }
        Map<String, Integer> hm1 = sortByValueInt(map);
        //Storing the sorted keys which is lib_id in an array
    ArrayList<Integer> hori = new ArrayList<Integer>();
    for (Map.Entry<String, Integer> en :
    hm1.entrySet()) {
        
        hori.add(Integer.parseInt(en.getKey())); 
    }
    ArrayList<Integer> hori2 = new ArrayList<Integer>();
    for(int i=hori.size()-1;i>=0;i--)
    {
        hori2.add(hori.get(i));
    }

    return hori2;
    }
    
    public static HashMap<Integer, String> sortByValue(HashMap<Integer, String> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, String> > list =
               new LinkedList<Map.Entry<Integer, String> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, String> >() {
            public int compare(Map.Entry<Integer, String> o1,
                               Map.Entry<Integer, String> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<Integer, String> temp = new LinkedHashMap<Integer, String>();
        for (Map.Entry<Integer, String> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> photo_temp= new ArrayList<String>();
        LinkedHashSet<LinkedHashSet<String> > photo_specs
        = new LinkedHashSet<LinkedHashSet<String> >();
        ArrayList<String> photo_scape= new ArrayList<String>();
        ArrayList<Integer> tags_count= new ArrayList<Integer>();
        int tags=0;
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            photo_scape.add(sc.next());
            tags=sc.nextInt();
            tags_count.add(tags);
            for(int j=0;j<tags;j++)
            {
                photo_temp.add(sc.next());
            }
            sc.nextLine();
            photo_specs.add(new LinkedHashSet<String>(photo_temp));
            photo_temp.clear();
        }
        HashMap<Integer, String> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(i,photo_scape.get(i));
        }
        Map<Integer, String> hm1 = sortByValue(map);
        //Storing the sorted keys which is lib_id in an array
        int[] photo_id=new int[n];
        int m=0;
        for (Map.Entry<Integer, String> en :
        hm1.entrySet()) {

            photo_id[m++]=en.getKey(); 
        }
        String temp2="H";
        String temp3="V";
        int H=0;
        int V=0;
        for (int i = 0; i < photo_id.length; i++) {
            if(photo_scape.get(i).compareTo(temp2)==0)
            {
                H++;
            }
            else if(photo_scape.get(i).compareTo(temp3)==0)
            {
                V++;
            }
            
        }
        int slideshows=H+(V/2);
        System.out.println(slideshows);
        int x=0;
        ArrayList<Integer> horizontal= new ArrayList<Integer>();
        while(x<H)
        {
            horizontal.add(photo_id[x]);
            x++;
        }
        horizontal=sort_by_tags(horizontal,tags_count);
        for(Integer i:horizontal)
        {
            System.out.println(i);
        }
        ArrayList<Integer> vertical= new ArrayList<Integer>();

        while(x<photo_id.length)
        {
            vertical.add(photo_id[x]);
            x++;
        }
        vertical=sort_by_tags(vertical,tags_count);
        x=0;
        while(x<vertical.size())
        {
            System.out.print(vertical.get(x)+" ");
            System.out.println(vertical.get(x+1));
            x=x+2;
        }
    }
}
