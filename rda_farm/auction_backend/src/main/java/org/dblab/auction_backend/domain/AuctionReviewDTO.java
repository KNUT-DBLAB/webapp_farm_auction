package org.dblab.auction_backend.domain;

import lombok.Data;

@Data
public class AuctionReviewDTO {

    private int auction_Id;
    private int consumer_id;
    private int farm_id;
    private int grade_point;
    private String review;
}
