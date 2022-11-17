package dianmingqi;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class name {
    private String name;

    public name() {
    }

    public name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<String> namelist()
    {   File file = null;
        FileInputStream fin = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try {
             file =new File("./src/name.txt");
             fin = new FileInputStream(file);
             reader = new InputStreamReader(fin);
             bufferedReader = new BufferedReader(reader);
            String str = "";
            ArrayList<String> ss =   new ArrayList<String> ();
            while ((str = bufferedReader.readLine())!=null)
            {   String name0 = str.split("\\s")[0];
                ss.add(name0);
            }

            return ss;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
