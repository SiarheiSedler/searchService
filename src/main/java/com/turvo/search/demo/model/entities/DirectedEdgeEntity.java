package com.turvo.search.demo.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "GRAPH")
public class DirectedEdgeEntity {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "FROM_V")
    private int from;

    @Column(name = "TO_W")
    private int to;

    @Column(name = "DURATION")
    private Integer duration;

    public DirectedEdgeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectedEdgeEntity that = (DirectedEdgeEntity) o;
        return from == that.from &&
                to == that.to &&
                Objects.equals(id, that.id) &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, duration);
    }
}
