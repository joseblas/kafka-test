package org.reactive.mvc.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactive.mvc.model.Provide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CassandraConfig.class)
public class ProvideRepositoryTest {
    @Autowired ProvideRepository repository;
    Provide provide;

    @Before
    public void setUp() {
        provide = new Provide();
        provide.setId(UUID.randomUUID().toString());
        provide.setCreated(new Date().toString());

    }

    @After
    public void tearDown(){
//        repository.delete(provide);
    }

    @Test
    public void findSavedUserById() {

        provide = repository.save(provide);
        assertThat(repository.findOne(provide.getId()).getId(), is(provide.getId()));
    }
}