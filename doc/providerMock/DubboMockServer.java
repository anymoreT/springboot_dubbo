package io.ymq.dubbo.consumer.providerMock;

import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.google.common.collect.Maps;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class DubboMockServer  {

	public static final String RUNNING = "running";

	public static final String STOP = "stop";

	private Map<Integer, MockGenericService> mockServices = Maps.newHashMap();

	private Map<Integer, ServiceConfig<GenericService>> dubboServices = Maps.newHashMap();

	private DubboServiceConfig dubboServiceConfig = new DubboServiceConfig();

//	@Resource
//	ProtocolConfigMapper protocolConfigMapper;

//	@Resource
//	RegistryConfigMapper registryConfigMapper;



	private String getServiceStatus(int serviceId) {
		return "";
	}




	public synchronized String startService(int serviceId) {

		
		
		unexportService(serviceId); // 卸载服务
		clearLocalCache(serviceId); // 清除本地缓存





		return getServiceStatus(serviceId);
	}

	private void assertConnect(RegistryConfig registryConfig) {
		try {
			ZkClient zk = new ZkClient(registryConfig.getRegistryAddress(), registryConfig.getRegistryTimeout());
			zk.close();
		} catch (Exception e) {
			throw new RuntimeException("注册中心 " + registryConfig.getRegistryAddress() + "无法连接", e);
		}
	}




	/**
	 * 更新本地缓存
	 *
	 * @param serviceId
	 * @param tmpMockservice
	 * @param service
	 */
	private void updateLocalCache(int serviceId, MockGenericService tmpMockservice,
			ServiceConfig<GenericService> service) {
		mockServices.put(serviceId, tmpMockservice);
		dubboServices.put(serviceId, service);
	}

	// 卸载服务
	private void unexportService(int serviceId) {
		if (dubboServices.containsKey(serviceId)) {
			ServiceConfig<GenericService> tempService = dubboServices.get(serviceId);
			if (tempService.isExported()) {
				tempService.unexport();
			}
		}
	}

	// 清除本地缓存
	private void clearLocalCache(int serviceId) {
		mockServices.remove(serviceId);
		dubboServices.remove(serviceId);
	}


}
