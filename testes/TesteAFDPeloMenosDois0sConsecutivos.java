package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import excessoes.AlfabetoInvalidoException;
import excessoes.EstadoInvalidoException;
import excessoes.ResultadoFuncaoTransicaoInvalidoException;
import modelos.AFD;

public class TesteAFDPeloMenosDois0sConsecutivos
{
	private AFD afd;
	
	@Before
	public void criaAFD()
	{	
		ArrayList<String> alfabeto = new ArrayList<>();
		ArrayList<String> regrasTransicao = new ArrayList<>();
		ArrayList<String> estadoFinal = new ArrayList<>();
		alfabeto.add("0");
		alfabeto.add("1");
		regrasTransicao.add("102");
		regrasTransicao.add("111");
		regrasTransicao.add("203");
		regrasTransicao.add("211");
		regrasTransicao.add("303");
		regrasTransicao.add("313");
		
		estadoFinal.add("3");
		
		afd = new AFD(alfabeto, 3, regrasTransicao, "1", estadoFinal);
	}
	
	@Test
	public void retornaProximoEstadoComSucesso()
	{
		try
		{
			assertEquals("3", afd.funcaoTransicao("3", "1"));
		} 
		catch (ResultadoFuncaoTransicaoInvalidoException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void falhaAoRetornarProximoEstado()
	{
		try 
		{
			assertEquals("Resultado da função é inválido.", afd.funcaoTransicao("1", "2"));
		} 
		catch (ResultadoFuncaoTransicaoInvalidoException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void retornaSaidaDoAutomatoComSucesso() 
	{
		try 
		{
			assertTrue(afd.verificar("1110010101"));
		} 
		catch (ResultadoFuncaoTransicaoInvalidoException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void retornaSaidaDoAutomatoSemSucesso() 
	{
		try 
		{
			assertFalse(afd.verificar("110"));
		} 
		catch (ResultadoFuncaoTransicaoInvalidoException e) 
		{
			System.out.println(e.getMessage());
		}
	}

}
