package day07;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class TerminalOps {

    public static void main(String[] args) {
        
        Integer max = 200;
        Integer range = 100;
        Random rnd = new SecureRandom();

        List<String> intList = new LinkedList<>();

        List<Integer> numList = new LinkedList<>();
            for (Integer i=0; i<max; i++) {

                numList.add(rnd.nextInt(range));

            }

        System.out.println(">>> numList: " + numList);

        joining(numList);

        reducing(numList);

        joiningAsReducing(numList);

        reducing2(numList);

    }

    public static void joiningAsReducing (List<Integer> numList) {

        System.out.println("-----JOINING AS REDUCING-----\n");

            Optional<String> opt = numList.stream() 
            .map(n -> "%d%d".formatted(n, n))
            .map(Integer::parseInt)
            .collect(
                
                Collectors.reducing((total, i) -> {
                    System.out.printf("total: %s, i: %s\n", total, i);
                   
                });
            )
            
            // Check if we have an answer
            if (opt.isPresent())
                // Get the answer
                System.out.println(">>> Total: " + opt.get());
            else 
                System.out.println("Error! Reducing produces no result! ");


        System.out.println(">>> total: " + opt);

    }
    
    public static void joining (List<Integer> numList) {

        System.out.println("-----JOINING-----\n");

        
        String listOfNums = numList.stream()
            .map(n -> "%d%d".formatted(n, n))
            .collect(Collectors.joining("-\n"));

        System.out.println(">>> csv: \n" + listOfNums);

    }

    public static void reducing (List<Integer> numList) {

        System.out.println("-----REDUCING-----\n");

        
        Optional<Integer> opt = numList.stream() // Optional --> like returning a box which may or may not contain an answer i.e schrodinger's cat
            // map: String apply (Integer i)
            .map(n -> "%d%d".formatted(n, n))
            .map(Integer::parseInt)
            .collect(
                // Integer apply (Integer total, Integer i)
                Collectors.reducing((total, i) -> {
                    System.out.printf("total: %d, i: %d\n", total, i);
                    return total + i;
                })
                
            );
            
            // Check if we have an answer
            if (opt.isPresent())
                // Get the answer
                System.out.println(">>> Total: " + opt.get());
            else 
                System.out.println("Error! Reducing produces no result! ");


        System.out.println(">>> total: " + opt);

    }
}
