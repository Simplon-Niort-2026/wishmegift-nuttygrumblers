package co.simplon.wishmegift.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.simplon.wishmegift.entity.Gifts;
import co.simplon.wishmegift.entity.Wishlist;
import co.simplon.wishmegift.repository.WishlistRepository;

@Service
public class WishlistService {

    private final WishlistRepository wlRepo;
    WishlistService(WishlistRepository repo) {
        this.wlRepo = repo;
    }

    public boolean edit(Wishlist editContent, Long wishlistId) {
        try {
            wlRepo.save(editContent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean create(Wishlist saveContent) {
        try {
            wlRepo.save(saveContent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Wishlist> retrieveAll() {
        return wlRepo.findAll();
    }

    public Optional<Wishlist> searchById(Long id) {
        return wlRepo.findById(id);
    }

    public Optional<List<Gifts>> retrieveAllWishlistGifts(Long wishlistId) {
        return wlRepo.findById(wishlistId).map(w -> w.getGifts());
    }
    
}
