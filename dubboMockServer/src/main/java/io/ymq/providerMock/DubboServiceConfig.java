package io.ymq.providerMock;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

public class DubboServiceConfig {
    public  RegistryConfig createRegistry(String address, int timeout) {
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        registry.setAddress(address);
        registry.setTimeout(timeout);
        registry.setPort(8899);
        return registry;
    }


    private static CtClass getParamType(ClassPool classPool, String paramType) {
        switch (paramType) {
            case "char":
                return CtClass.charType;
            case "byte":
                return CtClass.byteType;
            case "short":
                return CtClass.shortType;
            case "int":
                return CtClass.intType;
            case "long":
                return CtClass.longType;
            case "float":
                return CtClass.floatType;
            case "double":
                return CtClass.doubleType;
            case "boolean":
                return CtClass.booleanType;
            default:
                try {
                    return classPool.get(paramType);
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

//    public void regiterJavasistDubboServeice(){
//
//        //====================
//        ClassPool pool = ClassPool.getDefault();
//        CtClass dubboInterface = pool.makeClass("io.ymq.providerMock.DubboInterface");
//
//
//        ApplicationConfig application = new ApplicationConfig();
//        application.setName("dubbo-test");
//        ProtocolConfig protocol = new ProtocolConfig();
//        RegistryConfig registry = createRegistry("127.0.0.1:2181", 500000);
//        ServiceConfig<CtClass> service = new ServiceConfig<>();
//
//        DubboImplement dubboImplement = new DubboImplement();
//        service.setInterface(dubboInterface.toClass());
//        service.setApplication(application);
//        service.setRegistry(registry);
//        service.setProtocol(protocol); // 多个协议可以用setProtocols()
//        service.setRef(dubboInterface);
////        service.setVersion("1.0.0");
//        // 暴露及注册服务
//        service.export();
//        System.out.print("export ok!");
//    }

    public void regiterDubboServeice(){
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-test");
        ProtocolConfig protocol = new ProtocolConfig();
        RegistryConfig registry = createRegistry("127.0.0.1:2181", 500000);
       ServiceConfig<DubboImplement> service = new ServiceConfig<>();
        DubboImplement dubboImplement = new DubboImplement();
        service.setInterface(DubboInterface.class);
        service.setApplication(application);
        service.setRegistry(registry);
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setRef(new DubboImplement());
//        service.setVersion("1.0.0");
        // 暴露及注册服务
        service.export();
        System.out.print("export ok!");
    }
}
