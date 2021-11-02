package com.ayupovmi.pmapp.model;
/**
* Simple Javabean domain object that represents Task.
*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "submissionDate")
    private String submissionDate;
    @Column(name = "startDate")
    private String startDate;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSubmissionDateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.submissionDate);
    }

    public void setSubmissionDate(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.submissionDate = dateFormat.format(submissionDate);
    }
    public Date getStartDateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.startDate);
    }

    public void setStartDate(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.startDate = dateFormat.format(startDate);
    }
}
