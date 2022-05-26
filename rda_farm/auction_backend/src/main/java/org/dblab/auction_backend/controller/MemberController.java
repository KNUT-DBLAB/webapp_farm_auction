package org.dblab.auction_backend.controller;

import java.util.HashMap;
import java.util.List;

import org.dblab.auction_backend.domain.ConsumerMemberDTO;
import org.dblab.auction_backend.domain.FarmMemberDTO;
import org.dblab.auction_backend.domain.LoginObj;
import org.dblab.auction_backend.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private Logger log = LoggerFactory.getLogger(MemberController.class);


	// #################################################### 소비자 CRUD ####################################################

	@PostMapping(value = "/signupConsumer", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public HashMap<String, Object> signupConsumer(@RequestBody ConsumerMemberDTO consumerMemberDTO) {
		System.out.println(consumerMemberDTO.toString());
		return memberService.signupConsumer(consumerMemberDTO);
	}

	@GetMapping(value = "/getConsumer", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ConsumerMemberDTO getConsumer(@RequestParam(value = "email") String email) {
		System.out.println(email);
		return memberService.getConsumerMember(email);
	}

	@PatchMapping(value = "/updateConsumerMember", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public int updateConsumerMember(@RequestBody ConsumerMemberDTO consumerMemberDTO) {
		return memberService.updateConsumerMember(consumerMemberDTO);
	}

	@DeleteMapping(value = "/deleteConsumerMember/{consumer_id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public int deleteConsumerMember(@PathVariable("consumer_id") int consumer_id) {
		System.out.println("deleteConsumerMember: " + consumer_id);
		return memberService.deleteConsumerMember(consumer_id);
	}


	// #################################################### 농가 CRUD ####################################################

	@PostMapping(value = "/signupFarmMember", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public HashMap<String, Object> signupFarmMember(@RequestBody FarmMemberDTO farmMemberDTO) {
		System.out.println(farmMemberDTO.toString());
		return memberService.signupFarmMember(farmMemberDTO);
	}

	@PatchMapping(value = "/updateFarmMember", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public int updateFarmMember(@RequestBody FarmMemberDTO farmMemberDTO) {
		return memberService.updateFarmMember(farmMemberDTO);
	}

	@DeleteMapping(value = "/deleteFarmMember/{farm_id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public int deleteFarmMember(@PathVariable("farm_id") int farm_id) {
		System.out.println("deleteFarmMember: " + farm_id);
		return memberService.deleteFarmMember(farm_id);
	}


	// #################################################### 로그인, 로그아웃, 이메일 중복 확인 ####################################################

	@PostMapping(value = "/login", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public UserDetails login(@RequestBody LoginObj loginObj) {
		System.out.println(loginObj);
		return memberService.login(loginObj.getCheckUser(), loginObj.getEmail(), loginObj.getPassword());
	}

	@GetMapping(value = "/logout/{checkUser}/{email}")
	public int login(@PathVariable("checkUser") String checkUser, @PathVariable("email") String email) {
		System.out.println(checkUser + "  /  " + email);

		return memberService.logout(checkUser, email);
	}

	@GetMapping(value = "/existEmail", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public int existEmail(@RequestParam(value = "email") String email) {
		System.out.println(email);

		return memberService.existEmail(email);
	}


	// #################################################### 테스트용 ####################################################
	
	@GetMapping(value = "/getAllConsumerMember", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public List<ConsumerMemberDTO> getAllConsumerMember() {
		return memberService.getAllConsumerMember();
	}

}