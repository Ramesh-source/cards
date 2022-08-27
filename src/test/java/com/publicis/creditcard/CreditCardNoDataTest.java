package com.publicis.creditcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.publicis.creditcard.dto.CreditCardDTO;
import com.publicis.creditcard.entity.CreditCard;
import com.publicis.creditcard.repository.CreditCardRepository;
import com.publicis.creditcard.service.CreditCardService;
import com.publicis.creditcard.utilities.ResponseDTO;

@ActiveProfiles("test")
@TestConfiguration
public class CreditCardNoDataTest extends CreditCardApplicationTests {

	
	@Mock
	CreditCardService creditCardService;
	
	@Mock
	CreditCardRepository creditCardRepository;

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void no_Cards() throws Exception {
		
		CreditCardDTO creditCardDTO = new CreditCardDTO();
		
		ResponseDTO<CreditCardDTO> creditCard = null;
		
		String mockCCJson = "{\"statusMsg\":\"SUCCESS\",\"statusCode\":\"412\",\"data\":[{\"creditCardID\":1,\"name\":\"Anvitha123\",\"cardNumber\":\"6304219447607087665\",\"balance\":\"100000\",\"limit\":\"4546544\"}]}";

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getAllCards")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		//when(creditCardService.addCreditCard(creditCardDTO)).thenReturn(creditCard);
		String resultCZ = result.getResponse().getContentAsString();
		assertFalse(resultCZ.isEmpty());
		assertEquals(mockCCJson, resultCZ);
	}
}
