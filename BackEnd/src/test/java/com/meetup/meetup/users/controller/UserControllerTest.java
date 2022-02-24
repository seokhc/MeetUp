package com.meetup.meetup.users.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest {
/*
    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private WebApplicationContext context;

    MockMvc mvc;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @AfterEach
    void cleanUp() {
        userRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "USER")
    void 유저_정보를_조회한다() throws Exception {
        //given
        String email = "test@test.com";
        String password = "1234";
        Address address = Address.builder()
                .city("city")
                .street("street")
                .zipcode("12345")
                .latitude("36.21353")
                .longitude("123.124545")
                .build();
        String picture = "~/test.jpg";
        Role type = Role.USER;

        //when
        User user = User.builder()
                .email(email)
                .password(password)
                .address(address)
                .picture(picture)
                .type(type)
                .build();

        userRepository.save(user);

        //then
        mvc.perform(get("/users/"+user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", email).exists())
                .andExpect(jsonPath("$.picture", picture).exists())
                .andExpect(jsonPath("$.type", type).exists());
    }

    @Test
    @WithMockUser(roles = "USER")
    void 유저를_등록한다() throws Exception {
        //given
        String email = "test@test.com";
        String password = "1234";
        Address address = Address.builder()
                .city("city")
                .street("street")
                .zipcode("12345")
                .latitude("36.21353")
                .longitude("123.124545")
                .build();
        String picture = "~/test.jpg";
        Role type = Role.USER;

        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .email(email)
                .password(password)
                .address(address)
                .picture(picture)
                .type(type)
                .build();

        String url = "http://localhost:" + port + "/users";

        //when
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
*//*
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
*//*

        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getEmail()).isEqualTo(email);
        assertThat(users.get(0).getPassword()).isEqualTo(password);
        assertThat(users.get(0).getAddress()).isEqualTo(address);
        assertThat(users.get(0).getPicture()).isEqualTo(picture);
        assertThat(users.get(0).getRole()).isEqualTo(Role.USER);
    }

    @Test
    @WithMockUser(roles = "USER")
    void 유저를_수정한다() throws Exception {
        //given
        String email = "test@test.com";
        String password = "1234";
        Address address = Address.builder()
                .city("city")
                .street("street")
                .zipcode("12345")
                .latitude("36.21353")
                .longitude("123.124545")
                .build();
        String picture = "~/test.jpg";
        Role type = Role.USER;

        User user = User.builder()
                .email(email)
                .password(password)
                .address(address)
                .picture(picture)
                .type(type)
                .build();

        User savedUser = userRepository.save(user);

        String newPassword = "qwer";
        Address newAddress = Address.builder()
                .city("newCity")
                .street("newStreet")
                .zipcode("67890")
                .latitude("110.12314214")
                .longitude("58.2139213")
                .build();
        String newPicture = "~/newTest.jpg";

        UserUpdateRequestDto requestDto = UserUpdateRequestDto.builder()
                .password(newPassword)
                .address(newAddress)
                .picture(newPicture)
                .build();

        String url = "http://localhost:" + port + "/users/" + savedUser.getId();

//        HttpEntity<UserUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
//        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());


        //then
*//*
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
*//*

        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getPassword()).isEqualTo(newPassword);
        assertThat(users.get(0).getAddress()).isEqualTo(newAddress);
        assertThat(users.get(0).getPicture()).isEqualTo(newPicture);

    }
*/
}