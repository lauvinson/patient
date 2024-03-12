package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;

import static training.AppExample.driver;

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
        String url = "https://the-internet.herokuapp.com/";

        // GET request to site
        driver.get(url);

        WebElement testingLink = driver.findElement(By.partialLinkText("Testing"));
        System.out.println(testingLink.toString());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Quitting the Driver - It is important to quit the driver at the end of the program:
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        driver.quit();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        LOGGER.info("存储数据库成功！");
    }
}