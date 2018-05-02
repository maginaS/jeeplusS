/**
 * 
 */
package com.jeeplus.modules.webapi;

import org.restlet.Context;
import org.restlet.engine.adapter.HttpRequest;
import org.restlet.engine.adapter.ServerCall;

/**
 * @author MikeSun
 *
 */
public class Webapi extends HttpRequest{
	
	public static String WEBAPI="http://121.69.128.11:9108/api/Service/gettoken";
	
	public static String unitIdStr ="EE2DCB60-95B5-4EBC-955E-ED73BD439E35"; 

	public Webapi(Context context, ServerCall httpCall) {
		super(context, httpCall);
//		// TODO Auto-generated constructor stub
	}
	
	
	

}
