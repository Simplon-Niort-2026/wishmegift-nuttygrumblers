package co.simplon.wishmegift.repository;

import co.simplon.wishmegift.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findAllWishlistByCreatorId(Long id);

}