package com.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.CatalogItem;
import com.model.DbConfiguration;
import com.model.UserRating;
import com.service.MovieInfo;
import com.service.UserRatingInfo;

@RestController
@RefreshScope
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	@Autowired
	DbConfiguration dbConfiguration;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		// get all rated movie ID
		// Suppose we got this data for user and we want to fetch movie information
		//URL is replaced by service name since its routing through discovery
		UserRating userRating = userRatingInfo.getUserRating(userId);

		return userRating.getUserRating().stream().map(rating -> movieInfo.getCatalogItem(rating)).collect(Collectors.toList());

	} 

	@RequestMapping("/mapping")
	public String getMapping() {
		
		return dbConfiguration.getConnection()+" "+dbConfiguration.getHost()+" "+dbConfiguration.getPort();
	}
	
	
	

	
	
}
