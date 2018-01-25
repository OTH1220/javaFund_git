import java.util.Comparator;

class StringLengthComparator implements Comparator{

    public int compare(Object o1, Object o2){

        if(!(o1 instanceof String)){
            throw new ClassCastException();
        }else if(!(o2 instanceof String)){
            throw new ClassCastException();
        }

        String str1 = (String) o1;
        String str2 = (String) o2;

        int lengthDiff = str1.length()-str2.length();

        return lengthDiff == 0 ? str1.compareTo(str2) : lengthDiff ;

    }
}
