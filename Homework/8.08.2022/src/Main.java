/*
Дан список Programmer. У каждого Programmer(String name, String city, List<String> skills)
есть список технологий (String), которыми он владеет.
Сформировать лист из всех технологий, которыми владеют сотрудники.
 */

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Programmer> programmers = List.of(
                new Programmer("Jack", "Berlin", List.of("Java", "C++", "Go")),
                new Programmer("John", "Berlin", List.of("Java", "SQL")),
                new Programmer("Nick", "Bohn", List.of("JavaScript", "CSS", "HTML")),
                new Programmer("Stan", "Dresden", List.of("Java", "C++", "Go"))
        );

        System.out.println(programmers);

        List<String> skills = programmers.stream()
                .flatMap(p -> p.getSkills().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("-".repeat(50));

        System.out.println(skills);


                /*
         Дан список Programmer. У каждого Programmer есть список технологий (String),
        которыми он владеет. Сформировать лист из строк вида
        «технология: имя программиста» отсортированный по технологии.
             */
        List<String> sortedSkills = programmers.stream()
                .flatMap(p->p.getSkills().stream().map(st->st+":"+p.getName()))
                .sorted(Comparator.comparing(s->s.substring(0, s.indexOf(":"))))
                .collect(Collectors.toList());

        System.out.println("-".repeat(50));

        System.out.println(sortedSkills);

    }


}
