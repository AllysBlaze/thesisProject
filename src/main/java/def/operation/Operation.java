package def.operation;

import def.machine.Machine;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue
    @Column(name = "operations_id")
    private Long id;
    @Column(name = "operations_name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_status")
    private OperationStatus operationStatus;

    @Column(name = "operation_planned_quantity")
    private Double plannedQuantity;

    @Column(name = "operation_notified_quantity")
    private Double notifiedQuantity;

    @Column(name = "operation_start_time")
    private Date operationStartTime;

    @Column(name = "operation_end_time")
    private Date operationEndTime;

    @Column(name = "operation_percentage_realized")
    private Double percentageRealized;

    public Operation(String name, Machine machine, Double plannedQuantity) {
        this.name = name;
        this.machine = machine;
        this.plannedQuantity = plannedQuantity;
        operationStatus = OperationStatus.published;
    }

    public Operation(Long id, String name, Machine machine, Double plannedQuantity) {
        this.id = id;
        this.name = name;
        this.machine = machine;
        this.plannedQuantity = plannedQuantity;
        operationStatus = OperationStatus.published;
    }

    public Operation() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Machine getMachine() {
        return machine;
    }

    public Double getPlannedQuantity() {
        return plannedQuantity;
    }

    public Double getNotifiedQuantity() {
        return notifiedQuantity;
    }

    public void setNotifiedQuantity(Double notifiedQuantity) {
        this.notifiedQuantity = notifiedQuantity;
    }

    public Date getOperationStartTime() {
        return operationStartTime;
    }

    public void setOperationStartTime(Date operationStartTime) {
        this.operationStartTime = operationStartTime;
    }

    public Date getOperationEndTime() {
        return operationEndTime;
    }

    public void setOperationEndTime(Date operationEndTime) {
        this.operationEndTime = operationEndTime;
    }

    public Double getPercentageRealized() {
        return percentageRealized;
    }

    public void setPercentageRealized() {
        if (plannedQuantity != 0 && notifiedQuantity != 0) {
            percentageRealized = notifiedQuantity / plannedQuantity * 100;
        } else {
            percentageRealized = 0d;
        }
    }

    @Override
    public String toString() {
        return machine.toString() + ", " + name + ", " + id;
    }

    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }
}
