import java.util.*;
public class photo_slideshow {
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
        int tags=0;
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            photo_scape.add(sc.next());
            tags=sc.nextInt();
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
        while(x<H)
        {
                System.out.print(photo_id[x]+"\n");
                x++;
        }
        while(x<photo_id.length)
        {
            System.out.print(photo_id[x]+" ");
            System.out.print(photo_id[x+1]+"\n");
            x=x+2;
        }
    }
}
