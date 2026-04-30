package co.simplon.wishmegift.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.wishmegift.entity.Gifts;
import co.simplon.wishmegift.entity.Wishlist;
import co.simplon.wishmegift.service.GiftService;
import co.simplon.wishmegift.service.WishlistService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/wishlists")
public class WishlistController {

    private final WishlistService wls;
    private final GiftService gs;
    WishlistController(WishlistService injectWishlistService, GiftService injectGiftService) {
        this.wls = injectWishlistService;
        this.gs = injectGiftService;
    }

    // GET ALL WISHLISTS
    @GetMapping
    public ResponseEntity<List<Wishlist>> getAllWishlists() {
        return new ResponseEntity<>(wls.retrieveAll(), HttpStatus.OK);
    }
    

    // GET WISHIST BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Wishlist> getWishlistById(@PathVariable Long id) {
        try {
            Optional<Wishlist> wl = wls.searchById(id);
            if (wl.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(wl.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // MODIFY WISHLIST BY ID
    @PutMapping("/{id}")
    public ResponseEntity<Wishlist> putWishlitInfos(@PathVariable Long id, @RequestBody Wishlist editedBody) {
        try {
            Optional<Wishlist> wl = wls.searchById(id);
            if (wl.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            if (wls.edit(editedBody, id)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // CREATE NEW WISHLIST
    @PostMapping("/create")
    public ResponseEntity<Wishlist> postWishlistById(@RequestBody Wishlist wlBody) {
        try {
            if (wls.create(wlBody)) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/gifts")
    public ResponseEntity<List<Gifts>> getAllGifts(@PathVariable Long id) {
        try {
            if (wls.searchById(id).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            Optional<List<Gifts>> gifts = wls.retrieveAllWishlistGifts(id);
            if (gifts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(gifts.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @GetMapping("/{wishlist_id}/gifts/{gift_id}")
    public ResponseEntity<Gifts> getGiftById(@PathVariable(name="wishlist_id") Long wishlistId, @PathVariable(name="gift_id") Long giftId) {
        try {
            Gifts found = wls.searchById(wishlistId)
                .map(w -> w.getGifts()
                    .stream()
                    .filter(g -> g.getId().equals(giftId))
                    .toList()
                    .getFirst()
                ).orElse(null);
            if (found == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(found, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    // @GetMapping("/share")
    // public ResponseEntity<Wishlist> getMethodName(@RequestParam String param) {
    //     try {
    //         return new ResponseEntity<>(HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
    //     }
    // }
    
}