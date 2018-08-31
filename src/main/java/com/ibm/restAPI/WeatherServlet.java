package com.ibm.restAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WeatherServlet
 */
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WeatherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, UnknownHostException {
		// TODO Auto-generated method stub

		try {
			String city = request.getParameter("selectedCity");
			// response.getWriter().append("selected City is: ").append(city);

			String resturl = null;
			// TODO: Always show the default url, did not check the city options below:

			if (city.equals("Paris")) {
				resturl = "http://api.wunderground.com/api/521977e10fbdb0c0/forecast/geolookup/conditions/q/France/Paris.json";
			} else if (city.equals("Las_Vegas")) {
				resturl = "http://api.wunderground.com/api/521977e10fbdb0c0/forecast/geolookup/conditions/q/NV/Las_Vegas.json";
			} else if (city.equals("San_Francisco")) {
				resturl = "http://api.wunderground.com/api/521977e10fbdb0c0/forecast/geolookup/conditions/q/CA/San_Francisco.json";
			} else if (city.equals("Miami")) {
				resturl = "http://api.wunderground.com/api/521977e10fbdb0c0/forecast/geolookup/conditions/q/FL/Miami.json";
			} else if (city.equals("Cork")) {
				resturl = "http://api.wunderground.com/api/521977e10fbdb0c0/forecast/geolookup/conditions/q/ireland/cork.json";
			} else if (city.equals("Barcelona")) {
				resturl = "http://api.wunderground.com/api/521977e10fbdb0c0/forecast/geolookup/conditions/q/Spain/Barcelona.json";
			}
			URL obj = new URL(resturl);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			if (responseCode >= 200 && responseCode < 300) {
				System.out.println("\nSending 'GET' request to URL : " + resturl);
				System.out.println("Response Code : " + responseCode);
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer responseStr = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					responseStr.append(inputLine);
				}
				in.close();

				System.out.println(responseStr.toString());
				response.setContentType("application/json");

				ServletOutputStream out = response.getOutputStream();
				out.print(responseStr.toString());
			}
		} catch (Exception e) {
			// TODO: RETURN ERROR TO MAIN.JS to handle request.onerror()
			// response.setStatus(500);
			System.out.println("There are network issues with the weather server. Cannot fetch the weather data");
			response.sendError(500);
		}
		// out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
