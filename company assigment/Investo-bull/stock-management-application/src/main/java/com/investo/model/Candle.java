package com.investo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Candle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonProperty("LastTradeTime")
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime lastTradeTime;

    @JsonProperty("QuotationLot")
    private Integer quotationLot;

    @JsonProperty("TradedQty")
    private Long tradedQty;

    @JsonProperty("OpenInterest")
    private Integer openInterest;

    @JsonProperty("Open")
    private Double open;

    @JsonProperty("High")
    private Double high;

    @JsonProperty("Low")
    private Double low;

    @JsonProperty("Close")
    private Double close;

}
