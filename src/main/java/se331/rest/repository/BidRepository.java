package se331.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.rest.entity.Bid;

public interface BidRepository extends JpaRepository<Bid,Long> {
}
