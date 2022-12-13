package day07ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    
    public static void main(String[] args) throws IOException {

        // String fileName = "C:/Users/Daryl/src/day07/googleplaystore.csv";
        // Path path = Paths.get(fileName);
        // //BufferedReader br = new BufferedReader(new FileReader(fileName));
        // List<String> ratingsList = new LinkedList<>();
        // Files.lines(path)
        //         .skip(1)
        //         .map( lines -> {
        //             String[] fields = lines.split(",");
        //             ratingsList.add(Integer.parseInt(fields[02]));
        //         });
        
        Reader r = new FileReader("googleplaystore.csv");
        BufferedReader br = new BufferedReader(r);

        List<App> apps = br.lines()
            .skip(1)
            // String -> String[]
            .map(l -> l.split(","))
            // .map(cols -> {
            //     if (cols.length <= 14)
            //         return cols;
            //     cols[1] = "%s %s".formatted(cols[0], cols[1]);
            //     String[] dest = new String [cols.length -1]
            // })
            .filter(cols -> cols.length<= 14)
            .filter(cols -> !cols[2].trim().toLowerCase().equals("nan")) // Get the value at index 02 and compare to check if its nan
            .map(cols -> {
                App app = new App();
                app.setName(cols[0]);
                app.setCategory(cols[1]);
                app.setRating(Float.parseFloat(cols[2]));
                return app;
            })
            .toList(); 

            br.close();
            r.close();

            System.out.println(App);
    }   
    
}
