import java.util.ArrayList;
import java.util.List;

/*
В программе задан список Person{ String fName, String lName, String email, String phone, Address address}.
Address{String postcode, String city, String street, String house}
Реализовать следующие функции:
   	                   	-получить список всех ФИО
           	   	    	-получить список всех e-mail
   	                   	-получить список всех телефонов
   	                   	-получить список всех адресов в виде строки адреса
Естественно, все вышеперечисленные функции может и должен реализовать один метод,
в который в качестве параметра должен приходить список Person и реализация необходимого способа обработки.
 Ограничения: не использовать стандартные Java интерфейсы, все необходимые классы и интерфейсы описывать
и реализовывать самостоятельно. Не использовать stream.
 List<String> listHandler(List<Person> list, PersonToStringFunction func)
       {   res=new List<String>
           for(Person p: list){
                res.add(func.apply(p))
           }
           return res;
       }
PersonToStringFunction{
    String apply(Person p)
}
Решить задачу №1 в общем виде: т.е. есть список объектов типа A необходимо получить
список объектов типа B. Проверить, получив из листа Person лист
объектов Address, из листа String лист Integer с длинами строк.
 */
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Jack", "Davis", "jack@gmailcom", "015789236", new Address("10115",
                "Berlin", "Wttelsbacherstr", "51"));
        Person p2 = new Person("Jane", "Mitchell", "jane@gmailcom", "017852369", new Address("10117",
                "Berlin", "Krausenstr", "82"));
        Person p3 = new Person("Jane", "Mitchell", "jane@gmailcom", "017852369", new Address("10117",
                        "Muenchen", "Krausenstr", "82"));

        List<Person>personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        System.out.println(listHandler(personList, new PersonToStringFunction() {
            @Override
            public String apply(Person person) {
                return person.getEmail();
            }
        }) );

        System.out.println(listHandler(personList, new PersonToStringFunction() {
            @Override
            public String apply(Person person) {
                return person.getAddress().toString();
            }
        }) );

        System.out.println(listHandler(personList, new PersonToStringFunction() {
            @Override
            public String apply(Person person) {
                return person.getfName() + " " + person.getlName();
            }
        }) );
//-----------------------------------------------------------------------------------------------
        System.out.println(genericListHandler(personList, new MyFunction<Person,String>() {
            @Override
            public String apply(Person person) {
                return person.getAddress().toString();
            }
        }) );

        System.out.println(genericListHandler(List.of("igugu", "hygytfytf", "1"), new MyFunction<String, String>() {
            @Override
            public String apply(String str) {
                return new StringBuilder(str).reverse().toString();
            }
        }));

        System.out.println(genericListHandler(personList, new MyFunction<Person, Address>() {
            @Override
            public Address apply(Person obj) {
                return obj.getAddress();
            }
        }) );

        MyFunction<Person, Address> getAddress = new MyFunction<Person, Address>() {
            @Override
            public Address apply(Person obj) {
                return obj.getAddress();
            }
        };

        MyFunction<Person,Address> getAddress1 = (Person p)->{return p.getAddress();};
        MyFunction<Person,Address> getAddress2 = p-> p.getAddress();

        MyPredicate<Person> fromBerlin = new MyPredicate<Person>() {
            @Override
            public boolean test(Person obj) {
                return obj.getAddress().getCity().equals("Berlin");
            }
        };

        MyPredicate<Person> predicate1 = (Person p) -> {return p.getfName().equals("Jack");};

        System.out.println(generic2ListHandler(personList,getAddress,fromBerlin));

        System.out.println(generic2ListHandler(personList,getAddress1,predicate1));

        System.out.println(generic2ListHandler(List.of("Str1","Str22","Str33","1"),
                (String s)->s.length(), s->s.length()>1));

    }

    public static List<String> listHandler(List<Person> list, PersonToStringFunction func){
        List<String> res = new ArrayList<>(list.size());
        for (Person p:list) {
            res.add(func.apply(p));
        }
        return res;
    }

    public static <T,R>List<R> genericListHandler(List<T> list, MyFunction<T,R> func){
        List<R> res = new ArrayList<>(list.size());
        for (T e:list) {
            res.add(func.apply(e));
        }
        return res;
    }

    public static <T,R>List<R> generic2ListHandler(List<T> list, MyFunction<T,R> func, MyPredicate<T> predicate){
        List<R> res = new ArrayList<>(list.size());
        for (T element:list) {
            if(predicate.test(element)) {
                res.add(func.apply(element));
            }
        }
        return res;
    }
}
