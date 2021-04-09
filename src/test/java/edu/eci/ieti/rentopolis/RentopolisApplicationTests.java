package edu.eci.ieti.rentopolis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import com.mongodb.client.MongoClients;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import edu.eci.ieti.rentopolis.dto.LeaseDTO;
import edu.eci.ieti.rentopolis.dto.PropertyDTO;
import edu.eci.ieti.rentopolis.dto.UserDTO;
import edu.eci.ieti.rentopolis.entities.*;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
import java.util.ArrayList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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

	private static final int ArrayList = 0;

	@Autowired
	private MongodExecutable mongodExecutable;
	private MongoTemplate mongoTemplate;


    @Autowired
    private WebApplicationContext webApplicationContext;



    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998");

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse("14/12/2000");

    RentopolisApplicationTests() throws ParseException {
    }

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
    void shouldNotGetAUserById() throws Exception {
        MvcResult response = mvcMock.perform(get("/home/user/14"))
                .andExpect(status().isNotFound()).andReturn();
        String responseBody = response.getResponse().getContentAsString();
        Assertions.assertEquals("Usuario no existe", responseBody);
    }


	@Test
	void shouldNotGetProperty() throws Exception{
		mvcMock.perform(get("/home/property/404"))
				.andExpect(status().isNotFound());
	}

	@Test
	void shouldGetUsers() throws Exception{
		mvcMock.perform(get("/home/users"))
				.andExpect(status().isOk());
	}

	@Test
	void shouldGetProperties() throws Exception{
		mvcMock.perform(get("/home/properties"))
				.andExpect(status().isAccepted());
	}


    @Test
    void shouldAddUser() throws Exception {
        UserDTO userDTO = new UserDTO("13", "Sara Perez", "123", "sara@gmail.com", "123");
        mvcMock.perform(post("/home/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(userDTO)))
                .andExpect(status().isCreated()).andDo(print());
    }

    @Test
    void shouldGetAUserById() throws Exception {
        UserDTO userDTO = new UserDTO("12", "Sara Perez", "123", "sara@gmail.com", "123");
        mvcMock.perform(post("/home/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(userDTO)))
                .andExpect(status().isCreated());


        MvcResult response = mvcMock.perform(get("/home/user/12"))
                .andExpect(status().isAccepted()).andReturn();
        String responseBody = response.getResponse().getContentAsString();
        UserDTO responseAsUser = gson.fromJson(responseBody, UserDTO.class);
        Assertions.assertEquals(userDTO.getId(), responseAsUser.getId());
    }

	@Test
	void shouldAddProperty() throws Exception{
		Location location= new Location(1,1);
		Property property= new Property();
		property.setId(6);
		property.setArea(50); 
		property.setPrice(5000000); 
		property.setLocation(location);
		property.setType(PropertyType.Apartaestudio);
		property.setNumberOfRooms(4); 
		property.setNumberOfBathRooms(2);
		property.setElevator(true);
		property.setSurveillance(true);
		property.setGym(false);
		property.setCommunityRoom(true);
		property.setFurniture(true);
		property.setDescription("");
		property.setReputation(4);
		List<String> images = new ArrayList<>();
		property.setImages(images);
		PropertyDTO propertyDTO= new PropertyDTO(property);
		mvcMock.perform(post("/home/property")
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(propertyDTO)))
				.andExpect(status().isCreated()).andDo(print());
	}


    @Test
    void shouldAddProperty() throws Exception {
        Location location = new Location(1, 1);
        Property property = new Property(16, 50, 5000000, location, PropertyType.Apartaestudio, 4, 2, true, true, false, true, true, "", 4);
        PropertyDTO propertyDTO = new PropertyDTO(property);
        mvcMock.perform(post("/home/property")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(propertyDTO)))
                .andExpect(status().isCreated()).andDo(print());
    }

    @Test
    void shouldAddImage() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "image.txt",
                MediaType.TEXT_PLAIN_VALUE, "prueba archivo".getBytes());
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders.multipart("/home/picture").file(file).param("id", "2").param("title", "image.txt")).andExpect(status().isCreated());
    }


    @Test
    void shouldAddImage2() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "image.txt",
                MediaType.TEXT_PLAIN_VALUE, "prueba archivo".getBytes());
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders.multipart("/home/picture").file(file).param("id", "null").param("title", "image.txt")).andExpect(status().isCreated());
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
    void shouldGetImage() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "image.txt",
                MediaType.TEXT_PLAIN_VALUE, "prueba archivo".getBytes());
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders.multipart("/home/picture").file(file).param("id", "15").param("title", "image.txt")).andExpect(status().isCreated());

        mvcMock.perform(get("/home/picture/15"))
                .andExpect(status().isOk());
    }


    @Test
    void shouldNotFindImage() throws Exception {
        mvcMock.perform(get("/home/picture/1"))
                .andExpect(status().isNotFound());
    }


    @Test
    void shouldUpdateUser() throws Exception {
        UserDTO userDTO = new UserDTO("30", "Carlos Perez", "1235", "carlos@gmail.com", "1235");
        mvcMock.perform(post("/home/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(userDTO)))
                .andExpect(status().isCreated()).andDo(print());
        UserDTO userDTO1 = new UserDTO("30", "Carlos Perez", "12345", "carlos@gmail.com", "12345");
        MvcResult response = mvcMock.perform(put("/home/" + userDTO1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(userDTO1)))
                .andExpect(status().isAccepted())
                .andReturn();
        Assertions.assertEquals(202, response.getResponse().getStatus());
    }

    @Test
    void shouldNotUpdateUser() throws Exception {
        UserDTO userDTO = new UserDTO("31", "David Perez", "12345", "david@gmail.com", "12345");
        mvcMock.perform(post("/home/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(userDTO)))
                .andExpect(status().isCreated()).andDo(print());
        UserDTO userDTO1 = new UserDTO("31", "David Perez", "1234", "david@gmail.com", "1234");
        MvcResult response = mvcMock.perform(put("/home/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(userDTO1)))
                .andExpect(status().isNotAcceptable())
                .andReturn();
        String responseBody = response.getResponse().getContentAsString();
        Assertions.assertEquals("El id no concuerda con el usuario", responseBody);
    }

    @Test
    void shouldDeleteUser() throws Exception {
        UserDTO userDTO = new UserDTO("35", "Juan Jose Perez", "45678", "jjose@gmail.com", "2342");
        mvcMock.perform(post("/home/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(userDTO)))
                .andExpect(status().isCreated());
        MvcResult response = mvcMock.perform(delete("/home/" + userDTO.getId()))
                .andExpect(status().isAccepted())
                .andReturn();
        Assertions.assertEquals(202, response.getResponse().getStatus());
    }

    @Test
    void shouldNotDeleteUser() throws Exception {
        MvcResult response = mvcMock.perform(delete("/home/3"))
                .andExpect(status().isNotFound())
                .andReturn();
        String responseBody = response.getResponse().getContentAsString();
        Assertions.assertEquals("Usuario no existe", responseBody);
    }

    @Test
    void shouldDeleteLease() throws Exception {
        //Property property = new Property(234, 24, new Location(12, 12), PropertyType.Apartaestudio, 4, 5, false, true, true, false, true, "Hermoso apto en Colina", "foto", "Carrera 13 # 12-12", "Colina", 5);
//        Property property = new Property();
//        Lessee lessee = new Lessee();
//        Lessor lessor = new Lessor();
//        String startDateString = "06/27/2007";
//
//        // This object can interpret strings representing dates in the format MM/dd/yyyy
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//
//        // Convert from String to Date
//        Date xxd = df.parse(startDateString);
//        System.out.println("Date, with the default formatting: " + startDate);
//        Lease lease = new Lease(209, property, lessee, lessor, startDate, startDate);
//
//        LeaseDTO leaseDTO = new LeaseDTO(lease);
//
//
//        mvcMock.perform(post("/home/lease")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(gson.toJson(leaseDTO)))
//                .andExpect(status().isCreated())
//                .andReturn();
//        MvcResult result = mvcMock.perform(get("/home/lease/" + leaseDTO.getId()))
//                .andExpect(status().isAccepted())
//                .andReturn();
//        String bodyResult = result.getResponse().getContentAsString();
//        JSONObject object = new JSONObject(bodyResult);
//
//        LeaseDTO leaseDTO1 = gson.fromJson(object.toString(), LeaseDTO.class);
//        long id = 213;
//        mvcMock.perform(delete("/home/lease/" + id))
//                .andExpect(status().isOk())
//                .andReturn();
    }

    @Test
    void shouldNotDeleteLease() throws Exception {
        MvcResult response = mvcMock.perform(delete("/home/lease/80"))
                .andExpect(status().isNotFound())
                .andReturn();
        Assertions.assertEquals("Lease no existe", response.getResponse().getContentAsString());
    }
}
