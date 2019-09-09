package test.topic;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface topicRepo extends CrudRepository<topicModel,Long> {

    //Collection<topicModel> findByTopicName(String topicName);
}
