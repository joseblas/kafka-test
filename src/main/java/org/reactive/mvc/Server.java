package org.reactive.mvc;


import org.reactive.mvc.model.Provide;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@EnableAutoConfiguration
public class Server {

    @RequestMapping(value = "/", method = POST,headers = {"Content-type=application/json"})
    @ResponseBody
    public JsonResponse provide(@RequestBody Provide provide) {
        return new JsonResponse("Ok","");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Server.class, args);
    }
}
