package les.scli.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Gerente implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column()
  private String nome;

  @Column()
  private String cpf;

  @Column()
  private String email;

  @Column()
  private String senha;

  @Column()
  private String uf;

  @Column()
  private String cidade;

  @Column()
  private String bairro;

  @Column()
  private String rua;
}