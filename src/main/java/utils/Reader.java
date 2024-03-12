package utils;

import com.alibaba.excel.EasyExcel;
import entity.Patient;

public class Reader<T> {
    /**
     * 指定列的下标或者列名
     *
     * <p>1. 创建excel对应的实体对象,并使用{@link T}注解. 参照{@link T}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link IndexOrNameDataListener}
     * <p>3. 直接读即可
     */
    public void indexOrNameRead(String path) {
        EasyExcel.read(path, Patient.class, new IndexOrNameDataListener<T>()).headRowNumber(2).sheet().doRead();
    }
}
