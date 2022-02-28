<h1> Calculo-Imposto-de-Renda</h1>
Api Rest- Calculo de Imposto de Renda com no modelo orientado a documentos com MongoDB.
A Api propoe a entrega de uma solução para cálculo de impostos como INSS E IRPF baseados na tabela 1 e tabela 2.
<br/>
<table>
	<p dir="auto">*<em>O valor máximo do INSS é R$ 642,34</em></p>
<h4 dir="auto"><a id="user-content-tabela-2---irpf-2019" class="anchor" aria-hidden="true" href="#tabela-2---irpf-2019"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>Tabela 1 - INSS 2019*</h4>
<table>
<thead>
<tr>
<th align="center">Salário (R$)</th>
<th align="center">Alíquota (%)</th>
</tr>
</thead>
<tbody>
<tr>
<td align="center">Até 1.751,81</td>
<td align="center">8,00%</td>
</tr>
<tr>
<td align="center">De 1.751,82 até 2.919,72</td>
<td align="center">9,00%</td>
</tr>
<tr>
<td align="center">De 2.919,73 até 5.839,45*</td>
<td align="center">11,00%</td>
</tr>
</tbody>
</table>
<p dir="auto">*<em>O valor máximo do INSS é R$ 642,34</em></p>
<h4 dir="auto"><a id="user-content-tabela-2---irpf-2019" class="anchor" aria-hidden="true" href="#tabela-2---irpf-2019"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>Tabela 2 - IRPF 2019*</h4>
<table>
<thead>
<tr>
<th align="center">Salário (R$)</th>
<th align="center">Alíquota (%)</th>
<th align="center">Desconto (R$)</th>
</tr>
</thead>
<tbody>
<tr>
<td align="center">Até 1.903,98</td>
<td align="center">0%</td>
<td align="center">R$ 0,00</td>
</tr>
<tr>
<td align="center">De 1.903,99 até 2.826,65</td>
<td align="center">7,5%</td>
<td align="center">R$ 142,80</td>
</tr>
<tr>
<td align="center">De 2.826,66 até 3.751,05</td>
<td align="center">15%</td>
<td align="center">R$ 354,80</td>
</tr>
<tr>
<td align="center">De 3.751,06 até 4.664,68</td>
<td align="center">22,5%</td>
<td align="center">R$ 636,13</td>
</tr>
<tr>
<td align="center">Acima de 4.664,68</td>
<td align="center">27,5%</td>
<td align="center">R$ 869,36</td>
</tr>
</tbody>
</table>
	
<h3>#Endpoints User</h3>
Listar usuários:
http://localhost:8080/users
<br/>

Usuários por id:
http://localhost:8080/users/{id}
<br/>

<h3>#Endpoints User Salary</h3>
http://localhost:8080/users/{id}/salary
<br/>

<br/>
##Tecnologias usadas<br/>
Java (versão 11 )<br/>
Banco de Dados (MongoDB)<br/>
Maven (versão 3.6.1 )<br/>
