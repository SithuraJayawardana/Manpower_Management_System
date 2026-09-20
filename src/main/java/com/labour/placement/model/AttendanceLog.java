package com.labour.placement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "attendance_logs",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_placement_date", columnNames = {"placement_id", "work_date"})
    }
)
public class AttendanceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placement_id", nullable = false)
    private Placement placement;

    @Column(name = "work_date", nullable = false)
    private LocalDate workDate;

    @Column(name = "status", nullable = false, length = 20)
    private String status = "PRESENT"; // PRESENT, ABSENT, HALF_DAY

    @Column(name = "hours_worked", nullable = false, precision = 4, scale = 1)
    private BigDecimal hoursWorked = new BigDecimal("8.0");

    @Column(name = "remarks", length = 255)
    private String remarks;

    @Column(name = "logged_at", updatable = false)
    private LocalDateTime loggedAt;

    public AttendanceLog() {
    }

    public AttendanceLog(Placement placement, LocalDate workDate, String status, BigDecimal hoursWorked, String remarks) {
        this.placement = placement;
        this.workDate = workDate;
        this.status = (status != null) ? status : "PRESENT";
        this.hoursWorked = (hoursWorked != null) ? hoursWorked : new BigDecimal("8.0");
        this.remarks = remarks;
    }

    @PrePersist
    protected void onCreate() {
        if (this.loggedAt == null) {
            this.loggedAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(BigDecimal hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }

    @Override
    public String toString() {
        return "AttendanceLog{" +
                "id=" + id +
                ", workDate=" + workDate +
                ", status='" + status + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
