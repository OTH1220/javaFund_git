/*
    This demo shows how to store customized object into hashset and the implementation of customized object's hashcode and equals method.
*/

import java.util.*;

class HashSetStoresObj{

    public static void main(String[] args){
        Collection hashSet = new HashSet();

        hashSet.add(new Person_Bean("Peter",23));
        hashSet.add(new Person_Bean("Roger",24));
        hashSet.add(new Person_Bean("William",25));
        hashSet.add(new Person_Bean("Bill",26));
        hashSet.add(new Person_Bean("Steve",27));
        hashSet.add(new Person_Bean("William",25));

        for(Iterator iterator = hashSet.iterator(); iterator.hasNext(); ){
            Person_Bean pb = null;
            System.out.println(hashSet.size());
            pb = (Person_Bean)iterator.next();
            System.out.println(pb.getName()+"...."+pb.getAge());

        }
    }
}
