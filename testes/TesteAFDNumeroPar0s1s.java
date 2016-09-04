package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import excessoes.AlfabetoInvalidoException;
import excessoes.EstadoInvalidoException;
import excessoes.ResultadoFuncaoTransicaoInvalidoException;
import modelos.AFD;

public class TesteAFDNumeroPar0s1s 
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
		regrasTransicao.add("103");
		regrasTransicao.add("112");
		regrasTransicao.add("204");
		regrasTransicao.add("211");
		regrasTransicao.add("301");
		regrasTransicao.add("314");
		regrasTransicao.add("402");
		regrasTransicao.add("413");
		
		estadoFinal.add("1");
		
		afd = new AFD(alfabeto, 4, regrasTransicao, "1", estadoFinal);
	}
	
	@Test
	public void retornaProximoEstadoComSucesso()
	{
		try
		{
			assertEquals("3", afd.funcaoTransicao("4", "1"));
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
			assertTrue(afd.verificar("110101"));
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
