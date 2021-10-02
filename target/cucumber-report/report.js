$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/acessarChatBotNorminha.feature");
formatter.feature({
  "name": "Acessar o ChatBot - Norminhao",
  "description": "",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@chat_norminha"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Contexto"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que acesso o chatBot da Norminha com usuario \"c1299459\" e senha \"12994596\"",
  "keyword": "Dado "
});
formatter.match({
  "location": "AcessarChatBoot.queAcessoOChatBotDaNorminhaComUsuarioESenha(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Acessar o ChatBot - Norminha",
  "description": "",
  "keyword": "Cenário",
  "tags": [
    {
      "name": "@chat_norminha"
    }
  ]
});
formatter.step({
  "name": "que seleciono no menu o chat o assunto \"Atendimento\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "AcessarChatBoot.queSelecionoNoMenuOChatOAssunto(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "escrevo \"Cadastro\" no chat e envio",
  "keyword": "E "
});
formatter.match({
  "location": "AcessarChatBoot.escrevoNoChatEEnvio(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a norminha me responde \"Desculpe... ainda estou aprendendo.\"",
  "keyword": "Então "
});
formatter.match({
  "location": "AcessarChatBoot.aNorminhaMeResponde(String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});