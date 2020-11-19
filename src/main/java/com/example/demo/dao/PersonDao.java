package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class PersonDao {

    JdbcTemplate template;
@Autowired
    public PersonDao(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Person p){
            String sql="insert into persons(person_id,first_name,last_name) values("+p.getId()+",'"+p.getFirstName()+"','"+p.getLastName()+"')";
            return template.update(sql);
        }
        public int update(Person p){
            String sql="update persons set first_name='"+p.getFirstName()+"', last_name='"+p.getLastName()+"' where person_id="+p.getId()+"";
            return template.update(sql);
        }
        public int delete(int id){
            String sql="delete from persons where person_id="+id+"";
            return template.update(sql);
        }
        public Person getPersonById(int id){
            String sql="select * from persons where person_id=?";
            return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Person>(Person.class));
        }
        public List<Person> getPeople(){
            return template.query("select * from persons",new RowMapper<Person>(){
                public Person mapRow(ResultSet rs, int row) throws SQLException {
                    Person e=new Person();
                    e.setId(rs.getInt(1));
                    e.setFirstName(rs.getString(2));
                    e.setLastName(rs.getString(3));

                    return e;
                }
            });
        }
    }