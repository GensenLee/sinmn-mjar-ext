package com.sinmn.mjar.ext.repository;

import org.springframework.stereotype.Repository;

import com.sinmn.core.model.annotation.ModelAutowired;
import com.sinmn.core.model.core.AbstractModelRepository;
import com.sinmn.core.model.core.Model;
import com.sinmn.mjar.ext.model.ExtColumnConfig;

@Repository
public class ExtColumnConfigRepository extends AbstractModelRepository<ExtColumnConfig>{

	@ModelAutowired
	private Model<ExtColumnConfig> extColumnConfigModel;
	
	@Override
	protected Model<ExtColumnConfig> getModel() {
		return extColumnConfigModel;
	}
}
