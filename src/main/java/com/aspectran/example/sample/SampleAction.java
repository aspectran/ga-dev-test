package com.aspectran.example.sample;

import java.util.LinkedHashMap;
import java.util.Map;

import com.aspectran.core.activity.Translet;
import com.aspectran.example.common.MyTranslet;

public class SampleAction {

    public String countTo10(Translet translet) {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= 10; i++) {
            sb.append(i).append("\n");
        }

        return sb.toString();
    }

    public int[] countTo10AsArray(Translet translet) {
        int arr[] = new int[10];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    public Object applyTheAdvice(Translet translet) {
        String beforeAdviceResult = translet.getBeforeAdviceResult("helloAdvice");
        String afterAdviceResult = translet.getAfterAdviceResult("helloAdvice");

        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("beforeAdviceResult", beforeAdviceResult);
        result.put("countTo10", countTo10AsArray(translet));
        result.put("sampleBean", translet.getBean("sampleBean").toString());
        result.put("afterAdviceResult", afterAdviceResult);

        return result;
    }

    public Object errorCaused(MyTranslet translet) {
        int i = 1 / 0;

        return i;
    }

    public int[] echoPrimitiveArray(int[] intArray) {
        return intArray;
    }

}
