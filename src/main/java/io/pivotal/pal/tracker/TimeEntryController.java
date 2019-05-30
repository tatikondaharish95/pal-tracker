package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        //System.out.println();
        //timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable("id") long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry obj =timeEntryRepository.update(timeEntryId,expected);
        if( null != obj){
            return new ResponseEntity(obj,HttpStatus.OK);
        }
        else {
         return new ResponseEntity(HttpStatus.NOT_FOUND) ;
    }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value="/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long nonExistentTimeEntryId) {

        TimeEntry obj = timeEntryRepository.find(nonExistentTimeEntryId);
        if(obj != null){
            return new ResponseEntity<TimeEntry>(obj, HttpStatus.OK);
        }
        else
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<List<TimeEntry>> list() throws Exception {
        return new ResponseEntity<List<TimeEntry>>(timeEntryRepository.list(),HttpStatus.OK);

    }
}
