package es.axh.snap.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.axh.snap.domain.Bundle;
import es.axh.snap.security.AuthoritiesConstants;
import es.axh.snap.service.BundleService;

@RestController
@RequestMapping("/api")
public class BundleResource {

	@Inject
	private BundleService bundleService;

	@RequestMapping(value = "/public/bundle", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bundle> findAll() {
		return bundleService.findAll();
	}

//	@RequestMapping(value = "/bundles/search/{query}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@RolesAllowed(AuthoritiesConstants.USER)
//	public List<Bundle> search(@RequestParam(value = "query") String query) {
//		return bundleService.findByQuery(query);
//	}

	@RequestMapping(value = "public/bundle/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bundle> view(@PathVariable String id) {
		Bundle bundle = bundleService.view(id);
		
		Collections.sort(bundle.getRoutes());
		
		List<Bundle> bundles = new ArrayList<Bundle>();
		bundles.add(bundle);
		
		return bundles;
	}

	@RequestMapping(value = "/bundle/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed(AuthoritiesConstants.GUIDE)
	public List<Bundle> create() {
		Bundle bundle = bundleService.create();
		
		List<Bundle> bundles = new ArrayList<Bundle>();
		bundles.add(bundle);
		
		return bundles;
	}
	
	@RequestMapping(value = "/bundle/edit/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed(AuthoritiesConstants.GUIDE)
	public List<Bundle> edit(@PathVariable String id) {
		Bundle bundle = bundleService.edit(id);
		
		List<Bundle> bundles = new ArrayList<Bundle>();
		bundles.add(bundle);
		
		return bundles;
	}
	
	@RequestMapping(value = "/bundle/edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed(AuthoritiesConstants.GUIDE)
	public List<Bundle> save(@RequestParam(value = "bundle") Bundle bundle) {
		bundle = bundleService.save(bundle);
		
		List<Bundle> bundles = new ArrayList<Bundle>();
		bundles.add(bundle);
		
		return bundles;
	}

}
