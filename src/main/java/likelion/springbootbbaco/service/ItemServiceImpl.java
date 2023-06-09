package likelion.springbootbbaco.service;

import likelion.springbootbbaco.domain.Item;
import likelion.springbootbbaco.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Item findById(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        } else {
            throw new IllegalStateException("예외발생");
        }
    }

    @Override
    @Transactional
    public void update(Long id, Item item) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item findItem = optionalItem.get();
            findItem.setBrand(item.getBrand());
            findItem.setName(item.getName());
            findItem.setPrice(item.getPrice());
            findItem.setStock(item.getStock()); // stockquantity 말고 stock으로
        }
    }
}
