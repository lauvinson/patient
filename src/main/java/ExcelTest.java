import entity.Patient;
import utils.Reader;

/**
 * @author vinson
 */
public class ExcelTest {
    public static void main(String[] args) {
        Reader<Patient> reader = new Reader<>();
        reader.indexOrNameRead("/Users/vinson/Downloads/R_final_final_副本.xlsx");
    }
}
