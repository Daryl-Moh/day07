package day07;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class IntList {
    
    public static void main(String[] args) {
        
        Integer max = 200;
        Integer range = 100;
        Random rnd = new SecureRandom();

        List<Integer> numList = new LinkedList<>();
            for (Integer i=0; i<max; i++) {

                numList.add(rnd.nextInt(range));
            
                

            }

        System.out.println(">>> numList: " + numList);
        
        filter(numList);


    }

    public static void filter (List<Integer> numList) {

        System.out.println("-----FILTER-----\n");
        List<Integer> resultList = new LinkedList<>();
            for (Integer n: numList) {
                if ((n % 3) == 0)
                    continue;
                resultList.add(n);
            }

        System.out.println(">>> iteration resultList: " + resultList);

        resultList = numList.stream()
            .filter((i) -> (i%3)!=0 )
            .distinct()
            .sorted()
            .limit(5)
            .toList();

        System.out.println(">>> stream resultList: " + resultList);

        List<Integer> appenList = new LinkedList<>();
        appenList = numList.stream()
            // map: String apply (Integer i)
            .map(i -> "%d%d".formatted(i, i))
            // map: Integer apply (String i)
            //.map(i -> Integer.parseInt(i)) or
            .map(Integer::parseInt) // method reference
            .toList();

        System.out.println(">>> stream appenList: " + appenList);
        
        
            // Predicate: boolean test (Integer i)
            //.filter((i) -> {
            //    return (i % 3) == 0;
            //}).toList(); 
            // or can shorten to -->  only if have a single return line operator 

        
    }

}