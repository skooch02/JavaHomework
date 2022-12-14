package chapterEleven;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        ObjectOutputStream os = null;
        ObjectInputStream is = null;
        List<Person> list = new ArrayList<>();
        try {
            String len = null;
            int x = 0;
            int y = 0;
            br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\19057\\Documents\\Codefield\\file_java\\JavaHomework\\src\\chapterEleven\\a.txt")));
            while ((len = br.readLine()) != null) {
                String[] strings = len.split(",");
                for (int i = 0; i < strings.length; i++) {
                    x = strings[i].indexOf('=');
                    len = strings[i].substring(x + 1);
                    if (i == 0) {
                        y = Integer.parseInt(len);
                    }
                }
                Person p = new Person(y, len);
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }

        try {
            os = new ObjectOutputStream(new FileOutputStream("person.txt"));
            os.writeObject(list);
            is = new ObjectInputStream(new FileInputStream("person.txt"));
            List<Person> _list = (List<Person>) is.readObject();
            for (Person p : _list) {
                System.out.println(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception _e) {
                    _e.printStackTrace();
                } finally {
                    if (is != null) {}
                    try {
                        is.close();
                    } catch (Exception __e) {
                        __e.printStackTrace();
                    }
                }
            }
        }
    }
}
