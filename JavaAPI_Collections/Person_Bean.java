class Person_Bean{

    private String name;
    private int age;

    public Person_Bean(String name, int age){
        super();
        this.name = name;
        this.age = age;
    }

    public Person_Bean(){
        super();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public int hashCode​(){
        //age*39 ensures the unique hashcode of the object.
        System.out.println("---------In HashCode----------");
        return name.hashCode() + age * 39;
    }

    public boolean equals​(Object obj){
        //
        // String objName = null;
            if(obj == null){
                throw new NullPointerException();
            }
            else if (!(obj instanceof Person_Bean)) {
                throw new ClassCastException();
            }
        Person_Bean person = (Person_Bean)obj;

        if(this == obj){
            System.out.println("---------In Equals if----------");
            return true;
        }
        else{
            System.out.println("---------In Equals else----------");
            return this.name.equals(person.name) && this.age == person.age;
        }

    }
}
