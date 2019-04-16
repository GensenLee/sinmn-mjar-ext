package com.sinmn.mjar.ext.repository;

import org.springframework.stereotype.Repository;

import com.sinmn.core.model.annotation.ModelAutowired;
import com.sinmn.core.model.core.AbstractModelRepository;
import com.sinmn.core.model.core.Model;
import com.sinmn.mjar.ext.model.ExtKeyValue;

@Repository
public class ExtKeyValueRepository extends AbstractModelRepository<ExtKeyValue>{

	@ModelAutowired
	private Model<ExtKeyValue> extKeyValueModel;
	
	@Override
	protected Model<ExtKeyValue> getModel() {
		return extKeyValueModel;
	}
}
