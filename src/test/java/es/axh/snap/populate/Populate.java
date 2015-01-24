package es.axh.snap.populate;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

import es.axh.snap.domain.Bundle;
import es.axh.snap.domain.Route;

public class Populate {

	public static void main(String[] args) {
		
		MongoOperations operations = null;
		
		try {
			operations = initMongoOperations();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		operations.dropCollection(Bundle.class);
		
//		Bundle bundle = new Bundle();
//		
//		bundle.setName("Visita monumental de Munich");
//		bundle.setDescription("Visita la ciudad de Munich");
//		bundle.setCity("Munich, Alemania");
//		
//		List<Route> routes = new ArrayList<Route>();
//
//		Route route1 = new Route();
//		route1.setName("Marienplatz");
//		route1.setDescription("Marienplatz es el centro y el alma de Múnich desde tiempos inmemoriales. En ella se encuentran edificios tan importantes como el ayuntamiento.");
//		route1.setPrice(1.0);
//		route1.setPhoto("/assets/images/cities/munchen/marienplatz.jpg");
//		routes.add(route1);
//		
//		Route route2 = new Route();
//		route2.setName("Viktualienmarkt");
//		route2.setDescription("Alimentos, frutas, quesos, flores e infinidad de coloridos productos se dan cita en el mercado Viktualienmarkt, el más conocido de Múnich.");
//		route2.setPrice(0.0);
//		route2.setPhoto("/assets/images/cities/munchen/viktualienmarkt.jpg");
//		routes.add(route2);
//		
//		Route route3 = new Route();
//		route3.setName("Karlsplatz");
//		route3.setDescription("Karlsplatz es una gran plaza localizada en el centro de Múnich que fue construida en el siglo XVIII tras el derribo de la muralla medieval.");
//		route3.setPrice(0.0);
//		route3.setPhoto("/assets/images/cities/munchen/karlsplatz.jpg");
//		routes.add(route3);
//		
//		Route route4 = new Route();
//		route4.setName("Olympiaturm");
//		route4.setDescription("Construida entre 1965 y 1968, la Torre Olímpica de Múnich es una torre de la televisión que ofrece las mejores vistas del Parque Olímpico de Múnich.");
//		route4.setPrice(10.0);
//		route4.setPhoto("/assets/images/cities/munchen/olympiaturm.jpg");
//		routes.add(route4);
//		
//		bundle.setRoutes(routes);
//		
//		operations.save(bundle);
		
//		operations.remove(operations.findById("54c38e3fe4b0fd6282d6cc1b", Bundle.class));
		
		List<Bundle> bundles = operations.findAll(Bundle.class);
		
		for(Bundle bundle : bundles){
			for(Route route : bundle.getRoutes()){
				String photo = route.getPhoto();
				
				if(photo.startsWith("/")){
					photo = photo.substring(1);
					route.setPhoto(photo);
				}
			}
			operations.save(bundle);
		}

	}
	
	private static MongoOperations initMongoOperations() throws UnknownHostException {
		UserCredentials credentials = new UserCredentials("ruta50", "ruta50");
		SimpleMongoDbFactory dbfactory = new SimpleMongoDbFactory(new MongoClient("ds033831.mongolab.com", 33831), "ruta50", credentials);
		//SimpleMongoDbFactory dbfactory = new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "easysupermarket");
		MongoTemplate mt = new MongoTemplate(dbfactory);
		/*for(String s :mt.getDb().getCollectionNames()) {
			if(s.startsWith("system.") == false) {
				mt.getCollection(s).drop();
			}
		}*/
		return mt;
	}
}
