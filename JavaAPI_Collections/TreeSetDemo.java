//This demo is for storing strings sorted by it's length

import java.util.TreeSet;
import java.util.Iterator;

class TreeSetDemo{

    public static void main(String[] args){
        TreeSet treeSet = new TreeSet(new StringLengthComparator());

        treeSet.add(new String("abcas"));
        treeSet.add(new String("adn87s0"));
        treeSet.add(new String("bda34cas"));
        treeSet.add(new String("3fdabc"));
        treeSet.add(new String("dfadfsafbcas"));
        treeSet.add(new String("a3b31cadss"));
        treeSet.add(new String("23abcas"));

        for (Iterator it = treeSet.iterator(); it.hasNext(); ){
            System.out.println(it.next());
        }
    }

}
