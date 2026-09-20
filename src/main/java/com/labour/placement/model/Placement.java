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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "placements")
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requisition_id", nullable = false)
    private Requisition requisition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "labourer_id", nullable = false)
    private Labourer labourer;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "agreed_daily_wage", nullable = false, precision = 10, scale = 2)
    private BigDecimal agreedDailyWage;

    @Column(name = "status", nullable = false, length = 20)
    private String status = "ACTIVE"; // ACTIVE, COMPLETED, TERMINATED

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Placement() {
    }

    public Placement(Requisition requisition, Labourer labourer, LocalDate startDate, LocalDate endDate, BigDecimal agreedDailyWage, String status) {
        this.requisition = requisition;
        this.labourer = labourer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.agreedDailyWage = agreedDailyWage;
        this.status = (status != null) ? status : "ACTIVE";
    }

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Requisition getRequisition() {
        return requisition;
    }

    public void setRequisition(Requisition requisition) {
        this.requisition = requisition;
    }

    public Labourer getLabourer() {
        return labourer;
    }

    public void setLabourer(Labourer labourer) {
        this.labourer = labourer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getAgreedDailyWage() {
        return agreedDailyWage;
    }

    public void setAgreedDailyWage(BigDecimal agreedDailyWage) {
        this.agreedDailyWage = agreedDailyWage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Placement{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", agreedDailyWage=" + agreedDailyWage +
                ", status='" + status + '\'' +
                '}';
    }
}
