package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.dao.AuctionItemDao;
import se331.rest.entity.AuctionItem;

import java.util.Optional;

@Service
public class AuctionServiceImpl implements AuctionService{
    @Autowired
    AuctionItemDao auctionItemDao;
    @Override
    public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page) {
        return auctionItemDao.getAuctionItems(pageSize, page);
    }
    @Override
    public Optional<AuctionItem> getAuctionItem(Long id) {
        return auctionItemDao.getAuctionItem(id);
    }
    @Override
    public Page<AuctionItem> getAuctionItems(String description, Integer value, Pageable page) {
        return auctionItemDao.getAuctionItems(description, value, page);
    }

    @Override
    public Page<AuctionItem> getAuctionItemByValue(Integer value, Pageable page) {
        return auctionItemDao.getAuctionItemByValue(value, page);
    }


}
