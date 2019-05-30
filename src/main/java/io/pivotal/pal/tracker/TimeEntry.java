package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long projectId, long userId, LocalDate parse, int i) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = parse;
        this.hours = i;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate parse, int i) {
        this.id = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = parse;
        this.hours = i;
    }

    public TimeEntry() {
    }

    /*public TimeEntry createObject(long id, TimeEntry obj){
        return new TimeEntry(id, obj.getProjectId(), obj.getUserId(), obj.getDate(), obj.getHours() );
    }*/
    public long getId() {
        return id;
    }

    public long getProjectId(){
        return projectId;
    }
    public long getUserId(){
        return userId;
    }
    public LocalDate getDate(){
        return date;
    }
    public int getHours(){
        return hours;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof TimeEntry)) return false;
        else if(obj == null) return false;
        else {
            TimeEntry timeEntry = (TimeEntry) obj;
            return (timeEntry.id==((TimeEntry) obj).getId() && timeEntry.projectId == ((TimeEntry) obj).getProjectId()
            && timeEntry.userId == ((TimeEntry) obj).getUserId() && timeEntry.date == ((TimeEntry) obj).getDate() && timeEntry.hours == ((TimeEntry) obj).getHours());
        }
    }

    @Override
    public int hashCode() {
       int result = 17;
        result =  31*result+ (int) id;
        result = 31*result+ (int)projectId;
        result = 31*result+(int) userId;
        result = 31*result+(int) hours;
        result = 31*result+(date.toString()).hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }
}
