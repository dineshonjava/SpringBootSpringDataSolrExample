/**
 * 
 */
package com.doj.app.pojo;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * @author Dinesh.Rajput
 *
 */
@SolrDocument(solrCoreName="content")
public class Content {
	
	@Field
	Long id;
	@Field
	String heading;
	@Field
	String description;
	@Field
	String priority;
	@Field
	String city;
	@Field
	String locality;
	@Field
	String contenturl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getContenturl() {
		return contenturl;
	}
	public void setContenturl(String contenturl) {
		this.contenturl = contenturl;
	}
	@Override
	public String toString() {
		return "Content [id=" + id + ", heading=" + heading + ", description=" + description + ", priority=" + priority
				+ ", city=" + city + ", locality=" + locality + ", contenturl=" + contenturl + "]";
	}
	
}
