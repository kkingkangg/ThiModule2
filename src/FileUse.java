import model.DanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TextFile {
    public static void writeTextFile(String pathname, List<DanhBa> list) {
        try {
            FileWriter fileWriter = new FileWriter(pathname, true);
            BufferedWriter br = new BufferedWriter(fileWriter);
            for (DanhBa danhBa: list) {
                br.write(danhBa.getSoDienThoai()+", "+danhBa.getNhom()+", "+danhBa.getHoTen()+", "+danhBa.getGioiTinh()+", "+danhBa.getDiaChi()+", "+danhBa.getNgaySinh()+", "+danhBa.getEmail());
            }
            fileWriter.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readTextFile(String pathname) {
        List<String> result = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(pathname);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                result.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
