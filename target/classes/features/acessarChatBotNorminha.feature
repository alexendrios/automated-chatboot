#language:pt
#encoding: utf-8

@chat_norminha
Funcionalidade: Acessar o ChatBot - Norminhao
	Contexto:
		Dado que acesso o chatBot da Norminha com usuario "c1299459" e senha "12994596"

Cenário: Acessar o ChatBot - Norminha
    Quando seleciono no menu do chat o assunto "Atendimento"
    E escrevo "Cadastro" no chat e envio
    Então a norminha me responde "Desculpe... ainda estou aprendendo."