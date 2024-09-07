import java.io.*;
import java.util.LinkedList;

public class MyMain{
    public static void store(InputStream inputStream, LinkedList<Person> list) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null){
            String[] parts = line.split(" ");
            if (parts.length == 3){
                String firstName = parts[0];
                String lastName = parts[1];
                String id = parts[2];
                list.add(new Person(firstName, lastName, id));
            }
        }
    }
    public static void display(PrintStream outputStream, LinkedList<Person> list){
        for (Person person : list){
            outputStream.println(person);
        }
    }
    public static int find(String sid, LinkedList<Person> list){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId().equals(sid)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        LinkedList<Person> list = new LinkedList<>();
        String data = "Denny Thongrasmy 003\nDen Thon 324\nDee Tee 234\nBob Joe 123\n";
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        
        try{
            store(inputStream, list);
            display(System.out, list);
            System.out.println("Searching for ID 003:");
            int index = find("003", list);
            if (index != -1){
                System.out.println("Found at index: " + index);
            } else {
                System.out.println("Nothing found.");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
