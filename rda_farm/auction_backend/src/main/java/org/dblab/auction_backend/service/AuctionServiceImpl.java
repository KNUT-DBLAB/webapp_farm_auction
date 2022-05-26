package org.dblab.auction_backend.service;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.HashMap;

import org.dblab.auction_backend.domain.AlertDTO;
import org.dblab.auction_backend.domain.AuctionDTO;
import org.dblab.auction_backend.domain.AuctionReviewDTO;
import org.dblab.auction_backend.domain.Bidding;
import org.dblab.auction_backend.domain.ProductDTO;
import org.dblab.auction_backend.mapper.AuctionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService{

    private final AuctionMapper auctionMapper;
    private Logger log = LoggerFactory.getLogger(AuctionServiceImpl.class);
    private String PRODUCT_IMG_PATH = "/home/dblab/auction_backend/src/main/resources/static/product_images/";
    private HashMap<Integer,SseEmitter> consumerEmitters = new HashMap<Integer, SseEmitter>();
    private HashMap<Integer,SseEmitter> farmEmitters = new HashMap<Integer, SseEmitter>();

    // #################################################### 경매 CURD #####################################################

    @Override
    public int registAuction(AuctionDTO auctionDTO) {
        log.info("registAuction.........." + auctionDTO);

        // 유저 이름 + 날짜, 임시로 농가 ID 사용!
        String product_img_name = auctionDTO.getFarm_id() + "," + LocalDateTime.now().toString().substring(0, 19);
        // 이미지 개수
        int numberOfImg = auctionDTO.getProductDTO().getProduct_img_file().size();
        try {
            for (int i=0; i<numberOfImg; i++){
                auctionDTO.getProductDTO().getProduct_img_file().get(i).transferTo(new File(PRODUCT_IMG_PATH + product_img_name + "(" + i + ")" + numberOfImg +".png"));
            }
            System.out.println(product_img_name + " 파일 저장 완료");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        auctionDTO.getProductDTO().setProduct_img_name(product_img_name + "(0)" + numberOfImg);
        auctionDTO.getProductDTO().setP_reg_date(new Date(System.currentTimeMillis()));
        auctionDTO.getProductDTO().setFarm_id(auctionDTO.getFarm_id());

        auctionMapper.registProduct(auctionDTO.getProductDTO());
        log.info("product_id: " + auctionDTO.getProductDTO().getProduct_id());
        log.info(auctionDTO.toString());
        
        return auctionMapper.registAuction(auctionDTO);
    }

    @Override
    public List<AuctionDTO> getAuction(int limit) {
        log.info("getAuction..........");
        List<AuctionDTO> auctionDTOs = auctionMapper.getAuction(limit);
        log.info(auctionDTOs.toString());

        return auctionDTOs;
    }

    @Override
    public int updateAuction(AuctionDTO auctionDTO) {
        log.info("updateAuction..........");
        return auctionMapper.updateAuction(auctionDTO);
    }

    @Override
    public int deleteAuction(int auction_id) {
        log.info("deleteAuction..........");
        return auctionMapper.deleteAuction(auction_id);
    }

    @Override
    public int updateBidding(Bidding bidding) {

        int mapperResult = auctionMapper.updateBidding(bidding.getAuction_id(), bidding.getBid_price());
    
        int alertResult = 0;

        if(mapperResult == 1){
            alertResult = registAlert(bidding);
        }

        return alertResult;
        // return mapperResult;
    }

    @Override
    public List<AuctionDTO> searchAuction(String checkUser, int id, String keyword){
        List<AuctionDTO> auctionDTOs = auctionMapper.searchAuction("%" + keyword + "%");

        // 검색된 경매가 있다면 해당 경매의 search_volume을 1씩 올려준다.
        if (!auctionDTOs.isEmpty()){
            log.info(auctionDTOs.toString());
            // auctionMapper.increseSearchVolume(keyword);
        }

        return auctionDTOs;
    }


    // #################################################### 상품 CURD #####################################################

    @Override
    public List<ProductDTO> getProduct() {
        log.info("getProduct..........");
        return auctionMapper.getProduct();
    }

    @Override
    public int updateProduct(ProductDTO productDTO) {

        // 이미지 변경 시 처리 코드 
        return auctionMapper.updateProduct(productDTO);
    }

    @Override
    public int deleteProduct(int product_id) {

        return auctionMapper.deleteProduct(product_id);
    }


    // #################################################### 리뷰 CRUD #####################################################

    @Override
    public int registAuctionReview(AuctionReviewDTO auctionReview) {

        return auctionMapper.registAuctionReview(auctionReview);
    }

    @Override
    public List<AuctionReviewDTO> getAuctionReview(String checkUser, int id) {
        log.info("getAuctionReview..........");

        if (checkUser.equals("consumer")) {

            return auctionMapper.getConsumerAuctionReview(id);
        } else {

            return auctionMapper.getFarmAuctionReview(id);
        }
    }

    @Override
    public int updateAuctionReview(AuctionReviewDTO auctionReview) {
        log.info("updateAuctionReview..........");

        return auctionMapper.updateAuctionReview(auctionReview);
    }

    @Override
    public int deleteAuctionReview(int auction_id) {
        log.info("deleteAuctionReview..........");

        return auctionMapper.deleteAuctionReview(auction_id);
    }

    
    // #################################################### 알림 #####################################################

    @Override
    public SseEmitter registEmitter(String checkUser, int id, SseEmitter emitter) {
        
        try {
            System.out.println("id: " + id);
            emitter.send(SseEmitter.event().name(""+id));

            // checkUser와 id를 이용해서 Alert 데이터 가져와서 emitter에 저장하기
            if (checkUser.equals("consumer")){
                List<AlertDTO> alertDTOs = auctionMapper.getConsumerAlert(id);

                emitter.send(SseEmitter.event().name("init").data(alertDTOs));
                emitter.onCompletion(() -> consumerEmitters.remove(id));
                consumerEmitters.put(id, emitter);
            } else {
                // List<AlertDTO> alertDTOs = auctionMapper.getFarmAlert(id);
                emitter.onCompletion(() -> farmEmitters.remove(id));
                farmEmitters.put(id, emitter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emitter;
    }
    
    @Override
    public int registAlert(Bidding bidding) {

        AlertDTO alertDto = new AlertDTO();

        SseEmitter farmEmitter = farmEmitters.get(bidding.getFarm_id());
        SseEmitter consumerEmitter = consumerEmitters.get(bidding.getConsumer_id());
        
        alertDto.setAuction_Id(bidding.getAuction_id());
        alertDto.setConsumer_Id(bidding.getConsumer_id());

        if (bidding.getAuction_consumer_id() == null) {
            alertDto.setD_status(1);
            alertDto = auctionMapper.registAlert(alertDto);
        } else {

            alertDto.setD_status(2);
            alertDto = auctionMapper.registAlert(alertDto);
            
            SseEmitter auctionConsumerEmitter = consumerEmitters.get(bidding.getAuction_consumer_id());

            if(auctionConsumerEmitter != null){
                // 이전 입찰자에게 알림!
                try {
                    System.out.println("auctionConsumerEmitter: " + alertDto.toString());
                    auctionConsumerEmitter.send(SseEmitter.event().name("alert").data(alertDto));
                } catch (IOException e) {
                    consumerEmitters.remove(bidding.getAuction_consumer_id());
                    e.printStackTrace();
                }
            }
        }

        if(consumerEmitter != null){
            // 새로운 입찰자에게 알림
            try {
                System.out.println("consumerEmitter: " + alertDto.toString());
                consumerEmitter.send(SseEmitter.event().name("alert").data(alertDto));
            } catch (IOException e) {
                consumerEmitters.remove(bidding.getConsumer_id());
                e.printStackTrace();
            }
        }
               
        if(farmEmitter != null){
            // 농가에게 알림
            try {
                farmEmitter.send(SseEmitter.event().name("alert").data(alertDto));
            } catch (IOException e) {
                farmEmitters.remove(bidding.getFarm_id());
                e.printStackTrace();
            }
        }
        
        return 1;
    }

    @Override
    public int checkedAlert(int alert_id) {
        return auctionMapper.updateCheckedAlert(alert_id);
    }



    
    

    
}
