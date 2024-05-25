package co.uco.doo.store.api.infrastructure.entrypoints.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/dummy")
public class DummyController {

    @GetMapping
    public String dummyEndpoint(){
        return "this is a test";
    }
}
