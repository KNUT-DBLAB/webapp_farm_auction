package org.dblab.auction_backend.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class AuctionDTO {

    private int auction_Id;
    private Date start_date;
    private Date deadline_date;
    private int a_starting_price;
    private int a_max_price;
    private int bid_price;
    private int bid_num;
    private int bid_status;
    private Date bid_time;
    private int product_id;
    private int farm_id;

    private String f_farm_name;
    private String f_name;
    private int f_num;
    private String f_location;
    private int f_phonenum;

    private ProductDTO productDTO;

}
