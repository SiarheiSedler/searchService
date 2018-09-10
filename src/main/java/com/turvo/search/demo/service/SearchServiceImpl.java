package com.turvo.search.demo.service;

import com.turvo.search.demo.model.DirectedEdge;
import com.turvo.search.demo.model.EdgeWeightedDigraph;
import com.turvo.search.demo.model.SearchParamms;
import com.turvo.search.demo.repositories.CityRepository;
import com.turvo.search.demo.repositories.DirectedEdgeRepository;
import com.turvo.search.demo.utils.DijkstraSP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


@Service
public class SearchServiceImpl implements SearchService {

    private DirectedEdgeRepository directedEdgeRepository;

    private CityRepository cityRepository;

    private Map<Integer, String> cityCodeNameMap;
    private Map<String, Integer> cityNameCodeMap;

    private ArrayList<DirectedEdge> edges;

    @Override
    public Map<String, Double> findAllCitiesByParamms(SearchParamms paramms) {
        if(isNull(cityCodeNameMap) || isNull(edges)){
            updateCach();
        }
        EdgeWeightedDigraph graph = getEdgeWeightedDigraph(edges.size());
        DijkstraSP algorithm = getDijkstraSP(graph, edges, paramms);
        return getAnswer(algorithm);
    }

    private Map<String, Double> getAnswer(DijkstraSP algorithm){
        double[] distTo = algorithm.getDistTo();
        Map<String, Double> answer = new HashMap<>();
        for(int i = 0; i<distTo.length; i++){
            if(distTo[i] < Double.POSITIVE_INFINITY){
                answer.put(cityCodeNameMap.get(i), distTo[i]);
            }
        }
        return answer;
    }

    private EdgeWeightedDigraph getEdgeWeightedDigraph(Integer size){
        if(nonNull(size)){
            return new EdgeWeightedDigraph(size);
        }
        throw new IllegalArgumentException("size can`t be null");
    }

    private DijkstraSP getDijkstraSP(EdgeWeightedDigraph graph, List<DirectedEdge> list, SearchParamms paramms){
        list.forEach(graph::addEdge);
        if(isNull(cityNameCodeMap.get(paramms.getCityName()))){
            throw new IllegalArgumentException("City name not found");
        }
        return new DijkstraSP(graph, cityNameCodeMap.get(paramms.getCityName()), paramms.getDuration());
    }

    private void updateCach(){
        edges = new ArrayList<>();
        cityCodeNameMap = new HashMap<>();
        cityNameCodeMap = new HashMap<>();
        cityRepository.findAll().forEach(cityEntity -> {
            cityCodeNameMap.put(cityEntity.getCode(), cityEntity.getName());
            cityNameCodeMap.put(cityEntity.getName(), cityEntity.getCode());
        });
        directedEdgeRepository.findAll().forEach(directedEdgeEntity -> {
            edges.add(new DirectedEdge(directedEdgeEntity.getFrom(), directedEdgeEntity.getTo(),
                    directedEdgeEntity.getDuration()));
        });
    }

    @Autowired
    public void setDirectedEdgeRepository(DirectedEdgeRepository directedEdgeRepository) {
        this.directedEdgeRepository = directedEdgeRepository;
    }

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}
