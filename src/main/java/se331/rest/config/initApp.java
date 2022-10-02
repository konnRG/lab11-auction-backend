package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.rest.entity.AuctionItem;
import se331.rest.entity.Bid;
import se331.rest.repository.AuctionRepository;
import se331.rest.repository.BidRepository;

@Component
public class initApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    AuctionRepository auctionRepository;
    @Autowired
    BidRepository bidRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        Bid bid1, bid2, bid3, bid4, bid5, bid6, bid7, bid8, bid9, bid10, bid11,bid12,bid13,bid14,bid15, succ1, succ2, succ3;
        bid1 = bidRepository.save(Bid.builder().amount(45000).date("29/09/22").time("12:30").build());
        bid2 = bidRepository.save(Bid.builder().amount(38000).date("27/09/22").time("00:30").build());
        bid3 = bidRepository.save(Bid.builder().amount(2500).date("28/09/22").time("14:30").build());
        bid4 = bidRepository.save(Bid.builder().amount(8700).date("29/09/22").time("10:45").build());
        bid5 = bidRepository.save(Bid.builder().amount(4000).date("28/09/22").time("16:01").build());
        bid6 = bidRepository.save(Bid.builder().amount(2560).date("28/09/22").time("14:05").build());
        bid7 = bidRepository.save(Bid.builder().amount(15000).date("28/09/22").time("14:45").build());
        bid8 = bidRepository.save(Bid.builder().amount(35000).date("28/09/22").time("15:13").build());
        bid9 = bidRepository.save(Bid.builder().amount(80000).date("27/09/22").time("17:00").build());
        bid10 = bidRepository.save(Bid.builder().amount(96000).date("27/09/22").time("19:31").build());
        bid11 = bidRepository.save(Bid.builder().amount(102000).date("27/09/22").time("20:12").build());
        bid12 = bidRepository.save(Bid.builder().amount(8700).date("29/09/22").time("10:45").build());
        bid13 = bidRepository.save(Bid.builder().amount(38000).date("27/09/22").time("00:30").build());
        bid14 = bidRepository.save(Bid.builder().amount(35000).date("28/09/22").time("15:13").build());
        bid15 = bidRepository.save(Bid.builder().amount(102000).date("27/09/22").time("20:12").build());


        succ1 = bidRepository.save(Bid.builder().amount(45000).build());
        succ2 = bidRepository.save(Bid.builder().amount(8000).build());
        succ3 = bidRepository.save(Bid.builder().amount(100000).build());

        AuctionItem tempAuction = null;
        tempAuction = auctionRepository.save(AuctionItem.builder().description("5k Gold Ring").type("Jewelry").successfulBid(succ1).build());
        tempAuction.getBidList().add(bid4);
        tempAuction.getBidList().add(bid2);
        tempAuction.getBidList().add(bid1);
        bid4.setAuctionItem(tempAuction);
        bid2.setAuctionItem(tempAuction);
        bid1.setAuctionItem(tempAuction);

        tempAuction = auctionRepository.save(AuctionItem.builder().description("14k Diamond Necklace").type("Jewelry").build());
        tempAuction.getBidList().add(bid7);
        tempAuction.getBidList().add(bid8);
        tempAuction.getBidList().add(bid12);
        bid7.setAuctionItem(tempAuction);
        bid8.setAuctionItem(tempAuction);
        bid12.setAuctionItem(tempAuction);

        tempAuction = auctionRepository.save(AuctionItem.builder().description("Blue-Eyed White Dragon Card").type("Collectables").successfulBid(succ2).build());
        tempAuction.getBidList().add(bid3);
        tempAuction.getBidList().add(bid5);
        tempAuction.getBidList().add(bid13);
        bid3.setAuctionItem(tempAuction);
        bid5.setAuctionItem(tempAuction);
        bid13.setAuctionItem(tempAuction);

        tempAuction = auctionRepository.save(AuctionItem.builder().description("150-year-old Emerald Dagger").type("Ancient Relic").successfulBid(succ3).build());
        tempAuction.getBidList().add(bid9);
        tempAuction.getBidList().add(bid10);
        tempAuction.getBidList().add(bid11);
        bid9.setAuctionItem(tempAuction);
        bid10.setAuctionItem(tempAuction);
        bid11.setAuctionItem(tempAuction);

        tempAuction = auctionRepository.save(AuctionItem.builder().description("Marco Polio's Diary").type("Ancient Relic").build());
        tempAuction.getBidList().add(bid6);
        tempAuction.getBidList().add(bid14);
        tempAuction.getBidList().add(bid15);
        bid6.setAuctionItem(tempAuction);
        bid14.setAuctionItem(tempAuction);
        bid15.setAuctionItem(tempAuction);
    }
}
