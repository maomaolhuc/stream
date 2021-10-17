package com.lhuc.stream.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Burdock
 * @create 2021-10-17 0:39
 */
public class StreamListDemo {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Mahesh", 12));
        list.add(new Student(2, "Suresh", 15));
        list.add(new Student(3, "Nilesh", 10));

        System.out.println("---Natural Sorting by Name---");
        List<Student> slist = list.stream().map((obj) -> {
            obj.setName("name" + obj.getId());
            return obj;
        }).sorted().collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));

        System.out.println("---Natural Sorting by Name in reverse order---");
        slist = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));

        System.out.println("---Sorting using Comparator by Age---");
        slist = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));

        System.out.println("---Sorting using Comparator by Age with reverse order---");
        slist = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));
    }


}
