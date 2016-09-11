/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author manav
 */
public class MarksModel {
    private int studentId;
    private int subjectId;
    private int mark;
    private String examTerminal;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getExamTerminal() {
        return examTerminal;
    }

    public void setExamTerminal(String examTerminal) {
        this.examTerminal = examTerminal;
    }
    
    
    
}
