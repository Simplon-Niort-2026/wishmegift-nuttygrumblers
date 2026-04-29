package co.simplon.wishmegift.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import co.simplon.wishmegift.entity.Gifts;
import co.simplon.wishmegift.repository.GiftRepository;

@Service
public class GiftService {

    private GiftRepository giftRepository;

    public GiftService(GiftRepository giftRepositoryInjected) {
        this.giftRepository = giftRepositoryInjected;
    }

    public Gifts create(Gifts gift) {
        return this.giftRepository.save(gift);
    }

    public Optional<Gifts> finById(final Long id) {
        return this.giftRepository.findById(id);
    }

    public void deleteGiftById(final Long id) {
        this.giftRepository.deleteById(id);
    }

}
