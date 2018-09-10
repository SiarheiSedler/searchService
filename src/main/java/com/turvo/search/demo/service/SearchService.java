package com.turvo.search.demo.service;

import com.turvo.search.demo.model.SearchParamms;

import java.util.Map;

/**
 * Interface provide searching method by paramms
 */
public interface SearchService {

    Map<String, Double> findAllCitiesByParamms(SearchParamms paramms);

}
