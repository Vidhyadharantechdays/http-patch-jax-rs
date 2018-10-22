package com.labkit.test.personapi.patch.jax.rs;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import com.vidhya.java.http.patch.jax.rs.AcceptPatchHeaderFilter;

@RunWith(MockitoJUnitRunner.class) 
public class AcceptPatchHeaderFilterTest {
	
	
	AcceptPatchHeaderFilter headerFilter;
	
	@Mock
	ContainerRequestContext reqContext;
	
	@Mock
	ContainerResponseContext resContext;
	
	private static final String OPTIONS_METHOD = "OPTIONS"; 
	
	private final MultivaluedHashMap<String, String> fakeReqHeaderMap = new MultivaluedHashMap<>(); 
    private final MultivaluedMap<String, Object> fakeRespHeaderMap = new MultivaluedHashMap<>(); 
 
	
	@Before 
    public void setUp() { 
        when(reqContext.getHeaders()).thenReturn(fakeReqHeaderMap); 
        when(resContext.getHeaders()).thenReturn(fakeRespHeaderMap); 
        headerFilter = new AcceptPatchHeaderFilter();
    } 
	
	@Test
	public void testFilter() throws Exception{
		when(reqContext.getMethod()).thenReturn(OPTIONS_METHOD);
		headerFilter.filter(reqContext, resContext);
	}

}
