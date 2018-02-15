/**
 * 
 */
package com.doj.app.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Boost;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.doj.app.pojo.Content;

/**
 * @author Dinesh.Rajput
 *
 */
public interface SolrContentRepository extends SolrCrudRepository<Content, String> {
	
	Page<Content> findByPriority(String priority, Pageable page);

	Page<Content> findByHeadingOrDescription(@Boost(2) String heading, String description, Pageable page);

	@Highlight(prefix = "<highlight>", postfix = "</highlight>")
	HighlightPage<Content> findByCityIn(String city, Pageable page);

	@Query(value = "name:?0")
	@Facet(fields = { "cat" }, limit=20)
	FacetPage<Content> findByLocalityAndFacetOnCity(String locality, Pageable page);
	
}
