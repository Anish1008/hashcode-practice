
import java.util.*;
public class traffic_lights
{
	// public void cars() {
		
	// }
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
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
	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
		//duration of simulation
		int d=sc.nextInt();
		//No. of intersections
		int i=sc.nextInt();
		//No. of streets
		int s=sc.nextInt();
		//No. of cars
		int c=sc.nextInt();
		//Points
		int p=sc.nextInt();
		sc.nextLine();
		String streets[][]=new String[s][4];
		for(int x=0; x<s;x++)
		{
			//Inersection start point
			streets[x][0]=sc.next();
			//Inersection end point
			streets[x][1]=sc.next();
			//Street name
			streets[x][2]=sc.next();
			//Time needed to cross the street
			streets[x][3]=sc.next();
		}
		sc.nextLine();
		ArrayList<String> arr = new ArrayList<String>();
		LinkedHashSet<LinkedHashSet<String> > car_path
            = new LinkedHashSet<LinkedHashSet<String> >();
			for(int x=0;x<c;x++)
			{
				int n=sc.nextInt();
				for(int y = 0;y<n;y++)
				{
					arr.add(sc.next());
				}
				car_path.add(new LinkedHashSet<String>(arr));
				arr.clear();
				if(x==c-1)
				continue;
				else
				sc.nextLine();
			}
			// System.out.println(car_path);
			// for(int x=0;x<s;x++)
			// {
			// 	for(int y=0;y<4;y++)
			// 	{
			// 		System.out.print(streets[x][y]+" ");
			// 	}
			// 	System.out.println();
			// }
			//Grouping streets on the basis of end intersection so that we could check which intersection has how many street-end traffic light
			HashMap<String, Integer> map = new HashMap<>();
			int test=0;
			for(int x=0;x<s;x++)
			{
				test=Integer.parseInt(streets[x][1]);
				map.put(streets[x][2],test);
			}
			Map<String, Integer> hm1 = sortByValue(map);
			int[] end= new int[s];
			String[] st_name=new String[s];
			int m=0,n=0;
			for (Map.Entry<String, Integer> en :
             hm1.entrySet()) {
				 end[m++]=en.getValue();
				 st_name[n++]=en.getKey(); 
			}
			// for (int j = 0; j < end.length; j++) {
			// 	System.out.print(end[j]+" ");
			// }
			System.out.println(i);
			// int count=0;
			ArrayList<String> save=new ArrayList<String>();
			for(int x=0;x<i;x++)
			{
				for(int y=0;y<s;y++)
				{
					// System.out.println("exe");
					//end=[0,1,1,2,3]
					if(end[y]==x)
					{
						save.add(st_name[y]);
					}
					
				}
				System.out.println(x);
				System.out.println(save.size());
				for(int z=0;z<save.size();z++)
				{
					System.out.println(save.get(z)+" "+1);
				}
				save.removeAll(save);
			}
		}
	}