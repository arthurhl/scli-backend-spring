package les.scli.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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