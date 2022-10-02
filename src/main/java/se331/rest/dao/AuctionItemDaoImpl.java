package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.rest.entity.AuctionItem;
import se331.rest.repository.AuctionRepository;

import java.util.Optional;

@Repository
public class AuctionItemDaoImpl implements AuctionItemDao {
    @Autowired
    AuctionRepository auctionRepository;

    @Override
    public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page) {
        return auctionRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Optional<AuctionItem> getAuctionItem(Long id) {
        return auctionRepository.findById(id);
    }
    @Override
    public Page<AuctionItem> getAuctionItems(String description, Integer value, Pageable page) {
        return auctionRepository.findByDescriptionContainingOrTypeContainingOrSuccessfulBid_AmountLessThan(description, description, value, page);
    }
    @Override
    public Page<AuctionItem> getAuctionItemByValue(Integer value, Pageable page) {
        return auctionRepository.findBySuccessfulBid_AmountLessThan(value, page);
    }
}
