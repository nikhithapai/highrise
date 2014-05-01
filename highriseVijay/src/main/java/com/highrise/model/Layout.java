package com.highrise.model;



/**
*
* @author Nikhitha, April 19, 2014
*/

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import static javax.persistence.GenerationType.IDENTITY;

 
@Entity
@Table(name="layout",uniqueConstraints={@UniqueConstraint(columnNames="layout_description")})
public class Layout implements Serializable{
	   
	  private Integer  layout_id; 
	  private String layout_description;
	  
	  /** Creates a new instance of Layout */
		/*public Layout()
	    {  }*/

		
		@Id
		@GeneratedValue(strategy = IDENTITY)
		@Column(name = "layout_id", unique = true, nullable = false)	
	public Integer getLayout_id() {
		return layout_id;
	}

	public void setLayout_id(Integer layout_id) {
		this.layout_id = layout_id;
	}

	
	@Column(name = "layout_description", unique = false, nullable = false, length = 75)
	public String getLayout_description() {
		return layout_description;
	}

	public void setLayout_description(String layout_description) {
		this.layout_description = layout_description;
	}
		
	/*@Override
	  public String toString() {
	    return "Layout [id=" + layout_id + ", layout_description =" + layout_description  + "]";
	  }
		*/

}
