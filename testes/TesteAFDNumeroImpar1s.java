package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import excessoes.AlfabetoInvalidoException;
import excessoes.EstadoInvalidoException;
import excessoes.ResultadoFuncaoTransicaoInvalidoException;
import modelos.AFD;

public class TesteAFDNumeroImpar1s
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
		regrasTransicao.add("101");
		regrasTransicao.add("112");
		regrasTransicao.add("202");
		regrasTransicao.add("211");

		estadoFinal.add("2");
		
		afd = new AFD(alfabeto, 2, regrasTransicao, "1", estadoFinal);
	}
	
	@Test
	public void retornaProximoEstadoComSucesso()
	{
		try
		{
			assertEquals("2", afd.funcaoTransicao("2", "0"));
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
			assertTrue(afd.verificar("001110"));
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
