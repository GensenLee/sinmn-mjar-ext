package com.sinmn.mjar.ext.core;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import com.sinmn.core.utils.util.BeanUtil;
import com.sinmn.core.utils.util.FastJsonUtils;
import com.sinmn.mjar.ext.annotation.KeyValueExt;
import com.sinmn.mjar.ext.annotation.KeyValueExtValue;
import com.sinmn.mjar.ext.model.ExtKeyValue;
import com.sinmn.mjar.ext.repository.ExtKeyValueRepository;

@Component
public class KeyValueExtCore {

	@Autowired
	private ExtKeyValueRepository extKeyValueRepository;
	
	public <T> T get(Class<T> clazz){
		
		String type = "";
		
		KeyValueExt keyValueExt = AnnotationUtils.findAnnotation(clazz, KeyValueExt.class);
		if(keyValueExt != null){
			type = keyValueExt.type();
		}
		return get(type,clazz);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String type,Class<T> clazz){
		
		try {
			
			List<ExtKeyValue> liExtKeyValue = extKeyValueRepository
				.where(ExtKeyValue.TYPE,type)
				.list();
			
			if(CollectionUtils.isEmpty(liExtKeyValue)){
				return null;
			}
			
			Map<String,Object> tmpMap = new HashMap<String,Object>();
			
			for(ExtKeyValue extKeyValue : liExtKeyValue){
				tmpMap.put(extKeyValue.getKey(), extKeyValue.getValue());
			}
			
			if(clazz.equals(Map.class)){
				return (T)tmpMap;
			}
			
			List<Field> liField = BeanUtil.getAllField(clazz);
			
			for(Field field : liField){
				
				String key = field.getName();
				
				KeyValueExtValue keyValueExtValue = AnnotationUtils.findAnnotation(field, KeyValueExtValue.class);
				if(keyValueExtValue != null){
					key = keyValueExtValue.key();
				}
				Object v = tmpMap.get(key);
				if(v == null){
					continue;
				}
				tmpMap.remove(key);
				tmpMap.put(field.getName(), v);
			}
	
			T result =  FastJsonUtils.getBean(FastJsonUtils.toJsonString(tmpMap), clazz);
			tmpMap.clear();
			return result;
			
		}catch (Exception e) {
			return null;
		}
	}
}
