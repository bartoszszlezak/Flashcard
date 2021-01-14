import java.io.*;
import java.util.*;

public class Logic {

    private int flag = 0;
    private int rand = 0;
    private String key, value;
    private Map<String, String> map_learn = new LinkedHashMap<>();
    private Map<String, String> map_done = new LinkedHashMap<>();


    public void get_from_files(String f1, String f2){

        FileReader file_spanish = null;
        FileReader file_polish = null;
        String line = "";

        try {
            file_spanish = new FileReader(f1);
        } catch (FileNotFoundException e) {
            System.out.println("Can't open this file!");
            System.exit(1);
        }

        BufferedReader buffer = new BufferedReader(file_spanish);
        try {
            while((line = buffer.readLine()) != null){
                map_learn.put(line,"none");
            }
        } catch (IOException e) {
            System.out.println("Error during reading!");
            System.exit(1);
        }
        try {
            file_spanish.close();
        } catch (IOException e) {
            System.out.println("Can't close this file!");
            System.exit(1);
        }

        try {
            file_polish = new FileReader(f2);
        } catch (FileNotFoundException e) {
            System.out.println("Can't open this file!");
            System.exit(1);
        }

        BufferedReader buffer1 = new BufferedReader(file_polish);
        Set<Map.Entry<String, String>> entries = map_learn.entrySet();
        Iterator<Map.Entry<String, String>> iter = entries.iterator();

        try {
            while(((line = buffer1.readLine()) != null) && iter.hasNext()){
                Map.Entry<String, String> entry;
                entry = iter.next();
                entry.setValue(line);
            }
        } catch (IOException e) {
            System.out.println("Error during reading!");
            System.exit(1);
        }
        try {
            //System.out.println(map_learn);
            file_polish.close();
        } catch (IOException e) {
            System.out.println("Can't close this file!");
            System.exit(1);
        }

    }


    public void random(){

        List<String> keyList = new ArrayList<String>(map_learn.keySet());
        int index = new Random().nextInt(keyList.size());
        key = keyList.get(index);
    }

    public void save() {

        FileWriter file_spanish = null;
        FileWriter file_polish = null;
        FileWriter file_s = null;
        FileWriter file_p = null;
        try {
            String file3 = "umiem_nauka.txt";
            file_spanish = new FileWriter(file3,true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String file4 = "umiem_tlumaczenia.txt";
            file_polish = new FileWriter(file4,true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String file1 = "nauka.txt";
            file_s = new FileWriter(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String file2 = "tlumaczenia.txt";
            file_p = new FileWriter(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter buffer1 = new BufferedWriter(file_spanish);
        BufferedWriter buffer2 = new BufferedWriter(file_polish);
        BufferedWriter buffer3 = new BufferedWriter(file_s);
        BufferedWriter buffer4 = new BufferedWriter(file_p);

        Set<Map.Entry<String, String>> entries = map_done.entrySet();
        Iterator<Map.Entry<String, String>> iter = entries.iterator();

        try {
            while (iter.hasNext()) {
                Map.Entry<String, String> item = iter.next();
                buffer1.write(item.getKey());
                buffer1.newLine();
                buffer2.write(item.getValue());
                buffer2.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Map.Entry<String, String>> entries2 = map_learn.entrySet();
        Iterator<Map.Entry<String, String>> iter2 = entries2.iterator();

        try {
            while (iter2.hasNext()) {
                Map.Entry<String, String> item2 = iter2.next();
                buffer3.write(item2.getKey());
                buffer3.newLine();
                buffer4.write(item2.getValue());
                buffer4.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            buffer1.close();
            buffer2.close();
            buffer3.close();
            buffer4.close();
            file_polish.close();
            file_spanish.close();
            file_p.close();
            file_s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int map_learn_size(){
        return this.map_learn.size();
    }

    public void map_add(){
        this.map_done.put(key,value);
    }

    public void map_remove(){
        this.map_learn.remove(key);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String map_get(){
        return this.map_learn.get(key);
    }

    public String getKey() {
        return key;
    }

    public int getRand() {
        return rand;
    }

    public void set_flag(int value){
        this.flag = value;
    }
    public void set_rand(int value){
        this.rand = value;
    }

    public int getFlag() {
        return flag;
    }

    public String getValue() {
        return value;
    }
}
