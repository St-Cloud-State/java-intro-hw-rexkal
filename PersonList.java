import java.io.*;
import java.util.LinkedList;

public class PersonList {
    private LinkedList<Person> list;
    public PersonList(){
        this.list = new LinkedList<>();
    }
    public void store(InputStream inputStream) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null){
            String[] parts = line.split(" ");
            if (parts.length == 3) {
                String firstName = parts[0];
                String lastName = parts[1];
                String id = parts[2];
                list.add(new Person(firstName, lastName, id));
            }
        }
    }

    public void display(PrintStream outputStream){
        for (Person person : list){
            outputStream.println(person);
        }
    }

    public int find(String sid){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId().equals(sid)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        PersonList personList = new PersonList();
        String data = "Denny Thongrasmy 003\nDen Thon 324\nDee Tee 234\nJohn Smith 123\n";
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        try {
            personList.store(inputStream);
            personList.display(System.out);
            System.out.println("Searching for ID 003:");
            int index = personList.find("003");
            if (index != -1){
                System.out.println("Found at index: " + index);
            } else{
                System.out.println("Nothing found.");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
