package utils;

import java.util.ArrayList;
import java.util.List;

import entity.Patient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;

import static training.AppExample.driver;
import static training.AppExample.patients;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
public class IndexOrNameDataListener<T> extends AnalysisEventListener<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexOrNameDataListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 1;
    List<T> list = new ArrayList<T>();

    @Override
    public void invoke(T data, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        Object patientId = ((Patient)data).getCaseId();

        // 有可能读到空行，所以判断一下id是否为空，空的就直接返回，不处理
        if(null == patientId || patientId.toString().isEmpty()){
            return;
        }

        // (A)B.C , 编译器怎么知道，你要的是把B.C转成A，还是B转A再获取C呢，这是歧义，所以要包起来
        // 所有的转换，查找，都没有经过测试，所以直接启动，有错再说
        // 直接用excel的PatientID，从在线数据转成的map里获取数据，然后拿他的ID，去打开页面
        //拿到存放在线病人数据的map根据CaseId（Excel的CaseID就是在线病人的PatientID）获取到ID
        String ID = patients.get(((Patient)data).getCaseId()).get("ID").toString();

        String url = "http://www.yihhm.com:82/Qn/Survey.aspx?QnID=404C3FFD-E661-49A9-8094-B82D73796A56&PatientID="+ ID +"&AnswerID=-1&ProjectID=30";
        // GET request to site
        driver.get(url);

       try {
           WebElement testingLink = driver.findElement(By.partialLinkText("Testing"));
           System.out.println(testingLink.toString());
       } catch (Exception e) {
           LOGGER.error(e.toString());
       }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Quitting the Driver - It is important to quit the driver at the end of the program:
    }

    // 数据读完之后，框架会调这个方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
//        driver.quit();
        LOGGER.info("所有数据解析完成！");
    }
}