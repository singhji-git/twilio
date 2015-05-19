package com.speaktoit.twilio.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.speaktoit.twilio.TwilioSmsServlet;

public class SmsServletTest {
	private TwilioSmsServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void setUp() {
		servlet = new TwilioSmsServlet();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}

	@Ignore
	@Test
	public void sendSms() throws ServletException, IOException {
		request.addParameter("From", "+79131112233");
		request.addParameter("Body", "test1");

		servlet.service(request, response);

		assertEquals("application/xml", response.getContentType());
		assertEquals("<Response><Message>response1</Message></Response>", response.getContentAsString());
	}
}
