package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import test.topic.topicModel;
import test.topic.topicRepo;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Component
public class DatabasaeLoader implements ApplicationRunner {
    private topicRepo topics;

    @Autowired
    public  DatabasaeLoader(topicRepo topics){
        this.topics=topics;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
         ArrayList<topicModel> bunchOfTopic = new ArrayList<topicModel>();

        String[] buzzWords = {"Multi Threading", "Inner Classes",  "Collections", "Generics", "Development", "JVM"};

        //Using java 8 features (stream, lambda)
        IntStream.range(0,10).forEach(it -> {
            String buzzWord = buzzWords[it % buzzWords.length];
            topicModel topic = new topicModel(buzzWord, (it % buzzWords.length));
            bunchOfTopic.add(topic);
        });

        topics.saveAll(bunchOfTopic);
    }
}
