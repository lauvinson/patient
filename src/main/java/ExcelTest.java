import entity.Patient;
import utils.Reader;

/**
 * @author vinson
 */
public class ExcelTest {
    public static void main(String[] args) {
        Reader<Patient> reader = new Reader<>();
        reader.indexOrNameRead("data.xlsx");
    }
}
