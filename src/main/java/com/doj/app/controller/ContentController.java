/**
 * 
 */
package com.doj.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightEntry.Highlight;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doj.app.pojo.Content;
import com.doj.app.repository.SolrContentRepository;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
public class ContentController {
	
	@Autowired
	SolrContentRepository solrContentRepository;
	
	@GetMapping("/content")
	public String content(@RequestParam String city){
		String description = "";
		
		HighlightPage<Content> highlightedContents = solrContentRepository.findByCityIn(city, Pageable.unpaged());
		highlightedContents.getContent();
		for (HighlightEntry<Content> content : highlightedContents.getHighlighted()) {
		    for (Highlight highlight : content.getHighlights()) {
				for (String snipplet : highlight.getSnipplets()) {
					description += snipplet;
		    }
		  }
		}
		return description;
	}
}
