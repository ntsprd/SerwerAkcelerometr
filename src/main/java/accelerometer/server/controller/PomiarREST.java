package accelerometer.server.model;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import javax.validation.Valid;

import accelerometer.server.model.PomiarModel;
import accelerometer.server.model.Pomiar;
import accelerometer.server.model.Wynik;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pomiar")
public class PomiarREST {

    private static final Logger logger = LoggerFactory.getLogger(PomiarREST.class);

    @Autowired
    public CassandraOperations cassandraTemplate;

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity newPomiar(@RequestBody @Valid PomiarModel pomiarModel) {

        Pomiar pomiar = new Pomiar(pomiarModel);

        if (logger.isInfoEnabled()) {
            logger.info("/POST /pomiar wartosci {}", pomiar);
        }

        cassandraTemplate.insert(pomiar);
        return status(CREATED).build();
    }

    @RequestMapping(method = RequestMethod.GET, produces = TEXT_HTML_VALUE)
    public ResponseEntity<String> getLastPrediction() {
        Wynik wynik = cassandraTemplate.select("select * from result where user_id='TEST_USER' limit 1", Wynik.class).get(0);

        StringBuilder builder = new StringBuilder("<header><META HTTP-EQUIV=\"refresh\" CONTENT=\"5\"></header>");
        builder.append("<h1> Aktywnosc = " + wynik.getWynik() + "</h1>");

        ResponseEntity response = new ResponseEntity(builder.toString(), FOUND);

        return response;
    }
}
