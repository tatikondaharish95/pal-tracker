package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    Map<Long, TimeEntry> timeEntryHashMap = new HashMap<>();
    private long userId = 0L;

    public TimeEntry create(TimeEntry timeEntry) {

        userId=userId+1;
        timeEntry.setId(userId);
        timeEntryHashMap.put(userId,timeEntry);
        return timeEntry;
    }

    public TimeEntry find(Long id) throws NullPointerException {
        TimeEntry obj = timeEntryHashMap.get(id);
        if( obj != null){
            return  obj;
        }
        else return null;
    }

    public List list() throws Exception {
        ArrayList<TimeEntry> result = new ArrayList<>();
        for(Map.Entry<Long, TimeEntry> me : timeEntryHashMap.entrySet()){
            result.add(timeEntryHashMap.get(me.getKey()));
        }

        return result;
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) throws NullPointerException {
        if(timeEntryHashMap.containsKey(id)){
            //timeEntryHashMap.remove(id);
            timeEntry.setId(userId);
            timeEntryHashMap.put(id, timeEntry);
            return timeEntryHashMap.get(id);
        }

        return null;
    }

    public void delete(Long id)
    {
        timeEntryHashMap.remove(id);
    }
}
