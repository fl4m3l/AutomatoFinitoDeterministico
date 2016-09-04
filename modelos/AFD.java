package modelos;

import java.util.ArrayList;

import excessoes.ResultadoFuncaoTransicaoInvalidoException;

public class AFD 
{
	private ArrayList<String> _alfabeto;
	private int _numeroEstados;
	private ArrayList<String> _regrasTransicao;
	private String _estadoInicial;
	private ArrayList<String> _estadoFinal;
	
	public AFD(ArrayList<String> alfabeto, int numeroEstados, ArrayList<String> regrasTransicao, 
			String estadoInicial, ArrayList<String> estadoFinal) 
	{
		_alfabeto = alfabeto;
		_numeroEstados = numeroEstados;
		_regrasTransicao = regrasTransicao;
		_estadoInicial = estadoInicial;
		_estadoFinal = estadoFinal;
	}
	
	private boolean temTransicao(String ch)
	{
		return ch.length() == 1;
	}
	
	public String funcaoTransicao(String estado, String elemento) 
			throws ResultadoFuncaoTransicaoInvalidoException
	{
		for (String ch : _regrasTransicao)
			if (ch.substring(0, 2).equals(estado + elemento))
					return ch.substring(2, 3);
		
		throw new ResultadoFuncaoTransicaoInvalidoException("Resultado da função é inválido.");
	}
	
	public boolean verificar(String entrada) throws ResultadoFuncaoTransicaoInvalidoException
	{
		String estadoAtual = _estadoInicial;
		
		for (int i = 0; i < entrada.length(); i++)
		{
			String resultadoTransicao = this.funcaoTransicao(estadoAtual, entrada.substring(i, i + 1));
			if (this.temTransicao(resultadoTransicao))
				estadoAtual = resultadoTransicao;
		}
		
		for (int i = 0; i < _estadoFinal.size(); i++)
			if (_estadoFinal.get(i).equals(estadoAtual))
				return true;
		
		return false;
	}
	
}
