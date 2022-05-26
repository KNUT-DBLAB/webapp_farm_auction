package org.dblab.auction_backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dblab.auction_backend.domain.ConsumerMemberDTO;
import org.dblab.auction_backend.domain.FarmMemberDTO;

public interface MemberMapper {

    // #################################################### 소비자 CRUD ####################################################

    public int signupConsumer(ConsumerMemberDTO consumerMember);

    public ConsumerMemberDTO getConsumerMember(@Param("c_email") String c_email);

    public int updateConsumerMember(ConsumerMemberDTO consumerMember);

    public int deleteConsumerMember(@Param("consumer_id") int consumer_id);

    public int setConsumerToken(@Param("c_email") String c_email, @Param("token") String token);

    public int setNullConsumerToken(@Param("c_email") String c_email);


    // #################################################### 농가 CRUD ####################################################
    
    public int signupFarmMember(FarmMemberDTO farmMemberDTO);

    public FarmMemberDTO getFarmMember(@Param("f_email") String f_email);

    public int updateFarmMember(FarmMemberDTO farmMemberDTO);

    public int deleteFarmMember(@Param("farm_id") int farm_id);

    public List<ConsumerMemberDTO> getAllConsumerMember();

    public int setFarmToken(@Param("f_email") String f_email, @Param("token") String token);

    public int setNullFarmToken(@Param("f_email") String f_email);


    // #################################################### 로그인, 이메일 중복 확인 #################################################### 

    public ConsumerMemberDTO loginConsumerMember(@Param("email") String email, @Param("password") String password);

    public FarmMemberDTO loginFarmMember(@Param("email") String email, @Param("password") String password);

    public int existEmail(@Param("email") String email);
}