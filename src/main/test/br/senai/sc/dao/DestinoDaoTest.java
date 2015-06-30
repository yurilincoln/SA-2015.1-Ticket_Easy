//package br.senai.sc.dao;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import br.senai.sc.configuration.JUnitRunner;
//import br.senai.sc.entity.Destino;
//
//@RunWith(JUnitRunner.class)
//public class DestinoDaoTest {
//
//private static DestinoDao dao;
//	
//	@Before
//	public void initTest() {
//		dao = new DestinoDao();
//	}
//	
//	@After
//	public void finishTest() {
//		dao = null;
//	}
//	
//	@Test
//	public void SalvarNovoDestinoTest() {
//		Destino d = new Destino();
//		d.setNome("Maracanâ");
//		d.setBairro("Maracana");
//		d.setCidade("Rio de Janeiro");
//		d.setEstado("RJ");
//		d.setHoraAbertura("06:00");
//		d.setHoraFechamento("12:00");
//		d.setValor((double) 240);
//		d.setDescricao("blaa");
//		d.setObersevacoes("bluu");
//			
//		dao.save(d);
//		
//		assertTrue(d.getId() != null);
//		
//	}
//	
//}
