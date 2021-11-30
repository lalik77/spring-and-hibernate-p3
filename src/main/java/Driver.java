import com.fasterxml.jackson.databind.ObjectMapper;
import com.mami.luv2codes.Student;

import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) {

        //create object mapper

        ObjectMapper mapper = new ObjectMapper();

        try {

            //read Json file and map/convert to
            // java Pojo: data/sample-lite.json

            Student student = mapper.readValue(new File("data/sample-lite.json"), Student.class);

            //print first name and last name

            System.out.println(student.getFirstName() +"   " +  student.getLastName());


        } catch (IOException e) {
            e.printStackTrace();
        }
        //print first name and last name


    }
}
