package com.speaktoit.twilio;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.twilio.sdk.verbs.Message;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

public class TwilioSmsServlet extends BaseTwilioServlet {
	private static final long serialVersionUID = -8510776154233631616L;

	private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsServlet.class);

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String query = request.getParameter("Body");
		if (Strings.isNullOrEmpty(query)) {
			// Empty request
			return;
		}
		String openApiResponse = sendRequestToApiAi(query, request.getParameterMap());

		TwiMLResponse twiml = new TwiMLResponse();
		Message message = new Message(openApiResponse);
		try {
			twiml.append(message);
		} catch (TwiMLException e) {
			LOGGER.error(e.getMessage());
		}

		response.setContentType("application/xml");
		response.getWriter().print(twiml.toXML());
	}
}
