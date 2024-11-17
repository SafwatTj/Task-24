import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Jack", "Vorobey", "vorobey@mail.com"),
                new Person("John", "Smith", "smith@mail.com"),
                new Person("Nick", "White", "whote@mail.com"),
                new Person("Sveta", "Ivanova", "ivanova@mail.com"),
                new Person("Sam", "Simpson", "simpson@mail.com")
        );


        Stream<String> stream1 = list.stream()
                .map(p -> p.getlName() + " " + p.getfName())
                .limit(3)
                .peek(s -> System.out.println("peek:" + s));
        //.toList();
        List<String> list1 = stream1.toList();



        long count = list.stream()
                .map(p -> p.getlName() + " " + p.getfName())
                .limit(3)
                .peek(s -> System.out.println("peek:" + s)).count();
        System.out.println(count);


        LinkedList<Person> collect = list.stream()
                .collect(Collectors.toCollection(() -> new LinkedList<>()));


        TreeSet<Person> collect1 =                              //   () -> new TreeSet()
                list.stream().collect(Collectors.toCollection(  () -> new TreeSet<>(  (p1, p2) -> p1.getlName().compareTo(p2.getlName())  )   ));
        System.out.println(collect1);

        Map<String, Person> collect2 = list.stream().collect(Collectors.toMap(p -> p.getEmail(), (p) ->{ return p; } ));
        System.out.println(collect2);




    }
}
