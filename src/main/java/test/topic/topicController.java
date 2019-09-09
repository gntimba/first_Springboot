package test.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;
import test.Util;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class topicController {
    @Autowired
    private topicRepo top;

    @RequestMapping(method = RequestMethod.GET)
    Collection<topicModel> getAll(){
        return Lists.newArrayList(top.findAll());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{topic}")
    Optional<topicModel> getbyTopic(@PathVariable Long topic){
        return top.findById(topic);
    }

    @RequestMapping (method= RequestMethod.POST)
    ResponseEntity<?> addtopic(@RequestBody topicModel topi){
        if(topi.getName()!=null && topi.getQuestionCount()!= 0){
            Util.save(top,new topicModel(topi.getName(),topi.getQuestionCount()));
            return Util.createResponseEntity("Created Successfully", HttpStatus.ACCEPTED);
        }
        return  Util.createResponseEntity("something bad happened",HttpStatus.BAD_REQUEST);
    }
    @RequestMapping (method= RequestMethod.DELETE,value = "/{Id}")
    ResponseEntity<?> deleteTopic(@PathVariable Long Id){
        try{

            top.deleteById(Id);
            return Util.createResponseEntity("Deleted Successfully", HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return Util.createResponseEntity("something bad happened", HttpStatus.BAD_REQUEST);
        }
    }


}
