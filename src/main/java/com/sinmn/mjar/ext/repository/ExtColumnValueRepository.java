package com.sinmn.mjar.ext.repository;

import org.springframework.stereotype.Repository;

import com.sinmn.core.model.annotation.ModelAutowired;
import com.sinmn.core.model.core.AbstractModelRepository;
import com.sinmn.core.model.core.Model;
import com.sinmn.mjar.ext.model.ExtColumnValue;

@Repository
public class ExtColumnValueRepository extends AbstractModelRepository<ExtColumnValue>{

	@ModelAutowired
	private Model<ExtColumnValue> extColumnValueModel;
	
	@Override
	protected Model<ExtColumnValue> getModel() {
		return extColumnValueModel;
	}
}
