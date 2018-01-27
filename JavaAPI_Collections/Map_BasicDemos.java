import java.util.*;

class Map_BasicDemos{

    public static void main(String[] args){
        HashMap<String, Integer> hashMap = new HashMap();

        hashMap.put("Jad", 21);
        System.out.println("First get: "+hashMap.get("Jad"));
        Integer integer = hashMap.put("Jad", 22);
        System.out.println("Second get: "+hashMap.get("Jad")+" Integer returned: "+ integer);
        hashMap.put("Mike", 23);
        hashMap.put("Brown", 20);
        hashMap.put("James", 29);
        hashMap.put("Tim", 27);
        hashMap.put("Wilson", 27);

        System.out.println(hashMap);
        System.out.println("HashMap Size: "+hashMap.size());

        System.out.println("Remove1: "+hashMap.remove("Mike"));
        System.out.println("Remove2: "+hashMap.remove("Miki"));

        System.out.println("putIfAbsent: "+hashMap.putIfAbsent("Tim", 33));
    }

}
