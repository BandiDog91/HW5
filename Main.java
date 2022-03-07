package JavaCore.HW5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        try (FileOutputStream table = new FileOutputStream("Таблица.csv",false)){
            byte[] bytes = newData().toString().getBytes(StandardCharsets.UTF_8);
            table.write(bytes);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try (FileInputStream table = new FileInputStream("Таблица.csv")){
        byte[] bytes = new byte[table.available()];
        table.read(bytes);
        String tableString = new String(bytes);
            System.out.println(tableString);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
    public static AppData newData (){
            AppData appData = new AppData();
            String[] headers = new String[] { "Заголовок 1", "Заголовок 2", "Заголовок 3" };
            appData.init(headers);
            return appData;
    }
}
