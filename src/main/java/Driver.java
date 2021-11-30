import com.fasterxml.jackson.databind.ObjectMapper;
import com.mami.luv2codes.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args) {

        //create object mapper

        ObjectMapper mapper = new ObjectMapper();

        try {

            //read Json file and map/convert to
            // java Pojo: data/sample-lite.json

            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            //print first name and last name

            System.out.println(student.getFirstName() +"   " +  student.getLastName());
            System.out.println(student.getAddress());


            Arrays.asList(student.getLanguages()).forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }
        //print first name and last name


    }
}
