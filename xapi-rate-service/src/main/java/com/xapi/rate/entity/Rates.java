package com.xapi.rate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Rates")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rates implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="rate_id")
	private String rateId;
	
	@Column(name="ccy_pair")
	private String ccyPair;	
	
	@Column(name="rate")
	private String rate;
}
