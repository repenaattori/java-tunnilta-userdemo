package com.reiskaoy.userdemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    

    private UserService uService = new UserService();


    @PostMapping("/")
    public String getBasicInfo(
        @RequestParam String lang
    ){
        if(lang.equals("eng"))
            return "This is root info!!!";
        
        return "Tämä on juurimappaus";
    }

    @GetMapping("/user/{category}/{id}")
    public User getUser(@PathVariable String category, @PathVariable String id){
        if(id.equals("0"))
            return new User("Reima", 22);
        
        return new User("Liisa", 34);
    }

    @PostMapping("/user")
    public String addUser(@RequestBody User user){
        uService.addUser(user);

        return "User added";
    }

    // @PostMapping("/user")
    // public String addUser(@RequestBody Map<String,String> json){
    //     return json.get("name") + json.get("age");
    // }


    @GetMapping("/users")
    public List<User> getUsers(){
        return uService.getUsers();
    }

    @GetMapping("/sum/{num1}/{num2}")
    public String getSum(@PathVariable Integer num1, @PathVariable Integer num2){
        return "The sum of numbers is " + (num1+num2);
    }


    //JSON muodon voi palauttaa MAP-rakenteena
    @GetMapping("/custom")
    public Map<String,String> getCustom(){
        Map<String,String> json = new HashMap<>(); 

        json.put("width", "45");
        json.put("height", "23");

        return json;
    }



    @GetMapping("/student")
    public ResponseEntity<String> getStudent(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>("Returning user", headers, HttpStatus.UNAUTHORIZED);
    }


}
