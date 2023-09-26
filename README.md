# Regular_Expression

Expressões regulares são utilizadas para identificar padrões, para isso temos que criar regras com o objetivo de validar um certo dado, por exemplo, verificar se o que foi digitado é um endereço válido de e-mail, se é um CPF ou número de telefone, se uma senha contém apenas letras ou se combina letras e caracteres especiais, etc.

Uma regra é composta por caracteres especiais que representam o comportamento ou tipo de dado. Alguns exemplos de regras que podemos construir para identificar o dado podem ser vistas abaixo:

***L1={w|w termine com aa ou bb}.***  ✏

***ER*** = (a+b)*(aa+bb)

***L2={w|w começa e termina com a}.***  ✏

***ER*** = a(a+b)*a

***L3={w|w termina com .png ou .jpeg ou .bmp}.*** ✏

***ER*** = .*(\\.png|\\.jpe?g|\\.bmp)

***L4={w|w aceita letras maiusculas ou minusculas}.*** ✏

***ER*** = [A-Za-z]*

	
	
	//ponto em uma expressão regular significa qualquer coisa
	//(.) qualquer simbolo dentro do alfabeto
	//.jpeg o caractere ".", de fato, diferenciamos um do outro com o  \\

Usando a linguagem de programação da sua escolha, crie um programa que receba
e valide a entrada do usuário para os seguintes formatos de dados, usando
expressões regulares:
1. CPF
2. Placa de carro (formato antigo e/ou novo)
3. Número de telefone (fixo e/ou celular)
4. Endereço de email
5. URL
6. Data
A validação dos formatos pode ser simplificada em relação ao que é permitido em
aplicações reais (por exemplo, a especificação de URLs em
https://www.w3.org/Addressing/URL/url-spec.html envolve muitas possibilidades).

## Alguns quantificadores 📌

+ n*: 0 ocorrencias de n
+ n+: 1 ou  muitas ocorrencias de n
+ n?: 0 ou 1 ocorrencia de n
+ n{x}: x ocorrencias de n
+ n{x,y}: x á y ocorrencias de n
+ n{x, }: pelo menos x ocorrencias de n

## Obervações
Embora a forma de construir as expressões regulares possam variar, dependendo da linguagem de programação utilizada, podemos citar alguns metacaracteres básicos de uma expressão:

+ ***\n*** quebra de linha
+ ***\t*** tabulação
+ ***\b*** backspace
+ ***\r*** cursor retorno

## Explicação para cada simbolo usado nas verificações

***//*** = escape, tudo que vem antes dele significa literalmente o caractere

```java
public static boolean validar_CPF(String CPF) {
		
		String ER_cpf = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
		return CPF.matches(ER_cpf);
	}
```

+ \\d representa um dígito (0-9).
+ {3} significa que o padrão anterior (dígito) deve ocorrer exatamente 3 vezes.
+ \\. corresponde ao caractere de ponto literal (".").
+ - corresponde ao caractere de hífen literal ("-").
+ - \\d{2} significa que o padrão anterior (dígito) deve ocorrer exatamente 2 vezes.

 ```java
public static boolean validar_placa_carro(String placa) {
		String ER_placa_carro = "[A-Z]{3}-\\d{4}|[A-Z]{3}\\d[A-Z]\\d{2}";
		return placa.matches(ER_placa_carro);
	}
```
 
+ [A-Z] corresponde a qualquer letra maiúscula de A a Z.
+ {3} significa que o padrão anterior (letra maiúscula) deve ocorrer exatamente 3 vezes.
+ - corresponde ao caractere de hífen literal ("-").
+ \\d{4} significa que o padrão anterior (dígito) deve ocorrer exatamente 4 vezes.
+ | representa o ***ou***, ou seja, a expressão aceita o formato antigo de placa (AAA-####) ou o novo (AAA1A22).("A" representa uma letra maiúscula e "#" representa um dígito).

```java
public static boolean validar_telefone(String telefone) {
		String ER_telefone = "\\(\\d{2}\\) \\d{4,5}-\\d{4}|\\(\\d{2}\\) \\d{4}-\\d{4,5}";
		return telefone.matches(ER_telefone);
	}
```
+ \\( corresponde ao caractere de parêntese aberto literal ("(").
+ \\d{2} significa que o padrão anterior (dígito) deve ocorrer exatamente 2 vezes.
+ \\) corresponde ao caractere de parêntese fechado literal (")").
+ " " corresponde ao caractere de espaço em branco literal.
+ \\d{4,5} significa que o padrão anterior (dígito) deve ocorrer entre 4 e 5 vezes.
+ - corresponde ao caractere de hífen literal ("-").
+ | representa o ***ou***, ou seja, a expressão aceita números de telefone com 4 ou 5 dígitos após o DDD.
Portanto, essa expressão regular valida números de telefone no formato "(DD) DDDDD-DDDD" ou "(DD) DDDDD-DDDDD", onde "DD" representa o código de área e "D" representa um dígito.

```java
public static boolean validar_email(String email) {
		String ER_email = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
		return email.matches(ER_email);
	}
```
+ [a-zA-Z0-9._%+-]+ corresponde a uma ou mais letras, dígitos ou caracteres especiais permitidos antes do "@".
+ @ corresponde ao caractere "@" literal.
+ [a-zA-Z0-9.-]+ corresponde a uma ou mais letras, dígitos, pontos ou hífens permitidos após o "@".
+ \\. corresponde ao caractere de ponto literal (".").
+ [a-zA-Z]{2,} significa que o padrão anterior (letra) deve ocorrer pelo menos 2 vezes após o último ponto.

```java
public static boolean validar_URL(String url) {
		String ER_url = "^(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}(/\\S*)?$";
		return url.matches(ER_url);
	}
```

+ ^ indica o início da string.
+ (http|https) corresponde a "http" ou "https".
+ :// corresponde aos caracteres "://" literalmente.
+ [a-zA-Z0-9.-]+ corresponde a uma ou mais letras, dígitos, pontos ou hífens no domínio.
\\. corresponde ao caractere de ponto literal (".").
[a-zA-Z]{2,4} significa que o padrão anterior (letra) deve ocorrer entre 2 e 4 vezes (domínio TLD).
(/\\S*)? corresponde a um caminho opcional após o domínio, que pode começar com "/" e incluir caracteres não espaços (opcional).
$ indica o fim da string.
Portanto, essa expressão regular valida URLs no formato "http://dominio.com" ou "https://dominio.com/caminho".

Validar Data:

String dataPattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
^ indica o início da string.
(0[1-9]|[12][0-9]|3[01]) corresponde a um dia válido no formato "dd". Aceita números de 01 a 31.
/(0[1-9]|1[0-2]) corresponde ao mês no formato "mm". Aceita números de 01 a 12.
/ corresponde ao caractere de barra literal ("/").
\\d{4} significa que o padrão anterior (dígito) deve ocorrer exatamente 4 vezes (ano).
$ indica o fim da string.
Portanto, essa expressão regular valida datas no formato "dd/mm/aaaa", onde "dd" é o dia, "mm" é o mês e "aaaa" é o ano.

Espero que estas explicações detalhadas das expressões regulares ajudem a compreender como cada uma delas funciona para validar os diferentes formatos de dados.




## Legenda: 📌
ER = Expressão Regular

