package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import excessoes.AlfabetoInvalidoException;
import excessoes.EstadoInvalidoException;
import excessoes.ResultadoFuncaoTransicaoInvalidoException;
import modelos.AFD;

public class TesteAFDabcComoPrefixo
{
	private AFD afd;
	
	@Before
	public void criaAFD()
	{	
		ArrayList<String> alfabeto = new ArrayList<>();
		ArrayList<String> regrasTransicao = new ArrayList<>();
		ArrayList<String> estadoFinal = new ArrayList<>();
		alfabeto.add("a");
		alfabeto.add("b");
		alfabeto.add("c");
		regrasTransicao.add("1a2");
		regrasTransicao.add("1b1");
		regrasTransicao.add("1c1");
		regrasTransicao.add("2a1");
		regrasTransicao.add("2b3");
		regrasTransicao.add("2c1");
		regrasTransicao.add("3a2");
		regrasTransicao.add("3b2");
		regrasTransicao.add("3c4");
		regrasTransicao.add("4a4");
		regrasTransicao.add("4b4");
		regrasTransicao.add("4c4");

		estadoFinal.add("4");
		afd = new AFD(alfabeto, 4, regrasTransicao, "1", estadoFinal);
	}
	
	@Test
	public void retornaProximoEstadoComSucesso()
	{
		try
		{
			assertEquals("4", afd.funcaoTransicao("3", "c"));
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
			assertEquals("Resultado da função é inválido.", afd.funcaoTransicao("1", "d"));
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
			assertTrue(afd.verificar("abcaaabca"));
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
			assertFalse(afd.verificar("aaba"));
		} 
		catch (ResultadoFuncaoTransicaoInvalidoException e) 
		{
			System.out.println(e.getMessage());
		}
	}

}
