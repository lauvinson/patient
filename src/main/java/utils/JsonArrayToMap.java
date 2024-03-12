package utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonArrayToMap {


    /**
     * 传入一个.json文件路径，文件必须是json数组，然后转成map返回
     * @param path
     * @return
     * @throws IOException
     */
    // 这他妈好像要返回一个map列表，一个json是一个map，有很多个json
    public static Map<String, Map<String, Object>> convert(String path) throws IOException {
        File jsonFile = new File(path);
        String jsonStr = new String(Files.readAllBytes(Paths.get(jsonFile.getPath())));
        JSONArray jsonArray = JSONArray.parseArray(jsonStr);

        Map<String, Map<String, Object>> res = new HashMap<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Map<String, Object> map = new HashMap<>();
            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            // 直接把每条map当成value放进一个整的map里，key就是每条数据的PatientID，然后外面直接用PatientID获取，就能拿到了
            res.put(map.get("PatientNo").toString(), map);
        }

        return res;
    }
}
