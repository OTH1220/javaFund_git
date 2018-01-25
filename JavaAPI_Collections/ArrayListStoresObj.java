/***
This Demo shows how to store Java Bean Objects into ArrayList

***/

import java.util.*;

class ArrayListStoresObj{
    public static void main(String[] args){

        ArrayList arrayList = new ArrayList();
        arrayList.add(new Person_Bean("Person-1", 15));
        arrayList.add(new Person_Bean("Person-2", 16));
        arrayList.add(new Person_Bean("Person-3", 17));
        arrayList.add(new Person_Bean("Person-4", 18));
        // arrayList.add(person_bean2);
        // arrayList.add(person_bean3);
        // arrayList.add(person_bean4);

        for(Iterator iterator = arrayList.listIterator(); iterator.hasNext(); ){
            Person_Bean person_bean = (Person_Bean)iterator.next();
            System.out.println(person_bean.getName()+": "+person_bean.getAge());
        }
    }
}
