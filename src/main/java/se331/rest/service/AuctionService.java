package se331.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.AuctionItem;

import java.util.Optional;

public interface AuctionService {
    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);
    Optional<AuctionItem> getAuctionItem(Long id);
    Page<AuctionItem> getAuctionItems(String description, Integer value, Pageable pageable);
    public Page<AuctionItem> getAuctionItemByValue(Integer value, Pageable page);

}
