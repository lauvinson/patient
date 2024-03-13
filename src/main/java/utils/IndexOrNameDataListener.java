package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import entity.Patient;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.springframework.util.NumberUtils;

import static training.AppExample.driver;
import static training.AppExample.patients;
import static utils.StringUtils.levenshteinDistance;

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
        Object patientId = ((Patient) data).getCaseId();

        // 有可能读到空行，所以判断一下id是否为空，空的就直接返回，不处理
        if (null == patientId || patientId.toString().isEmpty()) {
            return;
        }
        Patient patient = (Patient) data;

        // 根据excel 中的病例 ID 获取在线的列表数据
        Map<String, Object> onlinePatient = patients.get(patient.getCaseId());
        if (onlinePatient == null) {
            LOGGER.error("在线患者不存在,需要新建");
            return;
        }
        // 从在线的列表数据中拿到ID，就可以访问对应的编辑页面了
        String ID = onlinePatient.get("ID").toString();

//        if (!Objects.equals(onlinePatient.get("CompletedCRFCount").toString(), "0")) {
//            return;
//        }

        // 基本信息
//        try {
//            // 基础信息页面
//            driver.get("http://www.yihhm.com:82/Qn/Survey.aspx?QnID=404C3FFD-E661-49A9-8094-B82D73796A56&PatientID=" + ID + "&AnswerID=-1&ProjectID=30");
//            String currentUrl = driver.getCurrentUrl();
//            // 检查URL中的PatientId参数是否为"-1"，填过的就不是-1，直接跳过，currentUrl.contains("AnswerID=-1")
//            if (currentUrl.contains("AnswerID=-1")) {
//                List<WebElement> fieldsets = driver.findElements(By.xpath("//form//fieldset"));
//                for (int i = 0; i < fieldsets.size(); i++) {
//                    WebElement fieldset = fieldsets.get(i);
//                    String fieldsetId = fieldset.getAttribute("id");
//                    WebElement legendTitle = fieldset.findElement(By.id(fieldsetId + "-legendTitle"));
//                    WebElement legendBody = fieldset.findElement(By.id(fieldsetId + "-body"));
//                    switch (i) {
//                        case 0 -> fillData(legendBody, patient.getCaseId());
//                        case 1 -> fillData(legendBody, patient.getIdNo().replace("'", ""));
//                        case 2 -> fillData(legendBody, patient.getSampleSrcNo());
//                        case 3 -> fillData(legendBody, patient.getBloodSampleNo());
//                        case 4 -> fillData(legendBody, patient.getTissueSampleNo());
//                        case 5 -> fillData(legendBody, patient.getAge());
//                        case 6 -> fillData(legendBody, patient.getWeight());
//                        case 7 -> fillData(legendBody, patient.getHeight());
//                        case 8 -> fillData(legendBody, patient.getEthnicity() + "族");
//                        case 9 -> fillData(legendBody, patient.getEducation());
//                        case 10 -> fillData(legendBody, "市内");
//                        case 11 -> fillData(legendBody, patient.getOccupation());
//                    }
//                }
//                driver.findElement(By.id("btnSubmit-btnEl")).click();
//                Thread.sleep(3000);
////                new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.className("x-form-display-field")));
//                return;
//            }
//        } catch (Exception e) {
//            LOGGER.error(e.toString());
//        }

        // 孕产情况
//        try {
//            // 基础信息页面
//            driver.get("http://www.yihhm.com:82/Qn/Survey.aspx?QnID=81C9A083-57A7-4237-8411-86F05FDF1F0E&PatientID=" + ID + "&AnswerID=-1&ProjectID=30");
//            String currentUrl = driver.getCurrentUrl();
//            // 检查URL中的PatientId参数是否为"-1"，填过的就不是-1，直接跳过，currentUrl.contains("AnswerID=-1")
//            if (currentUrl.contains("AnswerID=-1")) {
//                List<WebElement> fieldsets = driver.findElements(By.xpath("//form//fieldset"));
//                for (int i = 0; i < fieldsets.size(); i++) {
//                    WebElement fieldset = fieldsets.get(i);
//                    String fieldsetId = fieldset.getAttribute("id");
//                    WebElement legendTitle = fieldset.findElement(By.id(fieldsetId + "-legendTitle"));
//                    WebElement legendBody = fieldset.findElement(By.id(fieldsetId + "-body"));
//                    switch (i) {
//                        case 0 -> fillData(legendBody, patient.getMaritalStatus());
//                        case 1 -> fillData(legendBody, "24");
//                        case 2 -> fillData(legendBody, patient.getPregnancyCount());
//                        case 3 -> fillData(legendBody, patient.getDeliveryCount());
//                        case 4 -> fillData(legendBody, patient.getCsectionCount());
//                        case 5 -> fillData(legendBody, patient.getVaginalDeliveryCount());
//                    }
//                }
//                driver.findElement(By.id("btnSubmit-btnEl")).click();
//                Thread.sleep(3000);
////                new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.className("x-form-display-field")));
//                return;
//            }
//        } catch (Exception e) {
//            LOGGER.error(e.toString());
//        }

//
//            // 盆底疾病
//            driver.get("http://www.yihhm.com:82/Qn/Survey.aspx?QnID=581C42E9-E1B9-403D-9C8D-C172C494AE43&PatientID=" + ID + "&AnswerID=-1&ProjectID=30");
//            Thread.sleep(3000);
//
//            // 基础疾病
//            driver.get("http://www.yihhm.com:82/Qn/Survey.aspx?QnID=3AAF799D-34E2-4397-9806-9FCB396ADBD3&PatientID=" + ID + "&AnswerID=-1&ProjectID=30");
//            Thread.sleep(3000);
//
        // CRADI-8
        try {
            // 基础信息页面
            driver.get("http://www.yihhm.com:82/Qn/Survey.aspx?QnID=48613CA7-4B58-469C-9739-01CC34320B59&PatientID=" + ID + "&AnswerID=-1&ProjectID=30");
            String currentUrl = driver.getCurrentUrl();
            // 检查URL中的PatientId参数是否为"-1"，填过的就不是-1，直接跳过，currentUrl.contains("AnswerID=-1")
            if (currentUrl.contains("AnswerID=-1")) {
                List<WebElement> fieldsets = driver.findElements(By.xpath("//form//fieldset"));
                for (int i = 0; i < fieldsets.size(); i++) {
                    WebElement fieldset = fieldsets.get(i);
                    String fieldsetId = fieldset.getAttribute("id");
                    WebElement legendTitle = fieldset.findElement(By.id(fieldsetId + "-legendTitle"));
                    WebElement legendBody = fieldset.findElement(By.id(fieldsetId + "-body"));
                    switch (i) {
                        case 0 -> fillData(legendBody, patient.getConstipationDefecationDifficulty(), true);
                        case 1 -> fillData(legendBody, patient.getUnableToDefecateCompletely(), true);
                        case 2 -> fillData(legendBody, patient.getIncontinenceOfFormedStool(), true);
                        case 3 -> fillData(legendBody, patient.getIncontinenceOfLooseStool(), true);
                        case 4 -> fillData(legendBody, patient.getInabilityToControlFlatulence(), true);
                        case 5 -> fillData(legendBody, patient.getPainOnDefecation(), true);
                        case 6 -> fillData(legendBody, patient.getFecalUrgency(), true);
                        case 7 -> fillData(legendBody, patient.getSensationOfRectalProtrusion(), true);
                    }
                }
                driver.findElement(By.id("btnSubmit-btnEl")).click();
                Thread.sleep(3000);
//                new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.className("x-form-display-field")));
                return;
            }
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
//
        // 便秘
//        try {
//            // 基础信息页面
//            driver.get("http://www.yihhm.com:82/Qn/Survey.aspx?QnID=A7F469AE-E67A-4DE7-B2C9-6C61E86419B0&PatientID=" + ID + "&AnswerID=-1&ProjectID=30");
//            String currentUrl = driver.getCurrentUrl();
//            // 检查URL中的PatientId参数是否为"-1"，填过的就不是-1，直接跳过，currentUrl.contains("AnswerID=-1")
//            if (currentUrl.contains("AnswerID=-1")) {
//                List<WebElement> fieldsets = driver.findElements(By.xpath("//form//fieldset"));
//                for (int i = 0; i < fieldsets.size(); i++) {
//                    WebElement fieldset = fieldsets.get(i);
//                    String fieldsetId = fieldset.getAttribute("id");
//                    WebElement legendTitle = fieldset.findElement(By.id(fieldsetId + "-legendTitle"));
//                    WebElement legendBody = fieldset.findElement(By.id(fieldsetId + "-body"));
//                    switch (i) {
//                        case 0 -> fillData(legendBody, patient.getDefecationFrequency(), true);
//                        case 1 -> fillData(legendBody, patient.getStrainedDefecation(), true);
//                        case 2 -> fillData(legendBody, patient.getSensationOfIncompleteBowelEvacuation(), true);
//                        case 3 -> fillData(legendBody, patient.getAbdomenPain(), true);
//                        case 4 -> fillData(legendBody, patient.getDefecationDuration(), true);
//                        case 5 -> fillData(legendBody, patient.getDefecationAssistanceMethod(), true);
//                        case 6 -> fillData(legendBody, patient.getUnsuccessfulDefecationAttemptsPerDay(), true);
//                        case 7 -> fillData(legendBody, patient.getDiseaseCourseDuration(), false);
//                    }
//                }
//                driver.findElement(By.id("btnSubmit-btnEl")).click();
//                Thread.sleep(3000);
////                new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.className("x-form-display-field")));
//                return;
//            }
//        } catch (Exception e) {
//            LOGGER.error(e.toString());
//        }
//
//            // SF-12
//            driver.get("http://www.yihhm.com:82/Qn/Survey.aspx?QnID=5D17DB29-024F-4BE3-BF14-72995467E59B&PatientID=" + ID + "&AnswerID=-1&ProjectID=30");
//            Thread.sleep(3000);
//
//            // 佛罗里达
//            driver.get("http://www.yihhm.com:82/Qn/Survey.aspx?QnID=ACAECB83-B4C8-4102-A4EA-A863AC5CBC20&PatientID=" + ID + "&AnswerID=-1&ProjectID=30");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Quitting the Driver - It is important to quit the driver at the end of the program:
    }

    // 数据读完之后，框架会调这个方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
//        driver.quit();
        LOGGER.info("所有数据解析完成！");
    }

    public void fillData(WebElement body, String data) {
        fillData(body, data, false);
    }

    // 传入一个问题回答区域元素，去判断是输入框还是单选框
    // 如果是输入框就输入data，如果是单选框就要去匹配 data 然后勾选
    // isNo data 是个数字，是答案的下标，无需对比，直接根据下标勾选
    public void fillData(WebElement body, String data, boolean isNo) {
        // 检查<fieldset>内是否包含输入框
        List<WebElement> inputFields = body.findElements(By.className("x-form-text"));
        if (!inputFields.isEmpty()) {
            // 处理输入框
            for (WebElement inputField : inputFields) {
                if (inputField.getAttribute("type").equals("text")) {
                    inputField.clear();
                    inputField.sendKeys(data);
                    return;
                }
            }
        }

        // 这里会涉及到一个问题，就是传入的 data 和页面上的 data 是一个意思，但是不完全一样，需要注意，匹配不了就要单独处理
        // 比如选项是商业服务业人员，他给你填个数据是商业服务人员，你没发匹配
        List<WebElement> tables = body.findElements(By.className("x-checkboxgroup-form-item"));
        if (!tables.isEmpty()) {

            // 如果是按序号选择，直接选该位置的序号
            if (isNo) {
                for (int i = 0; i < tables.size(); i++) {
                    if (Integer.parseInt(data) == i) {
                        String mostMatchingTableId = tables.get(i).getAttribute("id");
                        WebElement input = tables.get(i).findElement(By.id(mostMatchingTableId + "-inputEl"));
                        input.click();
                        return;
                    }
                }
            }

            // 按照选项内容匹配程度选
            WebElement mostMatchingTable = null;
            double maxScore = 0.0;
            // 处理单选框
            for (WebElement table : tables) {
                String tableId = table.getAttribute("id");
                WebElement label = table.findElement(By.id(tableId + "-boxLabelEl"));
                String labelText = label.getText();
                double score = levenshteinDistance(labelText.replace("、", ""), data);

                if (score > maxScore) {
                    maxScore = score;
                    mostMatchingTable = table;
                }
            }

            if (mostMatchingTable != null) {
                String mostMatchingTableId = mostMatchingTable.getAttribute("id");
                WebElement input = mostMatchingTable.findElement(By.id(mostMatchingTableId + "-inputEl"));
                input.click();
            }
        }
    }
}