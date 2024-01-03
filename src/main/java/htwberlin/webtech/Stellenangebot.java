package htwberlin.webtech;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Stellenangebot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;
    private String company;
    private String location;
    private String description;
    private String deadline;
    private String startDate;

    public Stellenangebot() {}

    public Stellenangebot(String jobTitle, String company, String location, String description, String deadline, String startDate) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.location = location;
        this.description = description;
        this.deadline = deadline;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stellenangebot)) return false;
        Stellenangebot that = (Stellenangebot) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getJobTitle(), that.getJobTitle()) &&
                Objects.equals(getCompany(), that.getCompany()) &&
                Objects.equals(getLocation(), that.getLocation());
    }


    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getJobTitle() != null ? getJobTitle().hashCode() : 0);
        result = 31 * result + (getCompany() != null ? getCompany().hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stellenangebot{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
