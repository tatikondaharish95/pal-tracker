package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry find(Long id) throws NullPointerException;
    public List list() throws Exception;
    public TimeEntry update(Long id, TimeEntry timeEntry);
    public void delete(Long id);
}
