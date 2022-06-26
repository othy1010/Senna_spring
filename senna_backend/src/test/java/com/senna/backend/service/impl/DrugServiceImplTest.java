package com.senna.backend.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.senna.backend.dao.DrugRepository;
import com.senna.backend.dao.UserRepository;
import com.senna.backend.domain.Drug;
import com.senna.backend.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
// import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

// @RunWith(SpringRunner.class)
@WebMvcTest(DrugServiceImpl.class)
// @WithMockUser(username = "senna", password = "12345")
public class DrugServiceImplTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    DrugRepository drugRepository;

    @Test
    void saveDrug() throws Exception {
        Drug drugTest = new Drug();
        // drugTest.setDrugId("othmane");
        // drugTest.setDrugCategoryId(1L);
        // drugTest.setDrugCreatedAt("bh111111");
        drugTest.setDrugName("doliprane");
        drugTest.setDrugPrice(25.50);
        drugTest.setDrugDescription("doliprane pour maux de tete");
        drugTest.setDrugQuantity(20);
        drugTest.setDrugSideEffects("maux de tete");
        drugTest.setDrugStock(200);
        drugTest.setDrugSupplierId(1L);
        drugTest.setDrugUsage("maux de tete");
        drugTest.setDrugWarnings("diabetique");
        drugTest.setNeedPrescription(false);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(drugTest);

        mvc.perform(post("/api/drugs").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    void findByDrugId() throws Exception {
        mvc.perform(get("/api/drugs/drugId/{drugId}", 1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteDrug() throws Exception {
        mvc.perform(delete("/api/drugs/drugId/{drugId}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void findAllByDrugUsageLike() {
    }

    @Test
    void findByDrugNameLike() {
    }

    @Test
    void findAllByDrugSupplierId() throws Exception {
        mvc.perform(get("/api/drugs/drugSupplierId/{drugSupplierId}", 1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findAll() throws Exception {
        mvc.perform(get("/api/drugs").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}