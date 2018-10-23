package com.labkit.test.personapi.patch.jax.rs;

import static org.mockito.Mockito.when;

import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ReaderInterceptorContext;

import org.junit.Test;
import org.mockito.Mock;

import com.vidhya.java.http.patch.jax.rs.Patching;

public class PatchingTest {
	
	Patching patch;

	
	@Mock
	ReaderInterceptorContext interceptorContext;
	
	@Mock
	UriInfo uriInfo;
	
	
	@Test
	public void patchTest() throws Exception{
		patch = new Patching();
		//when(patch.aroundReadFrom(interceptorContext)).thenReturn(patch);
	}
	
}
