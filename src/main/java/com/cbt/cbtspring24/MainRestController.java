package com.cbt.cbtspring24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MainRestController
{
    Logger logger = LoggerFactory.getLogger(MainRestController.class);

    //@Autowired
    //MyNumber num_1; //DEPENDENCY INJECTION

    //@Autowired
    //MyNumber num_2; //DEPENDENCY INJECTION

    @Autowired
    List<MyNumber> myNumberList;

    @Autowired // DEPENDENCY INJECTION
    CredentialRepository credentialRepository; //INJECTION OF THE APPROPRIATE OBJECT|DEPENDENCY

    @GetMapping("greet")
    public ResponseEntity<String> greet()
    {
        return ResponseEntity.ok("We are learning Spring Framework and Databases ");
    }

    @GetMapping("agreet")
    public ResponseEntity<String> anotherGreet(@RequestParam String username)
    {
        return ResponseEntity.ok("Welcome "+username+" How's it going?");
    }

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody Credential credential)
    {
        credentialRepository.save(credential);
        return ResponseEntity.ok("NEW SIGNUP SUCESSFULL WITH USERNAME :"+credential.getUsername());

    }

    @GetMapping("getnum")
    public ResponseEntity<MyNumber> getNumber()
    {
        logger.info("num_1 :"+myNumberList.get(0));
        logger.info("num_2 :"+myNumberList.get(1));
        //logger.info("num_2 :"+myNumberList.get(2));

        return ResponseEntity.ok(myNumberList.get(1));
    }


}
