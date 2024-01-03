package htwberlin.webtech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StellenangebotController.class)
public class StellenangebotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StellenangebotService stellenangebotService;

    @Test
    @DisplayName("Should get all Stellenangebote")
    void testGetAllStellenangebote() throws Exception {
        List<Stellenangebot> stellenangebote = Arrays.asList(
                new Stellenangebot("Software Engineer", "Example Company 1", "Berlin", "Job description 1", "2024-01-10", "2024-02-01"),
                new Stellenangebot("Web Developer", "Example Company 2", "Munich", "Job description 2", "2024-01-15", "2024-02-15")
        );
        when(stellenangebotService.getAll()).thenReturn(stellenangebote);

        mockMvc.perform(get("/stellenangebote"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"jobTitle\":\"Software Engineer\",\"company\":\"Example Company 1\",\"location\":\"Berlin\",\"description\":\"Job description 1\",\"deadline\":\"2024-01-10\",\"startDate\":\"2024-02-01\"},{\"jobTitle\":\"Web Developer\",\"company\":\"Example Company 2\",\"location\":\"Munich\",\"description\":\"Job description 2\",\"deadline\":\"2024-01-15\",\"startDate\":\"2024-02-15\"}]"));
    }

    @Test
    @DisplayName("Should get a Stellenangebot by its id")
    void testGetStellenangebotById() throws Exception {
        Stellenangebot stellenangebot = new Stellenangebot("Software Engineer", "Example Company", "Berlin", "Job description", "2024-01-10", "2024-02-01");
        when(stellenangebotService.get(1L)).thenReturn(stellenangebot);

        mockMvc.perform(get("/stellenangebote/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"jobTitle\":\"Software Engineer\",\"company\":\"Example Company\",\"location\":\"Berlin\",\"description\":\"Job description\",\"deadline\":\"2024-01-10\",\"startDate\":\"2024-02-01\"}"));
    }
}