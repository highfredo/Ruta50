package es.axh.snap.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@Autowired
	private BundleService bundleService;

	@RequestMapping(value = "/bundles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bundle> findAll() {
		return bundleService.findAll();
	}

	@RequestMapping(value = "/bundles/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed(AuthoritiesConstants.USER)
	public List<Bundle> search(@RequestParam(value = "query") String query) {
		return bundleService.findByQuery(query);
	}

	@RequestMapping(value = "/bundle/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed(AuthoritiesConstants.USER)
	public Bundle view(@RequestParam(value = "id") String id) {
		return bundleService.view(id);
	}

	@RequestMapping(value = "/bundle/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed(AuthoritiesConstants.GUIDE)
	public Bundle create() {
		return bundleService.create();
	}
	
	@RequestMapping(value = "/bundle/edit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed(AuthoritiesConstants.USER)
	public Bundle edit(@RequestParam(value = "id") String id) {
		return bundleService.edit(id);
	}
	
	@RequestMapping(value = "/bundle/edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed(AuthoritiesConstants.USER)
	public Bundle save(@RequestParam(value = "bundle") Bundle bundle) {
		return bundleService.save(bundle);
	}

}
