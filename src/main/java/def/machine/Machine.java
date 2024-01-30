package def.machine;

import jakarta.persistence.*;

@Entity
@Table(name = "machine")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_id")
    private Long id;
    @Column(name = "machine_name")
    private String name;

    public Machine(String name) {
        this.name = name;
    }

    public Machine(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Machine() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
