package com.sinmn.mjar.ext.repository;

import org.springframework.stereotype.Repository;

import com.sinmn.core.model.annotation.ModelAutowired;
import com.sinmn.core.model.core.AbstractModelRepository;
import com.sinmn.core.model.core.Model;
import com.sinmn.mjar.ext.model.ExtColumnType;

@Repository
public class ExtColumnTypeRepository extends AbstractModelRepository<ExtColumnType>{

	@ModelAutowired
	private Model<ExtColumnType> extColumnTypeModel;
	
	@Override
	protected Model<ExtColumnType> getModel() {
		return extColumnTypeModel;
	}
}
