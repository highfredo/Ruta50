package es.axh.snap.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import es.axh.snap.domain.Bundle;
import es.axh.snap.domain.Route;
import es.axh.snap.repository.BundleRepository;

@Service
public class BundleService {

	@Inject
	private BundleRepository bundleRepository;
	
	public List<Bundle> findAll(){
		return bundleRepository.findAll();
	}
	
//	public List<Bundle> findByQuery(String query){
//		return bundleRepository.search(query);
//	}
	
	public Bundle create(){
		Bundle bundle = new Bundle();
		
		bundle.setRoutes(new ArrayList<Route>());
//		bundle.setTags(new ArrayList<String>());
		
		return bundle;
	}
	
	public Bundle edit(String id){
		return bundleRepository.findOne(id);
	}
	
	public Bundle save(Bundle bundle){
		return bundleRepository.save(bundle);
	}

	public Bundle view(String id) {
		return bundleRepository.findOne(id);
	}
	
	/**
	 * @author Ale
	 * No estoy muy contento con este método, peeeeeero..
	 */
	public List<Route> routesByBundleNumber(String bundleId, Integer bundleNumber){
		List<Double> prices = new ArrayList<Double>();
		Bundle bundle = bundleRepository.findOne(bundleId);
		
		for(Route route : bundle.getRoutes()){
			prices.add(route.getPrice());
		}
		
		prices = new ArrayList<Double>(new HashSet<Double>(prices));
		Collections.sort(prices);
		
		Double price = prices.get(bundleNumber);
		
		List<Route> routes = new ArrayList<Route>();
		
		for(Route route : bundle.getRoutes()){
			if(price.compareTo(route.getPrice()) > 0){
				routes.add(route);
			}
		}
		
		return routes;
		
	}
	
}
