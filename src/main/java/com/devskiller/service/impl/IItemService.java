package com.devskiller.service.impl;

import java.util.List;

public interface IItemService {

    List<String> getTitlesWithAverageRatingLowerThan(Double rating) ;
}
