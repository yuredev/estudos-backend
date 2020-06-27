const express = require('express');

const server = express();

server.listen(8080, () => {
  console.log('Running on http://localhost:8080');
});

// middlewares são funções que são colocadas para serem executadas 
// antes de realizar alguma ação

// no express temos o middleware server.use 

// nele injetamos funções para serem chamadas antes de alguma requisição

// geralmente essas funções são de configuração

// exemplos:

// * o session de express-session

// * o json que configuramos quando queremos trabalhar com uma api rest 

// * o express static quando queremos deixar uma página estática para o servidor

// * a variável routes para definir as rotas da aplicação

server.use((req, res, next) => {
  console.log('Middleware executado antes de todas as requisições não importando a rota');
  next();
});


server.use('/users', (req, res, next) => {
  console.log('Middleware 0');
  next();
}, (req, res, next) => {
  console.log('Middleware 1');
  next(); // passa para o proximo middleware
});

server.use('/users', (req, res, next) => {
  console.log('Middleware 2');

  // definindo variaveis globais 
  res.locals = {
    ameno: 'dorime'
  }

  next();
}); 

// middlewares executam códigos assincronos
// o middleware abaixo faz com que todas requisições feitas à /users 
// demorem 2 segundos a serem feitas 
// uma vez que o next está dentro do setTimeout de 2 segundos
server.use('/users', (req, res, next) => {
  setTimeout(() => {
    next();
  }, 2000);
});

// todas as vezes que uma requisição vier para essa rota 
// os middlewares da rota /users acima serão executados
server.get('/users/final', (req, res, next) => {
  console.log('middleware 3');
  next();
}, (req, res, next) => {
  console.log('Finalizou requisição');

  console.log('variavel global: ', res.locals.ameno);

  // os middlewares são empilhados e vão sendo executados até que algum tenha alguma 
  // finalização da requisição
  res.send('Hello World');
});

server.use('/', (req, res) => {
  res.send('Raiz');
});