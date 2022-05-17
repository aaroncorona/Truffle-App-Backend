package com.example.fansbackend.Controller;

import com.example.fansbackend.Model.Fan;
import com.example.fansbackend.Service.FanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class FanController {

    // Create a Service object for the Controller object to use
    public FanService service;

    // Constructor (Controller needs a Service, which then connects to the repp)
    public FanController(FanService serviceParam) {
        this.service = serviceParam;
    }

    // GET default return
    @GetMapping()
    public String hello() {
        return("Hello Goodbye");
    }

    // GET all fans (JSON format)
    @GetMapping("/fans/json")
    public List<Fan> allPublic() {
        List fansList = service.getAllFans();
        return fansList;
    }

    // GET one fan (Lookup by ID)
    @GetMapping("/fans/json/{id}")
    public Map<String, Object> one(@PathVariable Long id) {
        Map<String, Object> fanMap = new HashMap<>();
        // Get the fan specified by the ID in the parameter
        fanMap.put("fan found: ", service.getFan(id));
        return fanMap;
    }

    // POST operation (Create a new Fan)
    @RequestMapping(value = "/fans/signup", method = {RequestMethod.POST, RequestMethod.GET})
    public String create(@RequestParam(defaultValue = "test") String name,
                         @RequestParam(defaultValue = "0") Integer age) {
        // Run the service method that saves records to the repo using the param to create an obj
        service.saveFan(new Fan(name, age));
        // Print the status on the web page
        ResponseEntity status = ResponseEntity.status(HttpStatus.CREATED).build(); // get the status of the post request
        return("Fan created using (" + name + ") (" + age + "). Post Status: " + status);
    }

    // PUT operation (Create/Update a Fan)
    // URL param format: http://localhost:8080/fans/update/626eeca93ed1ef2f64ea3e47?name=bandit&age=2
    @RequestMapping(value = "/fans/update/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(@PathVariable Long id,
                         @RequestParam(defaultValue = "test") String name,
                         @RequestParam(defaultValue = "0") Integer age) {
        // Get the fan specified by the ID in the parameter
        Optional<Fan> optionalFan = service.getFan(id);
        // If the fan exists, update their attributes
        // Add this PUT logic in the Service layer?
        if(optionalFan.isPresent()) {
            // Current Fan attributes
            Fan fan = optionalFan.get();
            String oldName = fan.getName();
            Integer oldAge = fan.getAge();
            // Set new attributes for the existing Fan
            fan.setName(name);
            fan.setAge(age);
            service.saveFan(fan); // repo save handles updates and inserts
            // Print confirmation
            return("Fan found! \n" +
                    "\nOld name: " + oldName + " \n New Name: " + fan.getName() +
                    "\nOld age: " + oldAge + " \n New Age: " + fan.getAge());
        } else {
            // POST
            service.saveFan(new Fan(name, age));
            // Print confirmation
            ResponseEntity status = ResponseEntity.status(HttpStatus.CREATED).build(); // get the status of the post request
            return("No fan found with that ID. Fan created using (" + name + ") (" + age + "). Post Status: " + status);
        }
    }

    // DELETE one fan (Lookup by ID)
    @RequestMapping(value = "/fans/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Long id) {
        // Get the fan specified by the ID in the parameter
        // Delete the fan entry if the ID exists
        if(service.getFan(id).isPresent()){
            Fan fan = service.getFan(id).get();
            String name = fan.getName();
            service.deleteFan(service.getFan(id).get());
            return("Fan deleted (" + name + ").");
        } else {
            return("No fan found with that ID (" + id + ").");
        }
    }
}
