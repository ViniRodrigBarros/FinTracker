package com.example.fintracker.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "agencia")
    private String agencia;

    @Column(name = "conta")
    private String conta;

    @Column(name = "banco_nome")
    private String bancoNome;

    @Column(name = "saldo")
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Método para obter o ID da conta e o ID do usuário pelo ID do usuário
    public static Long[] getIdsByUserId(EntityManager entityManager, Long userId) {
        // Consulta JPQL para obter o ID da conta e o ID do usuário com base no ID do usuário
        String jpql = "SELECT a.id, u.id FROM Account a INNER JOIN a.user u WHERE u.id = :userId";

        Object[] result = (Object[]) entityManager.createQuery(jpql)
                .setParameter("userId", userId)
                .getSingleResult();

        if (result != null && result.length == 2) {
            Long accountId = (Long) result[0];
            Long userIdFromAccount = (Long) result[1];
            return new Long[]{accountId, userIdFromAccount};
        } else {
            // Se não houver resultados, retorne null ou trate conforme necessário
            return null;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public void setBancoNome(String bancoNome) {
        this.bancoNome = bancoNome;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
