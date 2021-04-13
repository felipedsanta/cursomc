package com.felps.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felps.cursomc.domain.Categoria;
import com.felps.cursomc.domain.Cidade;
import com.felps.cursomc.domain.Cliente;
import com.felps.cursomc.domain.Endereco;
import com.felps.cursomc.domain.Estado;
import com.felps.cursomc.domain.ItemPedido;
import com.felps.cursomc.domain.Pagamento;
import com.felps.cursomc.domain.PagamentoComBoleto;
import com.felps.cursomc.domain.PagamentoComCartao;
import com.felps.cursomc.domain.Pedido;
import com.felps.cursomc.domain.Produto;
import com.felps.cursomc.domain.enums.EstadoPagamento;
import com.felps.cursomc.domain.enums.TipoCliente;
import com.felps.cursomc.repositories.CategoriaRepository;
import com.felps.cursomc.repositories.CidadeRepository;
import com.felps.cursomc.repositories.ClienteRepository;
import com.felps.cursomc.repositories.EnderecoRepository;
import com.felps.cursomc.repositories.EstadoRepository;
import com.felps.cursomc.repositories.ItemPedidoRepository;
import com.felps.cursomc.repositories.PagamentoRepository;
import com.felps.cursomc.repositories.PedidoRepository;
import com.felps.cursomc.repositories.ProdutoRepository;

@Service
public class DBservice {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2,p4));
		cat3.getProdutos().addAll(Arrays.asList(p5,p6));
		cat4.getProdutos().addAll(Arrays.asList(p1,p2,p3,p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9,p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Bahia");
		
		

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Salvador", est3);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		est3.getCidades().addAll(Arrays.asList(c4));

		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		Cliente cli1 = new Cliente(null, "Felipe Santos", "felipe@gmail.com", "09552930570", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("71993208108", "93838393"));

		Cliente cli2 = new Cliente(null, "Bruna Louise", "Louise@gmail.com", "08573960570", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("71993376368"));
		
		Endereco e1 = new Endereco(null, "Tv Santa luzia", "5", "Apto 303", "Estrada das barreiras", "41195520", cli1, c4);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777834", cli1, c2);
		Endereco e3 = new Endereco(null, "Travessa Wolf", "69", "Apto 303", "Ribeira", "52210520", cli2, c4);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2, e3));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2020 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2020 19:32"), cli1, e2);
		Pedido ped3 = new Pedido(null, sdf.parse("12/04/2021 14:32"), cli2, e3);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2020 00:00"),null);
		ped2.setPagamento(pagto2);
		
		Pagamento pagto3 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped3, sdf.parse("20/04/2021 00:00"),null);
		ped3.setPagamento(pagto3);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		cli2.getPedidos().addAll(Arrays.asList(ped3));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2,ped3));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2,pagto3));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped1, p2, 100.00 , 1, 800.00);
		ItemPedido ip4 = new ItemPedido(ped3, p5, 0.00 , 1, 50.00);
		ItemPedido ip5 = new ItemPedido(ped3, p11, 0.00 , 1, 100.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		ped3.getItens().addAll(Arrays.asList(ip4, ip5));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		p4.getItens().addAll(Arrays.asList(ip4));
		p5.getItens().addAll(Arrays.asList(ip5));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3,ip4,ip5));
		
	}

}
