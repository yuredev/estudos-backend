const express = require('express');
const session = require('express-session');
const server = express();

server.use(session({
  secret: 'keyboard cat',
}));

server.get('/', (req, res) => {
  res.type('.html');

  // retona todos os cookies em formato string separando por ;
  // res.headers.cookie

  if (Object.keys(req.query).length !== 0) {

    // pegando nome do primeiro parametro 
    const [paramName] = Object.keys(req.query);
  
    // pegando valor do primeiro parametro
    const [paramValue] = Object.values(req.query);
  
    // cookie persistente, dura 120 segundos
    res.cookie(paramName, paramValue, {
      maxAge: 120 * 1000
    });
    // cookie transiente
    res.cookie('coxinha', 'frango');
  }
  

  if (req.headers.cookie) {
    console.log(req.headers.cookie.split(';'));
  } else {
    console.log('Nenhum cookie cadastrado');
  }

  // res.write: escreve no corpo
  // res.end:  finaliza requisição 
  // res.send:  escreve e envia 
  // res.sendStatus: manda uma msg http escolhida
  // res.json: manda json 
  // res.status: adiciona mensagem http mas nao envia

  res.send('Session id: ' + req.session.id);
});


server.listen(8080, () => console.log('listening at: http://localhost:8080'));