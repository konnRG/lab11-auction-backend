package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se331.rest.entity.AuctionItem;
import se331.rest.service.AuctionService;
import se331.rest.util.LabMapper;

@RestController
public class AuctionItemController {
    @Autowired
    AuctionService auctionService;

    @GetMapping("auction")
    public ResponseEntity<?> getAuctionItems(
            @RequestParam(value = "_limit", required = false)Integer perPage,
            @RequestParam(value = "_page", required = false)Integer page,
            @RequestParam(value = "description", required = false)String description,
            @RequestParam(value= "successfulBid", required = false)Integer successfulBid) {
        perPage = perPage == null ? 10 : perPage;
        page = page == null ? 1 : page;
        Page<AuctionItem> output;
        if(successfulBid != null) {
            output = auctionService.getAuctionItemByValue(successfulBid, PageRequest.of(page-1,perPage));
        }
        else if(description == null){
            output = auctionService.getAuctionItems(perPage, page);
        }
        else {
            output = auctionService.getAuctionItems(description, successfulBid, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(output.getTotalElements()));

        return new ResponseEntity<>(LabMapper.INSTANCE.getAuctionItemDTO(output.getContent()),responseHeader, HttpStatus.OK);
    }

}
