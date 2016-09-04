package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import excessoes.AlfabetoInvalidoException;
import excessoes.EstadoInvalidoException;
import excessoes.ResultadoFuncaoTransicaoInvalidoException;
import modelos.AFD;

public class TesteAFDxyxComoSubpalavra
{
private AFD afd;
	
	@Before
	public void criaAFD()
	{	
		ArrayList<String> alfabeto = new ArrayList<>();
		ArrayList<String> regrasTransicao = new ArrayList<>();
		ArrayList<String> estadoFinal = new ArrayList<>();
		alfabeto.add("x");
		alfabeto.add("y");
		alfabeto.add("z");
		regrasTransicao.add("1x2");
		regrasTransicao.add("1y1");
		regrasTransicao.add("1z1");
		regrasTransicao.add("2x2");
		regrasTransicao.add("2y3");
		regrasTransicao.add("2z1");
		regrasTransicao.add("3x4");
		regrasTransicao.add("3y1");
		regrasTransicao.add("3z1");
		regrasTransicao.add("4x4");
		regrasTransicao.add("4y4");
		regrasTransicao.add("4z4");
		
		estadoFinal.add("4");
		
		afd = new AFD(alfabeto, 4, regrasTransicao, "1", estadoFinal);
	}
	
	@Test
	public void retornaProximoEstadoComSucesso()
	{
		try
		{
			assertEquals("4", afd.funcaoTransicao("4", "x"));
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
			assertEquals("Resultado da função é inválido.", afd.funcaoTransicao("1", "w"));
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
			assertTrue(afd.verificar("xyzyxyxzzz"));
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
			assertFalse(afd.verificar("xyz"));
		} 
		catch (ResultadoFuncaoTransicaoInvalidoException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
