package com.devskiller.dao;

import com.devskiller.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    //Did it natively to save time, but can be enhanced
    @Query(value = "SELECT I.ID,I.DESCRIPTION,I.TITLE FROM ITEM I\n" +
            "LEFT JOIN REVIEW R\n" +
            "WHERE I.ID = R.ITEM_ID\n" +
            "AND R.RATING < :rating", nativeQuery = true)
    List<Item> findItemsWithAverageRatingLowerThan(@Param("rating") Double rating);
}
