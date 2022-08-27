package com.publicis.creditcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

import com.publicis.creditcard.entity.CreditCard;
import com.publicis.creditcard.repository.CreditCardRepository;
import com.publicis.creditcard.service.CreditCardService;

@ActiveProfiles("test")
@TestConfiguration
public class CreditCardControllerTest extends CreditCardApplicationTests {

	@Mock
	CreditCardService creditCardService;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void testAddCard() throws Exception {

		String record = "{\"statusMsg\":\"SUCCESS\",\"statusCode\":\"412\",\"data\":[{\"creditCardID\":1,\"name\":\"Anvitha123\",\"cardNumber\":\"6304219447607087665\",\"balance\":\"100000\",\"limit\":\"4546544\"}]}";;

		String mockAdd = "{\r\n" + "    \"name\":\"Anvitha123\",\r\n"
				+ "    \"cardNumber\":\"6304219447607087665\",\r\n" + "    \"balance\": \"100000\",\r\n"
				+ "    \"limit\":\"4546544\"\r\n" + "}";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/addCard")
				.contentType(MediaType.APPLICATION_JSON).content(mockAdd).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String resultCZ = result.getResponse().getContentAsString();
		assertNotNull(resultCZ);
		assertEquals(record, resultCZ);
	}

	@Test
	public void getAllCards() throws Exception {
		String mockCCJson = "{\"statusMsg\":\"SUCCESS\",\"statusCode\":\"412\",\"data\":[{\"creditCardID\":1,\"name\":\"Anvitha123\",\"cardNumber\":\"6304219447607087665\",\"balance\":\"100000\",\"limit\":\"4546544\"}]}";

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getAllCards")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();

		String resultCZ = result.getResponse().getContentAsString();
		assertNotNull(resultCZ);
		assertEquals(mockCCJson, resultCZ);

	}

	@Test
	public void testAddCard_invalidCard() throws Exception {

		String record = "{\"errorCode\":\"411\",\"errorMsg\":\"This is not a valid card\"}";

		String mockAdd = "{\r\n" + "    \"name\":\"Anvitha123\",\r\n" + "    \"cardNumber\":\"1234\",\r\n"
				+ "    \"balance\": \"100000\",\r\n" + "    \"limit\":\"4546544\"\r\n" + "}";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/addCard")
				.contentType(MediaType.APPLICATION_JSON).content(mockAdd).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String resultCZ = result.getResponse().getContentAsString();
		assertNotNull(resultCZ);
		assertEquals(record.toString(), resultCZ);
	}

	@Test
	public void testAddCard_greaterThan19() throws Exception {

		String record = "{\"errorCode\":\"411\",\"errorMsg\":\"This is not a valid card\"}";

		String mockAdd = "{\r\n" + "    \"name\":\"Anvitha123\",\r\n"
				+ "    \"cardNumber\":\"63042194476070876655\",\r\n" + "    \"balance\": \"100000\",\r\n"
				+ "    \"limit\":\"4546544\"\r\n" + "}";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/addCard")
				.contentType(MediaType.APPLICATION_JSON).content(mockAdd).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String resultCZ = result.getResponse().getContentAsString();
		assertNotNull(resultCZ);
		assertEquals(record.toString(), resultCZ);
	}

}
