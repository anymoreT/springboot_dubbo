package io.ymq.dubbo.consumer.providerMock;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MockGenericService implements GenericService {



    private MockService             mockService;

    private List<ServiceMethedRule> methodRules = Lists.newArrayList();

    public MockGenericService(MockService mockService, List<ServiceMethedRule> methodRules) {
        super();
        this.mockService = mockService;
        this.methodRules = methodRules;
        init();
    }

    public void init() {

        Map<String, List<ServiceMethedRule>> tempMap = Maps.newHashMap();
        for (int i = 0; i < methodRules.size(); i++) {
            ServiceMethedRule mrule = methodRules.get(i);
            if (!tempMap.containsKey(mrule.getMethodName())) {
                tempMap.put(mrule.getMethodName(), new ArrayList<ServiceMethedRule>());
            }
            tempMap.get(mrule.getMethodName()).add(mrule);
        }

    }

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {


        String s = "{}";
        return JSON.parse(s);
    }

    public Map<String, Object> buildContext(String method, String[] parameterTypes, Object[] args) {

        return null;
    }

//    public MethodRule getMethodRule(String methodName) {
//        return rules.get(methodName);
//    }
//
//    public Map<String, MethodRule> getRules() {
//        return rules;
//    }

    public MockService getMockService() {
        return mockService;
    }

    public List<ServiceMethedRule> getMethodRules() {
        return methodRules;
    }

}
