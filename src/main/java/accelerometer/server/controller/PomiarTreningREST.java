package accelerometer.server.controller;

import accelerometer.server.model.PomiarTrening;
import accelerometer.server.model.PomiarTreningModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/trening")
public class PomiarTreningREST {

    private static final Logger log = LoggerFactory.getLogger(PomiarTreningREST.class);

    @Autowired
    private CassandraOperations cassandraTemplate;

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity newPomiar(@RequestBody @Valid PomiarTreningModel pomiarTreningModel) {

        if (log.isInfoEnabled()) {
            log.info("/POST /pomiarTrening with values {}", pomiarTreningModel);
        }

        PomiarTrening pomiarTrening = new PomiarTrening(pomiarTreningModel);
        cassandraTemplate.insert(pomiarTrening);

        return status(CREATED).build();
    }

}
