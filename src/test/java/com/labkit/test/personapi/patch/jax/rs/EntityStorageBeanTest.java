package com.labkit.test.personapi.patch.jax.rs;

import org.junit.Test;

import com.vidhya.java.http.patch.jax.rs.EntityStorageBean;
import com.vidhya.java.http.patch.jax.rs.entity.Person;
import com.vidhya.java.http.patch.jax.rs.entity.PersonUtil;

import junit.framework.Assert;

public class EntityStorageBeanTest {
	
	static EntityStorageBean bean = new EntityStorageBean();
	
	@Test
	public void setPersonTest(){
		
		bean.setPerson(PersonUtil.getDefaultPerson());
	}
	
	@Test
	public void getPersonTest(){
		bean.getPerson();
		
	}

}
