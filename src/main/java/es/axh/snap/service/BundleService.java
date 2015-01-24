package es.axh.snap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.axh.snap.domain.Bundle;
import es.axh.snap.domain.Route;
import es.axh.snap.repository.BundleRepository;

public class BundleService {

	@Autowired
	private BundleRepository bundleRepository;
	
	public List<Bundle> findAll(){
		return bundleRepository.findAll();
	}
	
	public List<Bundle> findByQuery(String query){
		return bundleRepository.search(query);
	}
	
	public Bundle create(){
		Bundle bundle = new Bundle();
		
		bundle.setRoutes(new ArrayList<Route>());
		bundle.setTags(new ArrayList<String>());
		
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
	
}
