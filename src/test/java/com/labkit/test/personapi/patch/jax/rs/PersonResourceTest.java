package com.labkit.test.personapi.patch.jax.rs;


import org.junit.Test;

import javax.ws.rs.core.MediaType;

import com.vidhya.java.http.patch.jax.rs.EntityStorageBean;
import com.vidhya.java.http.patch.jax.rs.PersonResource;
import com.vidhya.java.http.patch.jax.rs.entity.Person;
import com.vidhya.java.http.patch.jax.rs.entity.PersonUtil;

import gherkin.deps.com.google.gson.Gson;


public class PersonResourceTest {
	
	PersonResource personResoucrce = new PersonResource();
	EntityStorageBean ejbTest = new EntityStorageBean();
	
	
	@Test
	public void getGreetingTest(){
		ejbTest.setPerson(PersonUtil.getDefaultPerson());
		ejbTest.getPerson();
		//personResoucrce.getGreeting();
	}
	
	
	@Test
	public void setPersonTest() throws Exception{
		
	}
	
	@Test
	public void getT1T2Test(){
		personResoucrce.getT1();
		personResoucrce.getT2();
	}
	
	@Test
	public void patchPersonTest(){
	}

}
