package co.simplon.wishmegift.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.wishmegift.entity.Gifts;
import co.simplon.wishmegift.service.GiftService;

@RestController
public class GiftController {

    private final GiftService giftService;

    public GiftController (GiftService giftServiceInjected){
        this.giftService= giftServiceInjected;
    }

    @GetMapping("/gifts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gifts getGiftById(@PathVariable Long id){
        return giftService.findById(id).orElse(null);
    }

    @PostMapping("gifts")
    @ResponseStatus(HttpStatus.CREATED)
    public Gifts createGifts(@RequestBody Gifts gift){
        return giftService.create(gift);
    }

    @PatchMapping("gifts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gifts updateGiftsPartialy(@PathVariable Long id, @RequestBody Gifts gift){
        gift.setId(id);
        return giftService.create(gift);
    }

     @PutMapping("gifts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gifts updateGifts(@PathVariable Long id, @RequestBody Gifts gift){
        gift.setId(id);
        return giftService.create(gift);
    }

    @DeleteMapping("/gifts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGift(@PathVariable Long id){
        giftService.deleteGiftById(id);
    }

}
