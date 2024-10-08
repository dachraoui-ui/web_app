package ahmed.io.runnerz.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;


import java.util.List;
import java.util.Optional;


@Repository

public class JdbcClientRunRepository {
    private static final Logger log = LoggerFactory.getLogger(JdbcClientRunRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll(){
        return jdbcClient.sql("select * from Run")
                .query(Run.class)
                .list();
    }

    public Optional<Run> findById(Integer id){
        return jdbcClient.sql("select * from Run where id = :id")
                .param("id", id)
                .query(Run.class)
                .optional();
    }
    public void create(Run run) {
        var updated = jdbcClient.sql("insert into Run (id, title, started_on, completed_on, miles, location) values (:id, :title, :started_on, :completed_on, :miles, :location)")
                .param("id", run.id())
                .param("title", run.title())
                .param("started_on", run.startedOn())
                .param("completed_on", run.completedOn())
                .param("miles", run.miles())
                .param("location", run.location().toString())
                .update();
        Assert.state(updated == 1, "Failed to create run " + run.title());
    }
//    public void update(Run run , Integer id) {
//        var updated = jdbcClient.sql("update Run set title = ? , started_on = ?,completed_on = ? ,miles =?,location = ? where id = ?")
//                .param("title", run.title())
//                .param("started_on", run.startedOn())
//                .param("completed_on", run.completedOn())
//                .param("miles", run.miles())
//                .param("location", run.location().toString())
//                .param(run.id())
//                .update();
//        Assert.state(updated == 1, "Failed to create run " + run.title());
//    }
    public void delete(Integer id){
        jdbcClient.sql("delete from Run where id = :id")
                .param("id" , id)
                .update();
    }
    public int count (){
        return jdbcClient.sql("select count(*) from Run")
                .query().listOfRows().size();
    }
    public void saveAll(List<Run> runs){
        runs.forEach(this::create);
    }
    public void deleteAll(){
        jdbcClient.sql("delete from Run")
                .update();
    }
    //delete all

}
