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
import edu.eci.ieti.rentopolis.dto.UserDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import edu.eci.ieti.rentopolis.entities.Location;
import edu.eci.ieti.rentopolis.entities.Picture;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.PropertyType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RentopolisApplicationTests {

	@Autowired
	MockMvc mvcMock;

	private static Gson gson = new Gson();

	private static final String CONNECTION_STRING = "mongodb://%s:%d";

	@Autowired
	private MongodExecutable mongodExecutable;
	private MongoTemplate mongoTemplate;

	@Autowired
	private WebApplicationContext webApplicationContext;

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
	void shouldNotGetAUserById() throws Exception{
		MvcResult response= mvcMock.perform(get("/home/user/14"))
				.andExpect(status().isNotFound()).andReturn();
		String responseBody = response.getResponse().getContentAsString();
		Assertions.assertEquals("Usuario no existe", responseBody);
	}

	/*
	@Test
	void shouldNotGetUsers() throws Exception{
		MvcResult response= mvcMock.perform(get("/home/users"))
				.andExpect(status().isNotFound()).andReturn();
		String responseBody = response.getResponse().getContentAsString();
		Assertions.assertEquals("No hay usuarios", responseBody);
	}
	*/

	@Test
	void shouldAddUser() throws Exception{
		UserDTO userDTO= new UserDTO("13","Sara Perez", "123","sara@gmail.com","123");
		mvcMock.perform(post("/home/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(userDTO)))
				.andExpect(status().isCreated()).andDo(print());
	}

	@Test
	void shouldGetAUserById() throws Exception{
		UserDTO userDTO= new UserDTO("12","Sara Perez", "123","sara@gmail.com","123");
		mvcMock.perform(post("/home/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(userDTO)))
				.andExpect(status().isCreated());

		MvcResult response= mvcMock.perform(get("/home/user/12"))
				.andExpect(status().isAccepted()).andReturn();
		String responseBody = response.getResponse().getContentAsString();
		UserDTO responseAsUser = gson.fromJson(responseBody, UserDTO.class);
		Assertions.assertEquals(userDTO.getId(), responseAsUser.getId());
	}

	@Test
	void shouldAddProperty() throws Exception{
		Location location= new Location(1,1);
		Property property= new Property(16,50, 5000000,location, PropertyType.Apartaestudio,4, 2, true, true, false, true, true, "", 4);
		PropertyDTO propertyDTO= new PropertyDTO(property);
		mvcMock.perform(post("/home/property")
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(propertyDTO)))
				.andExpect(status().isCreated()).andDo(print());
	}

	@Test
	void shouldAddImage() throws Exception{
		MockMultipartFile file = new MockMultipartFile("file", "image.txt", 
								MediaType.TEXT_PLAIN_VALUE,"prueba archivo".getBytes());
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(MockMvcRequestBuilders.multipart("/home/picture").file(file).param("id","2").param("title","image.txt")).andExpect(status().isCreated());
	}

	@Test
	void shouldAddImage2() throws Exception{
		MockMultipartFile file = new MockMultipartFile("file", "image.txt", 
								MediaType.TEXT_PLAIN_VALUE,"prueba archivo".getBytes());
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(MockMvcRequestBuilders.multipart("/home/picture").file(file).param("id","null").param("title","image.txt")).andExpect(status().isCreated());
	}


	@Test
	void shouldAddImageToProperty() throws Exception{

		Location location= new Location(1,1);
		Property property= new Property(163,50, 5000000,location, PropertyType.Apartaestudio,4, 2, true, true, false, true, true, "", 4);
		PropertyDTO propertyDTO= new PropertyDTO(property);
		mvcMock.perform(post("/home/property")
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(propertyDTO)))
				.andExpect(status().isCreated());

		MockMultipartFile file = new MockMultipartFile("file", "image.txt", 
								MediaType.TEXT_PLAIN_VALUE,"prueba archivo".getBytes());
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(MockMvcRequestBuilders.multipart("/home/property/picture").file(file).param("propertyId","163").param("id","null").param("title","image.txt")).andExpect(status().isCreated());
	}

	@Test
	void shouldGetImage() throws Exception{
		MockMultipartFile file = new MockMultipartFile("file", "image.txt", 
								MediaType.TEXT_PLAIN_VALUE,"prueba archivo".getBytes());
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(MockMvcRequestBuilders.multipart("/home/picture").file(file).param("id","15").param("title","image.txt")).andExpect(status().isCreated());

		mvcMock.perform(get("/home/picture/15"))
				.andExpect(status().isOk());
	}


	@Test
	void shouldNotFindImage() throws Exception{
		mvcMock.perform(get("/home/picture/1"))
				.andExpect(status().isNotFound());
	}


	@Test
	void shouldUpdateUser() throws Exception{
		UserDTO userDTO= new UserDTO("30","Carlos Perez", "1235","carlos@gmail.com","1235");
		mvcMock.perform(post("/home/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(userDTO)))
				.andExpect(status().isCreated()).andDo(print());
		UserDTO userDTO1 = new UserDTO("30","Carlos Perez", "12345","carlos@gmail.com","12345");
		MvcResult response= mvcMock.perform(put("/home/"+userDTO1.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(userDTO1)))
				.andExpect(status().isAccepted())
				.andReturn();
		Assertions.assertEquals(202, response.getResponse().getStatus());
	}

	@Test
	void shouldNotUpdateUser() throws Exception{
		UserDTO userDTO= new UserDTO("31","David Perez", "12345","david@gmail.com","12345");
		mvcMock.perform(post("/home/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(userDTO)))
				.andExpect(status().isCreated()).andDo(print());
		UserDTO userDTO1 = new UserDTO("31","David Perez", "1234","david@gmail.com","1234");
		MvcResult response= mvcMock.perform(put("/home/3")
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(userDTO1)))
				.andExpect(status().isNotAcceptable())
				.andReturn();
		String responseBody = response.getResponse().getContentAsString();
		Assertions.assertEquals("El id no concuerda con el usuario", responseBody);
	}

	@Test
	void shouldDeleteUser() throws Exception{
		UserDTO userDTO= new UserDTO("35","Juan Jose Perez", "45678","jjose@gmail.com","2342");
		mvcMock.perform(post("/home/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(userDTO)))
				.andExpect(status().isCreated());
		MvcResult response= mvcMock.perform(delete("/home/"+userDTO.getId()))
				.andExpect(status().isAccepted())
				.andReturn();
		Assertions.assertEquals(202, response.getResponse().getStatus());
	}

	@Test
	void shouldNotDeleteUser() throws Exception{
		MvcResult response= mvcMock.perform(delete("/home/3"))
				.andExpect(status().isNotFound())
				.andReturn();
		String responseBody = response.getResponse().getContentAsString();
		Assertions.assertEquals("Usuario no existe", responseBody);
	}
}
