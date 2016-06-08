package com.quasar.hibernateh2.dao.entity;


import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Irbis
 */
@Entity
@Table(name = "group_s")
/* Group это зарезервированное SQL слово, а имя таблицы не экранируется в ORM по 
* некоторым объективным причинам (не могу вспомнить, где я объяснение видел). 
* Назовите класс или таблицу иначе, либо добавьте экранирование @Table(name="\"group\"")
*/
public class Groups extends Model implements Serializable {

    private static final long serialVersionUID = -767942793051535537L;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "group")
    private Set<Student> students;

    public Groups() {
        name = null;
    }

    public Groups(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return getName();
    }

}
