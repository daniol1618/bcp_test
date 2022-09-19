package com.devskiller.service.impl;

import com.devskiller.dao.ItemRepository;
import com.devskiller.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements IItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @Override
    public List<String> getTitlesWithAverageRatingLowerThan(Double rating) {

        List<Item> items = itemRepository.findItemsWithAverageRatingLowerThan(rating);

        List<String> titles = new ArrayList<>();
        items.forEach(
                item -> {
                    //System.out.println(item.getTitle());
                    titles.add(item.getTitle());
                }
        );
        return titles;
    }
}
