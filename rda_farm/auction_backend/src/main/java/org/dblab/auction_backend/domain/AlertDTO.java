package org.dblab.auction_backend.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class AlertDTO {

    private int alert_id;
    private int d_status;
    private Date time;
    private int auction_Id;
    private int consumer_Id;
    private int checked;
}
