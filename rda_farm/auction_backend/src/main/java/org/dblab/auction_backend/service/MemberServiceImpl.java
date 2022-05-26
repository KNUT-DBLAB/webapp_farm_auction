package org.dblab.auction_backend.service;

import java.util.HashMap;
import java.util.List;

import org.dblab.auction_backend.config.JwtTokenProvider;
import org.dblab.auction_backend.domain.ConsumerMemberDTO;
import org.dblab.auction_backend.domain.FarmMemberDTO;
import org.dblab.auction_backend.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;
    
    private Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
    

    // #################################################### 소비자 CRUD ####################################################

    public HashMap<String, Object> signupConsumer(ConsumerMemberDTO consumerMember) {
        log.info("signupConsumer..........");

        HashMap<String, Object> token = null;

        consumerMember.setC_passwd(passwordEncoder.encode(consumerMember.getC_passwd()));
        log.info(consumerMember.getC_passwd());

        if (memberMapper.signupConsumer(consumerMember) == 1){
            token = new HashMap<String,Object>();

            // String tokenString = jwtManager.generateToken(consumerMember.getC_email());
            String tokenString = jwtTokenProvider.createToken(consumerMember.getC_email(), "consumer");
            System.out.println(tokenString);
            token.put("token", tokenString);
        }
        return token;
    }

	public ConsumerMemberDTO getConsumerMember(String c_email) {
        log.info("getConsumerMember..........");
        return memberMapper.getConsumerMember(c_email);
	}

    public int updateConsumerMember(ConsumerMemberDTO consumerMember) {
        log.info("updateConsumerMember..........");

        consumerMember.setC_passwd(passwordEncoder.encode(consumerMember.getC_passwd()));

        return memberMapper.updateConsumerMember(consumerMember);
    }

    public int deleteConsumerMember(int consumer_id) {
        log.info("deleteConsumerMember..........");
        return memberMapper.deleteConsumerMember(consumer_id);
    }


    // #################################################### 농가 CRUD ####################################################

    public HashMap<String, Object> signupFarmMember(FarmMemberDTO farmMemberDTO) {
        log.info("signupFarmMember..........");

        HashMap<String, Object> token = null;

        farmMemberDTO.setF_passwd(passwordEncoder.encode(farmMemberDTO.getF_passwd()));

        if (memberMapper.signupFarmMember(farmMemberDTO) == 1){
            token = new HashMap<String,Object>();

            // String tokenString = jwtManager.generateToken(farmMemberDTO.getF_email());
            String tokenString = jwtTokenProvider.createToken(farmMemberDTO.getF_email(), "farm");
            System.out.println(tokenString);
            token.put("token", tokenString);
        }
        return token;
    }

    public int updateFarmMember(FarmMemberDTO farmMemberDTO){
        log.info("updateFarmMember..........");

        farmMemberDTO.setF_passwd(passwordEncoder.encode(farmMemberDTO.getF_passwd()));

        return memberMapper.updateFarmMember(farmMemberDTO);
    }

    public int deleteFarmMember(int farm_id) {
        log.info("deleteFarmMember..........");
        return memberMapper.deleteFarmMember(farm_id);
    }


    // #################################################### 로그인, 로그아웃, 이메일 중복 확인 ####################################################

    public UserDetails login(String checkUser ,String email, String password) {
        log.info("login..........");

        // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        ConsumerMemberDTO consumerMember = null;
        FarmMemberDTO farmMember = null;
        String token = null;

        System.out.println("checkUser: " + checkUser);
        
        if (checkUser.equals("consumer")){
            consumerMember = memberMapper.getConsumerMember(email);
            if(consumerMember == null || !passwordEncoder.matches(password, consumerMember.getC_passwd())) {
                System.out.println("비밀번호가 틀렸습니다.");
                System.out.println("널입니다!");
                return null;
            } else if (consumerMember.getToken() != null){

                System.out.println("토큰 만료");
                memberMapper.setNullConsumerToken(consumerMember.getC_email());

                ConsumerMemberDTO duplicateLoginObject = new ConsumerMemberDTO();
                duplicateLoginObject.setAuthority("ROLE_USER");
                return duplicateLoginObject;
            }
            System.out.println(consumerMember.toString());

            // 생성된 토큰 넣어주기
            token = jwtTokenProvider.createToken(email, checkUser);
            memberMapper.setConsumerToken(email, token);

            consumerMember.setToken(token);
            consumerMember.setC_passwd("");

            System.out.println(token);
            return consumerMember;
        }

        farmMember = memberMapper.getFarmMember(email);

        if(farmMember == null && !passwordEncoder.matches(password, farmMember.getF_passwd())) {
            System.out.println("널입니다!");
            return null;
        } else if (farmMember.getToken() != null){
            System.out.println("토큰 만료");
            memberMapper.setNullConsumerToken(farmMember.getF_email());

            ConsumerMemberDTO duplicateLoginObject = new ConsumerMemberDTO();
            duplicateLoginObject.setAuthority("ROLE_USER");
            return duplicateLoginObject;
        }
        System.out.println(farmMember.toString());

        // 생성된 토큰 넣어주기
        token = jwtTokenProvider.createToken(email, checkUser);
        memberMapper.setFarmToken(email, token);
        farmMember.setToken(token);
        farmMember.setF_passwd("");

        System.out.println(token);

        return farmMember;
    }

    @Override
    public int logout(String checkUser, String email) {

        int result;
        if (checkUser.equals("consumer")) {
            result = memberMapper.setNullConsumerToken(email);
        } else {
            result = memberMapper.setNullFarmToken(email);
        }
        return result;
    }

    public int existEmail(String email) {
        int result = memberMapper.existEmail(email);
        System.out.println("result: "+ result);
        return result;
    }
    



    // #################################################### 테스트용! ####################################################

    public List<ConsumerMemberDTO> getAllConsumerMember() {
        log.info("getAllList..........");
        return memberMapper.getAllConsumerMember();
    }
    
}
