package org.beduin.hl.socialnetwork.repos;

import lombok.AllArgsConstructor;
import org.beduin.hl.socialnetwork.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;
import java.sql.PreparedStatement;

@Repository
@AllArgsConstructor
public class UserRepository implements IUserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<UserDto> getUser(Integer id) {
        System.out.println("Get User --- Дошли до репозитория");
        String query="select u.id, u.first_name, u.last_name, u.city, u.email, u.birthdate, u.gender " +
                "from users u where u.id = ? and isdeleted =false ;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(UserDto.class), id).stream().findAny();
    }

    @Override
    public void storeUser(UserDto item) {

        System.out.println("----- Store User - Дошли до репозитория");

        String query = "INSERT INTO users (first_name, last_name, city, email,  isdeleted, birthdate, gender) " +
                "VALUES(?, ?, ?, ?, false, ?, ?)";

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(query, new String[]{});
            ps.setString(1, item.getFirstName());
            ps.setString(2, item.getLastName());
            ps.setString(3, item.getCity());
            ps.setString(4, item.getEmail());
            ps.setDate(5, item.getBirthdate());
            ps.setString(6, item.getGender());
            return ps;
        });
    }

    public Collection<UserDto> getUsers() {
        System.out.println("Get User List ---- Дошли до репозитория");
                String query = "select u.id, u.first_name, u.last_name, u.city, u.email, u.birthdate, u.gender " +
                        "from users u order by u.id";
                return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(UserDto.class));
            }
}
