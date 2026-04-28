package co.simplon.wishmegift.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.wishmegift.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    
}