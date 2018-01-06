import java.util.*;

/**
* This Demo is for practicing all the basic methods of Collection
*  Methods include:
*  add / addAll / remove / removeAll / retainAll / containAll / isEmpty
*
*  The use of Iterator of collections
*/

class CollectionFunctionDemo{

    public static void main(String[] args){

        Collection collection1 = new ArrayList();
        Collection collection2 = new ArrayList();

        collection1.add("string1");
        collection1.add("string2");
        collection1.add("string3");
        collection1.add("string4");
        collection1.add("string5");
        // collection1.add("info2");

        collection2.add("info1");
        collection2.add("info2");
        // collection2.add("string3");
        collection2.add("info3");
        collection2.add("info4");
        collection2.add("info5");

        System.out.println("Is Empty: "+collection1.isEmpty());
        System.out.println(collection1);

        // collection1.addAll(collection2);
        // collection1.clear();
        // collection1.removeAll(collection2);
        // System.out.println("RetainAll test: "+collection1.retainAll(collection2));
        // System.out.println(collection1);
        // System.out.println("Collection1 contains all of C2: "+collection1.containsAll(collection2));
        // System.out.println(collection2);

        for(Iterator iterator = collection1.iterator(); iterator.hasNext(); ){
            // System.out.println(iterator.next().toString());
            System.out.println(iterator.next());
        }

    }

}
