package example;

import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.RestExpress;

public class LogService {

//	HTTP Methods, if not changed in the fluent (DSL) interface, map to the following:
//	    GET --> read(Request, Response)
//	    PUT --> update(Request, Response)
//	    POST --> create(Request, Response)
//	    DELETE --> delete(Request, Response)
	public void create(Request request, Response response) {
		read(request, response);
	}
	
	public void update(Request request, Response response) {
		read(request, response);
	}
	
	public void delete(Request request, Response response) {
		read(request, response);
	}

	public void read(Request request, Response response) {
		System.out.println("message: " + request.getHeader("m") + ", " + "stacktrace: " + request.getHeader("s"));
	}
	
	public static void main(String[] args) {
		RestExpress server = (new RestExpress()).setPort(8080);
		server.uri("/log", new LogService());
		server.bind();
		server.awaitShutdown();
	}
}
