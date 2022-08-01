package manager;

import contacts.User;
import org.testng.annotations.DataProvider;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {


    @DataProvider
    public Iterator<Object[]> dataLogin() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"mia@gmail.com", "Mmia12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"mia@gmail.com", "Mmia12345$"});


        return list.iterator();

    }
    @DataProvider
    public Iterator<Object[]>loginCvs() throws IOException {
        List<Object[]>list=new ArrayList<>();

        BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader("src/test/resources/login.csv")));
        String line =reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]>registrationCvs() throws IOException {
        List<Object[]>list=new ArrayList<>();

        BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader("src/test/resources/registration.csv")));
        String line =reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

}