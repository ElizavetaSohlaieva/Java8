package com.epam.com;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        if(args.length == 0){
            args = new String[2];
            args[0] = "10";
            args[1] = "100";
        }
        int itemCount = Integer.parseInt(args[0]);
        int maxRandomValue = Integer.parseInt(args[1]);

        List<Integer> myList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < itemCount; i++) {
            myList.add(random.nextInt(maxRandomValue));
        }
        System.out.println("Unsorted list: " + myList);
        Collections.sort(myList, (a, b) -> b.compareTo(a));
        System.out.println("Sorted list: " + myList);
        System.out.println();

        List<String> stringList = Arrays.asList("Peter", "Mike", "John", "Jack", "Antony", "Zigi");
        System.out.println("Unsorted list: " + stringList);
        Collections.sort(stringList, (s1, s2) -> s2.compareTo(s1));
        System.out.println("Sorted list: " + stringList);
        myList.stream().filter(l -> l >= 50).forEach(System.out::println);

        stringList.stream().filter(n -> n.startsWith("J")).forEach(System.out::println);

        System.out.println();
        Converter conv = s -> System.out.println(s.toUpperCase());
        conv.convertStrings("manhattan");

        System.out.println();
        Stream<Integer> infiniteStream = Stream.iterate(10, i -> i +10);
        List<Integer> collect = infiniteStream.limit(10).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println();

        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("John", 25, "M"));
        listPerson.add(new Person("Nick", 45, "M"));
        listPerson.add(new Person("Susan", 25, "F"));
        listPerson.add(new Person("Tom", 61, "M"));
        listPerson.add(new Person("Kate", 39, "F"));
        listPerson.add(new Person("Steven", 15, "M"));
        listPerson.add(new Person("Tim", 35, "M"));
        listPerson.stream().filter(p -> p.getAge() >= 18 && p.getAge() <= 60 && p.getSex().equals("M")).collect(Collectors.toList()).forEach(System.out::println);
        double averageAge = listPerson.stream().filter(p -> p.getSex().equals("F")).mapToInt(Person::getAge).average().getAsDouble();
        System.out.println(averageAge);
        }

  }
