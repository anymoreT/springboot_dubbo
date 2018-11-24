package io.ymq.dubbo.consumer.providerMock;

//import com.tony.test.mock.po.ProtocolConfigExample;
//import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProtocolConfigMapper {
//    int countByExample(ProtocolConfigExample example);
//
//    int deleteByExample(ProtocolConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProtocolConfig record);

    int insertSelective(ProtocolConfig record);

//  List<ProtocolConfig> selectByExample(ProtocolConfigExample example);
//
//    ProtocolConfig selectByPrimaryKey(Integer id);
//
//    int updateByExampleSelective(@Param("record") ProtocolConfig record, @Param("example") ProtocolConfigExample example);
//
//    int updateByExample(@Param("record") ProtocolConfig record, @Param("example") ProtocolConfigExample example);

//    int updateByPrimaryKeySelective(ProtocolConfig record);
//
//    int updateByPrimaryKey(ProtocolConfig record);
}