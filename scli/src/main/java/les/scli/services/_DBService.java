package les.scli.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import les.scli.model.Cliente;
import les.scli.model.EmpresaTerceirizada;
import les.scli.model.Fornecedor;
import les.scli.model.Funcionario;
import les.scli.model.Gerente;
import les.scli.model.ItemPedido;
import les.scli.model.ItemReposicao;
import les.scli.model.Orcamento;
import les.scli.model.Pedido;
import les.scli.model.Produto;
import les.scli.model.RealizarServicoEmpresa;
import les.scli.model.RealizarServicoFuncionario;
import les.scli.model.Reposicao;
import les.scli.model.Servico;
import les.scli.repositories.ClienteRepository;
import les.scli.repositories.EmpresaTerceirizadaRepository;
import les.scli.repositories.FornecedorRepository;
import les.scli.repositories.FuncionarioRepository;
import les.scli.repositories.GerenteRepository;
import les.scli.repositories.ItemPedidoRepository;
import les.scli.repositories.ItemReposicaoRepository;
import les.scli.repositories.OrcamentoRepository;
import les.scli.repositories.PedidoRepository;
import les.scli.repositories.ProdutoRepository;
import les.scli.repositories.RealizarServicoEmpresaRepository;
import les.scli.repositories.RealizarServicoFuncionarioRepository;
import les.scli.repositories.ReposicaoRepository;
import les.scli.repositories.ServicoRepository;

@Service
public class _DBService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EmpresaTerceirizadaRepository empresaTerceirizadaRepository;

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private ReposicaoRepository reposicaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private RealizarServicoFuncionarioRepository realizarServicoFuncionarioRepository;

    @Autowired
    private RealizarServicoEmpresaRepository realizarServicoEmpresaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ItemReposicaoRepository itemReposicaoRepository;
    
    public void instantiateTestDatabase() throws ParseException, IOException {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Cliente cli1 = new Cliente(null, "Nome1", "12345678912", "email@gmail.com", "123","ES", "Pequia", "Centro", "Rua Gustavo Lima");
        Cliente cli2 = new Cliente(null, "Nome2", "12345678912", "email@gmail.com", "123","ES", "Pequia", "Centro", "Rua Gustavo Lima");

        Fornecedor for1 = new Fornecedor(null, "Nome1", "12345678912", "ES", "Pequia", "Centro", "Rua Gustavo Lima");
        Fornecedor for2 = new Fornecedor(null, "Nome2", "12345678912", "ES", "Pequia", "Centro", "Rua Gustavo Lima");
       
        Gerente ger1 = new Gerente(null, "Nome1", "12345678912", "email@gmail.com", "123","ES", "Pequia", "Centro", "Rua Gustavo Lima");
        Gerente ger2 = new Gerente(null, "Nome2", "12345678912", "email@gmail.com", "123","ES", "Pequia", "Centro", "Rua Gustavo Lima");

        Funcionario fun1 = new Funcionario(null, "Nome1", "12345678912", "email@gmail.com", "123","ES", "Pequia", "Centro", "Rua Gustavo Lima");
        Funcionario fun2 = new Funcionario(null, "Nome2", "12345678912", "email@gmail.com", "123","ES", "Pequia", "Centro", "Rua Gustavo Lima");

        EmpresaTerceirizada emp1 = new EmpresaTerceirizada(null, "Nome1", "12345678912345", "ES", "Pequia", "Centro", "Rua Gustavo Lima");
        EmpresaTerceirizada emp2 = new EmpresaTerceirizada(null, "Nome2", "12345678912345", "ES", "Pequia", "Centro", "Rua Gustavo Lima");

        Orcamento orc1 = new Orcamento(null, sdf.parse("2022-01-01"), sdf.parse("2022-01-01"), "Descricao1", 10.00, cli1, fun1);
        Orcamento orc2 = new Orcamento(null, sdf.parse("2022-01-01"), sdf.parse("2022-01-01"), "Descricao2", 10.00, cli2, fun2); 

        Reposicao rep1 = new Reposicao(null, 10, ger1, for1);
        Reposicao rep2 = new Reposicao(null, 10, ger2, for2);

        Produto pro1 = new Produto(null, "Produto1", 10.00, 10,"Descricao1");
        Produto pro2 = new Produto(null, "Produto2", 10.00, 10,"Descricao2");

        Servico ser1 = new Servico(null, false, orc1);
        Servico ser2 = new Servico(null, false, orc2);

        RealizarServicoFuncionario rsf1 = new RealizarServicoFuncionario(null, sdf.parse("2022-01-01"), false, false, ser1, fun1);
        RealizarServicoFuncionario rsf2 = new RealizarServicoFuncionario(null, sdf.parse("2022-01-01"), false, false, ser2, fun2);

        RealizarServicoEmpresa rse1 = new RealizarServicoEmpresa(null, sdf.parse("2022-01-01"), false, false, false, ser1, emp1);
        RealizarServicoEmpresa rse2 = new RealizarServicoEmpresa(null, sdf.parse("2022-01-01"), false, false, false, ser2, emp2);

        Pedido ped1 = new Pedido(null, "Endereco1", 10.00, "28123123123",cli1);
        Pedido ped2 = new Pedido(null, "Endereco2", 10.00, "28123123123",cli2);

        ItemPedido itp1 = new ItemPedido(ped1, pro1, 10.00);
        ItemPedido itp2 = new ItemPedido(ped2, pro2, 10.00);

        ItemReposicao itr1 = new ItemReposicao(pro1,rep1, 1);
        ItemReposicao itr2 = new ItemReposicao(pro2,rep2,2);

        pro1.setFornecedores(Arrays.asList(for1));
        pro2.setFornecedores(Arrays.asList(for2));
       
        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        fornecedorRepository.saveAll(Arrays.asList(for1, for2));
        gerenteRepository.saveAll(Arrays.asList(ger1, ger2));
        funcionarioRepository.saveAll(Arrays.asList(fun1, fun2));
        empresaTerceirizadaRepository.saveAll(Arrays.asList(emp1, emp2));
        orcamentoRepository.saveAll(Arrays.asList(orc1, orc2));
        reposicaoRepository.saveAll(Arrays.asList(rep1, rep2));
        produtoRepository.saveAll(Arrays.asList(pro1, pro2));
        servicoRepository.saveAll(Arrays.asList(ser1, ser2));
        realizarServicoFuncionarioRepository.saveAll(Arrays.asList(rsf1,rsf2));
        realizarServicoEmpresaRepository.saveAll(Arrays.asList(rse1,rse2));
        pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
        itemPedidoRepository.saveAll(Arrays.asList(itp1,itp2));
        itemReposicaoRepository.saveAll(Arrays.asList(itr1,itr2));
    }
}
