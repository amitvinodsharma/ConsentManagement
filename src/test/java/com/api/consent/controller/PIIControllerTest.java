package com.api.consent.controller;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.api.consent.model.PII;
import com.api.consent.service.PIIService;
import com.fasterxml.jackson.databind.ObjectMapper;


public class PIIControllerTest {
	private MockMvc mockMvc;
	@Mock
    private PIIService piiService;
    
    @InjectMocks
    private PIIController pIIController;
    
   
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(pIIController).build();
    }
    @After
	public void tearDown() throws Exception {
    	mockMvc=null;
	}

	/*
	 * @Test public void testgetPIIs() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testgetPIIById() { fail("Not yet implemented"); }
	 */

	@Test
	public void testaddPII()throws Exception{
		PII pII = new PII();
		/*
		 * pII.setpiiName("India"); pII.setPopulation(1000);
		 */
		Mockito.doReturn(pII).when(piiService).addPII(Mockito.any(PII.class));
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/piis")
			      .content(asJsonString(pII))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(MockMvcResultMatchers.status().isCreated());
			      //.andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
		//piiController.addPII(pii);
	}
	
	@Test
	public void testgetPIIById()throws Exception{
		PII pII = new PII();
		
		Mockito.doReturn(pII).when(piiService).getPII(Mockito.anyInt());
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/piis/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(MockMvcResultMatchers.status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }
	@Test
	public void testgetPIIs()throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/piis")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testupdatePII()throws Exception{
		PII pII = new PII();
		
		//Mockito.doReturn(pii).when(piiService).addPII(Mockito.any(pii.class));
		mockMvc.perform( MockMvcRequestBuilders
			      .put("/piis/1")
			      .content(asJsonString(pII))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(MockMvcResultMatchers.status().isOk());
			      //.andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
		//piiController.addPII(pii);
	}
	
	@Test
	public void testdeletePII()throws Exception{

		mockMvc.perform( MockMvcRequestBuilders
			      .delete("/piis/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(MockMvcResultMatchers.status().isOk());
    }
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	/*
	 * @Test public void testupdatePII() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testdeletePII() { fail("Not yet implemented"); }
	 */

}
