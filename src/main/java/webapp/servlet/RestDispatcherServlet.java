/*
 * Copyright 2018 University of Padua, Italy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package webapp.servlet;

import webapp.rest.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Dispatches the request to the proper REST resource.
 *
 * @author Nicola Ferro (ferro@dei.unipd.it)
 * @version 1.00
 * @since 1.00
 */
public final class RestDispatcherServlet extends AbstractDatabaseServlet {

	/**
	 * The JSON UTF-8 MIME media type
	 */
	private static final String JSON_UTF_8_MEDIA_TYPE = "application/json; charset=utf-8";

	@Override
	protected void service(final HttpServletRequest req, final HttpServletResponse res) throws IOException {


		final OutputStream out = res.getOutputStream();

		try {

			// if the requested resource was an Person, delegate its processing and return
			if (processPerson(req, res)) {
                            res.setStatus(HttpServletResponse.SC_OK);
				return;
			}

			// if none of the above process methods succeeds, it means an unknown resource has been requested
			LOGGER.warn("Unknown resource requested: %s.", req.getRequestURI());

			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			res.setContentType(JSON_UTF_8_MEDIA_TYPE);
		} catch (Throwable t) {
			LOGGER.error("Unexpected error while processing the REST resource.", t);

			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} finally {

			// ensure to always flush and close the output stream
			if (out != null) {
				out.flush();
				out.close();
			}

		}
	}


	private boolean processPerson(final HttpServletRequest req, final HttpServletResponse res) throws Exception {

		final String method = req.getMethod();

		String path = req.getRequestURI();

		switch (method) {
				case "POST":
					new CreatePersonRR(req, res, getConnection()).serve();
					break;
				default:
					LOGGER.warn("Unsupported operation for URI /person: %s.", method);

					res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
					break;
			}

		return true;

	}
}
