# Compiladores
 
 **Material do curso de compiladores**

 * CompilerBase: classes abstratas

 * TesteLL: teste de um parser LL para expressões parcialmente parentisas contendo as quatro operações.

 * TesteLR: teste de um parser LR para expressões parcialmente parentisas contendo as quatro operações.

 * MiniPascaL: parser LL enfatizando o projeto de tabelas de símbolos básicas e geração de código intermediário.
 
**Modificações realizadas no MiniPascal**

* A classe abstrata `Environment` foi renomeada para `AbstractSymbolTable`.

* Foi inserido o método `grammar` na classe abstrata `Control`, a qual gera o arquivo texto `Grammar.txt` incluído no projeto

* Bugs no `scanner` foram corrigidos

* Alguns `throw` foram substituídos por `assert(false)`

* As ações semânticas @Echo, @VarDec, @Real, @Integer, @CreateList, @InsertList, @VarIdList e @ProgramArguments foram implementas

**Para testar, coloque um breakpoint na linha 40 do semântico, execute no modo depuração e inspecione a variável table**


