const express = require('express');
const server = express();

server.use(express.json());

/**
 * Tipos de parametros da requisição
 * 
 */


/**
 * Query param
 * é o parametro nomeado colocado na url 
 * exemplo http://localhost:3333?name=yure
 * name é o parametro query 
 * eles podem ser acessados com req.query
 * também são eles os parametros nomeados passados 
 * em uma requisição POST onde o name de cada input no
 * formulário é um query param
 * 
 * geralmente usado para get, ou quando for usar um submit POST de um form
 */

server.get('/user', (req, res) => {
  const { name } = req.query;
  res.send(name); 
}); 

/**
 * Route param 
 * parametro não nomeado, passando unicamente a informação
 * exemplo: htt://localhost:3333/users/14
 * 
 * usado unicamente na rota.
 * geralmente usado em requisições PUT ou DELETE
 * ou quando queremos resgatar alguma informação específica com o get
 * 
 * o nome do parametro colocado depois de : 
 * é o nome do parametro a ser referido dentro da função 
 * se for '/user/:id' o nome deste parametro será id 
 * 
 * podemos pegar o route param com req.param 
 */

server.put('/user/:id', (req, res) => {
  const { id } = req.param;
  res.send('id mandado: ', id);
});

/**
 * Query param 
 * 
 * parametro pego do corpo de uma requisição
 * geralmente usado em APIS REST 
 * pode ser de vários tipos 
 * incluindo principalmente JSON
 * o JSON mandado do frontend pode ser pego em req.query
 */

server.post('/user', (req, res) => {
  const { name, id, email } = req.query;
  res.send(name + id + email);
});