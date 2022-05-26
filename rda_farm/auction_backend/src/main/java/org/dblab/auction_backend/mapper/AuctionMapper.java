package org.dblab.auction_backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dblab.auction_backend.domain.AlertDTO;
import org.dblab.auction_backend.domain.AuctionDTO;
import org.dblab.auction_backend.domain.AuctionReviewDTO;
import org.dblab.auction_backend.domain.ProductDTO;

public interface AuctionMapper {

    // #################################################### 경매 CURD #####################################################

    public int registAuction(AuctionDTO auction);
    
    public List<AuctionDTO> getAuction(@Param("startLimit") int startLimit);

    public int updateAuction(AuctionDTO auction);

    public int deleteAuction(@Param("auction_id") int auction_id);

    public int updateBidding(@Param("auction_id") int auction_id, @Param("bid_price") int bid_price);

    public List<AuctionDTO> searchAuction(@Param("keyword") String keyword);

    public int increseSearchVolume(@Param("keyword") String keyword);


    // #################################################### 상품 CURD #####################################################

    public int registProduct(ProductDTO product);
    
    public List<ProductDTO> getProduct();

    public int updateProduct(ProductDTO productDTO);

    public int deleteProduct(@Param("product_id") int product_id);


    // #################################################### 리뷰 CRUD #####################################################

    public int registAuctionReview(AuctionReviewDTO auctionReview);

    public List<AuctionReviewDTO> getConsumerAuctionReview(@Param("consumer_id") int consumer_id);

    public List<AuctionReviewDTO> getFarmAuctionReview(@Param("farm_id") int farm_id);

    public int updateAuctionReview(AuctionReviewDTO auctionReview);

    public int deleteAuctionReview(@Param("auction_Id") int auction_Id);

    
    // #################################################### 알림 CRUD #####################################################

    public AlertDTO registAlert(AlertDTO alertDTO);

    public List<AlertDTO> getConsumerAlert(@Param("consumer_id") int consumer_id);

    public int updateCheckedAlert(@Param("alert_id") int alert_id);

    public int deleteAlert(@Param("alert_id") int alert_id);
}