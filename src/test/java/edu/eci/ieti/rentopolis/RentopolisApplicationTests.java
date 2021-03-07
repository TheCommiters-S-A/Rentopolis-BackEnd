package edu.eci.ieti.rentopolis;

import com.google.gson.Gson;
import com.mongodb.client.MongoClients;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import edu.eci.ieti.rentopolis.dto.PropertyDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import edu.eci.ieti.rentopolis.entities.Location;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.PropertyType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RentopolisApplicationTests {

	@Autowired
	MockMvc mvcMock;

	private static Gson gson = new Gson();

	private static final String CONNECTION_STRING = "mongodb://%s:%d";

	private MongodExecutable mongodExecutable;
	private MongoTemplate mongoTemplate;

	@AfterEach
	void clean() {
		mongodExecutable.stop();
	}

	@BeforeEach
	void setup() throws Exception {
		String ip = "localhost";
		int port = 27017;
		IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
				.net(new Net(ip, port, Network.localhostIsIPv6()))
				.build();
		MongodStarter starter = MongodStarter.getDefaultInstance();
		mongodExecutable = starter.prepare(mongodConfig);
		mongodExecutable.start();
		mongoTemplate = new MongoTemplate(MongoClients.create(String.format(CONNECTION_STRING, ip, port)), "test");
	}

	@Test
	void shouldAddProperty() throws Exception{
		Location location= new Location(1,1);
		PropertyType propertyType= new PropertyType("Apartamento");
		Property property= new Property(16,50, 5000000,location, propertyType,4, 2, true, true, false, true, true, "", 4);
		PropertyDTO propertyDTO= new PropertyDTO(property);
		mvcMock.perform(post("/home/property")
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(propertyDTO)))
				.andExpect(status().isCreated()).andDo(print());
	}

}
