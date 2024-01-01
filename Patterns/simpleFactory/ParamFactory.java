/*
 * @author Neo0214
 */
package org.group11.Patterns.simpleFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取参数的工厂类
 */
public class ParamFactory {
    /**
     * 获取参数
     * @param values key名，value值，key名，value值，key名，value值，key名，value值......
     * @return 参数
     */
    public static Map<String,String> getParam(String... values){
        if (values.length%2!=0){
            throw new IllegalArgumentException("参数个数必须为偶数");
        }
        Map<String,String> params = new HashMap<>();
        for (int i=0;i<values.length;i+=2){
            params.put(values[i],values[i+1]);
        }
        return params;
    }
}
