package org.dblab.auction_backend.domain;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDTO {

    private int product_id;
    private String p_name;
    private String product;
    private int product_kg;
    private int p_starting_price;
    private Date p_drop_date;
    private String size;
    private String p_status;
    private String p_explanation;
    private String product_img_name;
    private List<MultipartFile> product_img_file;
    private Date p_reg_date;
    private int farm_id;
    
}
