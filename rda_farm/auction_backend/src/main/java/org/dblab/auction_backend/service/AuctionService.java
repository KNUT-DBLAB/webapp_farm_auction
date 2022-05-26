package org.dblab.auction_backend.service;

import java.util.List;

import org.dblab.auction_backend.domain.AuctionDTO;
import org.dblab.auction_backend.domain.AuctionReviewDTO;
import org.dblab.auction_backend.domain.Bidding;
import org.dblab.auction_backend.domain.ProductDTO;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface AuctionService {

    // #################################################### 경매 CURD #####################################################
    
    public int registAuction(AuctionDTO auctionDTO);
    
    public List<AuctionDTO> getAuction(int limit);

    public int updateAuction(AuctionDTO auctionDTO);

    public int deleteAuction(int auction_id);

    public int updateBidding(Bidding bidding);

    public List<AuctionDTO> searchAuction(String checkUser, int id, String keyword);


    // #################################################### 상품 URD #####################################################

    public List<ProductDTO> getProduct();

    public int updateProduct(ProductDTO productDTO);

    public int deleteProduct(int product_id);

    // #################################################### 리뷰 CRUD #####################################################

    public int registAuctionReview(AuctionReviewDTO auctionReview);

    public List<AuctionReviewDTO> getAuctionReview(String checkUser, int id);

    public int updateAuctionReview(AuctionReviewDTO auctionReview);

    public int deleteAuctionReview(int auction_id);


    // #################################################### 알림 #####################################################

    public SseEmitter registEmitter(String checkUser, int id, SseEmitter emitter);

    public int registAlert(Bidding bidding);

    public int checkedAlert(int alert_id);
}
