import entity.Patient;
import utils.Reader;

import static utils.StringUtils.levenshteinDistance;

/**
 * @author vinson
 */
public class ExcelTest {
    public static void main(String[] args) {
        double result = levenshteinDistance("专业技术人员", "操作人员");
        double result2 = levenshteinDistance("生产、运输设备操作人员及有关人员", "操作人员");
        System.out.println();
    }


}
