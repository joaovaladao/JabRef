## <a>Introdução</a>

<p style="text-indent: 20px; text-align: justify">
Visando a organização do projeto, este documento disponibiliza uma tabela de cobertura de Condições/Decisões do arquivo "ColorUtil.java" responsável por padronizar a formatação das cores do projeto JabRef.
</p>


## <a>Tabela de Decisões/Condições</a>

<center>

| Decisão | Condição | Situação para True | Situação para False |
| :--: |-- | -- |:--:|
| 01 | Formatação da variável de entrada "color"| Descrita como RGB ou Hex | Descrita de qualquer outro modo |
| 02 | Variável "color" estar no formato RGB (%d,%d,%d,%f) | Opacidade definida | Opacidade não definida |
| 02 | Variável "color" estar no formato RGB (#%02X%02X%02X)  | Opacidade não definida | Opacidade definida |
| 03 | Variável "color" estar no formato HEX | Necessariamente deve estar apresentada com uma # inicial e uma sequencia de 6 dígitos hexadecimais | Qualquer outra formatação |


</center>

## <a>Variáveis</a>
<p style="text-indent: 20px; text-align: justify">
Essas foram as variáveis criadas para serem utilizadas durante os processos de testes, pois também deveríamos testar diferentes meios de declaração de variáveis no funcionamento do programa.

</p>
<br>

<center>

![cores](../wiki/cores.png)
</center>

## <a>Testes Elaborados</a>

<p style="text-indent: 20px; text-align: justify">
Essas foram os testes criados para cobrir todos os casos de tomadas de decisões, e os casos especiais quando uma cor apresenta opacidade 0 (transparente), e quando são declaradas variáveis de maneiras diferentes que o habitual (Color.rgb, Color.hsb, Color.web, etc).
<br>
</p>
<center>

![cores](../wiki/testes_RGB.png)

<br>

![cores](../wiki/testes_HEX.png)

</center>