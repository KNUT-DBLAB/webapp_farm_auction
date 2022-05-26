package org.dblab.auction_backend.service;

import java.util.HashMap;
import java.util.List;

import org.dblab.auction_backend.domain.ConsumerMemberDTO;
import org.dblab.auction_backend.domain.FarmMemberDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface MemberService {
    
    // #################################################### 소비자 CRUD ####################################################

    public HashMap<String, Object> signupConsumer(ConsumerMemberDTO consumerMember);

	public ConsumerMemberDTO getConsumerMember(String c_email);

    public int updateConsumerMember(ConsumerMemberDTO consumerMember);

    public int deleteConsumerMember(int consumer_id);


    // #################################################### 농가 CRUD ####################################################

    public HashMap<String, Object> signupFarmMember(FarmMemberDTO farmMemberDTO);

    public int updateFarmMember(FarmMemberDTO farmMemberDTO);
    
    public int deleteFarmMember(int farm_id);

    public List<ConsumerMemberDTO> getAllConsumerMember();


    // #################################################### 로그인, 로그아웃, 이메일 중복 확인 ####################################################

    public UserDetails login(String checkUser ,String email, String password);

    public int logout(String checkUser ,String email);

    public int existEmail(String email);

}
