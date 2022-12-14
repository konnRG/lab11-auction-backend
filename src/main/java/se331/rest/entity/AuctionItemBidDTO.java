package se331.rest.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemBidDTO {
    Long id;
    Integer amount;
    String date;
    String time;
}
