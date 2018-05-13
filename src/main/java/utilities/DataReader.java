package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class DataReader {
    private JSONObject jsonObject;
    //Hàm chuyển chuỗi thành JSON object
    public DataReader(String fileName){
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileName));
            jsonObject = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Hàm đọc dữ liệu từ JSON object
    public JSONObject get(String key){
        return (JSONObject) jsonObject.get(key);
    }
}
