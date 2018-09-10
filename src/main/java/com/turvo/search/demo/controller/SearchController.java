package com.turvo.search.demo.controller;

import com.turvo.search.demo.model.SearchParamms;
import com.turvo.search.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    @RequestMapping(value = "/city", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity findListSities(@RequestBody SearchParamms searchParamms){

        return new ResponseEntity<>(searchService.findAllCitiesByParamms(searchParamms), HttpStatus.OK);

    }

    @Autowired
    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }
}
