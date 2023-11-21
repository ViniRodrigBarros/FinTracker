package gestor.finance.api.controller;

import Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public List<Map<String, Object>> getEmailSenha(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String senha = requestBody.get("senha");
        System.out.println(senha);

        String sql = "SELECT id, email, password FROM users WHERE email = ? AND password = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, email, senha);
        if(result.isEmpty()){
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Email ou senha incorretos");
            return (List<Map<String, Object>>) errorResponse;
        }
        return result;
    }
}
