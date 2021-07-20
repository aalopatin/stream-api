package com.example.students;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alex", Speciality.Physics, 1),
                new Student("Rika", Speciality.Biology, 4),
                new Student("Julia", Speciality.Biology, 2),
                new Student("Steve", Speciality.History, 4),
                new Student("Mike", Speciality.Finance, 1),
                new Student("Hinata", Speciality.Biology, 2),
                new Student("Richard", Speciality.History, 1),
                new Student("Kate", Speciality.Psychology, 2),
                new Student("Sergey", Speciality.ComputerScience, 4),
                new Student("Maximilian", Speciality.ComputerScience, 3),
                new Student("Tim", Speciality.ComputerScience, 5),
                new Student("Ann", Speciality.Psychology, 1)
        );

//        //Нужно сгруппировать всех студентов по курсу.
//        //My
//        students.stream()
//                .collect(Collectors.groupingBy(Student::getYear))
//                .forEach((integer, studs) -> System.out.printf("Course: %d, Students: %s\n", integer, studs));
//
//        System.out.println();

//        //Вывести в алфавитном порядке список специальностей, на которых учатся перечисленные в списке студенты.
//        //My
//        students.stream()
//                .map(Student::getSpeciality)
//                .distinct()
//                .sorted(Comparator.comparing(Enum::name))
//                .forEach(System.out::println);
//
//        System.out.println();
//
//        //Вывести количество учащихся на каждой из специальностей.
//        //My
//        students.stream()
//                .collect(Collectors.groupingBy(Student::getSpeciality, Collectors.counting()))
//                .forEach((speciality, count) -> System.out.println(speciality + ": " + count));
//
//        System.out.println();

//        //Сгруппировать студентов по специальностям, сохраняя алфавитный порядок специальности, а затем сгруппировать по курсу.
//        //My
//        Map<Speciality, Map<Integer, List<Student>>> result =
//                students.stream()
//                .sorted(Comparator.comparing(Student::getSpeciality, Comparator.comparing(Enum::name)))
//                .collect(
//                        Collectors.groupingBy(
//                                Student::getSpeciality,
//                                LinkedHashMap::new,
//                                Collectors.groupingBy(Student::getYear)
//                        )
//                );

//        result.forEach((s, map) -> {
//            System.out.println("-= " + s + " =-");
//            map.forEach((year, list) -> System.out.format("%d: %s%n", year, list.stream()
//                    .map(Student::getName)
//                    .sorted()
//                    .collect(Collectors.joining(", ")))
//            );
//            System.out.println();
//        });
//
//        System.out.println();

//        //Проверить, есть ли третьекурсники среди учащихся всех специальностей кроме физики и CS.
//        //1 - My
//        System.out.println(students.stream().anyMatch(student -> student.getSpeciality() != Speciality.Physics
//                                && student.getSpeciality() != Speciality.ComputerScience
//                                && student.getYear() == 3));
//        //2 - My
//        System.out.println(students.stream()
//                .anyMatch(s -> !EnumSet.of(Speciality.ComputerScience, Speciality.Physics).contains(s.getSpeciality())
//                        && s.getYear() == 3));
//
//        //3
//        System.out.println(students.stream()
//                .filter(s -> !EnumSet.of(Speciality.ComputerScience, Speciality.Physics).contains(s.getSpeciality()))
//                .anyMatch(s -> s.getYear() == 3));

//        //Вычислить число Пи методом Монте-Карло.
//        // 3.1415344
//        final Random rnd = new Random();
//        final double r = 1000.0;
//        final int max = 10000000;
//        long count = IntStream.range(0, max)
//                .mapToObj(i -> rnd.doubles(2).map(x -> x * r).toArray())
//                .parallel()
//                .filter(arr -> Math.hypot(arr[0], arr[1]) <= r)
//                .count();
//        System.out.println(4.0 * count / max);

//        //Вывести таблицу умножения.
//        IntStream.rangeClosed(2, 9)
//                .boxed()
//                .flatMap(first -> IntStream.rangeClosed(2, 9)
//                        .mapToObj(second -> String.format("%d * %d = %d", first, second, first * second))
//                ).forEach(System.out::println);;

//        //Или более экзотический вариант, в 4 столбца, как на школьных тетрадях.
//        IntFunction<IntFunction<String>> function = i -> j -> String.format("%d x %2d = %2d", i, j, i * j);
//
//        IntFunction<IntFunction<IntFunction<String>>> repeaterX = count -> i -> j ->
//                IntStream.range(0, count)
//                        .mapToObj(delta -> function.apply(i + delta).apply(j))
//                        .collect(Collectors.joining("\t\t"));
//        IntFunction<IntFunction<IntFunction<IntFunction<String>>>> repeaterY = countY -> countX -> i -> j ->
//                IntStream.range(0, countY)
//                        .mapToObj(deltaY -> repeaterX.apply(countX).apply(i).apply(j + deltaY))
//                        .collect(Collectors.joining("\n"));
//        IntFunction<String> row = i -> repeaterY.apply(10).apply(4).apply(i).apply(1) + "\n";
//        IntStream.of(2, 6).mapToObj(row).forEach(System.out::println);
    }
}
