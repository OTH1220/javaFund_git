/*
    This demo shows basic methods of HashSet class along with its characters
    like: Unique Object and iteration is not sequential.
*/

import java.util.*;

class HashSetBasicDemo{

    public static void main(String[] args){
        Collection hashSet = new HashSet();

        hashSet.add(new String("Test1"));
        hashSet.add(new String("Test2"));
        hashSet.add(new String("Test3"));
        hashSet.add(new String("Test4"));
        hashSet.add(new String("Test3"));
        hashSet.add(new String("Test33"));

        for(Iterator iterator = hashSet.iterator(); iterator.hasNext(); ){
            System.out.println(iterator.next());
        }
    }

}
