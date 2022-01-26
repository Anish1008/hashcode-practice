/**
 * book_scanning
 */

// Pseudo code:
// Input part:
//     int inputs:
//         no. of books, no. of libraries, no.of days,
//     array inputs:
//         scores of individual books
//     LinkedHashSet inputs:
//         Library specs: no. of books present, the signup timing and the no. of books which can be scanned per day

//             why linkedhashset: bcoz taking inputs in 2d having varying sizes is kind of easy.

//             why need 2D array: bcoz we don't want to initialize 3*no. of libraries integers and technically that is impossible to intialize.

//             drawbacks of Linked Hashset which I faced: it contains only unique elements.
//             Suppose in this case:
//                 Check the 3rd line of input it says:
//                 we need to input 3 things 5 2 2
//                 but if we pass this to linked hashset it will accept only 5 2
//                 Therefore, the final linked list will contain [[5 2] [4 3 1]]

//             I am sorry to say but this has not been corrected by me till now but I am gonna correct it asap peace out.
//             You will not see any discripancy in the output bcoz we did not use the other "2" anyway.
//             But it is a wrong practice..... remember that.....!!!!!!!

//         Lib_Book_ids = [[0 1 2 3 4] [3 2 5 0]]
    
//     Few imp doubts i need to clear:
//         why did i actually used array_list too....:  to make input into the linked_list.
//         well that can only be made understandable well if I explain it via voice if you actually didn't get it.


// There we go, we have all the inputs, lets revise it again what we have:
//     few integers: b,l,d;
//     one array: scores;
//     two linked list: lib_specs and books.
//     let me make this clear we are accepting all values in string in linked hashset

// If you understand this give yourself a big thumbs up bcoz it took me like half an hour how to take input.

// Further into the problem:

// Lets discuss what we actually need to do....

// First of all: we need to arrange the libraries according to minimum time taken for sign up..
//     Let me give you an example:
//         if library 0 takes 3 days for signup and library 1 takes around 2 days
//         then we are gonna arrange them like library 1 will go first for signup followed by library 2.

// Last step: we need to send unique books for scanning...
//     example(its a follow up example of the first task): 
//         if libraray 0 is having 4 books namely: 0 1 2 3 
//         and libraray 1 is having 3 books namely: 0 2 4
//         so, as I am sending library 1 for signup I will sending these books for scanning: 1 2 4
//         and then for library 0 I will be sending only these books: 3 5
        
// See that is it we are done understanding what we have to do..... wasn't it simple....

// If you have understand this till now, you would have understood that the question isn't difficult and neither the solution.

// Lets hop into actual code - stay focussed this is where we create magic...
//     In order to complete the first task: 
//         we need to create a hashmap: 
//             what is a hashmap: Its like id:value in js or key:value in python dictionaries.
//             key: lib_id
//             Value: time needed for them to signup.
//         sort the hashmap by value...
//         And then store the keys to an arraylist.... basically the sorted the lib_id
    
//     This is it... we actually completed the first task stay motivated bcoz only the last portion is left.


//     Coming on to the last task:
//         we need to create an arraylist for storing all the available book ids
//         example(it is a follow up example): if there are 5 books in total, we will store there ids which is actually from 0 to n-1(in this case 5-1=4)
//         so the arraylist would contain: [0 1 2 3 4]
//         now basically we need to check if the books we are sending exists in this arraylist or not:
//             if it exists then send the book and delete its id from the arraylist
//             else 
//             we are not sending it.
    

//     Did you follow up guys.....
//     We actually covered the algorithm.... any doubts feel free to ask....
//     If you understand this all then trust me you are not a beginner :)


// We will be moving on to my version of code, there can actually be many versions of it any suggestions to improve my code will be accepted heartedly..

// I will like you direct you to the main method and skip the above two methods bcoz it will be called by the main method and therefore you will be refering it at that time.


import java.util.*;
public class book_scanning {
    static int binarySearch(ArrayList<Integer> arr, int x)
    {
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            // Check if x is present at mid
            if (arr.get(m) == x)
                return m;
 
            // If x greater, ignore left half
            if (arr.get(m) < x)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
        return -1;
    }
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
        //Imput part starts
        Scanner sc = new Scanner(System.in);
        //total no. of books
        int b=sc.nextInt();
        //total no. of libraries
        int l=sc.nextInt();
        //total no. of days
        int d=sc.nextInt();
        int scores[]=new int[b];
        // storing the scores
        for(int i=0;i<b;i++)
        scores[i]=sc.nextInt();
        // for storing the library specifications
        LinkedHashSet<LinkedHashSet<String> > lib_specs
            = new LinkedHashSet<LinkedHashSet<String> >();
        //for storing the book ids availabe in the library.
        LinkedHashSet<LinkedHashSet<String> > books
            = new LinkedHashSet<LinkedHashSet<String> >();
        ArrayList<String> arr1=new ArrayList<String>();
        ArrayList<String> arr2=new ArrayList<String>();
        sc.nextLine();
        for(int i=0;i<l;i++)
        {
            for (int j = 0; j < 3; j++) {
                arr1.add(sc.next());
            }
            sc.nextLine();
            for (int j = 0; j < Integer.parseInt(arr1.get(0)); j++) {
                arr2.add(sc.next());
            }
            sc.nextLine();
            lib_specs.add(new LinkedHashSet<String>(arr1));
            // System.out.println(lib_specs);
            books.add(new LinkedHashSet<String>(arr2));
            // System.out.println(books);
            arr1.clear();
            arr2.clear();
        }
        //Input part over

        
        // First task starts
        //Initialized an hashmap
        HashMap<String, Integer> map = new HashMap<>();
        int int_temp=0;
        //For converting the lib_index to string as it is gonna be key which we initialized as String
        String str_temp="";
        int x=0;
        //looping through libraries
        for(int i=0;i<l;i++)
        {
            //converting the index of library to string..
            str_temp=String.valueOf(i);
            //accessing the linked hashset
            //innerset is accessing the inner array in the 2d array
            for (Set<String> innerSet : lib_specs) {
                //arr_temp is storing the inner array of the 2d array
                //note: it gets updated for every lib_index as I initialized and stored it in the loop
                ArrayList<String> arr_temp = new ArrayList<String>(innerSet);
                //checking if the index in the array coincide with the current index of the linked hashset
                //in order to do that we are incrementing x which gives the current index of the linked hashset at which we are
                if(x++==i){
                    //converting the time to sigup from string to integer
                    int_temp=Integer.parseInt(arr_temp.get(1));
                    //finally putting them into map
                    map.put(str_temp,int_temp);
            }
            //if x>i we don't need to access further so we will be breking from the innerSet loop and makin the x index back to 0
            else if(x>i)
            {
                x=0;
                break;
            }
            }
        }
        // Finally Sorting them with values
        Map<String, Integer> hm1 = sortByValue(map);
        //Storing the sorted keys which is lib_id in an array
        String[] lib_num=new String[l];
        int n=0;
        for (Map.Entry<String, Integer> en :
        hm1.entrySet()) {
            lib_num[n++]=en.getKey(); 
        }
        // First task finally complete
        //If you understood this far you kind you got me..
        //P.S. you are not a beginner :")

        //Coming to last part
        //Storing all the book ids
        ArrayList<Integer> unique_books=new ArrayList<Integer>();
        for(int i=0;i<b;i++)
        {
            unique_books.add(i);
        }
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        int pos=0;
        x=0;
        //Printing the no. of libraries we will send for signup
        System.out.println(l);
        for(int i=0;i<l;i++)
        {
            //printing the index of the library which will go scanning
            System.out.print(lib_num[i]+" ");
            //accesssing the lib books
            for (Set<String> innerSet : books) {
                ArrayList<String> arr_temp2=new ArrayList<String>(innerSet);
                //checking if we are at the correct lib index as compared to the current for loop index
                if(x++==Integer.parseInt(lib_num[i])){
                for (int z=0;z<arr_temp2.size();z++) {
                    //Converting every book index from string to integer
                    int_temp=Integer.parseInt(arr_temp2.get(z));
                    //searching whether the book id exists in unique_book_id 
                    pos=binarySearch(unique_books,int_temp);
                    //if yes it will add the book index to the list and delete the book from unique_id
                    if(pos>-1)
                    {list1.add(int_temp);
                    unique_books.remove(pos);
                    }
                }
            }
            else if(x>i)
            {x=0;
            break;
            }
            }
            //printing the no. of books
            System.out.println(list1.size());
            for(int z=0;z<list1.size();z++)
            {
                //printing the book ids
                System.out.print(list1.get(z)+" ");
            }
            list1.clear();
            System.out.println();
        }
    }
}