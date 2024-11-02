package io.github.feilian1999.kkdiary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String correction;
    private String reason;
    private int startPos;
    private int endPos;

    protected  Revision(){
    }

    public Revision(String correction, String reason, int startPos, int endPos) {
        this.correction = correction;
        this.reason = reason;
        this.startPos = startPos;
        this.endPos = endPos;
    }
}